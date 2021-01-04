import java.awt.*;
import java.util.Random;

public class SudokuUtils {

    static int randomNumber() {
        Random random = new Random();
        return Sudoku.values[random.nextInt(Sudoku.values.length)];
    }

    static Color getColor(int number) {
        Color color = Color.WHITE;
        switch(number) {
            case 1:
                color = Color.CYAN;
            break;
            case 2:
                color = Color.BLUE;
            break;
            case 3:
                color = Color.YELLOW;
            break;
            case 4:
                color = Color.PINK;
            break;
            case 5:
                color = Color.GREEN;
            break;
            case 6:
                color = Color.MAGENTA;
            break;
            case 7:
                color = Color.RED;
            break;
            case 8:
                color = Color.ORANGE;
            break;
            case 9:
                color = Color.BLACK;
            break;
            default:
                color = Color.WHITE;
            break;
        }
        return color;
    }

    static int getColorNumber(Color color) {
        if (color == Color.CYAN) {
            return 1;
        }
        if (color == Color.BLUE) {
            return 2;
        }
        if (color == Color.YELLOW) {
            return 3;
        }
        if (color == Color.PINK) {
            return 4;
        }
        if (color == Color.GREEN) {
            return 5;
        }
        if (color == Color.MAGENTA) {
            return 6;
        }
        if (color == Color.RED) {
            return 7;
        }
        if (color == Color.ORANGE) {
            return 8;
        }
        if (color == Color.BLACK) {
            return 9;
        }
        return 0;
    }

    static String getColorName(int number) {
        String color = "White";
        switch(number) {
            case 1:
                color = "Cyan";
                break;
            case 2:
                color = "Blue";
                break;
            case 3:
                color = "Yellow";
                break;
            case 4:
                color = "Pink";
                break;
            case 5:
                color = "Green";
                break;
            case 6:
                color = "Magenta";
                break;
            case 7:
                color = "Red";
                break;
            case 8:
                color = "Orange";
                break;
            case 9:
                color = "Black";
                break;
        }
        return color;
    }

}
