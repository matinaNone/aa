package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangnan01 on 2017/10/16.
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
