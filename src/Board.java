import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.math.*;

public class Board {
    public String currentPos = "a1";
    public LinkedHashMap<String, HashMap<String, Lattice>> pastBoards = new LinkedHashMap<>();
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public HashMap<String, Lattice> board = new HashMap<String, Lattice>(64); //board
    public Board(){
        board.put("a1", new Lattice(0));
        board.put("a2", new Lattice(1));
        board.put("a3", new Lattice(0));
        board.put("a4", new Lattice(2));
        board.put("a5", new Lattice(4));
        board.put("a6", new Lattice(4));
        board.put("a7", new Lattice(7));
        board.put("a8", new Lattice(9));
        board.put("b1", new Lattice(2));
        board.put("b2", new Lattice(2));
        board.put("b3", new Lattice(3));
        board.put("b4", new Lattice(6));
        board.put("b5", new Lattice(10));
        board.put("b6", new Lattice(7));
        board.put("b7", new Lattice(9));
        board.put("b8", new Lattice(8));
        board.put("c1", new Lattice(4));
        board.put("c2", new Lattice(0));
        board.put("c3", new Lattice(1));
        board.put("c4", new Lattice(4));
        board.put("c5", new Lattice(7));
        board.put("c6", new Lattice(5));
        board.put("c7", new Lattice(11));
        board.put("c8", new Lattice(10));
        board.put("d1", new Lattice(3));
        board.put("d2", new Lattice(1));
        board.put("d3", new Lattice(4));
        board.put("d4", new Lattice(2));
        board.put("d5", new Lattice(9));
        board.put("d6", new Lattice(8));
        board.put("d7", new Lattice(9));
        board.put("d8", new Lattice(12));
        board.put("e1", new Lattice(5));
        board.put("e2", new Lattice(2));
        board.put("e3", new Lattice(2));
        board.put("e4", new Lattice(5));
        board.put("e5", new Lattice(6));
        board.put("e6", new Lattice(8));
        board.put("e7", new Lattice(10));
        board.put("e8", new Lattice(11));
        board.put("f1", new Lattice(6));
        board.put("f2", new Lattice(5));
        board.put("f3", new Lattice(7));
        board.put("f4", new Lattice(9));
        board.put("f5", new Lattice(8));
        board.put("f6", new Lattice(6));
        board.put("f7", new Lattice(12));
        board.put("f8", new Lattice(8));
        board.put("g1", new Lattice(2));
        board.put("g2", new Lattice(7));
        board.put("g3", new Lattice(10));
        board.put("g4", new Lattice(8));
        board.put("g5", new Lattice(7));
        board.put("g6", new Lattice(13));
        board.put("g7", new Lattice(14));
        board.put("g8", new Lattice(10));
        board.put("h1", new Lattice(4));
        board.put("h2", new Lattice(6));
        board.put("h3", new Lattice(7));
        board.put("h4", new Lattice(11));
        board.put("h5", new Lattice(9));
        board.put("h6", new Lattice(10));
        board.put("h7", new Lattice(12));
        board.put("h8", new Lattice(17));
    }
    public void printBoard(){
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        for(int row = 8; row >= 1; row--){
            System.out.print(row + " ");
            for(String column: letters) {
                double altitude = round((board.get(column + row)).getAltitude(), 2);
                String print = "|  " + altitude + "  |";
                if (String.valueOf(altitude).length() == 3) {
                    print = "| " + altitude + "  |";
                }else if(String.valueOf(altitude).length() == 4){
                    print = "| " + altitude + " |";
                }
                System.out.print(print);
            }
            System.out.println("\n  --------------------------------------------------------------");
        }
        System.out.print("  ");
        for(String letter: letters){
            System.out.print("   " + letter + "    ");
        }
        System.out.println();
    }
    public boolean validMove(String newPos){
        if(!board.containsKey(newPos)){
            return false;
        }
        Lattice spot = board.get(newPos);
        boolean hasNotVisitedThree = spot.getVisits() < 3;
        if(!hasNotVisitedThree){
            return false;
        }
        HashMap<String, Integer> letters = new HashMap<>();
        letters.put("a", 1);
        letters.put("b", 2);
        letters.put("c", 3);
        letters.put("d", 4);
        letters.put("e", 5);
        letters.put("f", 6);
        letters.put("g", 7);
        letters.put("h", 8);

        double xDifference = Math.abs(letters.get(newPos.substring(0, 1)) - letters.get(currentPos.substring(0, 1)));
        double yDifference = Math.abs(Integer.parseInt(newPos.substring(1)) - Integer.parseInt(currentPos.substring(1)));
        double zDifference = Math.abs(spot.getAltitude() - board.get(currentPos).getAltitude());
        double[] movements = new double[] {0, 1, 2};
        double[] differences = new double[] {xDifference, yDifference, zDifference};
        for(int i = 0; i < movements.length; i++){
            boolean moveInMovements = false;
            for(double difference: differences){
                if (difference == movements[i]) {
                    moveInMovements = true;
                    movements[i] = -1;
                    break;
                }
            }
            if(!moveInMovements){
                return false;
            }
        }
        return true;
    }
    public void move(String newPos){
        currentPos = newPos;
    }
    public void moveKnight(String newPos, int minutes){
        pastBoards.put(currentPos, new HashMap<String, Lattice>(board));
        //Find lattice of same altitude
        move(newPos);
        Lattice newSpot = board.get(newPos);
        HashMap<String, Integer> letterDict = new HashMap<>();
        letterDict.put("a", 1);
        letterDict.put("b", 2);
        letterDict.put("c", 3);
        letterDict.put("d", 4);
        letterDict.put("e", 5);
        letterDict.put("f", 6);
        letterDict.put("g", 7);
        letterDict.put("h", 8);
        String[] letters = new String[] {"a", "b", "c", "d", "e", "f", "g", "h"};
        String diametricallyOppositeSpotKey = letters[8 - letterDict.get(newPos.substring(0, 1))] + (9 - Integer.parseInt(newPos.substring(1)));
        Lattice diametricallyOppositeSpot = board.get(diametricallyOppositeSpotKey);
        ArrayList<String> similarSpots = new ArrayList<>();
        for (String lattice : board.keySet()) {
            if (newSpot.getAltitude() == board.get(lattice).getAltitude()) {
                similarSpots.add(lattice);
            }
        }
        double sink_rise = minutes * ((double)1 / similarSpots.size());
        diametricallyOppositeSpot.setAltitude(diametricallyOppositeSpot.getAltitude() + sink_rise);
        for (String spot : similarSpots) {
            Lattice toBeChanged = board.get(spot);
            toBeChanged.setAltitude(toBeChanged.getAltitude() - sink_rise);
        }
    }
    public void goBack(){
        String previous = pastBoards.lastEntry().getKey();
        board = pastBoards.get(previous);
        move(previous);
        pastBoards.remove(previous);
        printBoard();
    }
}
