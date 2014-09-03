package com.vooft.trycatch.board;

import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.square.impl.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by vooft on 01.09.14.
 */
public class SquareBoardPieceFactory implements AbstractPieceFactory {
    private SquareChessBoard board;
    private Map<PieceType, AbstractPiece> pieces = new HashMap<>();

    public SquareBoardPieceFactory(SquareChessBoard board) {
        this.board = board;

        pieces.put(PieceType.KING, new King().setBoard(board));
        pieces.put(PieceType.QUEEN, new Queen().setBoard(board));
        pieces.put(PieceType.BISHOP, new Bishop().setBoard(board));
        pieces.put(PieceType.ROOK, new Rook().setBoard(board));
        pieces.put(PieceType.KNIGHT, new Knight().setBoard(board));
    }

    @Override
    public AbstractPiece createPiece(PieceType type) {
        return pieces.get(type);
    }
}
