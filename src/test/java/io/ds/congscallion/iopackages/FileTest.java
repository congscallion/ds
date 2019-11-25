package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FileTest {

    @Test
    public void test1() throws IOException {

        File file = new File("/home/wangcong/test/a.txt");
        char a = file.separatorChar;
        System.out.println(a);
        char b = file.pathSeparatorChar;
        System.out.println(b);

        System.out.println(file.getParent());
        System.out.println(file.getName());


        file.createNewFile();



    }


    @Test
    public void test2(){

        FileSystem aDefault = FileSystems.getDefault();

    }

    @Test
    public void test3(){
        URI uri = URI.create("a.txt");
        System.out.println(uri.getScheme());
        System.out.println(uri.toString());
    }
}
