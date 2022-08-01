import java.util.ArrayList;

public class Utility {
    public static String printSudoku(ArrayList<Integer> sudoku) {
        // Printing the sudoku in a nice format.
        String answer = "";
        String space = "  ";
        int n = 0;
        answer += "Your Sudoku is:\n";
        for (int i = 0; i < 9; i++) {
            answer += "+-----+-----+-----+  +-----+-----+-----+  +-----+-----+-----+\n";
            answer += "|  " + (sudoku.get(n) == 0 ? space : sudoku.get(n)) + "  |  " + (sudoku.get(n + 1) == 0 ? space : sudoku.get(n + 1)) + "  |  " + (sudoku.get(n + 2) == 0 ? space : sudoku.get(n + 2)) + "  |  |  " + (sudoku.get(n + 3) == 0 ? space : sudoku.get(n + 3)) + "  |  " + (sudoku.get(n + 4) == 0 ? space : sudoku.get(n + 4)) + "  |  " + (sudoku.get(n + 5) == 0 ? space : sudoku.get(n + 5)) + "  |  |  " + (sudoku.get(n + 6) == 0 ? space : sudoku.get(n + 6)) + "  |  " + (sudoku.get(n + 7) == 0 ? space : sudoku.get(n + 7)) + "  |  " + (sudoku.get(n + 8) == 0 ? space : sudoku.get(n + 8)) + "  |  \n";
            if ((i + 1) % 3 == 0 && (i + 1 != 9)) {
                answer += "+-----+-----+-----+  +-----+-----+-----+  +-----+-----+-----+\n";
            }

            n += 9;
        }
        answer += "+-----+-----+-----+  +-----+-----+-----+  +-----+-----+-----+\n";
        answer += "\n";
        return answer;
    }

    public static String printSudokuFromAllSets(ArrayList<ArrayList<Space>> allSets) {
        String space = "  ";
        String answer = "";
        //System.out.println("Completed Sudoku:");
        answer += "Completed Sudoku:\n";
        answer += "+-----+-----+-----+  +-----+-----+-----+  +-----+-----+-----+\n";
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                if ((j + 1) % 3 == 0) {
                    answer += "|  " + allSets.get(i).get(j).getElement() + "  |  ";
                } else {
                    answer += "|  " + (allSets.get(i).get(j).getElement() == 0 ? space : allSets.get(i).get(j).getElement()) + "  ";
                }
            }
            answer += "\n";
            answer += "+-----+-----+-----+  +-----+-----+-----+  +-----+-----+-----+\n";
            if ((i + 1) % 3 == 0 && (i + 1) != 9) {
                answer += "+-----+-----+-----+  +-----+-----+-----+  +-----+-----+-----+\n";
            }

        }
        return answer;
    }
}


