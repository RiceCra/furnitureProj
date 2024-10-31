package com.example.furnitureproj;

public class FurnitureItem {
    private int length;
    private int width;
    private String style;
    private String color;
    private boolean isPlaced;

    public FurnitureItem(int length, int width, String style, String color, boolean isPlaced) {
        this.length = length;
        this.width = width;
        this.style = style;
        this.color = color;
        this.isPlaced = isPlaced;
    }

    // Getters for all attributes
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    // Optional setters if you need to modify values later
    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    @Override
    public String toString() {
        return String.format("Item: %dx%d, Color: %s, Style: %s", length, width, color, style);
    }
}
