package Jdk9Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangnan01 on 2017/10/19.
 */
public class TrySource {
    public static void main(String[] args) {

        

        //common
        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("out.txt", true)));
            out.println("the text");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try-with-resource 1.7
        try (PrintWriter out2 = new PrintWriter(
                new BufferedWriter(
                        new FileWriter("out2.txt", true)));
             PrintWriter out3 = new PrintWriter(
                     new BufferedWriter(
                             new FileWriter("out3.txt", true)))) {
            out2.println("the text");
            out3.println("the text");
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
