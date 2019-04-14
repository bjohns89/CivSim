package com.stormy.studios.screen;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class InfoScreen implements Screen {

    @Override
    public void displayOutput(AsciiPanel panel) {
        panel.writeCenter("This is the info screen", panel.getHeightInCharacters() / 2);
    }

    @Override
    public Screen reactToInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return new PlayScreen();
            default:
                System.out.println("unknown command: " + key.getKeyChar());
        }
        return this;
    }
}
