package com.vooft.trycatch.pieces.square;

import com.vooft.trycatch.board.AbstractChessBoard;
import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;

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
}
