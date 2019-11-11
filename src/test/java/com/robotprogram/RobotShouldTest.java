package com.robotprogram;

import com.robotprogram.robotutil.Grid;
import com.robotprogram.robotutil.Robots;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class RobotShouldTest {

    private Robots robot;

  @Before
   public void initialise(){
      Grid grid =new Grid();
      robot = new Robots(grid);
  }

    @Test
    @Parameters({
            "R,0:0:EAST",
            "RR,0:0:SOUTH",
            "RRR,0:0:WEST",
            "RRRR,0:0:NORTH"
    })
   public void rotate_right(String commands, String position){
        Assert.assertThat(robot.executeForTest(commands),is(position));
    }



    @Test
    @Parameters({
            "L,0:0:WEST",
            "LL,0:0:SOUTH",
            "LLL,0:0:EAST",
            "LLLL,0:0:NORTH"
    })
    public void rotate_left(String commands, String position){
       Assert.assertThat(robot.executeForTest(commands),is(position));
    }

    @Test
    @Parameters({
            "M,0:1:NORTH",
            "MM,0:2:NORTH",
            "MMM,0:3:NORTH"
               })
    public void move_up(String commands, String position){
        Assert.assertThat(robot.executeForTest(commands),is(position));
    }


    @Test
    @Parameters({
            "MMMMMMMMMM,0:0:NORTH",
            "MMMMMMMMMMMMMMM,0:5:NORTH",
    })
    public void wrap_top_to_bottom_when_moving_north(String commands, String position){
       Assert.assertThat(robot.executeForTest(commands),is(position));
    }


    @Test
    @Parameters({
            "RM,1:0:EAST",
            "RMMMMM,5:0:EAST",
    })
    public void move_right(String commands, String position){
       Assert.assertThat(robot.executeForTest(commands),is(position));
    }



    @Test
    @Parameters({
            "RMMMMMMMMMM,0:0:EAST",
            "MMMMMMMMMMMMMMM,0:5:NORTH",
    })
    public void wrap_from_right_to_left_when_moving_east(String commands, String position){
        Assert.assertThat(robot.executeForTest(commands),is(position));
    }


    @Test
    @Parameters({
            "LM,9:0:WEST",
            "LMMMMM,5:0:WEST",
    })
    public void move_left(String commands, String position){
        Assert.assertThat(robot.executeForTest(commands),is(position));
    }


    @Test
    @Parameters({
            "LLM,0:9:SOUTH",
            "LLMMMMM,0:5:SOUTH",
    })
    public void move_south(String commands, String position){
      Assert.assertThat(robot.executeForTest(commands),is(position));
    }
}