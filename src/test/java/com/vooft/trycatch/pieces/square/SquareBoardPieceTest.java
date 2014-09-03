package com.vooft.trycatch.pieces.square;

import com.vooft.trycatch.board.AbstractChessBoard;
import com.vooft.trycatch.board.AbstractPieceFactory;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.PieceType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SquareBoardPieceTest {
    private SquareBoardPiece piece;

    @Before
    public void setUp() throws Exception {
        piece = new SquareBoardPiece(PieceType.KING) {
            @Override
            public Set<Point> getMovementsForPoint(Point point) {
                return new HashSet<>();
            }
        };
    }

    @Test(expected=WrongBoardTypeException.class)
    public void testSetBoard() throws Exception {
        AbstractChessBoard board = new AbstractChessBoard() {
            @Override
            public AbstractPieceFactory getPieceFactory() {
                return null;
            }
        };

        piece.setBoard(board);
    }
}