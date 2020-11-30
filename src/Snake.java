import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Model;
import ProjectStarterCode.view.View;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Snake {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Model model;

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

    public static void main(String[] args) {
        Board board = new Board();
        Snake snake = new Snake(board);
        Food food = new Food(board);
        Collision collision = new Collision(board, snake);
        board.printBoard();
        for (int i = 0; i < 3; i++) {
            collision.snakeCollision();
            snake.printSnake();
            board.printBoard();
        }

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
