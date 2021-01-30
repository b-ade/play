// You are given a 2D array of integers. Print out the clockwise spiral traversal of the matrix.

// Example:

// grid = [[1,  2,  3,  4,  5],
//         [6,  7,  8,  9,  10],
//         [11, 12, 13, 14, 15],
//         [16, 17, 18, 19, 20]]

// The clockwise spiral traversal of this array is:

// 1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12

import java.util.Arrays;

public class SpiralPrint {

    static String as2DString(int[][] grid){
        StringBuilder sb = new StringBuilder();
        for (int[] is : grid) {
            for (int is2 : is) {
                sb.append(is2).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {1,  2,  3,  4,  5},
            {6,  7,  8,  9,  10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        int[] spiraled = new int[grid[0].length * grid.length];
        int fillCounter = 0;
        unwind(grid, spiraled,fillCounter, 
            0, grid[0].length - 1, 0, grid.length - 1);
        System.out.println(as2DString(grid)+"\nprinted out spirally is\n"+Arrays.toString(spiraled));
    }

    static void unwind(int[][] grid, int[] toFill, int fillCounter,int columnStart,int columnEnd,int rowStart,int rowEnd){
        int width = columnEnd - columnStart + 1;
        int height = rowEnd - rowStart + 1;

        if(width < 1 || height < 1)//base case
            return;

        if(height >= 2){
            //copy top - left to right
            for (int i = columnStart; i <= columnEnd; i++) {
                toFill[fillCounter++] = grid[rowStart][i];
            }

            //insert inner right wall 
            for (int i = rowStart + 1; i < rowEnd ; i++) {
                toFill[fillCounter++] = grid[i][columnEnd];
            }

            //copy bottom - right to left
            for (int i = columnEnd; i >= columnStart; i--) {
                toFill[fillCounter++] = grid[rowEnd][i];
            }

            //insert inner left wall
            for (int i = rowEnd - 1; i > rowStart ; i--) {
                toFill[fillCounter++] = grid[i][columnStart];
            }

            unwind(grid, toFill, fillCounter, 
                columnStart + 1, columnEnd - 1, rowStart + 1, rowEnd - 1);

            return;
        }

        //inner grind is one row high, fill rest
        for (int i = columnStart; i <= columnEnd; i++) {
            toFill[fillCounter++] = grid[rowStart][i];
        }
    }
}