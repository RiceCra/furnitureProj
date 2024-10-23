package com.example.furnitureproj;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class spRectangle extends Rectangle {
    private List<spRectangle> childrenNodes;

    public spRectangle(int size, int width, Color color) {
        super(size, width, color);
        childrenNodes = new ArrayList<>();
    }


    public List<spRectangle> getChildrenNodes() {
        return childrenNodes;
    }

    public void addChildNode(spRectangle child) {
        childrenNodes.add(child);
    }

    public void remChildNode(spRectangle child) {
        childrenNodes.remove(child);
    }

}
