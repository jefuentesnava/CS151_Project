package ProjectStarterCode.view;

import ProjectStarterCode.controller.Message;
import ProjectStarterCode.controller.NewGameMessage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View {
    private JFrame menuFrame;
    private JFrame gameFrame;
    private JFrame deathFrame;
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

        MenuView();
    }

    public void MenuView(){
        menuFrame = new JFrame("Snake Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panels to contain components
        JPanel logoPanel = new JPanel();
        JPanel playButtonPanel  = new JPanel();
        JPanel gameDescPanel = new JPanel();
        JPanel winConPanel = new JPanel();

        //componenets
        JLabel logo = new JLabel("Snake");
        JButton playButton = new JButton("Play");
        JLabel gameDesc = new JLabel("Eat Food to Grow in Size");
        JLabel winCon = new JLabel("*** Win condition: When Snake's length reaches half the size of the board size ***");

        //set up layout
        menuFrame.setLayout(new GridLayout(4,1));


        logo.setForeground(Color.GREEN);
        logo.setFont(logo.getFont().deriveFont(100.0f));
        logoPanel.setBackground(Color.BLACK);
        logoPanel.add(logo);

        playButton.setForeground(Color.GREEN);
        playButton.setBackground(Color.BLACK);
        playButton.setFont(playButton.getFont().deriveFont(75.0f));
        playButtonPanel.setBackground(Color.BLACK);
        playButtonPanel.add(playButton);

        gameDesc.setForeground(Color.WHITE);
        gameDesc.setFont(gameDesc.getFont().deriveFont(20.0f));;
        gameDescPanel.setBackground(Color.BLACK);
        gameDescPanel.add(gameDesc);

        winCon.setForeground(Color.WHITE);
        winCon.setFont(gameDesc.getFont().deriveFont(20.0f));
        winConPanel.setBackground(Color.BLACK);
        winConPanel.add(winCon);

        menuFrame.add(logoPanel);
        menuFrame.add(playButtonPanel);
        menuFrame.add(gameDescPanel);
        menuFrame.add(winConPanel);
        menuFrame.pack();
        menuFrame.setVisible(true);


        //actions listeners
        playButton.addActionListener(event -> {
            try {
                this.queue.put(new NewGameMessage()); // <--- adding NewGame message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void GameView(){
        JLabel snakeLen = new JLabel();
        JPanel gamePanel  = new JPanel();
        gamePanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

    }

    public void DeathView(){

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

//resources used
/***
 * https://stackoverflow.com/questions/1843180/how-to-adjust-jframe-border-thickness-in-java
 *
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 *
 *
 */
