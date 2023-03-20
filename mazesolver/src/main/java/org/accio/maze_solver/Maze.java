package org.accio.maze_solver;

import org.accio.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze extends JFrame {
    /* the 2d matrix represents the maze cordinates,
     where 1 is the block, 0 is accessible and 9 is destgination*/
    private int maze[][] =
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,0,0,1,1,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}

    };
    //path list to store the path coordinates
    List<Integer> path = new ArrayList<>();

    public Maze(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazeDfs solver = new MazeDfs();
        solver.searchPath(maze , 1, 1 , path);
    }
    //overriden method from jframe to desighn graphics
    @Override
    public void paint(Graphics g)
    {
        g.translate(50,50);//coordinate to locate the graphics

        for(int i=0; i< maze.length ; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                //fill the color for each cell
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);

                //to show the rectangle lines
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }

        for(int i=0 ; i<path.size() ; i+=2)
        {
            if(i==0)
            {
                int pathx = path.get(i);
                int pathy = path.get(i+1);
                g.setColor(Color.RED);
                g.fillRect(30*pathx , 30*pathy , 20 , 20);
            }
            else {
                int pathx = path.get(i);
                int pathy = path.get(i + 1);
                g.setColor(Color.GREEN);
                g.fillRect(30 * pathx, 30 * pathy, 20, 20);
            }
        }
    }


}
