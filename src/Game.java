
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.model.Model;
import ProjectStarterCode.view.View;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Game {

    private BlockingQueue<Message> queue;
    private View view; // Direct reference to view
    private Model model; // Direct reference to model
	
	public Controller(View view, Model model, BlockingQueue<Message> queue) {
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
