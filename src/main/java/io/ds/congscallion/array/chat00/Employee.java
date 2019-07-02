/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat00;

import java.io.Serializable;

/**
 * @author wangcong
 * @version $Id: Employee.java, v0.1 7/2/19 3:59 PM wangcong Exp $$
 */
public class Employee extends SubperEmployee implements Serializable {

    public String firstName;
    static String lastName;
    static String lastName2 = "TANA";
    public transient String companyName;
    public transient final String address = "DEL";
    static transient String companyCEO;
    static transient String companyCEO2 = "Jayshree";

}


class SubperEmployee implements VariableConstant {

    public String familyName;
}

interface VariableConstant {
    String education = "MCA";
}
