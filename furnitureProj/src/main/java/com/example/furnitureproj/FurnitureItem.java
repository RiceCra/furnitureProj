package com.example.furnitureproj;

public class FurnitureItem {
    private int length;
    private int width;
    private String furnitureType;
    private String style;
    private String color;
    private boolean isPlaced;

    public FurnitureItem(int length, int width, String furnitureType, String style, String color, boolean isPlaced) {
        this.length = length;
        this.width = width;
        this.furnitureType = furnitureType;
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

    public String getFurnitureType() { return furnitureType; }
    public void setFurnitureType(String furnitureType) { this.furnitureType = furnitureType; }

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
        return String.format("A %s %s %s that is %dx%dft",
                style.toLowerCase(),
                color.toLowerCase(),
                furnitureType.toLowerCase(),
                width, length);
    }
}
