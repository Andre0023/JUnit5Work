package dit;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Junit {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Method declaredMethod : SimpleTest.class.getDeclaredMethods()) {
            Test test = declaredMethod.getAnnotation(Test.class);

            if (test != null){
                declaredMethod.invoke(
                        SimpleTest.class.getConstructor().newInstance()


                );
                System.out.println("test passed");
            }

        }

    }
}
