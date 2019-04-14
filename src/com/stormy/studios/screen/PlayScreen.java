package com.stormy.studios.screen;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

import static com.stormy.studios.Main.gameManager;
import static com.stormy.studios.manager.Hud.playHUD;

public class PlayScreen implements Screen {

    public PlayScreen() {

    }

    @Override
    public void displayOutput(AsciiPanel panel) {
        playHUD(panel, gameManager);
    }

    @Override
    public Screen reactToInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_Q:
                gameManager.nextTurn();
                break;
            default:
                System.out.println("unknown command: " + key.getKeyChar());
        }
        return this;
    }
}
