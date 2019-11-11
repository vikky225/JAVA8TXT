package com.robotprogram.robotutil;

import com.robotprogram.enums.Direction;

public class Grid {


        private static final int MAX_HIGHT = 10;
        private static final int MAX_WIDTH = 10;

        public Coordinate nextCoordinateFor(Coordinate coordinate, Direction direction) {
            int x =coordinate.x();
            int y =coordinate.y();
            if(direction==Direction.NORTH)
                y=(y+1)%MAX_HIGHT;
            if(direction==Direction.EAST)
                x=(x+1)%MAX_WIDTH;
            if(direction==Direction.WEST)
                x=(x>0)? x-1:MAX_WIDTH-1;
            if(direction==Direction.SOUTH)
                y=(y>0)? y-1:MAX_HIGHT-1;
            return new Coordinate(x,y);
        }


}
