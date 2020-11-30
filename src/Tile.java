public class Tile {

    private String containing;
    private int x, y;

    public Tile(int x, int y) {
        containing = "nothing";
        this.x = x;
        this.y = y;
    }

    public String getInsideTile() {
        return containing;
    }

    public void setInsideTile(String setting) {
        containing = setting;
    }

    @Override
    public String toString() {
        return containing + "(" + x + ", " + y + ")";
    }
}
