
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Model;
import ProjectStarterCode.view.View;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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

	   model = new Model();
        view = View.init(queue);
        Controller game = new Controller(view, model, queue);
	}

}
