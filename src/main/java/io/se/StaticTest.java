package io.se;

public class StaticTest {

  static {
    i = 0;
//    System.out.println(i); // Illegal forward reference
  }

  static int i = 1;


  public static void main(String[] args) {

    System.out.println(Sub.A);

  }
}


class Parent{

  public static int A = 1;

  static {
    A = 2;
  }

}


class Sub extends Parent{

  public static int B = A;
}