package JVM;

/**
 * Created by wangnan01 on 2017/10/17.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length: " + oom.stackLength);
            e.printStackTrace();
        }
    }
}
