package ProjectStarterCode;

import java.util.LinkedList;
import ProjectStarterCode.controller.Controller;
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Model;
import ProjectStarterCode.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Snake {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static View view;
    private static Model model;

    private boolean alive;
    private int size;
    //public direction, what are we using to keep track of direction?
    public LinkedList<Tile> location;

    public static void main(String[] args) {
        view = View.init(queue);
        model = new Model();
        Controller controller = new Controller(view, model, queue);

        controller.mainLoop();
        view.dispose();
        queue.clear();
    }

    public Snake() {
        alive = true;
        size = 3; //need to double check starting length
        //direction =
        location = new LinkedList<Tile>();
        //need to add initial location of tiles
        //head
        //body
        //tail?
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
        //0 should be replaced with 1/2 of board size
        return size > 0;
    }
}
