package com.stormy.studios.util;

import asciiPanel.AsciiPanel;

public class NameBuilder {
    private String name;
    private String[] builtName;

    public NameBuilder(String name) {
        this.name = name;
        builtName = new String[3];


        for (int i = 0; i < builtName.length; i++) {
            switch (i) {
                case 0:
                    builtName[i] = dashed();
                    break;
                case 1:
                    builtName[i] = "-" + name + "-";
                    break;
                case 2:
                    builtName[i] = dashed();
                    break;
            }
        }
    }

    public void print(AsciiPanel panel, int x, int y) {
        for (int i = 0; i < builtName.length; i++) {
            panel.write(builtName[i], x, y + i);
        }
    }

    public int nameLength() {
        return builtName[1].length();
    }

    private String dashed() {
        int dash = name.length() + 2;
        StringBuilder d = new StringBuilder();
        for (int i = 0; i < dash; i++) {
            d.append("-");
        }
        return d.toString();
    }
}
