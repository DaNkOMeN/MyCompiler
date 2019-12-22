package Operators;

import Main.Interpreter;

import javax.script.ScriptException;

public class Let extends Operator {

    public Let(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter interpreter) {
        String[] parts = code.split("=");
        try {
            Object val = Expression.eval(interpreter.getVars(),parts[1]);
            interpreter.getVars().put(parts[0].trim(), Double.parseDouble(val.toString()));

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        interpreter.next();
    }
}
