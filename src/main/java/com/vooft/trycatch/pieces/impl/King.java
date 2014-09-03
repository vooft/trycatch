package com.vooft.trycatch.pieces.impl;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.SquareBoardPiece;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vooft on 01.09.14.
 */
public class King extends SquareBoardPiece {
    public King() {
        super(PieceType.KING);
    }

    @Override
    public Set<Point> getMovementsForPoint(Point point) {
        Set<Point> result = new HashSet<>();

        SquareChessBoard board = (SquareChessBoard) this.board;
        BoardSize size = board.getBoardSize();

        // top left
        if(point.getX()>0 && point.getY()>0) {
            result.add(new Point(point.getX()-1, point.getY()-1));
        }

        // bottom left
        if(point.getX()>0 && point.getY()<size.getHeight()-1) {
            result.add(new Point(point.getX()-1, point.getY()+1));
        }

        // left
        if(point.getX()>0) {
            result.add(new Point(point.getX()-1, point.getY()));
        }

        // top
        if(point.getY()>0) {
            result.add(new Point(point.getX(), point.getY()-1));
        }

        // top right
        if(point.getX()<size.getWidth()-1 && point.getY()>0) {
            result.add(new Point(point.getX()+1, point.getY()-1));
        }

        // bottom right
        if(point.getX()<size.getWidth()-1 && point.getY()<size.getHeight()-1) {
            result.add(new Point(point.getX()+1, point.getY()+1));
        }

        // right
        if(point.getX()<size.getWidth()-1) {
            result.add(new Point(point.getX()+1, point.getY()));
        }

        // bottom
        if(point.getY()<size.getHeight()-1) {
            result.add(new Point(point.getX(), point.getY()+1));
        }

        return result;
    }


}
