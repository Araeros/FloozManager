package com.floozmanager;

public class LogText {
    String contenu;
    private int ttl = 0;

    public LogText() {
        this.contenu = "";
    }

    public LogText(String text) {
        if (text == null){
            this.contenu = "";
        } else {
            this.contenu = text;
        }
    }

    public void concat(String newText) {
        if (this.ttl >= 5)
            this.reset(newText);
        else {
            this.contenu = this.contenu + newText;
        }
    }

    public void reset(String newContenu) {
        this.contenu = newContenu;
        this.ttl = 0;
    }

    @Override
    public String toString() {
        this.ttl += 1;
        return this.contenu;
    }
}
