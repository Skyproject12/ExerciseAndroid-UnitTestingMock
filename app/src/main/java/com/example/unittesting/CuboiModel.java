package com.example.unittesting;

public class CuboiModel {
    double width;
    double length;
    double height;

    public CuboiModel() {
    }

    // set width and another variable to take from function getSurfaceArea
    public void Save(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }
    double getVolume(){
        return width*length*height;
    }

    // get value from method save
    public double getSurfaceArea(){
        double wl= width*length;
        double wh= width*height;
        double lh= length*height;
        return 2*(wl+wh+lh);
    }

    public double getCircumference(){
        return 4 *(width*length*height);
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
