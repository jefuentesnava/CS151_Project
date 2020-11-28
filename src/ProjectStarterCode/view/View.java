package ProjectStarterCode.view;

import ProjectStarterCode.controller.Message;
import ProjectStarterCode.controller.NewGameMessage;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
        GameView();
        DeathView();
    }

    public void MenuView(){
        menuFrame = new JFrame("Snake Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panels to contain components
        JPanel logoPanel = new JPanel();
        JPanel playButtonPanel  = new JPanel();
        JPanel gameDescPanel = new JPanel();
        JPanel winConPanel = new JPanel();

        //components
        JLabel logo = new JLabel("Snake");
        JButton playButton = new JButton("Play");
        JLabel gameDesc = new JLabel("Eat Food to Grow in Size");
        JLabel winCon = new JLabel("*** Win condition: When Snake's length reaches half the size of the board size ***");

        //set up layout
        menuFrame.setLayout(new GridLayout(4,1));

        //logo and logoPanel properties
        logo.setForeground(Color.GREEN);
        logo.setFont(logo.getFont().deriveFont(100.0f));
        logoPanel.setBackground(Color.BLACK);
        logoPanel.add(logo);

        //playButton and playButtonPanel properties
        playButton.setForeground(Color.GREEN);
        playButton.setBackground(Color.BLACK);
        playButton.setFont(playButton.getFont().deriveFont(70.0f));
        playButtonPanel.setBackground(Color.BLACK);
        playButton.setBorder(new LineBorder(Color.WHITE, 5));
        playButtonPanel.add(playButton);

        //gameDesc and gameDecsPanel properties
        gameDesc.setForeground(Color.WHITE);
        gameDesc.setFont(gameDesc.getFont().deriveFont(20.0f));;
        gameDescPanel.setBackground(Color.BLACK);
        gameDescPanel.add(gameDesc);

        //winCon and winConPanel properties
        winCon.setForeground(Color.WHITE);
        winCon.setFont(gameDesc.getFont().deriveFont(20.0f));
        winConPanel.setBackground(Color.BLACK);
        winConPanel.add(winCon);

        //add everything to frame
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
        int row = 9;
        int col = 9;

        gameFrame = new JFrame("Snake Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().setBackground(Color.BLACK);

        //setup layout
        gameFrame.setLayout(new BorderLayout());

        //panels to contain components
        JPanel snakeLenPanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel bot = new JPanel();
        JLabel snakeLen = new JLabel(" Snake Length: ");

        //fieldPanel properties and setup
        fieldPanel.setLayout(new GridLayout(row,col,3,3));
        fieldPanel.setBackground(Color.WHITE);

        JLabel[][] grid = new JLabel[row][col];
        for(int i = 0 ; i < row; i++){
            for (int j = 0; j < col; j++){
                grid[i][j] = new JLabel();
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setOpaque(true);
                fieldPanel.add(grid[i][j]);
            }
        }

        //snakeLen and snakeLenPanel properties
        snakeLen.setForeground(Color.WHITE);
        snakeLen.setFont(snakeLen.getFont().deriveFont(20.0f));
        snakeLenPanel.add(snakeLen);
        snakeLenPanel.setBackground(Color.BLACK);

        //remaining panel properties
       bot.setBackground(Color.BLACK);
       right.setBackground(Color.BLACK);
       left.setBackground(Color.BLACK);

       //add everything to frame
        gameFrame.add(snakeLenPanel, BorderLayout.NORTH);
        snakeLenPanel.setPreferredSize(new Dimension(1000,50));
        gameFrame.add(fieldPanel, BorderLayout.CENTER);
        gameFrame.add(bot, BorderLayout.SOUTH);
        bot.setPreferredSize(new Dimension(1000,50));
        gameFrame.add(right, BorderLayout.EAST);
        right.setPreferredSize(new Dimension(50,1000));
        gameFrame.add(left, BorderLayout.WEST);
        left.setPreferredSize(new Dimension(50,1000));
        gameFrame.pack();
        gameFrame.setVisible(true);
    }

    public void DeathView(){
        deathFrame = new JFrame("Snake Death");
        deathFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deathFrame.getContentPane().setBackground(Color.BLACK);

        //set up frame layout
        deathFrame.setLayout(new BorderLayout());

        //panels to contain components
        JPanel top = new JPanel();
        JPanel interior = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel bot = new JPanel();

        //components
        JLabel deathMes = new JLabel(" Unfortunately, Slither has died.");
        JButton playAgainButton = new JButton(" Play Again ");
        JButton menuButton = new JButton(" Menu ");

        //set up interiorPanel
        interior.setLayout(new GridLayout(1,2,200,0));
        interior.setBackground(Color.BLACK);

        //center JLabel
        top.setLayout(new GridBagLayout());

        //deathMes and top panel properties
        deathMes.setForeground(Color.WHITE);
        deathMes.setFont(deathMes.getFont().deriveFont(20.0f));
        top.setBackground(Color.BLACK);
        top.add(deathMes);

        //playAgainButton and interior panel properties
        playAgainButton.setBackground(Color.BLACK);
        playAgainButton.setForeground(Color.GREEN);
        playAgainButton.setBorder(new LineBorder(Color.WHITE, 5));
        playAgainButton.setFont(playAgainButton.getFont().deriveFont(35.0f));
        interior.add(playAgainButton);

        //menuButton properties
        menuButton.setBackground(Color.BLACK);
        menuButton.setForeground(Color.GREEN);
        menuButton.setBorder(new LineBorder(Color.WHITE, 5));
        menuButton.setFont(menuButton.getFont().deriveFont(35.0f));
        interior.add(menuButton);

        //remaining panel properties
        bot.setBackground(Color.BLACK);
        right.setBackground(Color.BLACK);
        left.setBackground(Color.BLACK);


        //add everything to frame
        deathFrame.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(1000,200));
        deathFrame.add(interior, BorderLayout.CENTER);
        interior.setPreferredSize(new Dimension(800,100));
        deathFrame.add(left, BorderLayout.WEST);
        left.setPreferredSize(new Dimension(100,100));
        deathFrame.add(right, BorderLayout.EAST);
        right.setPreferredSize(new Dimension(100, 100));
        deathFrame.add(bot , BorderLayout.SOUTH);
        bot.setPreferredSize(new Dimension(1000, 200));
        deathFrame.pack();
        deathFrame.setVisible(true);

        //actions listeners
        playAgainButton.addActionListener(event -> {
            try {
                this.queue.put(new NewGameMessage()); // <--- adding NewGame message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        menuButton.addActionListener(event -> {
            try {
                this.queue.put(new NewGameMessage()); // <--- adding NewGame message to the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
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
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
 *
 * https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html
 *
 *https://stackoverflow.com/questions/36159929/printing-a-2d-array-of-jlabels-to-a-gridlayout
 *
 * https://stackoverflow.com/questions/9829319/centering-a-jlabel-in-a-jpanel
 */
