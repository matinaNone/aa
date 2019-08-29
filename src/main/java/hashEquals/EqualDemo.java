package hashEquals;

public class EqualDemo {
    public static void main(String[] args) {
        /**
         * step1 基本类型比较：所有基本类型直接比较的是值
         */
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.print("基本类型Integer比较......: == —>");
        System.out.print(i1 == i2);
        System.out.print(" equal —>");
        System.out.println(i1.equals(i2));
        /**
         * step2 引用类型比较：一种比较String类型，一种比较User对象类型
         */
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";
        System.out.print("引用类型String比较......: == —>");
        System.out.print(s1 == s2);
        System.out.print(" s1和s3 —>");
        System.out.print(s1 == s3);
        System.out.print(" equal —>");
        System.out.println(s1.equals(s2));

        User u1 = new User();
        u1.setFirstName("wang");
        u1.setLastName("dan");
        User u2 = new User();
        u2.setFirstName("wang");
        u2.setLastName("dan");
        System.out.print("引用类型User对象比较......: == —>");
        System.out.print(u1 == u2);
        System.out.print(" equal —>");
        System.out.println(u1.equals(u2));
    }
}
