package annotation.learn;

/**
 * Created by wangnan01 on 2017/7/13.
 */
public class SayHiEmlement {
    public void SayHiDefault(String param){
        System.out.println("Hi " + param);
    }

    @SayHiAnnotation(paramValue = "Ace")
    public void sayHiAnnotation(String name){
        System.out.println("Hi, " + name);
    }

    @SayHiAnnotation
    public void SayHiAnnotationDefault(String name){
        System.out.println("Hi, " + name);
    }
}
