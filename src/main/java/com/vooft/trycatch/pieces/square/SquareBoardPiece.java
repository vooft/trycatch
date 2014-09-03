package com.vooft.trycatch.pieces.square;

import com.vooft.trycatch.board.AbstractChessBoard;
import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vooft on 01.09.14.
 */
public abstract class SquareBoardPiece extends AbstractPiece {
    public SquareBoardPiece(PieceType type) {
        super(type);
    }

    @Override
    public AbstractPiece setBoard(AbstractChessBoard board) throws WrongBoardTypeException {
        if(board instanceof SquareChessBoard == false)
            throw new WrongBoardTypeException();

        this.board = board;

        return this;
    }

    protected Set<Point> getDiagonalMovementsForPoint(Point point) {
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

        // top right
        for(int x=point.getX()+1, y=point.getY()-1; x<size.getWidth() && y>=0; x++, y--) {
            result.add(new Point(x, y));
        }

        // bottom right
        for(int x=point.getX()+1, y=point.getY()+1; x<size.getWidth() && y<size.getHeight(); x++, y++) {
            result.add(new Point(x, y));
        }

        return result;
    }

    protected Set<Point> getHorizontalMovementsForPoint(Point point) {
        Set<Point> result = new HashSet<>();

        SquareChessBoard board = (SquareChessBoard) this.board;
        BoardSize size = board.getBoardSize();

        // left
        for(int x=point.getX()-1, y=point.getY(); x>=0; x--) {
            result.add(new Point(x, y));
        }

        // right
        for(int x=point.getX()+1, y=point.getY(); x<size.getWidth(); x++) {
            result.add(new Point(x, y));
        }

        return result;
    }

    protected Set<Point> getVerticalMovementsForPoint(Point point) {
        Set<Point> result = new HashSet<>();

        SquareChessBoard board = (SquareChessBoard) this.board;
        BoardSize size = board.getBoardSize();

        // top
        for(int x=point.getX(), y=point.getY()-1; y>=0; y--) {
            result.add(new Point(x, y));
        }

        // bottom
        for(int x=point.getX(), y=point.getY()+1; y<size.getHeight(); y++) {
            result.add(new Point(x, y));
        }
        return result;
    }
}
