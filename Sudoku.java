// https://medium.com/javarevisited/build-a-sudoku-solver-in-java-part-1-c308bd511481
// found this on the internet but did not really refer that much to it

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudoku{

    public static int[][] startingGrid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    }; // Initial grid that will later be given specific values

    int[][] grid;

    public Sudoku(int[][] grid){
        this.grid = new int[9][9];
        for(int i = 0; i<9; i++){
            for(int j =0; j<9;j++){
                this.grid[i][j] = grid[i][j];
            }
        }
        // A sudoku constructor that initializes the grid and copies all the values
        // from startingGrid to grid
    }


    boolean isInRow(int row, int value){
        for(int i = 0; i<grid[row].length; i++){
            if( grid[row][i] == value)
                return true;
        }
        return false;
        //checks if a given nu,ver is already present in the given row
    }

    boolean isInColumn(int col, int value){
        for(int i = 0; i<grid.length; i++){
            if(grid[i][col] == value)
                return true;
        }
        return false;
        //checks if the given value is already present in the given column
    }

    boolean searchSquare(int row, int col, int value){
        for(int i = row; i < row + 3; i++){
            for(int j = col; j< col+3; j++){
                if(grid[i][j] == value)
                    return true;
            }
        }
        return false;
        //checks if the given value is already present in the given square
    }

    boolean isInSquare(int row, int col, int value){
        if(row>=0 && row<=2){
            if(col>=0 && col<=2){
                return searchSquare(0, 0, value);
            }
            if(col>=3 && col<=5){
                return searchSquare(0, 3, value);
            }
            if(col>=6 && col<=8){
                return searchSquare(0, 6, value);
            }
        }

        if(row>=3 && row<=5){
            if(col>=0 && col<=2){
                return searchSquare(3, 0, value);
            }
            if(col>=3 && col<=5){
                return searchSquare(3, 3, value);
            }
            if(col>=6 && col<=8){
                return searchSquare(3, 6, value);
            }
        }

        if(row>=6 && row<=8){
            if(col>=0 && col<=2){
                return searchSquare(6, 0, value);
            }
            if(col>=3 && col<=5){
                return searchSquare(6, 3, value);
            }
            if(col>=6 && col<=8){
                return searchSquare(6, 6, value);
            }
        }
        return false;
        //tells what square to search based on the location of the given value

    }

    public boolean solve(){
        for(int i = 0; i<9; i++){
            for(int j =0; j<9; j++){

                if(grid[i][j] == 0){
                    for(int num = 1; num<=9; num++){
                        if(!isInRow(i, num) && !isInColumn(j, num) && !isInSquare(i, j, num)){
                            grid[i][j] = num;
                            if(solve())
                                return true;
                            else grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
        //for each element in the array, loops through ints 1-9 and recursively solves the sudoku

    }

    public void print(long a){
        String answer = "";

        for(int i = 0; i<9;i++){
            for(int j = 0; j<9;j++){
                answer += grid[i][j] + "  ";
            }
            answer+= "\n";
        }
        answer+= "\n"  + "Solved in " + (System.currentTimeMillis() - a) + " milliseconds";

        JFrame frame = new JFrame("Solved Sudoku");
        JTextArea answered = new JTextArea(answer);
        answered.setBounds(0,0,175,200);
        frame.add(answered);
        frame.setSize(175,225);
        frame.setLayout(null);
        frame.setVisible(true);

        //creates a string with the solved sudoku, then creates a JFrame and adds text to it
    }


    public static void main(String[] args) {
        GUI();

    }
    public static void callSudoku(){
        long startingTime = System.currentTimeMillis();
        Sudoku sudoku = new Sudoku(startingGrid);

        if (sudoku.solve()) {
            sudoku.print(startingTime);
            System.out.println();
            //solves sudoku and records the time to calculate the running time
        }
        else
            System.out.println("Unsolvable");
    }
    public static void GUI(){
        JFrame frame = new JFrame("Sudoku solver");
        JTextField f1, f2, f3, f4, f5, f6, f7, f8, f9;
        JTextField f10, f11, f12, f13, f14, f15, f16, f17;
        JTextField f18, f19, f20, f21, f22, f23, f24, f25;
        JTextField f26,f27, f28, f29, f30, f31, f32, f33;
        JTextField f34, f35, f36, f37, f38, f39, f40, f41;
        JTextField f42, f43, f44, f45, f46, f47, f48, f49;
        JTextField f50, f51, f52, f53, f54, f55, f56, f57;
        JTextField f58, f59, f60, f61, f62, f63, f64, f65;
        JTextField f66, f67, f68, f69, f70, f71, f72, f73;
        JTextField f74, f75, f76, f77, f78, f79, f80, f81;
        //creates 81 text fields for all elements of sudoku

        f1=new JTextField("0");
        f1.setBounds(0,0, 50,50);
        f1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][0] = Integer.parseInt(f1.getText());
            }
            //waits for a number to be entered, then passes the value to the startingGrig
        });

        f2=new JTextField("0");
        f2.setBounds(50,0, 50,50);
        f2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][1] = Integer.parseInt(f2.getText());
            }
        });
        f3 = new JTextField("0");
        f3.setBounds(100,0, 50,50);
        f3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][2] = Integer.parseInt(f3.getText());
            }
        });
        f4 = new JTextField("0");
        f4.setBounds(150,0, 50,50);
        f4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][3] = Integer.parseInt(f4.getText());
            }
        });
        f5 = new JTextField("0");
        f5.setBounds(200,0, 50,50);
        f5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][4] = Integer.parseInt(f5.getText());
            }
        });
        f6 = new JTextField("0");
        f6.setBounds(250,0, 50,50);
        f6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][5] = Integer.parseInt(f6.getText());
            }
        });
        f7 = new JTextField("0");
        f7.setBounds(300,0, 50,50);
        f7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][6] = Integer.parseInt(f7.getText());
            }
        });
        f8 = new JTextField("0");
        f8.setBounds(350,0, 50,50);
        f8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][7] = Integer.parseInt(f8.getText());
            }
        });
        f9 = new JTextField("0");
        f9.setBounds(400,0, 50,50);
        f9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[0][8] = Integer.parseInt(f9.getText());
            }
        });
        f10 = new JTextField("0");
        f10.setBounds(0,50, 50,50);
        f10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][0] = Integer.parseInt(f10.getText());
            }
        });
        f11 = new JTextField("0");
        f11.setBounds(50,50, 50,50);
        f11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][1] = Integer.parseInt(f11.getText());
            }
        });
        f12 = new JTextField("0");
        f12.setBounds(100,50, 50,50);
        f12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][2] = Integer.parseInt(f12.getText());
            }
        });
        f13 = new JTextField("0");
        f13.setBounds(150,50, 50,50);
        f13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][3] = Integer.parseInt(f13.getText());
            }
        });
        f14 = new JTextField("0");
        f14.setBounds(200,50, 50,50);
        f14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][4] = Integer.parseInt(f14.getText());
            }
        });
        f15 = new JTextField("0");
        f15.setBounds(250,50, 50,50);
        f15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][5] = Integer.parseInt(f15.getText());
            }
        });
        f16 = new JTextField("0");
        f16.setBounds(300,50, 50,50);
        f16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][6] = Integer.parseInt(f16.getText());
            }
        });
        f17 = new JTextField("0");
        f17.setBounds(350,50, 50,50);
        f17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][7] = Integer.parseInt(f17.getText());
            }
        });
        f18 = new JTextField("0");
        f18.setBounds(400,50, 50,50);
        f18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[1][8] = Integer.parseInt(f18.getText());
            }
        });
        f19 = new JTextField("0");
        f19.setBounds(0,100, 50,50);
        f19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][0] = Integer.parseInt(f19.getText());
            }
        });
        f20 = new JTextField("0");
        f20.setBounds(50,100, 50,50);
        f20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][1] = Integer.parseInt(f20.getText());
            }
        });
        f21 = new JTextField("0");
        f21.setBounds(100,100, 50,50);
        f21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][2] = Integer.parseInt(f21.getText());
            }
        });
        f22 = new JTextField("0");
        f22.setBounds(150,100, 50,50);
        f22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][3] = Integer.parseInt(f22.getText());
            }
        });
        f23 = new JTextField("0");
        f23.setBounds(200,100, 50,50);
        f23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][4] = Integer.parseInt(f23.getText());
            }
        });
        f24 = new JTextField("0");
        f24.setBounds(250,100, 50,50);
        f24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][5] = Integer.parseInt(f24.getText());
            }
        });
        f25 = new JTextField("0");
        f25.setBounds(300,100, 50,50);
        f25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][6] = Integer.parseInt(f25.getText());
            }
        });
        f26 = new JTextField("0");
        f26.setBounds(350,100, 50,50);
        f26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][7] = Integer.parseInt(f26.getText());
            }
        });
        f27 = new JTextField("0");
        f27.setBounds(400,100, 50,50);
        f27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[2][8] = Integer.parseInt(f27.getText());
            }
        });
        f28 = new JTextField("0");
        f28.setBounds(0,150, 50,50);
        f28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][0] = Integer.parseInt(f28.getText());
            }
        });
        f29 = new JTextField("0");
        f29.setBounds(50,150, 50,50);
        f29.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][1] = Integer.parseInt(f29.getText());
            }
        });
        f30 = new JTextField("0");
        f30.setBounds(100,150, 50,50);
        f30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][2] = Integer.parseInt(f30.getText());
            }
        });
        f31 = new JTextField("0");
        f31.setBounds(150,150, 50,50);
        f31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][3] = Integer.parseInt(f31.getText());
            }
        });
        f32 = new JTextField("0");
        f32.setBounds(200,150, 50,50);
        f32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][4] = Integer.parseInt(f32.getText());
            }
        });
        f33 = new JTextField("0");
        f33.setBounds(250,150, 50,50);
        f33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][5] = Integer.parseInt(f33.getText());
            }
        });
        f34 = new JTextField("0");
        f34.setBounds(300,150, 50,50);
        f34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][6] = Integer.parseInt(f34.getText());
            }
        });
        f35 = new JTextField("0");
        f35.setBounds(350,150, 50,50);
        f35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][7] = Integer.parseInt(f35.getText());
            }
        });
        f36 = new JTextField("0");
        f36.setBounds(400,150, 50,50);
        f36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[3][8] = Integer.parseInt(f36.getText());
            }
        });
        f37 = new JTextField("0");
        f37.setBounds(0,200, 50,50);
        f37.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][0] = Integer.parseInt(f37.getText());
            }
        });
        f38 = new JTextField("0");
        f38.setBounds(50,200, 50,50);
        f38.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][1] = Integer.parseInt(f38.getText());
            }
        });
        f39 = new JTextField("0");
        f39.setBounds(100,200, 50,50);
        f39.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][2] = Integer.parseInt(f39.getText());
            }
        });
        f40 = new JTextField("0");
        f40.setBounds(150,200, 50,50);
        f40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][3] = Integer.parseInt(f40.getText());
            }
        });
        f41 = new JTextField("0");
        f41.setBounds(200,200, 50,50);
        f41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][4] = Integer.parseInt(f41.getText());
            }
        });
        f42 = new JTextField("0");
        f42.setBounds(250,200, 50,50);
        f42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][5] = Integer.parseInt(f42.getText());
            }
        });
        f43 = new JTextField("0");
        f43.setBounds(300,200, 50,50);
        f43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][6] = Integer.parseInt(f43.getText());
            }
        });
        f44 = new JTextField("0");
        f44.setBounds(350,200, 50,50);
        f44.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][7] = Integer.parseInt(f44.getText());
            }
        });
        f45 = new JTextField("0");
        f45.setBounds(400,200, 50,50);
        f45.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[4][8] = Integer.parseInt(f45.getText());
            }
        });
        f46 = new JTextField("0");
        f46.setBounds(0,250, 50,50);
        f46.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][0] = Integer.parseInt(f46.getText());
            }
        });
        f47 = new JTextField("0");
        f47.setBounds(50,250, 50,50);
        f47.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][1] = Integer.parseInt(f47.getText());
            }
        });
        f48 = new JTextField("0");
        f48.setBounds(100,250, 50,50);
        f48.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][2] = Integer.parseInt(f48.getText());
            }
        });
        f49 = new JTextField("0");
        f49.setBounds(150,250, 50,50);
        f49.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][3] = Integer.parseInt(f49.getText());
            }
        });
        f50 = new JTextField("0");
        f50.setBounds(200,250, 50,50);
        f50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][4] = Integer.parseInt(f50.getText());
            }
        });
        f51 = new JTextField("0");
        f51.setBounds(250,250, 50,50);
        f51.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][5] = Integer.parseInt(f51.getText());
            }
        });
        f52 = new JTextField("0");
        f52.setBounds(300,250, 50,50);
        f52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][6] = Integer.parseInt(f52.getText());
            }
        });
        f53 = new JTextField("0");
        f53.setBounds(350,250, 50,50);
        f53.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][7] = Integer.parseInt(f53.getText());
            }
        });
        f54 = new JTextField("0");
        f54.setBounds(400,250, 50,50);
        f54.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[5][8] = Integer.parseInt(f54.getText());
            }
        });
        f55 = new JTextField("0");
        f55.setBounds(0,300, 50,50);
        f55.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][0] = Integer.parseInt(f55.getText());
            }
        });
        f56 = new JTextField("0");
        f56.setBounds(50,300, 50,50);
        f56.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][1] = Integer.parseInt(f56.getText());
            }
        });
        f57 = new JTextField("0");
        f57.setBounds(100,300, 50,50);
        f57.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][2] = Integer.parseInt(f57.getText());
            }
        });
        f58 = new JTextField("0");
        f58.setBounds(150,300, 50,50);
        f58.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][3] = Integer.parseInt(f58.getText());
            }
        });
        f59 = new JTextField("0");
        f59.setBounds(200,300, 50,50);
        f59.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][4] = Integer.parseInt(f59.getText());
            }
        });
        f60 = new JTextField("0");
        f60.setBounds(250,300, 50,50);
        f60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][5] = Integer.parseInt(f60.getText());
            }
        });
        f61 = new JTextField("0");
        f61.setBounds(300,300, 50,50);
        f61.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][6] = Integer.parseInt(f61.getText());
            }
        });
        f62 = new JTextField("0");
        f62.setBounds(350,300, 50,50);
        f62.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][7] = Integer.parseInt(f62.getText());
            }
        });
        f63 = new JTextField("0");
        f63.setBounds(400,300, 50,50);
        f63.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[6][8] = Integer.parseInt(f63.getText());
            }
        });
        f64 = new JTextField("0");
        f64.setBounds(0,350, 50,50);
        f64.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][0] = Integer.parseInt(f64.getText());
            }
        });
        f65 = new JTextField("0");
        f65.setBounds(50,350, 50,50);
        f65.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][1] = Integer.parseInt(f65.getText());
            }
        });
        f66 = new JTextField("0");
        f66.setBounds(100,350, 50,50);
        f66.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][2] = Integer.parseInt(f66.getText());
            }
        });
        f67 = new JTextField("0");
        f67.setBounds(150,350, 50,50);
        f67.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][3] = Integer.parseInt(f67.getText());
            }
        });
        f68 = new JTextField("0");
        f68.setBounds(200,350, 50,50);
        f68.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][4] = Integer.parseInt(f68.getText());
            }
        });
        f69 = new JTextField("0");
        f69.setBounds(250,350, 50,50);
        f69.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][5] = Integer.parseInt(f69.getText());
            }
        });
        f70 = new JTextField("0");
        f70.setBounds(300,350, 50,50);
        f70.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][6] = Integer.parseInt(f70.getText());
            }
        });
        f71 = new JTextField("0");
        f71.setBounds(350,350, 50,50);
        f71.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][7] = Integer.parseInt(f71.getText());
            }
        });
        f72 = new JTextField("0");
        f72.setBounds(400,350, 50,50);
        f72.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[7][8] = Integer.parseInt(f72.getText());
            }
        });
        f73 = new JTextField("0");
        f73.setBounds(0,400, 50,50);
        f73.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][0] = Integer.parseInt(f73.getText());
            }
        });
        f74 = new JTextField("0");
        f74.setBounds(50,400, 50,50);
        f74.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][1] = Integer.parseInt(f74.getText());
            }
        });
        f75 = new JTextField("0");
        f75.setBounds(100,400, 50,50);
        f75.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][2] = Integer.parseInt(f75.getText());
            }
        });
        f76 = new JTextField("0");
        f76.setBounds(150,400, 50,50);
        f76.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][3] = Integer.parseInt(f76.getText());
            }
        });
        f77 = new JTextField("0");
        f77.setBounds(200,400, 50,50);
        f77.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][4] = Integer.parseInt(f77.getText());
            }
        });
        f78 = new JTextField("0");
        f78.setBounds(250,400, 50,50);
        f78.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][5] = Integer.parseInt(f78.getText());
            }
        });
        f79 = new JTextField("0");
        f79.setBounds(300,400, 50,50);
        f79.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][6] = Integer.parseInt(f79.getText());
            }
        });
        f80 = new JTextField("0");
        f80.setBounds(350,400, 50,50);
        f80.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][7] = Integer.parseInt(f80.getText());
            }
        });
        f81 = new JTextField("0");
        f81.setBounds(400,400, 50,50);
        f81.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startingGrid[8][8] = Integer.parseInt(f81.getText());
            }
        });
        frame.add(f1); frame.add(f2); frame.add(f3); frame.add(f4); frame.add(f5); frame.add(f6); frame.add(f7);
        frame.add(f8); frame.add(f9); frame.add(f10); frame.add(f11); frame.add(f12); frame.add(f13); frame.add(f14);
        frame.add(f15);frame.add(f16);frame.add(f17);frame.add(f18); frame.add(f19);frame.add(f20);frame.add(f21);
        frame.add(f22);frame.add(f23);frame.add(f24);frame.add(f25);frame.add(f26);frame.add(f27); frame.add(f28);
        frame.add(f29);frame.add(f30);frame.add(f31);frame.add(f32);frame.add(f33);frame.add(f34); frame.add(f35);
        frame.add(f36);frame.add(f37); frame.add(f38);frame.add(f39);frame.add(f40);frame.add(f41); frame.add(f42);
        frame.add(f43);frame.add(f44); frame.add(f45);frame.add(f46);frame.add(f47);frame.add(f48); frame.add(f49);
        frame.add(f50);frame.add(f51); frame.add(f52);frame.add(f53);frame.add(f54);frame.add(f55); frame.add(f56);
        frame.add(f57);frame.add(f58); frame.add(f59);frame.add(f60);frame.add(f61);frame.add(f62); frame.add(f63);
        frame.add(f64);frame.add(f65); frame.add(f66);frame.add(f67);frame.add(f68);frame.add(f69); frame.add(f70);
        frame.add(f71);frame.add(f72); frame.add(f73);frame.add(f74);frame.add(f75);frame.add(f76); frame.add(f77);
        frame.add(f78);frame.add(f79); frame.add(f80);frame.add(f81);
        //adds all 81 textFields to the JFrame

        JButton button = new JButton("Solve");
        button.setBounds(175, 465, 100, 50);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callSudoku();
            }
            //creates a button and calls callSudoku when button is pressed
        });
        frame.setSize(450,550);
        frame.setLayout(null);
        frame.setVisible(true);
        //makes the frame visible
    }
}
