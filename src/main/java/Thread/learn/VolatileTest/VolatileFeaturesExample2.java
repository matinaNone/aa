package Thread.learn.VolatileTest;

public class VolatileFeaturesExample2 {
    long vl = 0L; // 64 位 的 long 型 普通 变量

    public synchronized void set(long l) {// 对 单个 的 普通 变量 的 写 用 同一个 锁 同步
        vl = l;
    }

    public void getAndIncrement() { // 普通 方法 调用

        long temp = get(); // 调用 已 同步 的 读 方法
        temp += 1L;//普通 写 操作
        set(temp); // 调用 已 同步 的 写 方法
    }

    public synchronized long get() { // 对 单个 的 普通 变量 的 读 用 同一个 锁 同步
        return vl;
    }
}
