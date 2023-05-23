
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoard extends JPanel{
  private static final long serialVersionUID = 1L;
  
   public static final int CELL_SIZE = 60; 
   public static final int BOARD_WIDTH  = CELL_SIZE * SudokuNumbers.GRID_SIZE;
   public static final int BOARD_HEIGHT = CELL_SIZE * SudokuNumbers.GRID_SIZE;
   CellInputListener listener = new CellInputListener();

  private Cell[][] cells = new Cell[SudokuNumbers.GRID_SIZE][SudokuNumbers.GRID_SIZE];
  private Puzzle puzzle = new Puzzle();

  public GameBoard() {
      super.setLayout(new GridLayout(SudokuNumbers.GRID_SIZE, SudokuNumbers.GRID_SIZE));

      for (int row = 0; row < SudokuNumbers.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuNumbers.GRID_SIZE; ++col) {
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]);
         }
      }

    super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

    for (int row = 0; row < SudokuNumbers.GRID_SIZE; ++row) {
      for (int col = 0; col < SudokuNumbers.GRID_SIZE; ++col) {
         if (cells[row][col].isEditable()) {
          cells[row][col].addActionListener(listener);
      }
    }
  }
   }

  public void newGame() {
      puzzle.newPuzzle(46);

      for (int row = 0; row < SudokuNumbers.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuNumbers.GRID_SIZE; ++col) {
            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
         }
      }
  }

  public boolean isSolved(){
    for(int row = 0; row < SudokuNumbers.GRID_SIZE; ++row){
      for(int col = 0; col < SudokuNumbers.GRID_SIZE; ++col){
        if(cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS)
            return false;
      }
    }
    return true;
  }

  private class CellInputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
       // Get a reference of the JTextField that triggers this action event
       Cell sourceCell = (Cell)e.getSource();
   
       // Retrieve the int entered
       int numberIn = Integer.parseInt(sourceCell.getText());
       // For debugging
       System.out.println("You entered " + numberIn);
          if (numberIn == sourceCell.number) {
            sourceCell.status = CellStatus.CORRECT_GUESS;
          } else {
            sourceCell.status = CellStatus.WRONG_GUESS;
          }
          sourceCell.paint();   // re-paint this cell based on its status

          if(isSolved()){
            JOptionPane.showMessageDialog(null, "Congratulation!");
          }
    }
  }
}