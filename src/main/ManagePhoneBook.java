/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.PersonController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PhoneBook;
import myExceptions.PrimaryKeyDuplicatedException;

/**
 *
 * @author Randula
 */
public class ManagePhoneBook {

    public static void main(String[] args) {

        try {
            PersonController pc = new PersonController();

            // Generate next primary Key
            String id = pc.generateNextId(0);
            System.out.println(id);

            // New Record adding to file
//            PhoneBook pb1 = new PhoneBook("1", "Paala", "456", "unawatuna");
//            PhoneBook pb2 = new PhoneBook("2", "Sandamal", "123", "Gintota");
//            PhoneBook pb3 = new PhoneBook("3", "Randula", "789", "Baddegama");
//            PhoneBook pb4 = new PhoneBook("4", "Pasan", "963", "pola");
//
//            boolean addRecord = pc.addRecord(pb1);
//            boolean addRecord1 = pc.addRecord(pb2);
//            pc.addRecord(pb4);
//            pc.addRecord(pb3);
            PhoneBook pb5 = new PhoneBook(id, "Lakmali", "896", "Galle");
            boolean addRecord = pc.addRecord(pb5);
            if (addRecord) {
                System.out.println("New record Added");
            } else {
                System.out.println("new record added failed !!");
            }

            
//        PhoneBook sr = pc.searchRecord("123");
//        if (sr != null) {
//            System.out.println("Available " + sr.getPersonName() + " "
//                    + sr.getPhoneNumber() + " " + sr.getLocation());
//        } else {
//            System.out.println("record is not found");
//        }
//Get All records
//        ArrayList<PhoneBook> all = pc.getAll();
//        for (PhoneBook pb : all) {
//            System.out.println(pb.getPersonName() + " " + pb.getPhoneNumber() + " " + pb.getLocation());
//        }
//Delete a Record
//        boolean deleteRecord = pc.deleteRecord("456");
//        if (deleteRecord) {
//            System.out.println("Deleted");
//        } else {
//            System.out.println("Not Deleted");
//        }
            //Update phoneBook
//         PhoneBook pb = new PhoneBook("2","Sandamal", "123", "Gin");
//        boolean update = pc.update(pb, "123");
//        if (update) {
//            System.out.println("updated");
//        } else {
//            System.out.println("Not updated");
//        }
        } catch (IOException ex) {
            Logger.getLogger(ManagePhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrimaryKeyDuplicatedException ex) {
            Logger.getLogger(ManagePhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
