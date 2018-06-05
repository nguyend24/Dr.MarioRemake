package ui;

import logic.API;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWindow extends JFrame implements KeyListener, MouseListener, Runnable {
    private JPanel       gameArea;
    private BorderLayout borderLayout;

    private Left         left;
    private Scoreboard   scoreboard;

    private Right        right;

    private Top          top;

    private Bottom       bottom;
    private JButton exit;
    private JButton reset;
    private Center       center;

    private Dimension screenSize = Toolkit.getDefaultToolkit()
                                          .getScreenSize();

    private Thread thread;

    public GameWindow() {
        thread = new Thread(this);
    }

    private void configureFrame() {
        setVisible(true);
        setTitle("Dr. Mario");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setContentPane(gameArea);
    }

    private void initializeAll() {
        gameArea = new JPanel();
        borderLayout = new BorderLayout();

        left = new Left();
        scoreboard = new Scoreboard();

        right = new Right();

        top = new Top();

        bottom = new Bottom();
        exit = new JButton("Exit");
        reset = new JButton("Reset");

        center = new Center();
    }

    private void configureGameArea() {
        gameArea.setLayout(borderLayout);
        gameArea.add(left, BorderLayout.LINE_START);
        gameArea.add(right, BorderLayout.LINE_END);
        gameArea.add(top, BorderLayout.PAGE_START);
        gameArea.add(bottom, BorderLayout.PAGE_END);
        gameArea.add(center, BorderLayout.CENTER);
    }

    private void configureLeft() {
        left.add(scoreboard);
    }

    private void configureRight() {

    }

    private void configureTop() {

    }

    private void configureBottom() {
        bottom.add(exit);
        bottom.add(reset);

        exit.addActionListener(action -> System.exit(0));
        reset.addActionListener(action -> API.reset());
    }

    private void configureCenter() {

    }

    public void refresh() {

    }

    public synchronized void start() {
        initializeAll();
        configureFrame();
        configureGameArea();
        configureLeft();
        configureRight();
        configureTop();
        configureBottom();
        configureCenter();
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int event = e.getKeyCode();

        switch (event) {
            case KeyEvent.VK_LEFT:
//                moveLeft();
                scoreboard.increaseScore();
                break;
            case KeyEvent.VK_RIGHT:
//                moveRight();
                scoreboard.increaseScore();
                break;
            case KeyEvent.VK_UP:
                scoreboard.resetTotal();
                break;
            case KeyEvent.VK_DOWN:
//                moveDown();
                scoreboard.increaseScore();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
