package com.robotprogram.robotutil;

import com.robotprogram.enums.Command;
import com.robotprogram.enums.Direction;
import com.robotprogram.exception.RobotException;

public class Robots {
    private Grid grid;

    Direction direction = Direction.NORTH;
    Coordinate coordinate = new Coordinate(0, 0);

    public Robots(Grid grid) {
        this.grid = grid;
    }


    public String executeForTest(String commands) {
        for (char c : commands.toCharArray()) {

            if (c == 'R') {
                direction = direction.right();

            }
            if (c == 'L') {
                direction = direction.left();

            }

            if (c == 'M') {
                coordinate = grid.nextCoordinateFor(coordinate,direction);

            }
        }
        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }


    public String execute(String inputString) throws RobotException {
        String[] args = inputString.split(" ");

        // validate command
        Command command;

        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new RobotException("Invalid command");
        }
        if (command == Command.PLACE && args.length < 2) {
            throw new RobotException("Invalid command");
        }

        // validate PLACE params
        String[] params;
        int x = 0;
        int y = 0;

        String d = null;

        if (command == Command.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                coordinate = new Coordinate(x, y);

                if (params[2].equals("NORTH")) {
                    direction = Direction.NORTH;
                } else if (params[2].equals("SOUTH")) {
                    direction = Direction.SOUTH;
                } else if (params[2].equals("WEST")) {
                    direction = Direction.WEST;
                } else
                    direction = Direction.EAST;


            } catch (Exception e) {
                throw new RobotException("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
                break;
            case MOVE:
                coordinate = grid.nextCoordinateFor(coordinate, direction);
                output = coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
                break;
            case LEFT:
                direction = direction.left();
                output = coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
                break;
            case RIGHT:
                direction = direction.right();
                output = coordinate.x() + ":" + coordinate.y() + ":" + direction.value();

                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new RobotException("Invalid command");
        }

        return output;
    }


    /**
     * Returns the X,Y and Direction of the robot
     */
    public String report() {

        return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }
}
