/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import model.PhoneBook;
import myExceptions.PrimaryKeyChecker;
import myExceptions.PrimaryKeyDuplicatedException;
import utilities.IdGeneratorForFileWritting;

/**
 *
 * @author Randula
 */
public class PersonController {

    RandomAccessFile file;
    private static int userId = 0;
    private static PrimaryKeyChecker checker = new PrimaryKeyChecker();
    
    
    public PersonController() throws FileNotFoundException, IOException {
        file = new RandomAccessFile("MyTest.txt", "rw");
    }

    //adding record for random access file  
    public boolean addRecord(PhoneBook phoneBook) throws IOException,PrimaryKeyDuplicatedException {
        long length = file.length();
        file.seek(length);
         
        checker.checkRecordAvailbilitys(file, phoneBook.getUserId());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(phoneBook.getUserId()).append(":").append(phoneBook.getPersonName()).append(":").append(phoneBook.getPhoneNumber()).
                append(":").append(phoneBook.getLocation());
        if (file.getFilePointer() != 0) {
            file.writeBytes(System.getProperty("line.separator"));
        }
        file.writeBytes(stringBuffer.toString());
        userId ++;
  
        return (length < file.length());
    }

    //Searching a record - Give a phone number as a key to Search
    public PhoneBook searchRecord(String phoneNumber) throws IOException {
        PhoneBook phoneBook = null;
        //Setting file pointer to start of file
        file.seek(0);
        String data = file.readLine();
        while (data != null) {
            String[] record = data.split(":");
            String contactNo = record[2];
            if (contactNo != null && contactNo.equals(phoneNumber)) {
                phoneBook = new PhoneBook(record[0], record[1], record[2], record[3]);
                break;
            }
            data = file.readLine();
        }

        return phoneBook;
    }

    public boolean checkRecordAvailbility(String phoneNumber) throws IOException {
        file.seek(0);
        boolean isAvailable = false;
        String data = file.readLine();
        while (data != null) {
            String[] record = data.split(":");
            if (record.length > 1) {
                String contactNo = record[2];
                if (contactNo != null && contactNo.equals(phoneNumber)) {
                    isAvailable = true;
                    break;
                } else {
                    isAvailable = false;
                }
                data = file.readLine();
            }
            data = file.readLine();
        }
        return isAvailable;
    }

    //Delete a Record From File
    public boolean deleteRecord(String phoneNumber) throws IOException, PrimaryKeyDuplicatedException {
        file.seek(0);
        ArrayList<PhoneBook> all = getAll();
        PhoneBook record = searchRecord(phoneNumber);
        System.out.println(record.toString() + " Get record");
        ArrayList<PhoneBook> newlist = new ArrayList<>();
        for (PhoneBook pb : all) {
            if (!record.toString().equals(pb.toString())) {
                newlist.add(pb);
            }
        }
        int addrecordCount = 0;
        int newListCount = newlist.size();
        file.setLength(0);
        for (PhoneBook newData : newlist) {
            boolean addRecord = addRecord(newData);
            if (addRecord) {
                addrecordCount++;
            }
        }
        if (addrecordCount == newListCount) {
            return true;
        } else {
            return false;
        }
    }

    //view records for random access file
    public ArrayList<PhoneBook> getAll() throws IOException {
        String data;
        //This is responsible for reading complete file
        ArrayList<PhoneBook> list = new ArrayList<>();
        PhoneBook phoneBook = null;
        file.seek(0);
        data = file.readLine();
        while (data != null) {
            String[] record = data.split(":");
            String contactNo = record[2];
            phoneBook = new PhoneBook(record[0], record[1], record[2], record[3]);
            list.add(phoneBook);
            data = file.readLine();
        }
        return list;
    }

    public boolean update(PhoneBook phoneBook, String poneNumber) throws IOException, PrimaryKeyDuplicatedException {
        //Setting file pointer to start of file
        file.seek(0);

        PhoneBook oldRecord = null;
        String data = file.readLine();
        while (data != null) {
            String[] split = data.split(":");
            if (split[2].equals(poneNumber)) {
                oldRecord = new PhoneBook(split[0]+":",split[1]+":",split[2]+":", split[3]);
                break;
            }
            data = file.readLine();
        }
        boolean deleteRecord = deleteRecord(poneNumber);
        boolean addRecord = addRecord(phoneBook);
        if (addRecord && deleteRecord) {
            return true;
        } else {
            boolean addRecord1 = addRecord(oldRecord);
            return false;
        }
    }

    public String generateNextId(int colomnNumber) throws IOException{
       String id = IdGeneratorForFileWritting.getNewId(file, userId);
       
       return id;
    }
    
}
