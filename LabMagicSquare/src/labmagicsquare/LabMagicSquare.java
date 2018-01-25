/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmagicsquare;

/**
 *
 * @author Spectra
 */
public class LabMagicSquare {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] square = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}};
        System.out.printf("Square %s a magic square. %n",
                (isMagicSquare(square) ? "is" : "is not"));
    }

    public static boolean isMagicSquare(int[][] square) {
        int magicNum = 0;
        boolean answer = true;
        for (int i = 0; i <= square.length - 1; i++) //across and down counting
        {
            int down = i;
            int sumNum = 0;
            int sumNum2 = 0;

            for (int j = 0; j <= square[0].length - 1; j++) {
                int across = j;
                sumNum += square[down][across];
                sumNum2 += square[across][down];
            }
            if (magicNum == 0 && sumNum == sumNum2) {
                magicNum = sumNum;
            } else if (sumNum != magicNum || sumNum2 != magicNum) {
                answer = false;
                break;
            }
        }
        if (answer == false) {
            return false;
        }
        
        

        int backSlash = 0;             //diagonal counting
        int forwardSlash = 0;
        for (int i = 0; i <= square.length - 1; i++) {
            backSlash += square[i][i];
            forwardSlash += square[i][(square[0].length - 1) - i];
        }
        if (backSlash != magicNum || forwardSlash != magicNum) {
            return false;
        }

        return answer;
    }

}
