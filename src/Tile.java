public class Tile {

    private String containing;
    private int row, col;

    public Tile(int row, int col) {
        containing = "nothing";
        this.row = row;
        this.col = col;
    }

    public String getInsideTile() {
        return containing;
    }

    public void setInsideTile(String setting) {
        containing = setting;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return containing + " (" + row + ", " + col + ") ";
    }
}
