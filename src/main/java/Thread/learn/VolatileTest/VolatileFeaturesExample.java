package Thread.learn.VolatileTest;

public class VolatileFeaturesExample {
    volatile long vl = 0L;// 使用 volatile 声明 64 位 的 long 型 变量

    public void set(long l) {
        vl = l; // 单个 volatile 变量 的 写
    }

    public void getAndIncrement() {
        vl++; // 复合（ 多个） volatile 变量 的 读/ 写
    }

    public long get() {
        return vl; // 单个 volatile 变量 的 读
    }
}
