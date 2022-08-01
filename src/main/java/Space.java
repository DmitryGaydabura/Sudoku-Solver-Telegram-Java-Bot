import java.util.HashSet;

public class Space {
    public int id;
    public int row;
    public int column;
    public int square;
    public HashSet<Integer> possible;
    public HashSet<Integer> NotPossible;

    public int element;

    public Space(int id, int row, int column, int square, HashSet<Integer> possible, HashSet<Integer> notPossible, int element) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.square = square;
        this.possible = possible;
        NotPossible = notPossible;
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public HashSet<Integer> getPossible() {
        return possible;
    }

    public void setPossible(HashSet<Integer> possible) {
        this.possible = possible;
    }

    public HashSet<Integer> getNotPossible() {
        return NotPossible;
    }

    public void setNotPossible(HashSet<Integer> notPossible) {
        NotPossible = notPossible;
    }


    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", row=" + row +
                ", column=" + column +
                ", square=" + square +
                ", possible=" + possible +
                ", NotPossible=" + NotPossible +
                ", element=" + element +
                '}';
    }
}
