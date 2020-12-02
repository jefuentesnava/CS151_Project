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

        view = View.init(queue);
        model = new Model();
        //Controller game = new Controller(view, model, queue);

        //game.mainLoop();
        //view.dispose();
        //queue.clear();


        model.board.printBoard();
        for (int i = 0; i < 3; i++) {
            model.snake.printSnake();
            model.updateModel();
            model.board.printBoard();
        }
    }

}
