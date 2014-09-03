package com.vooft.trycatch.pieces.impl;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.SquareBoardPiece;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vooft on 03.09.14.
 */
public class Knight extends SquareBoardPiece {
    public Knight() {
        super(PieceType.KNIGHT);
    }

    @Override
    public Set<Point> getMovementsForPoint(Point point) {
        Set<Point> result = new HashSet<>();

        SquareChessBoard board = (SquareChessBoard) this.board;
        BoardSize size = board.getBoardSize();

        if(point.getX()>=2 && point.getY()>=1) {
            result.add(new Point(point.getX() - 2, point.getY() - 1));
        }

        if(point.getX()>=2 && point.getY()<size.getHeight()-1) {
            result.add(new Point(point.getX()-2, point.getY()+1));
        }

        if(point.getX()>=1 && point.getY()>=2) {
            result.add(new Point(point.getX()-1, point.getY()-2));
        }

        if(point.getX()>=1 && point.getY()<size.getHeight()-2) {
            result.add(new Point(point.getX()-1, point.getY()+2));
        }

        if(point.getX()<size.getWidth()-1 && point.getY()>=2) {
            result.add(new Point(point.getX()+1, point.getY()-2));
        }

        if(point.getX()<size.getWidth()-1 && point.getY()<size.getHeight()-2) {
            result.add(new Point(point.getX()+1, point.getY()+2));
        }

        if(point.getX()<size.getWidth()-2 && point.getY()>=1) {
            result.add(new Point(point.getX()+2, point.getY()-1));
        }

        if(point.getX()<size.getWidth()-2 && point.getY()<size.getHeight()-1) {
            result.add(new Point(point.getX()+2, point.getY()+1));
        }

        return result;
    }
}
