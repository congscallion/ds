package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class RandomAccessFileDemo {

    @Test
    public void test1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("b.txt", "rw");
        Path path = Paths.get("b.txt");

        raf.setLength(10);
        System.out.println("=================raf.setLength(10);==================");
        System.out.println("after raf.setLength(10), filePointer: " + raf.getFilePointer());
        print(path);



        System.out.println("before seek(1000), filePointer: " + raf.getFilePointer());
        print(path);
        System.out.println("=================raf.seek(1000);==================");
        raf.seek(1000);
        System.out.println("after seek(1000), filePointer: " + raf.getFilePointer());
        print(path);

        raf.write("abc".getBytes());
        System.out.println("after write(\"abc\".getBytes()), filePointer: " + raf.getFilePointer());
        System.out.println("length: " + raf.length());

        print(path);

        System.out.println("=================raf.setLength(1024 * 10);==================");
        raf.setLength(1024 * 10);
        System.out.println("after setLength(1024 * 10), filePointer: " + raf.getFilePointer());
        System.out.println("length: " + raf.length());

        print(path);


        Files.delete(Paths.get("b.txt"));
    }


    private void print(Path path) throws IOException {
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = fileAttributeView.readAttributes();
        System.out.println("basic:size = " + basicFileAttributes.size());

        long size = Files.size(path);
        System.out.println("Files:size = " + size);

    }
}
