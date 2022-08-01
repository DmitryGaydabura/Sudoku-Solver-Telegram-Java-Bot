import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Logic {


    public static String startApp(String n) {


        ArrayList<Integer> initialState = new ArrayList<>(81);
        String[] initialStateHorizontalString = n.split(" ");
        for (int i = 0; i < 81; i++) {
            initialState.add(Integer.parseInt(initialStateHorizontalString[i]));
        }

        String answer = Utility.printSudoku(initialState);


        createAndPrintInitialSudoku(initialState);
        ArrayList<Space> spaces = createArrayListWithAllSpaces(initialState);

        ArrayList<Space> Row0 = createRow0(spaces);
        ArrayList<Space> Row1 = createRow1(spaces);
        ArrayList<Space> Row2 = createRow2(spaces);
        ArrayList<Space> Row3 = createRow3(spaces);
        ArrayList<Space> Row4 = createRow4(spaces);
        ArrayList<Space> Row5 = createRow5(spaces);
        ArrayList<Space> Row6 = createRow6(spaces);
        ArrayList<Space> Row7 = createRow7(spaces);
        ArrayList<Space> Row8 = createRow8(spaces);

        ArrayList<Space> Col0 = createCol0(spaces);
        ArrayList<Space> Col1 = createCol1(spaces);
        ArrayList<Space> Col2 = createCol2(spaces);
        ArrayList<Space> Col3 = createCol3(spaces);
        ArrayList<Space> Col4 = createCol4(spaces);
        ArrayList<Space> Col5 = createCol5(spaces);
        ArrayList<Space> Col6 = createCol6(spaces);
        ArrayList<Space> Col7 = createCol7(spaces);
        ArrayList<Space> Col8 = createCol8(spaces);

        ArrayList<Space> Squ0 = getArrayListOfHashSetsOfSquares(spaces).get(0);
        ArrayList<Space> Squ1 = getArrayListOfHashSetsOfSquares(spaces).get(1);
        ArrayList<Space> Squ2 = getArrayListOfHashSetsOfSquares(spaces).get(2);
        ArrayList<Space> Squ3 = getArrayListOfHashSetsOfSquares(spaces).get(3);
        ArrayList<Space> Squ4 = getArrayListOfHashSetsOfSquares(spaces).get(4);
        ArrayList<Space> Squ5 = getArrayListOfHashSetsOfSquares(spaces).get(5);
        ArrayList<Space> Squ6 = getArrayListOfHashSetsOfSquares(spaces).get(6);
        ArrayList<Space> Squ7 = getArrayListOfHashSetsOfSquares(spaces).get(7);
        ArrayList<Space> Squ8 = getArrayListOfHashSetsOfSquares(spaces).get(8);

        ArrayList<ArrayList<Space>> allSets = new ArrayList<>();
        allSets.add(Row0);
        allSets.add(Row1);
        allSets.add(Row2);
        allSets.add(Row3);
        allSets.add(Row4);
        allSets.add(Row5);
        allSets.add(Row6);
        allSets.add(Row7);
        allSets.add(Row8);

        allSets.add(Col0);
        allSets.add(Col1);
        allSets.add(Col2);
        allSets.add(Col3);
        allSets.add(Col4);
        allSets.add(Col5);
        allSets.add(Col6);
        allSets.add(Col7);
        allSets.add(Col8);

        allSets.add(Squ0);
        allSets.add(Squ1);
        allSets.add(Squ2);
        allSets.add(Squ3);
        allSets.add(Squ4);
        allSets.add(Squ5);
        allSets.add(Squ6);
        allSets.add(Squ7);
        allSets.add(Squ8);

        for (int j = 0; j < 20; j++) {

            for (int i = 0; i < 27; i++) {
                int lastElement = findLastElementInSet(allSets.get(i));
                if (lastElement == 0) {
                    continue;
                }
                int indexOfSpace = 0;
                indexOfSpace = getOndexOfSpaceWith0(allSets.get(i));
                allSets.get(i).get(indexOfSpace).setElement(lastElement);

            }
        }

        return answer + Utility.printSudokuFromAllSets(allSets);


    }

    private static int getOndexOfSpaceWith0(ArrayList<Space> spaces) {
        for (int i = 0; i < 9; i++) {
            if (spaces.get(i).getElement() == 0) {
                return i;
            }
        }
        return 0;
    }

    public static ArrayList<ArrayList<Space>> getArrayListOfHashSetsOfSquares(ArrayList<Space> spaces) {
        ArrayList<Space> Squ0 = new ArrayList<>();
        ArrayList<Space> Squ1 = new ArrayList<>();
        ArrayList<Space> Squ2 = new ArrayList<>();
        ArrayList<Space> Squ3 = new ArrayList<>();
        ArrayList<Space> Squ4 = new ArrayList<>();
        ArrayList<Space> Squ5 = new ArrayList<>();
        ArrayList<Space> Squ6 = new ArrayList<>();
        ArrayList<Space> Squ7 = new ArrayList<>();
        ArrayList<Space> Squ8 = new ArrayList<>();

        for (int i = 0; i < 81; i++) {
            if (getSquare(i) == 0) Squ0.add(spaces.get(i));
            else if (getSquare(i) == 1) Squ1.add(spaces.get(i));
            else if (getSquare(i) == 2) Squ2.add(spaces.get(i));
            else if (getSquare(i) == 3) Squ3.add(spaces.get(i));
            else if (getSquare(i) == 4) Squ4.add(spaces.get(i));
            else if (getSquare(i) == 5) Squ5.add(spaces.get(i));
            else if (getSquare(i) == 6) Squ6.add(spaces.get(i));
            else if (getSquare(i) == 7) Squ7.add(spaces.get(i));
            else if (getSquare(i) == 8) Squ8.add(spaces.get(i));
        }
        ArrayList<ArrayList<Space>> list = new ArrayList<>();
        list.add(Squ0);
        list.add(Squ1);
        list.add(Squ2);
        list.add(Squ3);
        list.add(Squ4);
        list.add(Squ5);
        list.add(Squ6);
        list.add(Squ7);
        list.add(Squ8);

        return list;
    }

    private static int findLastElementInSet(ArrayList<Space> set) {
        List<Space> list = set.stream().toList();
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (list.get(i).getElement() == 0) {
                continue;
            }
            integers.add(list.get(i).getElement());
        }
        if (integers.size() != 8) {
            return 0;
        }
        if (!integers.contains(1)) return 1;
        else if (!integers.contains(2)) return 2;
        else if (!integers.contains(3)) return 3;
        else if (!integers.contains(4)) return 4;
        else if (!integers.contains(5)) return 5;
        else if (!integers.contains(6)) return 6;
        else if (!integers.contains(7)) return 7;
        else if (!integers.contains(8)) return 8;
        else if (!integers.contains(9)) return 9;
        return 0;

    }

    private static ArrayList<Space> createCol8(ArrayList<Space> spaces) {
        ArrayList<Space> Col8 = new ArrayList<>(9);
        for (int i = 8; i <= 80; i += 9) {
            Col8.add(spaces.get(i));
        }
        return Col8;
    }

    private static ArrayList<Space> createCol7(ArrayList<Space> spaces) {
        ArrayList<Space> Col7 = new ArrayList<>(9);
        for (int i = 7; i <= 79; i += 9) {
            Col7.add(spaces.get(i));
        }
        return Col7;
    }

    private static ArrayList<Space> createCol6(ArrayList<Space> spaces) {
        ArrayList<Space> Col6 = new ArrayList<>(9);
        for (int i = 6; i <= 78; i += 9) {
            Col6.add(spaces.get(i));
        }
        return Col6;
    }

    private static ArrayList<Space> createCol5(ArrayList<Space> spaces) {
        ArrayList<Space> Col5 = new ArrayList<>(9);
        for (int i = 5; i <= 77; i += 9) {
            Col5.add(spaces.get(i));
        }
        return Col5;
    }

    private static ArrayList<Space> createCol4(ArrayList<Space> spaces) {
        ArrayList<Space> Col4 = new ArrayList<>(9);
        for (int i = 4; i <= 76; i += 9) {
            Col4.add(spaces.get(i));
        }
        return Col4;
    }

    private static ArrayList<Space> createCol3(ArrayList<Space> spaces) {
        ArrayList<Space> Col3 = new ArrayList<>(9);
        for (int i = 3; i <= 75; i += 9) {
            Col3.add(spaces.get(i));
        }
        return Col3;
    }

    private static ArrayList<Space> createCol2(ArrayList<Space> spaces) {
        ArrayList<Space> Col2 = new ArrayList<>(9);
        for (int i = 2; i <= 74; i += 9) {
            Col2.add(spaces.get(i));
        }
        return Col2;
    }

    private static ArrayList<Space> createCol1(ArrayList<Space> spaces) {
        ArrayList<Space> Col1 = new ArrayList<>(9);
        for (int i = 1; i <= 73; i += 9) {
            Col1.add(spaces.get(i));
        }
        return Col1;
    }

    private static ArrayList<Space> createCol0(ArrayList<Space> spaces) {
        ArrayList<Space> Col0 = new ArrayList<>(9);
        for (int i = 0; i <= 72; i += 9) {
            Col0.add(spaces.get(i));
        }
        return Col0;
    }

    private static ArrayList<Space> createRow8(ArrayList<Space> spaces) {
        ArrayList<Space> Row8 = new ArrayList<>(9);
        for (int i = 72; i < 81; i++) {
            Row8.add(spaces.get(i));
        }
        return Row8;
    }

    private static ArrayList<Space> createRow7(ArrayList<Space> spaces) {
        ArrayList<Space> Row7 = new ArrayList<>(9);
        for (int i = 63; i < 72; i++) {
            Row7.add(spaces.get(i));
        }
        return Row7;
    }

    private static ArrayList<Space> createRow6(ArrayList<Space> spaces) {
        ArrayList<Space> Row6 = new ArrayList<>(9);
        for (int i = 54; i < 63; i++) {
            Row6.add(spaces.get(i));
        }
        return Row6;
    }

    private static ArrayList<Space> createRow5(ArrayList<Space> spaces) {
        ArrayList<Space> Row5 = new ArrayList<>(9);
        for (int i = 45; i < 54; i++) {
            Row5.add(spaces.get(i));
        }
        return Row5;
    }

    private static ArrayList<Space> createRow4(ArrayList<Space> spaces) {
        ArrayList<Space> Row4 = new ArrayList<>(9);
        for (int i = 36; i < 45; i++) {
            Row4.add(spaces.get(i));
        }
        return Row4;
    }

    private static ArrayList<Space> createRow3(ArrayList<Space> spaces) {
        ArrayList<Space> Row3 = new ArrayList<>(9);
        for (int i = 27; i < 36; i++) {
            Row3.add(spaces.get(i));
        }
        return Row3;
    }

    private static ArrayList<Space> createRow2(ArrayList<Space> spaces) {
        ArrayList<Space> Row2 = new ArrayList<>(9);
        for (int i = 18; i < 27; i++) {
            Row2.add(spaces.get(i));
        }
        return Row2;
    }

    private static ArrayList<Space> createRow1(ArrayList<Space> spaces) {
        ArrayList<Space> Row1 = new ArrayList<>(9);
        for (int i = 9; i < 18; i++) {
            Row1.add(spaces.get(i));
        }
        return Row1;
    }

    private static ArrayList<Space> createRow0(ArrayList<Space> spaces) {
        ArrayList<Space> Row0 = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            Row0.add(spaces.get(i));
        }
        return Row0;
    }

    private static ArrayList<Space> createArrayListWithAllSpaces(ArrayList<Integer> list) {
        ArrayList<Space> spaces = new ArrayList<>(81);
        for (int i = 0; i < 81; i++) {
            spaces.add(new Space(i, getRow(i), getColumn(i), getSquare(i), getPossibleSet(i, list), new HashSet<Integer>(), list.get(i)));
        }
//        for (int i = 0; i < 81; i++) {
//            System.out.println(spaces.get(i).toString());
//        }
        return spaces;
    }

    private static HashSet<Integer> getPossibleSet(int i, ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        if (list.get(i) != 0) {
            set.add(list.get(i));
            return set;
        } else {
            set.add(1);
            set.add(2);
            set.add(3);
            set.add(4);
            set.add(5);
            set.add(6);
            set.add(7);
            set.add(8);
            set.add(9);
            return set;
        }
    }

    private static int getSquare(int i) {
        //Some magic. Do not touch
        int m;
        int n = 0;

        if (i < 27) m = i;
        else if (i < 54) {
            n = 3;
            m = i - 27;
        } else {
            n = 6;
            m = i - 54;
        }

        int k = m / 9;
        m -= k * 9;

        if (m <= 2) return n;
        else if (m <= 5) return 1 + n;
        else if (m <= 8) return 2 + n;
        return -1;
    }

    private static int getColumn(int i) {
        int n = i / 9;
        return i - 9 * n;
    }

    private static int getRow(int i) {
        return i / 9;
    }

    private static void createAndPrintInitialSudoku(ArrayList<Integer> initialState) {

        Utility.printSudoku(initialState);
    }

    private static ArrayList<Integer> askForInitialState() {
        // Asking the user to enter the initial state of the sudoku.
        System.out.println("Please,enter each number of your sudoku(or type in \"0\", for each blank space)");
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();

        ArrayList<Integer> initialState = new ArrayList<>(81);
        String[] initialStateHorizontalString = n.split(" ");
        for (int i = 0; i < 81; i++) {
            initialState.add(Integer.parseInt(initialStateHorizontalString[i]));
        }

        return initialState;
    }
}

