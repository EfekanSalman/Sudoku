import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku");
        SudokuGrid grid = new SudokuGrid();
        JButton solveButton = new JButton("Solve");
        JButton resetButton = new JButton("Reset");
        JButton generateButton = new JButton("Generate");

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] board = grid.getGrid();
                if (SudokuSolver.solve(board)) {
                    grid.setGrid(board);
                } else {
                    JOptionPane.showMessageDialog(frame, "Unsolvable Sudoku!");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.resetGrid();
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] generatedBoard = SudokuGenerator.generate();
                grid.setGrid(generatedBoard);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(generateButton);

        frame.add(grid, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
