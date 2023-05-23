public class Puzzle{
  int[][] numbers = new int[SudokuNumbers.GRID_SIZE][SudokuNumbers.GRID_SIZE];
  boolean[][] isGiven = new boolean[SudokuNumbers.GRID_SIZE][SudokuNumbers.GRID_SIZE];

  public Puzzle(){
    super();
  }

  public void newPuzzle(int cellstoGuess){
    int[][] hardCodedcell = 
      {{5, 3, 6, 8, 2, 7, 9, 4, 1},
       {1, 7, 2, 9, 6, 4, 3, 5, 8},
       {8, 9, 4, 1, 5, 3, 2, 6, 7},
       {7, 1, 5, 3, 4, 9, 8, 2, 6},
       {6, 4, 3, 7, 8, 2, 1, 9, 5},
       {9, 2, 8, 5, 1, 6, 7, 3, 4},
       {4, 8, 1, 2, 9, 5, 6, 7, 3},
       {3, 6, 9, 4, 7, 1, 5, 8, 2},
       {2, 5, 7, 6, 3, 8, 4, 1, 9}};

    for (int row = 0; row < SudokuNumbers.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuNumbers.GRID_SIZE; ++col) {
            numbers[row][col] = hardCodedcell[row][col];
          }
    }

    boolean[][] hardcodedisGiven = 
      {{true, false, false, false, true, false, false, false, true},
          {true, false, true, false, false, true, true, false, false},
          {false, true, false, false, false, true, false, true, true},
          {false, true, false, true, true, false, true, false, true},
          {true, false, true, false, false, false, false, true, true},
          {false, true, false, true, false, false, true, false, true},
          {true, false, true, false, false, false, false, true, false},
          {true, false, false, false, false, true, false, false, true},
          {false, true, true, false, true, false, true, false, true}};

    for (int row = 0; row < SudokuNumbers.GRID_SIZE; ++row) {
         for (int col = 0; col < SudokuNumbers.GRID_SIZE; ++col) {
            isGiven[row][col] = hardcodedisGiven[row][col];
         }
      }
  }
  
}