package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderDemo {

    @Test
    public void test1() throws IOException {

        InputStream in = new ByteArrayInputStream(new byte[1024]);
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        br.readLine();

        FileReader fileReader = new FileReader("a.txt");
        BufferedReader fbr = new BufferedReader(fileReader);
        fbr.readLine();


    }
}
