package io.se;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

  public static void main(String[] args)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    ClassLoader classLoader = new ClassLoader() {
      @Override
      public Class<?> loadClass(String name) throws ClassNotFoundException {

        try {

          String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

          InputStream is = getClass().getResourceAsStream(fileName);
          if (null == is) {
            return super.loadClass(name);
          }

          byte[] b = new byte[is.available()];

          is.read(b);

          return defineClass(name, b, 0, b.length);
        } catch (IOException ex) {
          throw new ClassNotFoundException(name);
        }
      }
    };

    Object obj = classLoader.loadClass("io.se.ClassLoaderTest").newInstance();

    System.out.println(obj.getClass());

    System.out.println(obj instanceof ClassLoaderTest);

    obj = classLoader.loadClass("io.se.Date").newInstance();
    System.out.println(obj.toString());


  }

}
