package com.vooft.trycatch.drawer;

import com.vooft.trycatch.board.AbstractChessBoard;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.AbstractPiece;

import java.util.Map;

/**
 * Created by vooft on 03.09.14.
 */
public abstract class AbstractBoardDrawer {
    protected AbstractChessBoard board;

    public void setBoard(AbstractChessBoard board) throws WrongBoardTypeException {
        this.board = board;
    }
    public abstract void draw(Map<Point, AbstractPiece> pieces);
}
