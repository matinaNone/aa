package HashMap;

import java.util.*;

/**
 * Created by wangnan01 on 2018/12/5.
 */
public class FailFastTest {
    public static void main(String[] args) {
//        Map<String, String> hashtable = new Hashtable<>();
//        hashtable.put("t1", "1");
//        hashtable.put("t2", "2");
//        hashtable.put("t3", "3");
//
//        Enumeration<Map.Entry<String, String>> iterator1 = (Enumeration<Map.Entry<String, String>>) hashtable.entrySet().iterator();
//        hashtable.remove(iterator1.nextElement().getKey());
//        while (iterator1.hasMoreElements()) {
//            System.out.println(iterator1.nextElement());
//        }

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("h1", "1");
        hashMap.put("h2", "2");
        hashMap.put("h3", "3");

//        Iterator<Map.Entry<String, String>> iterator2 = hashMap.entrySet().iterator();
//        hashMap.remove(iterator2.next().getKey());
//        while (iterator2.hasNext()) {
//            System.out.println(iterator2.next());
//        }

        System.out.println(hashMap);

    }
}