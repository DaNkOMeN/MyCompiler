package Operators;

import Main.Interpreter;

abstract public class Operator {
    String code;

    public Operator(String code) {
        this.code = code;
    }

    abstract public void exec(Interpreter interpreter);

    @Override
    public String toString() {
        return getClass().getName() + " " + code;
    }
}
