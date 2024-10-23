package com.example.furnitureproj;

public class roomLayout {
    private String name;
    private layoutNode initLayoutNode;

    public roomLayout(String name) {
        this.name = name;
    }

    public void setLayout(layoutNode node) {
        this.initLayoutNode = node;
    }

    public layoutNode getLayout() {
        return this.initLayoutNode;
    }

    public String getName() {
        return this.name;
    }

}
