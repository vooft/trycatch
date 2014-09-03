package com.vooft.trycatch.pieces;

/**
 * Created by vooft on 01.09.14.
 */
public enum PieceType {
    KING("\u2654"),
    QUEEN("\u2655"),
    BISHOP("\u2657"),
    ROOK("\u2656"),
    KNIGHT("\u2658")
    ;

    private String name;
    PieceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
