/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat00;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author wangcong
 * @version $Id: SerializaitonClass.java, v0.1 7/2/19 4:01 PM wangcong Exp $$
 */
public class SerializaitonClass {


    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.firstName = "Vivekanand";
        employee.lastName = "Gautam";
        employee.familyName = "Jen";
        employee.companyName = "NND";
        employee.companyCEO = "CEO";

        try {

            FileOutputStream fileOut = new FileOutputStream("./employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(employee);
            out.close();
            fileOut.close();

            System.out.printf("Serialized data is saved in ./employee.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }


    }


}
