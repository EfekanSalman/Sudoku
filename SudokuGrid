import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGrid extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField[][] cells;

    public SudokuGrid() {
        setLayout(new GridLayout(9, 9));
        cells = new JTextField[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                // Only allow numeric input
                cells[row][col].getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        handleInput(e);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        handleInput(e);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        handleInput(e);
                    }

                    private void handleInput(DocumentEvent e) {
                        try {
                            String text = e.getDocument().getText(0, e.getDocument().getLength());
                            if (!text.matches("\\d?")) {
                                e.getDocument().remove(0, e.getDocument().getLength());
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                // Add ActionListener to check for valid input
                cells[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField source = (JTextField) e.getSource();
                        String text = source.getText();
                        if (text.length() > 1 || (text.length() == 1 && !Character.isDigit(text.charAt(0)))) {
                            source.setText("");
                        }
                    }
                });

                add(cells[row][col]);

                // Border settings
                Border border = BorderFactory.createMatteBorder(
                    row % 3 == 0 ? 2 : 1,  // top border
                    col % 3 == 0 ? 2 : 1,  // left border
                    (row + 1) % 3 == 0 ? 2 : 1,  // bottom border
                    (col + 1) % 3 == 0 ? 2 : 1,  // right border
                    Color.BLACK
                );
                cells[row][col].setBorder(border);
            }
        }
    }

    public int[][] getGrid() {
        int[][] grid = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = cells[row][col].getText();
                grid[row][col] = text.isEmpty() ? 0 : Integer.parseInt(text);
            }
        }
        return grid;
    }

    public void setGrid(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText(grid[row][col] == 0 ? "" : String.valueOf(grid[row][col]));
            }
        }
    }

    public void resetGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText("");
            }
        }
    }
}
