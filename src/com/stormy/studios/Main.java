package com.stormy.studios;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import com.stormy.studios.manager.GameManager;
import com.stormy.studios.screen.PlayScreen;
import com.stormy.studios.screen.Screen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {

    private AsciiPanel asciiPanel;
    private Screen screen;
    public static GameManager gameManager = new GameManager();

    public Main() {
        super("CivSim Reborn");
        asciiPanel = new AsciiPanel(70, 50, AsciiFont.TAFFER_10x10);
        screen = new PlayScreen();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(asciiPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        addKeyListener(this);

        repaint();
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void repaint() {
        asciiPanel.clear();
        screen.displayOutput(asciiPanel);
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.reactToInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}