package Operators;

import Main.Interpreter;

public class GoTo extends Operator {


    public GoTo(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter interpreter) {
        interpreter.goTo(Integer.parseInt(code));
    }
}
