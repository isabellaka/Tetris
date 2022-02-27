/*
 * Multidimensional arrays
 * This project prints 4 different matrices representing tetris gaming pieces and rotates and prints them 4 times.
 * Author: Isabella Kainer
 * Last Change: 15/12/2021
 */

public class Tetris {

    //prints all matrices
    public static void printMatrices(char[][][] matrices) {
        boolean firstElementInLine = true;

        for (int lineNumber = 0; lineNumber < 4; lineNumber++) {
            for (int matrix = 0; matrix < 4; matrix++) {
                if (!firstElementInLine) {
                    System.out.print(" ");
                }
                for (char element : matrices[matrix][lineNumber]) {
                    if (!firstElementInLine) {
                        System.out.print(" ");
                    } else {
                        firstElementInLine = false;
                    }
                    System.out.print(element);
                }
            }
            firstElementInLine = true;
            System.out.println();
        }
    }

    //rotates the matrices by 90 degrees --> every column becomes the corresponding line (number of column equals number of line)
    public static char[][][] rotateMatrices(char[][][] matrices) {
        char[][][] newMatrices = new char[4][4][4];

        for (int matrix = 0; matrix < 4; matrix++) {
            for (int column = 0; column < 4; column++) {
                newMatrices[matrix][column][3] = matrices[matrix][0][column]; //the first element of the column becomes the last element of the line
                newMatrices[matrix][column][2] = matrices[matrix][1][column];
                newMatrices[matrix][column][1] = matrices[matrix][2][column];
                newMatrices[matrix][column][0] = matrices[matrix][3][column]; //the last element of the column becomes the first element of the line
            }
        }
        return newMatrices;
    }

    public static void main(String[] args) {
        char[][][] matrices = {{{'-', '-', '-', '-'}, //matrix 1
                                {'-', 'o', '-', '-'},
                                {'o', 'o', 'o', '-'},
                                {'-', '-', '-', '-'}},
                               {{'-', '-', '-', '-'}, //matrix 2
                                {'-', 'o', 'o', '-'},
                                {'o', 'o', '-', '-'},
                                {'-', '-', '-', '-'}},
                               {{'-', '-', '-', '-'}, //matrix 3
                                {'-', 'o', '-', '-'},
                                {'-', 'o', '-', '-'},
                                {'-', 'o', 'o', '-'}},
                               {{'-', '-', 'o', '-'}, //matrix 4
                                {'-', '-', 'o', '-'},
                                {'-', '-', 'o', '-'},
                                {'-', '-', 'o', '-'}}};


        printMatrices(matrices);

        //rotates and prints the matrices 4 times
        for (int i = 0; i < 4; i++) {
            System.out.println();
            matrices = rotateMatrices(matrices);
            printMatrices(matrices);
        }
    }

}
