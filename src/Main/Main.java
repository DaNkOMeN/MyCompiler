package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("/home/danko/Загрузки/q.bas"));

        Interpreter interpreter = new Interpreter();
        while (true){
            String line = reader.readLine();
            System.out.println(line);
            if (line ==null) break;
            interpreter.parse(line);
        }
        interpreter.run();
    }
}
