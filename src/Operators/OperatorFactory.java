package Operators;

import Operators.Print;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

    static Map<String, Class> ops = new HashMap<>();
    static {
        ops.put("print", Print.class);
        ops.put("let", Let.class);
        ops.put("if", If.class);
        ops.put("goto", GoTo.class);
    }


    public static Operator createOperator(String opName, String substring){
        Class opClass = ops.get(opName);

        try {
            return  (Operator)opClass.getConstructor(String.class).newInstance(substring);
        } catch (InstantiationException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }

    }
}
