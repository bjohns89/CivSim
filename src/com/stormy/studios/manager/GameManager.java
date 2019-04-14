package com.stormy.studios.manager;

import com.stormy.studios.faction.Faction;

public class GameManager {
    public static int WORLD_TURN = 1;

    private Faction player;

    public GameManager() {
        player = new Faction("player");
    }

    public void nextTurn() {
        player.run();
        WORLD_TURN++;
    }

    public Faction getPlayerFaction() {
        return player;
    }
}
