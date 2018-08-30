/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import model.PhoneBook;

/**
 *
 * @author Randula
 */
public class IdGeneratorForFileWritting {

    private static String getLastId( RandomAccessFile file, int colomnNumber) throws IOException {
        String lastId = null;

        String data;
        //This is responsible for reading complete file
        ArrayList<PhoneBook> list = new ArrayList<>();
        PhoneBook phoneBook = null;
        
        ArrayList<Integer> keyArrayList = new ArrayList();
        file.seek(0);
        data = file.readLine();
        while (data != null) {
            String[] record = data.split(":");
           
            Integer keyValue = Integer.parseInt(record[colomnNumber]);
            keyArrayList.add(keyValue);
            data = file.readLine();
        }
        Collections.sort(keyArrayList);
        int last =keyArrayList.get(keyArrayList.size()-1);
        lastId = Integer.toString(last);
        return lastId;
    }

    public static String getNewId(RandomAccessFile file, int colomnNumber) throws IOException {
        String newId = null;
            if(file.length()>0){
                int newKey = Integer.parseInt(getLastId(file, colomnNumber))+1;
                newId = Integer.toString(newKey);
            }else{
                newId = "1";
            }
        return newId;
    }
}
