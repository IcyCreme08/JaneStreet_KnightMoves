import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Build Board
        Dictionary<Integer, Dictionary>[] board = new Hashtable[8]; //board

        Dictionary<Integer, Dictionary> columnA = new Hashtable<>(8);
        int[] columnA_Altitudes = {0, 1, 0, 2, 4, 4, 7, 9};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnA_Altitudes[i], 0);
            columnA.put(i, spot);
        }
        board[0] = columnA;

        Dictionary<Integer, Dictionary> columnB = new Hashtable<>(8);
        int[] columnB_Altitudes = {2, 2, 3, 6, 10, 7, 5, 11, 10};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnB_Altitudes[i], 0);
            columnB.put(i, spot);
        }
        board[1] = columnB;

        Dictionary<Integer, Dictionary> columnC = new Hashtable<>(8);
        int[] columnC_Altitudes = {4, 0, 1, 4, 7, 5, 11, 10};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnC_Altitudes[i], 0);
            columnC.put(i, spot);
        }
        board[2] = columnC;

        Dictionary<Integer, Dictionary> columnD = new Hashtable<>(8);
        int[] columnD_Altitudes = {3, 1, 4, 2, 9, 8, 9, 12};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnD_Altitudes[i], 0);
            columnD.put(i, spot);
        }
        board[3] = columnD;

        Dictionary<Integer, Dictionary> columnE = new Hashtable<>(8);
        int[] columnE_Altitudes = {5, 2, 2, 5, 6, 8, 10, 11};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnE_Altitudes[i], 0);
            columnE.put(i, spot);
        }
        board[4] = columnE;

        Dictionary<Integer, Dictionary> columnF = new Hashtable<>(8);
        int[] columnF_Altitudes = {6, 5, 7, 9, 8, 6, 12, 8};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnF_Altitudes[i], 0);
            columnF.put(i, spot);
        }
        board[5] = columnF;

        Dictionary<Integer, Dictionary> columnG = new Hashtable<>(8);
        int[] columnG_Altitudes = {2, 7, 10, 8, 7, 13, 14, 10};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnG_Altitudes[i], 0);
            columnG.put(i, spot);
        }
        board[6] = columnG;

        Dictionary<Integer, Dictionary> columnH = new Hashtable<>(8);
        int[] columnH_Altitudes = {4, 6, 7, 11, 9, 10, 12, 17};
        for(int i = 0; i < 8; i++) {
            Dictionary<Integer, Integer> spot = new Hashtable<>(2);
            spot.put(columnH_Altitudes[i], 0);
            columnH.put(i, spot);
        }
        board[7] = columnH;

        for(Dictionary column: board){
            System.out.println(column);
            /*for(Enumeration lattices = column.keys(); lattices.hasMoreElements();){
                Dictionary lattice = lattices.nextElement();
                System.out.println(lattices.nextElement());
            }*/
        }









    }
}