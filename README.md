# sudoku_solver
### created Fall2019

In this project I created an algorithm that solves sudoky puzzles using GUI.
After running `sudoku.java` a window opens where you can enter the values of the sudoky puzzle that you want to solve./
<img src=pics/enter.jpg />
Lets say we want to solve the following sudoku, which has the f/ollowing solution:
<img src=pics/example.png />
After you enter your values your window should look like this:/
<img src=pics/entered.jpg />
And after pressing Solve a new window should be opened with the answers to your sudoku puzzle:/
<img src=pics/solved.jpg />/
The algorithm for solving the sudoku uses a backtracking algorithm that recursively illiminates the solutions that fail to saitisfu the suku requirments (repeating numbers in colums, rows and diagonals)
