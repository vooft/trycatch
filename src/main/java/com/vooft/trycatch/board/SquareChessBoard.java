package com.vooft.trycatch.board;

import com.vooft.trycatch.common.BoardSize;

/**
 * Created by vooft on 01.09.14.
 */
public class SquareChessBoard implements AbstractChessBoard {
    private AbstractPieceFactory pieceFactory = null;
    private BoardSize boardSize;

    public SquareChessBoard(BoardSize boardSize) {
        this.boardSize = boardSize;
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }

    @Override
    public AbstractPieceFactory getPieceFactory() {
        if(pieceFactory==null) {
            pieceFactory = new SquareBoardPieceFactory(this);
        }

        return pieceFactory;
    }
}
