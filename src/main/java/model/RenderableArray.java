package model;

import java.awt.Graphics;

import java.util.Collections;
import java.util.Vector;
import java.util.HashMap;

import util.Argumentable;

public class RenderableArray extends Structure<Integer> {

    private Vector<Integer> elements;

    public RenderableArray() {
        elements = new Vector<>();
        operations.put("add", new HashMap<>());
        operations.put("sort", new HashMap<>());
        operations.put("remove", new HashMap<>());

        operations.get("add").put("element", Argumentable.Integral);
        operations.get("remove").put("element", Argumentable.Integral);
    }

    public void render(Graphics g) {
        int currentX = 20, currentY = 30;
        int endOfRowCounter = 0;
        for(int i = 0; i < elements.capacity(); i++ ) {

            if( (endOfRowCounter * 80) >= 600 ) {
                currentY += 80;
                currentX = 20;
                endOfRowCounter = 0;
            }

            g.drawRect(currentX, currentY, 80, 80);

            if( i < elements.size() ) {
                g.drawString(elements.get(i).toString(), currentX + 5, currentY + 40);
            }

            currentX += 80;
            endOfRowCounter++;
        }
    }

    public String go() {
        switch(operation){
            case "add":
                add((Integer)args.get("element"));
                return null;
            case "remove":
                remove((Integer)args.get("element"));
                return null;
            case "sort":
                sort();
                return null;
            default:
                return null;
        }
    }

    public void add(Integer element) {
        elements.add(element);
    }

    public void remove(Integer element) {
        elements.remove(element);
    }

    public void sort() {
        Collections.sort(elements);
    }
}
