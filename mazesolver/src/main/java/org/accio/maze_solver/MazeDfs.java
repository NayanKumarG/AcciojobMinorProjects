package org.accio.maze_solver;

import java.util.List;

public class MazeDfs {
    public boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {
        /*we are taking y x because in grid coordination x as horizontal and y as vertical*/
        if(maze[y][x]==9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x]==0)
        {
            maze[y][x]=2;
            int dx = -1;
            int dy = 0;
            if(searchPath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 1;
            dy = 0;
            if(searchPath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = -1;
            if(searchPath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = 1;
            if(searchPath(maze,x+dx,y+dy,path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
