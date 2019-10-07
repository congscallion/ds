package io.se;

public class ClassLoaderT {


  public static void main(String[] args) {

    System.out.println(String.class.getClassLoader());

    System.out.println("ClassLoaderT.getClass().getClassLoader() : "
        + ClassLoaderT.class.getClassLoader());

    try {
      Class
          .forName("io.se.ClassLoaderT", true, ClassLoaderT.class.getClassLoader().getParent());

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }
}
