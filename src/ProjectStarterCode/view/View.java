package ProjectStarterCode.view;

import ProjectStarterCode.controller.HitMessage;
import ProjectStarterCode.controller.Message;
import ProjectStarterCode.controller.NewGameMessage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View {
    private JFrame gameFrame;
    private BlockingQueue<Message> queue;

    public static View init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new View(queue);
    }

    private View(BlockingQueue<Message> queue) {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it
        gameFrame = new JFrame("Snake Menu");

        JLabel snakeLabel = new JLabel("Snake");
        JButton newGame = new JButton("Play");
        JLabel gameDescription = new JLabel("Eat Food to Grow in Size");
        JLabel winConMessage = new JLabel("*** Win condition: When Snake's length reaches half the size of the board size ***");

        newGame.addActionListener(event -> {
            try {
                this.queue.put(new NewGameMessage()); // <--- adding NewGame message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // add everything and set layout and other standard JFrame settings
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);

        gameFrame.add(snakeLabel);
        snakeLabel.setForeground(Color.GREEN);
        snakeLabel.setBorder(whiteLine);

        gameFrame.add(newGame);

        gameFrame.add(gameDescription);
        gameDescription.setForeground(Color.WHITE);


        gameFrame.add(winConMessage);
        winConMessage.setForeground(Color.WHITE);



        gameFrame.getContentPane().setBackground(Color.BLACK);
        gameFrame.setSize(1000,1000);

        gameFrame.setLayout(new FlowLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }


    public void change() {
        // TODO: do all the updates and repaint
        //gameFrame.repaint();
    }

    public void dispose() {
        // TODO: clear all the resources
        // for example, gameFrame.dispose();
    }
}
