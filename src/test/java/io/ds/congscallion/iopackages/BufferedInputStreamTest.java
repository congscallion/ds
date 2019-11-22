package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {


    @Test
    public void test1() throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(getOriginArr());

        BufferedInputStream bis = new BufferedInputStream(bais, 1024);

        for (int i = 1, len = 0; len != -1; i++, len = bis.read()) {
            if (i == 200) {
                bis.mark(1024 * 3);
            }

        }

    }


    private byte[] getOriginArr() {
        byte[] originArr = new byte[8 * 1024];
        for (int i = 0; i < originArr.length; i++) {
            originArr[i] = (byte) ((int) (Math.random() * i) & 0xff);
        }
        return originArr;
    }


}
