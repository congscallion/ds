package io.ds.congscallion.array.chat00;

import java.util.HashMap;
import java.util.Map;

public class Employee2 {

  private int empId;
  private String name;

  public Employee2(int empId, String name) {
    this.empId = empId;
    this.name = name;
  }


  /**
   * hashCode 与 equals 两个方法必须同时重写
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + empId;
    result = prime * result +
        ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /**
   * hashCode 与 equals 两个方法必须同时重写
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee2 other = (Employee2) obj;
    if (empId != other.empId) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }
}

class Address {

  private int houseNo;
  private String streetName;
  private String city;
  private int pinCode;


  public Address(int houseNo, String streetName,
      String city, int pinCode) {
    this.houseNo = houseNo;
    this.streetName = streetName;
    this.city = city;
    this.pinCode = pinCode;
  }

  public String getAddress() {
    return houseNo + ", " + streetName +
        ", " + city + ", " + pinCode;
  }
}

class Test {

  public static String getAddress(Map map, Employee2 employee) {

    Address address = (Address) map.get(employee);

    return address.getAddress();

  }

  public static void main(String[] args) {

    Employee2 emp1 = new Employee2(110, "Sajid Ali Khan");
    Address adrs1 = new Address(304, "Marol Mahrisi",
        "Mumbai", 400069);

    Employee2 emp2 = new Employee2(111, "Jaspreet Singh");
    Address adrs2 = new Address(203, "Seepz", "Mumbai",
        400093);

    Map<Employee2, Address> map = new HashMap<>();
    map.put(emp1, adrs1);
    map.put(emp2, adrs2);

    System.out.println(Test.getAddress(map, new Employee2(110,
        "Sajid Ali Khan")));

  }
}
