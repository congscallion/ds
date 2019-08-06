/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat00;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 1. java序列化对象必须实现java.io.Serializable接口 2. java.io.Serializable接口是标记接口，没有什么方法 3.
 * transient修饰的实例属性不会被序列化 4.　父类实现了java.io.Serializable接口，子类也可以序列化 5.
 * 子类继承未实现java.io.Serializable接口的父类，父类所有变量均是零值 6. serialVersionUID字段不是必须的。该字段是每个可序列化类序列化时的版本号，在反序列化时，可用于校验。比如是否兼容等。
 * 7. 如果声明serialVersionUID，类型必须是long且是final. 8. 未显示定义serialVersionUID字段，序列化运行时将计算该类的默认值。　这可能因编译器而异。因此建议定义serialVersionUID.
 * 9. 建议serialVersionUID使用私有访问符 10. 数组类不能声明serialVersionUID，因为它们始终具有默认的计算值，但是对数组类，不需要匹配serialVersionUID值.
 * 11. 如果反序列化时，serialVersionUID与序列化时的serialVersionUID不同，则将抛出InvalidClassException. 12.
 * 静态变量属于整个类型，而不是单个实例。序列化是持久化对象的状态，因此仅序列化与特定的实例关联的数据，所以会序列化期间会忽略静态字段. 13.
 * 因此，transient与static都可以让属性不被序列化。但是static字段在反序列化时，如果JVM加载了当前类，且相同名字的属性已赋值，　则反序列化的对象同名属性会被赋值相同的值.
 * 14. final修饰的transient属性可以被赋值.
 *
 * @author wangcong
 * @version $Id: DeserializationClass.java, v0.1 7/2/19 4:04 PM wangcong Exp $$
 */
public class DeserializationClass {

    public static void main(String[] args) {

        Employee.lastName2 = "XICI";
        Employee.companyCEO2 = "CIII";
        Employee.lastName = "YIOOO";
        Employee.companyCEO = "CEOOO";

        Employee employee = null;

        try {

            FileInputStream fileIn = new FileInputStream("./employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            employee = (Employee) in.readObject();

            in.close();
            fileIn.close();


        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserializing Employee...");
        System.out.println("First Name of Employee: " + employee.firstName);
        System.out.println("Last Name of Employee: " + employee.lastName);
        System.out.println("Last Name2 of Employee: " + employee.lastName2);
        System.out.println("FamilyName of Employee: " + employee.familyName);
        System.out.println("CompanyName of Employee: " + employee.companyName);
        System.out.println("CompanyCEO of Employee: " + employee.companyCEO);
        System.out.println("CompanyCEO2 of Employee: " + employee.companyCEO2);
        System.out.println("Address of Employee: " + employee.address);
        System.out.println("Education of Employee: " + employee.education);

    }


}
