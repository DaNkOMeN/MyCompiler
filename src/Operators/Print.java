package Operators;

import Main.Interpreter;

import javax.script.ScriptException;

public class Print extends Operator {

    public Print(String code) {
        super(code);
    }


    @Override
    public void exec(Interpreter interpreter) {
        Object res = null;

        interpreter.next();

        String trim = code.trim();
        if (trim.startsWith("\"")) {
            String quotedStr = trim.substring(1, trim.length() - 1);
            if (trim.endsWith(";")) {
                System.out.println(quotedStr);
            } else {
                System.out.println(quotedStr);
            }
        }

        try {
            res = Expression.eval(interpreter.getVars(), code);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(res);
        interpreter.next();
    }
}
