package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

public class BufferedReaderTest {


    @Test
    public void test1() throws IOException {

        BufferedReader reader = new BufferedReader(getCharArrayReader(), 1024);

        String s = "";
        for (int i = 0; s != null; i++, s = reader.readLine()) {

            System.out.println(s);

            if (i == 359) {
                reader.mark(782);
            }
        }
    }


    private Reader getCharArrayReader() {

        char[] arr = new char[10 * 1024];

        int skipPos = 3;
        for (int i = 0; i < 10 * 1024; i++) {
            if (skipPos == i) {
                arr[i] = '\n';
                skipPos += 3;
                continue;
            }
            arr[i] = (char) (i & (128 - 1));
        }

        CharArrayReader arrayReader = new CharArrayReader(arr);
        return arrayReader;
    }


}
