package ProjectStarterCode.view;

import ProjectStarterCode.controller.Message;
import ProjectStarterCode.controller.NewGameMessage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

public class View {
    private JFrame mainFrame;
    private JFrame menuFrame;
    private JFrame gameFrame;
    private JFrame deathFrame;
    private JFrame winFrame;
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

//        MenuView();
//        GameView();
//        DeathView();
//        WinView();
        TestView();
    }

    public void TestView(){
        mainFrame = new JFrame("Snake");

        int row = 9;
        int col = 9;

        /*********************************************************************************************
            JPanels, JButtons, JTextFields, ...
         ********************************************************************************************/
        JPanel panelContent = new JPanel();     //Parent Panel
        JPanel menuPanel = new JPanel();        //Child Panel
        JPanel gamePanel = new JPanel();        //Child Panel
        JPanel deathPanel = new JPanel();        //Child Panel
        JPanel winPanel = new JPanel();        //Child Panel

        //Components used in more than one Child Panel
        JButton playAgainButton = new JButton("Play Again");
        JButton menuButton = new JButton("Menu");

        //Menu Components
        JPanel logoPanel = new JPanel();
        JPanel playButtonPanel = new JPanel();
        JPanel gameDescPanel = new JPanel();
        JPanel winConPanel = new JPanel();
        JButton playButton = new JButton("Play");
        JLabel logo = new JLabel("Snake");
        JLabel gameDesc = new JLabel("Eat Food to Grow in Size");
        JLabel winCon = new JLabel("*** Win condition: When Snake's length reaches half the size of the board size ***");

        //Game Components
        JPanel snakeLenPanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel bot = new JPanel();
        JLabel snakeLen = new JLabel(" Snake Length: ");


        /*********************************************************************************************
            layouts
         ********************************************************************************************/
        CardLayout cl =  new CardLayout();
        panelContent.setLayout(cl);

        /**Menu Layouts**/
        menuPanel.setLayout(new GridLayout(4, 1));

        /**Game layouts**/
        gamePanel.setLayout(new BorderLayout());
        fieldPanel.setLayout(new GridLayout(row, col, 3, 3));  //create a gridlayout 9x9 with vertical and horizontal gaps of 3
        fieldPanel.setBackground(Color.WHITE);  //set color of background to white to increase contrast

        /*********************************************************************************************
         Panel Logic
         ********************************************************************************************/
        /**Menu Panel Logic**/
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
        gameDesc.setFont(gameDesc.getFont().deriveFont(20.0f));
        gameDescPanel.setBackground(Color.BLACK);
        gameDescPanel.add(gameDesc);

            //winCon and winConPanel properties
        winCon.setForeground(Color.WHITE);
        winCon.setFont(gameDesc.getFont().deriveFont(20.0f));
        winConPanel.setBackground(Color.BLACK);
        winConPanel.add(winCon);

            //add everything to frame
        menuPanel.add(logoPanel);
        menuPanel.add(playButtonPanel);
        menuPanel.add(gameDescPanel);
        menuPanel.add(winConPanel);
        

        /**Game Panel logic**/
        JLabel[][] grid = new JLabel[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = new JLabel();
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setOpaque(true);
                fieldPanel.add(grid[i][j]);
            }
        }

        snakeLen.setForeground(Color.WHITE);
        snakeLen.setFont(snakeLen.getFont().deriveFont(20.0f));
        snakeLenPanel.add(snakeLen);
        snakeLenPanel.setBackground(Color.BLACK);

        bot.setBackground(Color.BLACK);
        right.setBackground(Color.BLACK);
        left.setBackground(Color.BLACK);

        //add everything to gamePanel and initialize
        gamePanel.add(snakeLenPanel, BorderLayout.NORTH);
        snakeLenPanel.setPreferredSize(new Dimension(1000, 50));
        gamePanel.add(fieldPanel, BorderLayout.CENTER);
        gamePanel.add(bot, BorderLayout.SOUTH);
        bot.setPreferredSize(new Dimension(1000, 50));
        gamePanel.add(right, BorderLayout.EAST);
        right.setPreferredSize(new Dimension(50, 1000));
        gamePanel.add(left, BorderLayout.WEST);
        left.setPreferredSize(new Dimension(50, 1000));
        gamePanel.setVisible(true);

        /*********************************************************************************************
         * Remaining Initialization
         *********************************************************************************************/
        //add components to corresponding children panels
        deathPanel.add(playAgainButton);
        deathPanel.add(menuButton);
        winPanel.add(playAgainButton);
        winPanel.add(menuButton);

        //set background color of children panels
        menuPanel.setBackground(Color.BLACK);
        gamePanel.setBackground(Color.BLACK);
        deathPanel.setBackground(Color.BLACK);
        winPanel.setBackground(Color.BLACK);

        //add children panels to parent panel
        panelContent.add(menuPanel, "1");
        panelContent.add(gamePanel, "2");
        panelContent.add(deathPanel, "3");
        panelContent.add(winPanel, "4");

        //select default panel
        cl.show(panelContent, "1");

        //add parent panel to frame
        mainFrame.add(panelContent);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

        /*********************************************************************************************
        action listeners
         *********************************************************************************************/
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContent, "2");
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContent, "2");
            }
        });

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelContent, "1");
            }
        });
    }



    /*
        Death View when user loses and can decide to play again or return to menu
     */
    public void DeathView() {
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
        interior.setLayout(new GridLayout(1, 2, 200, 0));
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
        top.setPreferredSize(new Dimension(1000, 200));
        deathFrame.add(interior, BorderLayout.CENTER);
        interior.setPreferredSize(new Dimension(800, 100));
        deathFrame.add(left, BorderLayout.WEST);
        left.setPreferredSize(new Dimension(100, 100));
        deathFrame.add(right, BorderLayout.EAST);
        right.setPreferredSize(new Dimension(100, 100));
        deathFrame.add(bot, BorderLayout.SOUTH);
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

    /*
        Win View when user wins and can decide to play again or return to menu
     */
    public void WinView() {
        winFrame = new JFrame("Snake Win");
        winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winFrame.getContentPane().setBackground(Color.BLACK);

        //set up frame layout
        winFrame.setLayout(new BorderLayout());

        //panels to contain components
        JPanel top = new JPanel();
        JPanel interior = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel bot = new JPanel();

        //components
        JLabel winMes = new JLabel(" Congratulations, you fed Slither a lot! ");
        JButton playAgainButton = new JButton(" Play Again ");
        JButton menuButton = new JButton(" Menu ");

        //set up interiorPanel
        interior.setLayout(new GridLayout(1, 2, 200, 0));
        interior.setBackground(Color.BLACK);

        //center JLabel
        top.setLayout(new GridBagLayout());

        //winMes and top panel properties
        winMes.setForeground(Color.WHITE);
        winMes.setFont(winMes.getFont().deriveFont(20.0f));
        top.setBackground(Color.BLACK);
        top.add(winMes);

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
        winFrame.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(1000, 200));
        winFrame.add(interior, BorderLayout.CENTER);
        interior.setPreferredSize(new Dimension(800, 100));
        winFrame.add(left, BorderLayout.WEST);
        left.setPreferredSize(new Dimension(100, 100));
        winFrame.add(right, BorderLayout.EAST);
        right.setPreferredSize(new Dimension(100, 100));
        winFrame.add(bot, BorderLayout.SOUTH);
        bot.setPreferredSize(new Dimension(1000, 200));
        winFrame.pack();
        winFrame.setVisible(true);

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
