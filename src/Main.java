import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- 9X9 COLOR SUDOKU GAME ---");

        Sudoku sudoku = new Sudoku();

        ArrayList<JButton> colorButtons = new ArrayList<JButton>();

        JFrame frame = new JFrame("9X9 COLOR SUDOKU GAME - OMER FARUK KUCUK");

        JFrame colorFrame = new JFrame("9X9 COLOR SUDOKU GAME - OMER FARUK KUCUK");
        colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorFrame.setSize(200,700);
        colorFrame.setLayout(new GridLayout(9,1));
        colorFrame.setVisible(true);
        for (int c = 1; c <= 9; c++) {
            JButton colorButton = new JButton();
            colorButton.setBackground(SudokuUtils.getColor(c));
            colorButton.setForeground(Color.WHITE);
            if (colorButton.getBackground() == Color.CYAN) {
                colorButton.setForeground(Color.BLACK);
            }
            colorButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            colorButton.setText(SudokuUtils.getColorName(c));
            colorButton.setFont(new Font("Arial", Font.PLAIN, 28));
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton cButton: colorButtons) {
                        cButton.setForeground(Color.WHITE);
                    }
                    sudoku.handColor = colorButton.getBackground();
                    colorButton.setForeground(Color.BLACK);
                }
            });
            colorButtons.add(colorButton);
            colorFrame.getContentPane().add(colorButton);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setLayout(new GridLayout(9,9));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        ArrayList<JButton> sudokuButtons = new ArrayList<JButton>();
        for (int y = 0; y < sudoku.grid.length; y++) {
            for(int x = 0; x < sudoku.grid[y].length; x++) {
                JButton buttonContext = new JButton("");
                buttonContext.setBackground(SudokuUtils.getColor(sudoku.grid[y][x]));
                buttonContext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (sudoku.grid[y][x] != 0) {
                    buttonContext.setEnabled(false);
                }
                int finalNum = sudoku.grid[y][x];
                int rowIndex = y;
                int colIndex = x;
                buttonContext.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (buttonContext.getBackground() != Color.WHITE && buttonContext.isEnabled()) {
                            buttonContext.setBackground(Color.WHITE);
                            buttonContext.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            sudoku.grid[rowIndex][colIndex] = SudokuUtils.getColorNumber(Color.WHITE);
                            return;
                        }
                        if (buttonContext.getBackground() == Color.WHITE) {
                            if (sudoku.verify(sudoku.grid, SudokuUtils.getColorNumber(sudoku.handColor), rowIndex, colIndex)) {
                                buttonContext.setBackground(sudoku.handColor);
                                buttonContext.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
                                sudoku.grid[rowIndex][colIndex] = SudokuUtils.getColorNumber(sudoku.handColor);
                                if (sudoku.isGameEnd()) {
                                    JOptionPane.showMessageDialog(frame, "It is okay, congratulations!");
                                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                    colorFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                    System.exit(0);
                                }
                            }
                        }
                    }
                });
                frame.getContentPane().add(buttonContext);
            }
        }

        frame.setVisible(true);

    }

}
