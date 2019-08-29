package List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wangnan01 on 2018/12/13.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode node = Wrapper.stringToListNode(line);
            Wrapper.prettyPrintLinkedList(node);
        }
    }
}

