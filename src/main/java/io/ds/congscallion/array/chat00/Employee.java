/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat00;

import java.io.Serializable;

interface VariableConstant {

    String education = "MCA";
}

/**
 * @author wangcong
 * @version $Id: Employee.java, v0.1 7/2/19 3:59 PM wangcong Exp $$
 */
public class Employee extends SubperEmployee implements Serializable {

    static String lastName;
    static String lastName2 = "TANA";
    static transient String companyCEO;
    static transient String companyCEO2 = "Jayshree";
    public transient final String address = "DEL";
    public String firstName;
    public transient String companyName;

}

class SubperEmployee implements VariableConstant {

    public String familyName;
}
