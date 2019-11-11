package com.robotprogram;

import com.robotprogram.exception.RobotException;
import com.robotprogram.reader.CommandReader;

import java.io.File;
import java.util.ArrayList;

public class RobotShouldMain {

    public static void main(String[] args) {
        try {
            CommandReader reader = new CommandReader();
            if (args.length == 1 && !args[0].isEmpty()) {
                try {
                    printResult(reader.readFrom(new File(args[0])));
                } catch (RobotException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Run command: java -jar robot-1.0-SNAPSHOT.jar <input file>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printResult(ArrayList<String> result) {
        result.stream().forEach(r -> {
            System.out.println("Output: " + r);
        });
    }
}
