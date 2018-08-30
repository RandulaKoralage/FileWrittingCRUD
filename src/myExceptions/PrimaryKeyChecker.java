/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Randula
 */
public class PrimaryKeyChecker {
    RandomAccessFile file;


     public void checkRecordAvailbilitys( RandomAccessFile file, String userId) throws IOException,PrimaryKeyDuplicatedException {
        file.seek(0);
        boolean isAvailable = false;
        String data = file.readLine();
        while (data != null) {
            String[] record = data.split(":");
            if (record.length > 1) {
                String contactNo = record[0];
                if (contactNo != null && contactNo.equals(userId)) {
                    isAvailable = true;
                    break;
                } else {
                    isAvailable = false;                      
                }
                data = file.readLine();
            }
            data = file.readLine();
        }
        if(isAvailable){
             throw new PrimaryKeyDuplicatedException("Duplicated Primaty Key for " + userId);
        }
    } 
}
