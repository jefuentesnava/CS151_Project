import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Model;
import ProjectStarterCode.view.View;

import java.util.concurrent.BlockingQueue;

public class Game {

    private static BlockingQueue<Message> queue;
    private static View view; // Direct reference to view
    private static Model model; // Direct reference to model

    public Game(View view, Model model, BlockingQueue<Message> queue) {
        this.view = view;
        this.model = model;
        this.queue = queue;
    }

    public static void main(String[] args) {

        //view = View.init(queue);
        //model = new Model();
        //Controller game = new Controller(view, model, queue);

        //game.mainLoop();
        //view.dispose();
        //queue.clear();

        Board board = new Board();
        Snake snake = new Snake(board);
        Food food = new Food(board, 6, 4);
        Collision collision = new Collision(board, snake);
        board.printBoard();
        for (int i = 0; i < 3; i++) {
            snake.printSnake();
            collision.snakeCollision();
            board.printBoard();
        }
    }

}
