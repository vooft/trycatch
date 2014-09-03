package com.vooft.trycatch.common;

/**
 * Created by vooft on 01.09.14.
 */
public class BoardSize {
    private int width;
    private int height;

    public BoardSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardSize boardSize = (BoardSize) o;

        if (height != boardSize.height) return false;
        if (width != boardSize.width) return false;

        return true;
    }

    @Override
    public String toString() {
        return String.format("%dx%d", width, height);
    }
}
