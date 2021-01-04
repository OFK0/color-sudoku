import java.awt.*;

public class Sudoku {

    int[][] grid = new int[9][9];
    static int[] values = { 0,0,0,0,0,0,0,2,3,1,4,6,7,5,8,9 };

    Color handColor = Color.CYAN;

    public Sudoku() {
        this.build();
    }

    void build() {

        int num;
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < this.grid[y].length; x++) {
                do {
                    num = SudokuUtils.randomNumber();
                }
                while (!this.verify(this.grid, num, y, x));
                this.grid[y][x] = num;
            }
        }

        for (int _y = 0; _y < this.grid.length; _y++) {
            for (int _x = 0; _x < this.grid[_y].length; _x++) {
                System.out.print(" " + this.grid[_y][_x] + " ");
            }
            System.out.println("");
        }

    }

    boolean verify(int[][] grid, int number, int rowIndex, int colIndex) {
        if (number == 0) {
            return true;
        }

        if (this.isUsedInBox(grid, number, rowIndex, colIndex)) {
            return false;
        }

        if (this.isUsedInX(grid, number, rowIndex)) {
            return false;
        }

        if (this.isUsedInY(grid, number, colIndex)) {
            return false;
        }

        return true;
    }

    boolean isUsedInX(int[][] grid, int number, int rowIndex) {
        for(int x = 0; x < this.grid[rowIndex].length; x++) {
            if (this.grid[rowIndex][x] != 0) {
                if (this.grid[rowIndex][x] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isUsedInY(int[][] grid, int number, int colIndex) {
        for (int y = 0; y < this.grid.length; y++) {
            if (this.grid[y][colIndex] == number) {
                return true;
            }
        }
        return false;
    }

    boolean isUsedInBox(int[][] grid, int number, int rowIndex, int colIndex)
    {
        int xStartIndex = 0, yStartIndex = 0;

        int col = (colIndex + 1);
        if (col < 3) {
            xStartIndex = 0;
        }
        if (col > 3 && col < 7) {
            xStartIndex = 3;
        }
        if (col > 6 && col < 10) {
            xStartIndex = 6;
        }

        int row = (rowIndex + 1);
        if (row < 4) {
            yStartIndex = 0;
        }
        if (row > 3 && row < 7) {
            yStartIndex = 3;
        }
        if (row > 6 && row < 10) {
            yStartIndex = 6;
        }

        for (int y = yStartIndex; y <= yStartIndex+2; y++) {
            for (int x = xStartIndex; x <= xStartIndex+2; x++) {
                if (this.grid[y][x] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isGameEnd() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int x = 0; x < this.grid[i].length; x++) {
                if (this.grid[i][x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
