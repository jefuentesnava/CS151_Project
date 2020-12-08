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


//        WinView();
        GameViews();
    }

    public void GameViews(){
        mainFrame = new JFrame("Snake");

        int row = 9;
        int col = 9;

        /*
        ----------------------------------------------------------------------------------------------------------------------------------------------------------------
            JPanels, JButtons, JTextFields, ...
         ----------------------------------------------------------------------------------------------------------------------------------------------------------------
         */

        JPanel panelContent = new JPanel();     //Parent Panel
        JPanel menuPanel = new JPanel();        //Child Panel
        JPanel gamePanel = new JPanel();        //Child Panel
        JPanel deathPanel = new JPanel();        //Child Panel
        JPanel winPanel = new JPanel();        //Child Panel

        //Components used in more than one Child Panel
        JButton playAgainButton = new JButton("Play Again");
        JButton menuButton = new JButton("Menu");

        //Menu Panel Components
        JPanel logoPanel = new JPanel();
        JPanel playButtonPanel = new JPanel();
        JPanel gameDescPanel = new JPanel();
        JPanel winConPanel = new JPanel();
        JButton playButton = new JButton("Play");
        JLabel logo = new JLabel("Snake");
        JLabel gameDesc = new JLabel("Eat Food to Grow in Size");
        JLabel winCon = new JLabel("*** Win condition: When Snake's length reaches half the size of the board size ***");

        //Game Panel Components
        JPanel snakeLenPanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel bot = new JPanel();
        JLabel snakeLen = new JLabel(" Snake Length: ");

        //Death Panel Components
        JPanel top = new JPanel();
        JPanel interior = new JPanel();
        JPanel dleft = new JPanel();
        JPanel dright = new JPanel();
        JPanel dbot = new JPanel();
        JLabel deathMes = new JLabel(" Unfortunately, Slither has died.");

        //Win Panel Components
        JPanel wtop = new JPanel();
        JPanel winterior = new JPanel();
        JPanel wleft = new JPanel();
        JPanel wright = new JPanel();
        JPanel wbot = new JPanel();
        JLabel winMes = new JLabel(" Congratulations, you fed Slither a lot! ");

        /*
        ----------------------------------------------------------------------------------------------------------------------------------------------------------------
            layouts
         ----------------------------------------------------------------------------------------------------------------------------------------------------------------
         */

        CardLayout cl =  new CardLayout();
        panelContent.setLayout(cl);

        /*Menu Layouts**/
        menuPanel.setLayout(new GridLayout(4, 1));

        /*Game layouts**/
        gamePanel.setLayout(new BorderLayout());
        fieldPanel.setLayout(new GridLayout(row, col, 3, 3));  //create a gridlayout 9x9 with vertical and horizontal gaps of 3
        fieldPanel.setBackground(Color.WHITE);  //set color of background to white to increase contrast

        /*Death Layout**/
        deathPanel.setLayout(new BorderLayout());
        interior.setLayout(new GridLayout(1, 2, 200, 0));
        top.setLayout(new GridBagLayout());

        /*Win Panel**/
        winPanel.setLayout(new BorderLayout());
        winterior.setLayout(new GridLayout(1, 2, 200, 0));
        wtop.setLayout(new GridBagLayout());

         /*
        ----------------------------------------------------------------------------------------------------------------------------------------------------------------
            Panel Logic
         ----------------------------------------------------------------------------------------------------------------------------------------------------------------
         */

        /*Menu Panel Logic**/
            //logo and logoPanel properties
        logo.setForeground(Color.GREEN);
        logo.setFont(logo.getFont().deriveFont(200.0f));
        logoPanel.setBackground(Color.BLACK);
        logoPanel.add(logo);

            //playButton and playButtonPanel properties
        playButton.setForeground(Color.GREEN);
        playButton.setBackground(Color.BLACK);
        playButton.setFont(playButton.getFont().deriveFont(140.0f));
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


        /*Game Panel logic**/
        JLabel[][] grid = new JLabel[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = new JLabel();
                grid[i][j].setBackground(Color.GRAY);
                grid[i][j].setOpaque(true);
                fieldPanel.add(grid[i][j]);
            }
        }

        //snakeLen properties
        snakeLen.setForeground(Color.WHITE);
        snakeLen.setFont(snakeLen.getFont().deriveFont(20.0f));
        snakeLenPanel.add(snakeLen);
        snakeLenPanel.setBackground(Color.BLACK);

        //remaining panel properties
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

        /* Death and Win condition Shared Logic*****************/
            //playAgainButton properties
        playAgainButton.setBackground(Color.BLACK);
        playAgainButton.setForeground(Color.GREEN);
        playAgainButton.setBorder(new LineBorder(Color.WHITE, 5));
        playAgainButton.setFont(playAgainButton.getFont().deriveFont(35.0f));

            //menuButton properties
        menuButton.setBackground(Color.BLACK);
        menuButton.setForeground(Color.GREEN);
        menuButton.setBorder(new LineBorder(Color.WHITE, 5));
        menuButton.setFont(menuButton.getFont().deriveFont(35.0f));


        /*Death Panel Logic********/
            //deathMes and top panel properties
        deathMes.setForeground(Color.WHITE);
        deathMes.setFont(deathMes.getFont().deriveFont(40.0f));
        top.setBackground(Color.BLACK);
        top.add(deathMes);

        //interior panel properties
        interior.setBackground(Color.BLACK);
        interior.add(playAgainButton);
        interior.add(menuButton);

        //remaining panel properties
        dbot.setBackground(Color.BLACK);
        dright.setBackground(Color.BLACK);
        dleft.setBackground(Color.BLACK);

        /*add everything to mainframe**/
        deathPanel.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(1000, 400));
        deathPanel.add(interior, BorderLayout.CENTER);
        interior.setPreferredSize(new Dimension(800, 100));
        deathPanel.add(dleft, BorderLayout.WEST);
        dleft.setPreferredSize(new Dimension(100, 100));
        deathPanel.add(dright, BorderLayout.EAST);
        dright.setPreferredSize(new Dimension(100, 100));
        deathPanel.add(dbot, BorderLayout.SOUTH);
        dbot.setPreferredSize(new Dimension(1000, 500));

        /*Win Panel Logic******************************************/
        winterior.setBackground(Color.BLACK);
        winMes.setForeground(Color.WHITE);
        winMes.setFont(winMes.getFont().deriveFont(20.0f));
        wtop.setBackground(Color.BLACK);
        wtop.add(winMes);

        //playAgainButton and interior panel properties
        winterior.add(playAgainButton);

        //menuButton properties
        winterior.add(menuButton);

        //remaining panel properties
        wbot.setBackground(Color.BLACK);
        wright.setBackground(Color.BLACK);
        wleft.setBackground(Color.BLACK);

        //add everything to frame
        winPanel.add(wtop, BorderLayout.NORTH);
        wtop.setPreferredSize(new Dimension(1000, 400));
        winPanel.add(winterior, BorderLayout.CENTER);
        winterior.setPreferredSize(new Dimension(800, 100));
        winPanel.add(wleft, BorderLayout.WEST);
        wleft.setPreferredSize(new Dimension(100, 100));
        winPanel.add(wright, BorderLayout.EAST);
        wright.setPreferredSize(new Dimension(100, 100));
        winPanel.add(wbot, BorderLayout.SOUTH);
        wbot.setPreferredSize(new Dimension(1000, 500));

         /*
        ----------------------------------------------------------------------------------------------------------------------------------------------------------------
            Remaining Initialization
         ----------------------------------------------------------------------------------------------------------------------------------------------------------------
         */

        //add components to corresponding children panels

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
        cl.show(panelContent, "3");

        //add parent panel to frame
        mainFrame.add(panelContent);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

        /*
        ----------------------------------------------------------------------------------------------------------------------------------------------------------------
             Action listeners
         ----------------------------------------------------------------------------------------------------------------------------------------------------------------
         */

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
