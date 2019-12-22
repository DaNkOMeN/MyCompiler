package Operators;

import Main.Interpreter;

import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class If extends Operator {

    public If(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter interpreter) {
        Pattern pattern = Pattern.compile("(.*) then goto (.*)");
        Matcher mather = pattern.matcher(code);
        if (!mather.find()){
            System.err.println("Bad operator if");
        } else {
            String cond = mather.group(1);
            int line = Integer.parseInt(mather.group(2));

            try {
                Object res = Expression.eval(interpreter.getVars(),cond.replace("=","=="));
                if (res instanceof Boolean && res.equals(true)){
                    interpreter.goTo(line);
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }

        }
    }
}
