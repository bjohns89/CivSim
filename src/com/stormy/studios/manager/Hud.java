package com.stormy.studios.manager;

import asciiPanel.AsciiPanel;
import com.stormy.studios.production.Production;
import com.stormy.studios.resource.ResourceStack;

import java.util.Map;

public class Hud {
    public static void playHUD(AsciiPanel panel, GameManager manager) {
        // wood,food.metal,stone

        // panel.write("turn:" + GameManager.WORLD_TURN + " " + manager.getPlayerFaction().getResourceStackHashMap() + "", 1, 0);
        panel.write("turn:" + GameManager.WORLD_TURN + " " + resourceString(manager) + "", 1, 0);

        panel.write("workers", 1, 1);
        for (int i = 0; i < manager.getPlayerFaction().getWorkers(); i++) {
            panel.write((char) 1, i + 9, 1);
        }

        for (int i = 0; i < manager.getPlayerFaction().getProductionList().size(); i++) {
            // + name or - name for active inactive resp.
            Production production = manager.getPlayerFaction().getProductionList().get(i);
            char ic = (manager.getPlayerFaction().getProductionList().get(i).isActiveProduction()) ? '+' : '-';
            panel.write(ic + "" + production.getName(), 5, 10 + i * 3);
        }

//        for (int i = 0; i < manager.getPlayerFaction().getProductionList().size(); i++) {
//            NameBuilder name = manager.getPlayerFaction().getProductionList().get(i).getNameBuilder();
//            //  System.out.println((1 + i) * 10);
//            int space = (i > 1) ? 4 : 0;
//          name.print(panel, (1 + i) * 10 + space, 20);
//        }
    }

    private static String resourceString(GameManager manager) {
        StringBuilder sb = new StringBuilder();
        Map tt = manager.getPlayerFaction().getResourceStackHashMap();
        for (Object ts : tt.keySet()) {
            ResourceStack rs = (ResourceStack) tt.get(ts);
            sb.append(rs.getResourceName()).append(":").append(rs.getCount()).append(" ");
        }
        return sb.toString();
    }
}
