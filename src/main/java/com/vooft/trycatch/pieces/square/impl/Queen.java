package com.vooft.trycatch.pieces.square.impl;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.square.SquareBoardPiece;

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

        SquareChessBoard board = (SquareChessBoard) this.board;
        BoardSize size = board.getBoardSize();

        // top left
        for(int x=point.getX()-1, y=point.getY()-1; x>=0 && y>=0; x--, y--) {
            result.add(new Point(x, y));
        }

        // bottom left
        for(int x=point.getX()-1, y=point.getY()+1; x>=0 && y<size.getHeight(); x--, y++) {
            result.add(new Point(x, y));
        }

        // left
        for(int x=point.getX()-1, y=point.getY(); x>=0; x--) {
            result.add(new Point(x, y));
        }

        // top
        for(int x=point.getX(), y=point.getY()-1; y>=0; y--) {
            result.add(new Point(x, y));
        }

        // top right
        for(int x=point.getX()+1, y=point.getY()-1; x<size.getWidth() && y>=0; x++, y--) {
            result.add(new Point(x, y));
        }

        // bottom right
        for(int x=point.getX()+1, y=point.getY()+1; x<size.getWidth() && y<size.getHeight(); x++, y++) {
            result.add(new Point(x, y));
        }

        // right
        for(int x=point.getX()+1, y=point.getY(); x<size.getWidth(); x++) {
            result.add(new Point(x, y));
        }

        // bottom
        for(int x=point.getX(), y=point.getY()+1; y<size.getHeight(); y++) {
            result.add(new Point(x, y));
        }

        return result;
    }


}
