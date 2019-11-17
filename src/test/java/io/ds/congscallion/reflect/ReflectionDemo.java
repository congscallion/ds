package io.ds.congscallion.reflect;

import org.junit.Test;
import sun.reflect.Reflection;

import java.lang.reflect.Modifier;

public class ReflectionDemo {

    @Test
    public void test2() {

        int a = Reflection.getClassAccessFlags(A.class);
        System.out.println(a);

        System.out.println(Modifier.isPublic(a));
        System.out.println(Modifier.isPrivate(a));
        System.out.println(Modifier.isProtected(a));


        int b = Reflection.getClassAccessFlags(B.class);
        System.out.println(b);

        int c = Reflection.getClassAccessFlags(C.class);
        System.out.println(c);
        System.out.println(Modifier.isPrivate(c));

        int d = Reflection.getClassAccessFlags(D.class);
        int modifiers = D.class.getModifiers();
        System.out.println(d);
        System.out.println(Modifier.isProtected(d));
        System.out.println(Modifier.isProtected(modifiers));


    }

    class A {

    }

    private class C {

    }

    protected class D {

    }


}

class B {

}




