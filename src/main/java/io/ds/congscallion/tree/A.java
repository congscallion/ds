/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangcong
 * @version $Id: A.java, v0.1 7/18/19 2:26 PM wangcong Exp $$
 */
public class A {

    public static void main(String[] args) throws IOException {

        List<String> allNumbers = Files
                .readAllLines(Paths.get("/home/wangcong/Desktop/a.txt"), Charset.defaultCharset());

        Scanner scanner = new Scanner(System.in);

        String line;
        while ((line = scanner.nextLine()) != null) {

            System.out.println(line);

            if ("886".equals(line)) {
                return;
            }

            int i = allNumbers.indexOf(line);

            FileWriter writer = new FileWriter("/home/wangcong/Desktop/b.txt");
            writer.write(i + ":" + line);
            writer.flush();

            if (!allNumbers.contains(line)) {
                System.out.println("你输入的密码不在程序生成的数值范围内： " + line);
            }else{

                System.out.println("你输入的密码是： " + line);
            }



        }


    }

}
