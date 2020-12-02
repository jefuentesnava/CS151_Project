package ProjectStarterCode.model;

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
        direction = Direction.DOWN;
        location = new LinkedList<Tile>();
        location.add(board.tiles[4][4]);
        board.tiles[4][4].setInsideTile("snake");
        location.add(board.tiles[3][4]);
        board.tiles[3][4].setInsideTile("snake");
        location.add(board.tiles[2][4]);
        board.tiles[2][4].setInsideTile("snake");
        size = location.size();
    }

    public boolean toggleAlive() {
        alive = !alive;
        return alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getSize() {
        return size;
    }

    public boolean checkWinCondition() {
        return size > 40;
    }

    public void printSnake() {
        for (Tile snakePiece : location) {
            System.out.print(snakePiece);
        }
        System.out.println(getSize());
    }

    public void updateSize() {
        size = location.size();
    }

    public void goLeft() {
        if (!direction.equals(Direction.RIGHT)) {
            direction = Direction.LEFT;
        }
    }

    public void goRight() {
        if (!direction.equals(Direction.LEFT)) {
            direction = Direction.RIGHT;
        }
    }

    public void goUp() {
        if (!direction.equals(Direction.DOWN)) {
            direction = Direction.UP;
        }
    }

    public void goDown() {
        if (!direction.equals(Direction.UP)) {
            direction = Direction.DOWN;
        }
    }
}
