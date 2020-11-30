import java.util.LinkedList;

public class Snake {

    private boolean alive;
    private int size;
    public Direction direction;
    public LinkedList<Tile> location;

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Snake(Board board) {
        alive = true;
        size = 3;
        direction = Direction.DOWN;
        location = new LinkedList<Tile>();
        location.add(board.tiles[4][4]);
        board.tiles[4][4].setInsideTile("snake");
        location.add(board.tiles[3][4]);
        board.tiles[3][4].setInsideTile("snake");
        location.add(board.tiles[2][4]);
        board.tiles[2][4].setInsideTile("snake");
    }

    public boolean toggleAlive() {
        alive = !alive;
        return alive;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    private boolean checkWinCondition() {
        return size > 40;
    }

    public void printSnake() {
        for (Tile snakePiece : location) {
            System.out.print(snakePiece);
        }
        System.out.println();
    }
}
