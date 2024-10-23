package com.example.furnitureproj;

public class layoutNode {

    private int length;    //in feet, double to allow for 5.5 feet, etc
    private String direction; //left, up, right, down
    private String type;      //door, wall, window?
    public layoutNode next;

    public layoutNode(int len, String dir, String t) {
        length = len;
        direction = dir;
        type = t;
        next = null; //this is a doubly linked list
    }

    public int getLength() {
        return length;
    }

    public String getDirection() {
        return direction;
    }

    public String getType() {
        return type;
    }



}
