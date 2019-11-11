package com.robotprogram.enums;

public enum Direction {

    NORTH("NORTH", "WEST", "EAST"),
    EAST("EAST", "NORTH", "SOUTH"),
    SOUTH("SOUTH", "EAST", "WEST"),
    WEST("WEST", "SOUTH", "NORTH");

    private final String value;
    private final String left;
    private final String right;

    Direction(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Direction right() {
        String right = this.right;
        Direction direction1 = directionMatching(right);
        if (direction1 != null) return direction1;
        return null;
    }

    private Direction directionMatching(String nextDirection) {
        for (Direction direction : values()) {

            if (direction.value == nextDirection) {
                return direction;
            }

        }
        return null;
    }


    public Direction left() {
        Direction direction = directionMatching(this.left);
        if (direction != null) return direction;
        return null;
    }


    public String value() {
        return value;
    }
}


