package com.vooft.trycatch.pieces.square.impl;

import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.square.SquareBoardPiece;

import java.util.Set;

/**
 * Created by vooft on 03.09.14.
 */
public class Bishop extends SquareBoardPiece {
    public Bishop() {
        super(PieceType.BISHOP);
    }

    @Override
    public Set<Point> getMovementsForPoint(Point point) {
        return getDiagonalMovementsForPoint(point);
    }


}
