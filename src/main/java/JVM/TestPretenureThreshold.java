package JVM;

/**
 * Created by wangnan01 on 2017/10/30.
 */
public class TestPretenureThreshold {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1;
        allocation1 = new byte[4*_1MB];
    }
}
