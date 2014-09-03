package com.vooft.trycatch.pieces.square.impl;

import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.square.SquareBoardPiece;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vooft on 03.09.14.
 */
public class Rook extends SquareBoardPiece {
    public Rook() {
        super(PieceType.ROOK);
    }

    @Override
    public Set<Point> getMovementsForPoint(Point point) {
        Set<Point> result = new HashSet<>();

        result.addAll(getHorizontalMovementsForPoint(point));
        result.addAll(getVerticalMovementsForPoint(point));

        return result;
    }


}