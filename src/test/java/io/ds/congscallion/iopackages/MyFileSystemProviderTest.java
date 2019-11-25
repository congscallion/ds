package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;

public class MyFileSystemProviderTest {

    @Test
    public void test1() throws IOException {

        Map<String, String> env = new HashMap<>();
        URI uri = URI.create("ild://a/b/c/d/e");

        System.out.println(uri.getScheme());


        FileSystem fileSystem = FileSystems.newFileSystem(uri, env);


    }
}
