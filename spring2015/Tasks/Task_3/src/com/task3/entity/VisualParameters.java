package com.task3.entity;
/**
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 23.15.2015
 *
 */
import javax.xml.bind.annotation.XmlElement;

public class VisualParameters {
    private String color;
    private int transparency;
    private int gemCutting;

    public String getColor() {
        return color;
    }

    public int getTransparency() {
        return transparency;
    }

    public int getGemCutting() {
        return gemCutting;
    }

    @XmlElement
    public void setColor(String color) {

        this.color = color;
    }

    @XmlElement
    public void setTransparency(int transparency) {
        if (transparency < 0 || transparency > 100) {
            throw new IllegalArgumentException("Transparency can't be lower than 0 and higher than 100");
        } else
            this.transparency = transparency;
    }

    @XmlElement
    public void setGemCutting(int gemCutting) {
        if (gemCutting < 4 || gemCutting > 15) {
            throw new IllegalArgumentException("Cut faces should be between 4 and 15 inclusive");
        } else
            this.gemCutting = gemCutting;
    }

    @Override
    public String toString() {
        String text = String.format("color %s, transparency %s, cut faces quantity %s.",
                color, transparency, gemCutting);
        return text;
    }
}
