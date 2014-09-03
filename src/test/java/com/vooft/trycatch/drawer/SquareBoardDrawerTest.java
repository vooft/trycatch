package com.vooft.trycatch.drawer;

import com.vooft.trycatch.board.AbstractPieceFactory;
import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.solver.SquareBoardSolver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SquareBoardDrawerTest {

    private SquareChessBoard board;
    private List<AbstractPiece> pieces;

    @Before
    public void setUp() throws Exception {
        board = new SquareChessBoard(new BoardSize(4, 4));
        AbstractPieceFactory factory = board.getPieceFactory();

        pieces = new ArrayList<>();
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.ROOK));
        pieces.add(factory.createPiece(PieceType.ROOK));
    }

    @Test
    public void testDraw() throws Exception {
        SquareBoardSolver solver = new SquareBoardSolver(board);
        Set<Map<Point, AbstractPiece>> result = solver.solve(pieces);

        SquareBoardDrawer drawer = new SquareBoardDrawer();
        drawer.setBoard(board);
        for (Map<Point, AbstractPiece> pointAbstractPieceMap : result) {
            drawer.draw(pointAbstractPieceMap);
        }
    }
}