package JVM.Dispatch;

public class Dispatch {
    static class QQ{}
    static class _360{}
    public static class Father{
        public void hardChoice(QQ qq){
            System.out.println("Father choice qq!");
        }
        public void hardChoice(_360 arg){
            System.out.println("Father choice 360!");
        }
    }
    public static class Son extends Father{
        public void hardChoice(QQ qq){
            System.out.println("Son choice qq!");
        }
        public void hardChoice(_360 arg){
            System.out.println("Son choice 360!");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

}
