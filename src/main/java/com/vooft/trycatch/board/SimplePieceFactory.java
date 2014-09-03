package com.vooft.trycatch.board;

import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.square.impl.*;
import com.vooft.trycatch.pieces.PieceType;


/**
 * Created by vooft on 01.09.14.
 */
public class SimplePieceFactory implements AbstractPieceFactory {
    private AbstractChessBoard board;

    public SimplePieceFactory(AbstractChessBoard board) {
        this.board = board;
    }

    @Override
    public AbstractPiece createPiece(PieceType type) {
        AbstractPiece result = null;
        switch (type) {
            case KING:
                result = new King();
                break;
            case QUEEN:
                result = new Queen();
                break;
            case BISHOP:
                result = new Bishop();
                break;
            case ROOK:
                result = new Rook();
                break;
            case KNIGHT:
                result = new Knight();
                break;
        }

        if(result==null)
            return result;

        return result.setBoard(board);
    }
}
