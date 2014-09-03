package com.vooft.trycatch.board;

import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;

/**
 * Created by vooft on 01.09.14.
 */
public interface AbstractPieceFactory {
    public AbstractPiece createPiece(PieceType type);
}
