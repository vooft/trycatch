package com.vooft.trycatch.pieces;

import com.vooft.trycatch.board.AbstractChessBoard;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.exception.WrongBoardTypeException;

import java.util.Set;

/**
 * Created by vooft on 01.09.14.
 */
public abstract class AbstractPiece {
    protected PieceType type;
    protected AbstractChessBoard board;

    public AbstractPiece(PieceType type) {
        this.type = type;
    }

    public AbstractPiece setPoint() {
        return this;
    }

    public AbstractPiece setBoard(AbstractChessBoard board) throws WrongBoardTypeException {
        this.board = board;
        return this;
    }

    public abstract Set<Point> getMovementsForPoint(Point point);

    @Override
    public String toString() {
        return type.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPiece that = (AbstractPiece) o;

        if (board != null ? !board.equals(that.board) : that.board != null) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (board != null ? board.hashCode() : 0);
        return result;
    }
}
