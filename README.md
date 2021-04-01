# sudoku solver
##### created Fall2019

In this project I created an algorithm that solves sudoku puzzles with the help of GUI.
After running `sudoku.java` a window opens where you can enter the values of the sudoku puzzle that you want to solve. <br />
<img src=pics/enter.jpg />
<br /> Lets say we want to solve the following sudoku, which has the following solution: <br />
<img src=pics/example.png />
<br /> After you enter your values your window should look like this: <br />
<img src=pics/entered.jpg />
<br /> And after pressing Solve a new window should be opened with the answers to your sudoku puzzle: <br />
<img src=pics/solved.jpg /> <br />
<br /> The algorithm for solving the sudoku uses a backtracking algorithm that recursively illiminates the solutions that fail to saitisfy the sudoku requirments (repeating numbers in colums, rows and diagonals)
