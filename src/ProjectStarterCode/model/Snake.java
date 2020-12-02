package ProjectStarterCode.model;

import java.util.LinkedList;

public class Snake {

    /**
    * Represents the snake that will be moving
    * throughout the board.
    */
    private boolean alive;
    private int size;
    public Direction direction;
    public LinkedList<Tile> location;

    // Directions will be up, down, left and right
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
    * Creates a Snake the length of three tiles.
    * It'll go down by default.
    * @param board the board in which the Snake will be placed
    */
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

     /**
     * Will make the Snake be dead by changing the status of alive
     * @return alive
     */ 
    public boolean toggleAlive() {
        alive = !alive;
        return alive;
    }

    /**
    * Gets the status on whether the snake is alive or not
    * @return alive
    */
    public boolean isAlive() {
        return alive;
    }

    /**
    * Gets the size of the Snake
    * @return size of the Snake
    */
    public int getSize() {
        return size;
    }

     /**
     * Checks if the size of the Snake has exceeded the length of 40 tiles
     * which is the win condition for the game
     * @return whether size is greater than 40
     */
    public boolean checkWinCondition() {
        return size > 40;
    }

    /**
    * Prints the snake
    */
    public void printSnake() {
        for (Tile snakePiece : location) {
            System.out.print(snakePiece);
        }
        System.out.println(getSize());
    }

    /**
    * Updates the size of the snake
    */
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
