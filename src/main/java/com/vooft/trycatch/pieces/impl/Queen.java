package com.vooft.trycatch.pieces.impl;

import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.SquareBoardPiece;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vooft on 03.09.14.
 */
public class Queen extends SquareBoardPiece {
    public Queen() {
        super(PieceType.QUEEN);
    }

    @Override
    public Set<Point> getMovementsForPoint(Point point) {
        Set<Point> result = new HashSet<>();

        result.addAll(getHorizontalMovementsForPoint(point));
        result.addAll(getVerticalMovementsForPoint(point));
        result.addAll(getDiagonalMovementsForPoint(point));

        return result;
    }


}
