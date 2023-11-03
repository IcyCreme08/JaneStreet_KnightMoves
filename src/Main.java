import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Build Board
        Hashtable[] board = new Hashtable[8]; //board

        Hashtable columnA = new Hashtable<>(8);
        int[] columnA_Altitudes = {0, 1, 0, 2, 4, 4, 7, 9};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnA_Altitudes[i]);
            columnA.put(i, spot);
        }
        board[0] = columnA;

        Hashtable columnB = new Hashtable<>(8);
        int[] columnB_Altitudes = {2, 2, 3, 6, 10, 7, 5, 11, 10};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnB_Altitudes[i]);
            columnB.put(i, spot);
        }
        board[1] = columnB;

        Hashtable columnC = new Hashtable<>(8);
        int[] columnC_Altitudes = {4, 0, 1, 4, 7, 5, 11, 10};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnC_Altitudes[i]);
            columnC.put(i, spot);
        }
        board[2] = columnC;

        Hashtable columnD = new Hashtable<>(8);
        int[] columnD_Altitudes = {3, 1, 4, 2, 9, 8, 9, 12};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnD_Altitudes[i]);
            columnD.put(i, spot);
        }
        board[3] = columnD;

        Hashtable columnE = new Hashtable<>(8);
        int[] columnE_Altitudes = {5, 2, 2, 5, 6, 8, 10, 11};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnE_Altitudes[i]);
            columnE.put(i, spot);
        }
        board[4] = columnE;

        Hashtable columnF = new Hashtable<>(8);
        int[] columnF_Altitudes = {6, 5, 7, 9, 8, 6, 12, 8};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnF_Altitudes[i]);
            columnF.put(i, spot);
        }
        board[5] = columnF;

        Hashtable columnG = new Hashtable<>(8);
        int[] columnG_Altitudes = {2, 7, 10, 8, 7, 13, 14, 10};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnG_Altitudes[i]);
            columnG.put(i, spot);
        }
        board[6] = columnG;

        Hashtable columnH = new Hashtable<>(8);
        int[] columnH_Altitudes = {4, 6, 7, 11, 9, 10, 12, 17};
        for(int i = 0; i < 8; i++) {
            Lattice spot = new Lattice(columnH_Altitudes[i]);
            columnH.put(i, spot);
        }
        board[7] = columnH;

        for(int row = 7; row >= 0; row--) {
            for (Dictionary column : board) {
                System.out.print((column.get(row)).getAltitude());
            }
            System.out.println();
        }









    }
}