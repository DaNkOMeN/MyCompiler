package Main;

import Operators.Operator;
import Operators.OperatorFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {
    TreeMap<Integer, Operator> code = new TreeMap<>();

    Map<String, Double> vars = new HashMap<>();

    Integer curLine;

    public void next(){
        curLine = code.higherKey(curLine);
    }

    public void goTo (int line){
        curLine = line;
    }

    public void parse(String line) {
        if (line.equalsIgnoreCase("RUN")){
            this.run();
        } else
        if (line.equalsIgnoreCase("list")){
            for ( int i: code.keySet()){
                System.out.println(i + " " + code.get(i));
            }
        } else {
            int lineNumber = 0;
            String parts[] = null;
            String opName = null;
            try {
                parts = line.split(" ");
                lineNumber = Integer.parseInt(parts[0]);
                opName = parts[1];
            } catch (RuntimeException e){
                System.err.println("WRONG OPERATION");
            }
            Operator operator = OperatorFactory.createOperator(opName, line.substring(parts[0].length() + parts[1].length() + 2));
            code.put(lineNumber, operator);
        }
    }

    public void run(){
        curLine = code.firstKey();
        while(true){
            Operator operator = code.get(curLine);
            operator.exec(this);
            if (curLine == null) break;
        }
    }

    public Map<String, Double> getVars() {
        return vars;
    }

    public void setVars(Map<String, Double> vars) {
        this.vars = vars;
    }
}
