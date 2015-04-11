package model;

import java.awt.Graphics;

@FunctionalInterface public interface Renderable {
    public void render(Graphics g);
}
