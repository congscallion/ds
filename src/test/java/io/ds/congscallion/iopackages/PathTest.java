package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    @Test
    public void test1() {

        Path path = Paths.get("");


    }


    @Test
    public void test2() throws IOException {

        Path path = FileSystems.getDefault().getPath("/abc/dd/xx");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));


    }
}
