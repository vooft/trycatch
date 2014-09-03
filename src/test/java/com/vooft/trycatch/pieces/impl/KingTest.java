package com.vooft.trycatch.pieces.impl;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import junitx.framework.ListAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KingTest {
    private static final int BOARD_WIDTH = 8;
    private static final int BOARD_HEIGHT = 8;

    private King king;
    private SquareChessBoard board;

    @Before
    public void setUp() throws Exception {
        king = new King();

        board = new SquareChessBoard(new BoardSize(BOARD_WIDTH, BOARD_HEIGHT));
        king.setBoard(board);
    }

    @Test
    public void testGetMovements() throws Exception {
        List<Point> topLeft = new ArrayList<>();
        topLeft.add(new Point(1, 0));
        topLeft.add(new Point(1, 1));
        topLeft.add(new Point(0, 1));

        List<Point> topRight = new ArrayList<>();
        topRight.add(new Point(BOARD_WIDTH-2, 0));
        topRight.add(new Point(BOARD_WIDTH-1, 1));
        topRight.add(new Point(BOARD_WIDTH-2, 1));

        List<Point> bottomLeft = new ArrayList<>();
        bottomLeft.add(new Point(0, BOARD_HEIGHT-2));
        bottomLeft.add(new Point(1, BOARD_HEIGHT-1));
        bottomLeft.add(new Point(1, BOARD_HEIGHT-2));

        List<Point> bottomRight = new ArrayList<>();
        bottomRight.add(new Point(BOARD_WIDTH-1, BOARD_HEIGHT-2));
        bottomRight.add(new Point(BOARD_WIDTH-2, BOARD_HEIGHT-1));
        bottomRight.add(new Point(BOARD_WIDTH-2, BOARD_HEIGHT-2));

        ListAssert.assertEquals(topLeft, new ArrayList<>(king.getMovementsForPoint(new Point(0, 0))));
        ListAssert.assertEquals(topRight, new ArrayList<>(king.getMovementsForPoint(new Point(BOARD_WIDTH-1, 0))));
        ListAssert.assertEquals(bottomLeft, new ArrayList<>(king.getMovementsForPoint(new Point(0, BOARD_HEIGHT-1))));
        ListAssert.assertEquals(bottomRight, new ArrayList<>(king.getMovementsForPoint(new Point(BOARD_WIDTH-1, BOARD_HEIGHT-1))));
    }
}