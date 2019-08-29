package Serialization;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wangnan01 on 2019/8/2.
 */
public class FileWriteTest {
    public static void main(String[] args) {


        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("lvelvelve....");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
