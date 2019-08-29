package lambda.learn;

/**
 * Created by wangnan01 on 2017/5/25.
 */
public class Calculator {
    interface IntegerMath {
        int operation(int a, int b);
    }

    public static int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }


    public static void main(String[] args) {
        class IntegerMathAdd implements IntegerMath {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        }

        int sum = operateBinary(1, 2, new IntegerMathAdd());

        Calculator app = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;

        System.out.println(operateBinary(40,2, addition));
        System.out.println(operateBinary(40,2, subtraction));




    }


}
