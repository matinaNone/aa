import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by wangnan01 on 2017/2/28.
 *
 */
public class DigestID {
    public static int index;
    public static byte[] macAddress;
    public static byte[] processName;

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, UnknownHostException, SocketException {
        macAddress =
                NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();

        processName = ManagementFactory.getRuntimeMXBean().getName().getBytes("UTF-8");


        System.out.println(id(1));
        System.out.println(id(2));
        System.out.println(id(3));
        System.out.println(id(4));
        System.out.println(id(5));
        System.out.println(id(6));
        System.out.println(id(7));
        System.out.println(id(8));

    }

    public static String id(int bytes) throws NoSuchAlgorithmException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.order(ByteOrder.BIG_ENDIAN);

        buffer.put(macAddress);

        buffer.put(processName);

        buffer.asLongBuffer().put(Thread.currentThread().getId());
        buffer.position(buffer.position() + 8);

        buffer.asLongBuffer().put(System.currentTimeMillis());
        buffer.position(buffer.position() + 8);

        buffer.asIntBuffer().put(index++); //
        buffer.position(buffer.position() + 4);

        buffer.flip();

        byte[] data = new byte[buffer.limit()];

        buffer.get(data);

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] digest = messageDigest.digest(data);

        byte[] value = new byte[bytes + 1];

        value[0] = 0;
        System.arraycopy(digest, 0, value, 1, bytes);

        BigInteger result = new BigInteger(value);

        for (int i = 1; i < value.length; ++i) {
            value[i] = (byte) 0xFF;
        }

        BigInteger max = new BigInteger(value);

        StringBuilder builder = new StringBuilder(result.toString());

        for (int i = max.toString().length() - builder.length(); i > 0; --i) {
            builder.insert(0, "0");
        }

        return builder.toString();
    }
}
