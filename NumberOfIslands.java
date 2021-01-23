import java.util.Arrays;

// Given a 2-dimensional grid consisting of 1's (land blocks) and 0's (water blocks), count the number of islands present in the grid. The definition of an island is as follows:
// 1.) Must be surrounded by water blocks.
// 2.) Consists of land blocks (1's) connected to adjacent land blocks (either vertically or horizontally). 
// Assume all edges outside of the grid are water.

// Example: 
// Input: 
// 10001
// 11000
// 10110
// 00000

// Output: 3


public class NumberOfIslands {
    
    public static void main(String[] args) {
        int[][][] grids = {
            {
                {1,0,0,0,1},
                {1,1,0,0,0},
                {1,0,1,1,0},
                {0,0,0,0,0}
            },
            {
                {1,1,0,0,0},
                {0,1,0,0,1},
                {1,0,0,1,1},
                {0,0,0,0,0}
            }
        };

        for(int[][] grid: grids){
            System.out.println("Number of islands in grid\n"+islandAsString(grid)+"is "+numberOfIslands(grid)+"\n");
        }
    }

    static String islandAsString(int[][] grid){
        String string = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                string += grid[i][j]+" ";
            }
            string += "\n";
        }
        return string;
    }

    //counting by elimination method
    static int numberOfIslands(int[][] grid){
        int total = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){//a part of an island is encountered
                    total++;//count the island
                    drown(grid, i, j);//drown the island
                }
            }
        }

        return total;
    }

    static void drown(int[][] grid,int row,int column){
        //only attempt to drown valid coordinates
        if(0 <= row && row <= (grid.length - 1) && 0 <= column && column <= (grid[0].length - 1)){ 

            if(grid[row][column] == 0)//can't drown what is already under water
                return;

            grid[row][column] = 0;//drown this part of the island

            //drown(attempt) the rest of it
            drown(grid, row - 1, column);
            drown(grid, row + 1, column);
            drown(grid, row, column - 1);
            drown(grid, row, column + 1);
        }
    }
}