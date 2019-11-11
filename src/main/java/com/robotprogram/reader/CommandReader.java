package com.robotprogram.reader;



import com.robotprogram.exception.RobotException;
import com.robotprogram.robotutil.Grid;
import com.robotprogram.robotutil.Robots;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommandReader {
Robots robot ;

	public ArrayList<String> readFrom(File file)
	throws RobotException, IOException {
		if (file == null) {
			throw new RobotException("File not found");
		}
		if (!file.exists()) {
			throw new RobotException("File not exist");
		}
		return read(file);
	}

	private ArrayList<String> read(File file)
	throws IOException {
		ArrayList<String> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			Grid grid =new Grid();
			robot = new Robots(grid);

			String currentLine;
			String output=null;
			while ((currentLine = br.readLine()) != null) {
				try {
					output = robot.execute(currentLine);
				} catch (RobotException e ) {
					e.printStackTrace();
				}
				if (currentLine.equals("REPORT")) {
					result.add(output);
				}
			}
		}
		return result;
	}
}
