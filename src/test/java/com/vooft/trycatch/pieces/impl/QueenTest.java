package com.vooft.trycatch.pieces.impl;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import junitx.framework.ListAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QueenTest {
    private static final int BOARD_WIDTH = 3;
    private static final int BOARD_HEIGHT = 3;

    private Queen queen;
    private SquareChessBoard board;

    @Before
    public void setUp() throws Exception {
        queen = new Queen();

        board = new SquareChessBoard(new BoardSize(BOARD_WIDTH, BOARD_HEIGHT));
        queen.setBoard(board);
    }

    @Test
    public void testGetMovements() throws Exception {
        List<Point> topLeft = new ArrayList<>();
        topLeft.add(new Point(1, 0));
        topLeft.add(new Point(2, 0));
        topLeft.add(new Point(0, 1));
        topLeft.add(new Point(0, 2));
        topLeft.add(new Point(1, 1));
        topLeft.add(new Point(2, 2));

        List<Point> topRight = new ArrayList<>();
        topRight.add(new Point(0, 0));
        topRight.add(new Point(1, 0));
        topRight.add(new Point(2, 1));
        topRight.add(new Point(2, 2));
        topRight.add(new Point(1, 1));
        topRight.add(new Point(0, 2));

        List<Point> bottomLeft = new ArrayList<>();
        bottomLeft.add(new Point(0, 0));
        bottomLeft.add(new Point(0, 1));
        bottomLeft.add(new Point(1, 2));
        bottomLeft.add(new Point(2, 2));
        bottomLeft.add(new Point(1, 1));
        bottomLeft.add(new Point(2, 0));

        List<Point> bottomRight = new ArrayList<>();
        bottomRight.add(new Point(0, 2));
        bottomRight.add(new Point(1, 2));
        bottomRight.add(new Point(2, 0));
        bottomRight.add(new Point(2, 1));
        bottomRight.add(new Point(1, 1));
        bottomRight.add(new Point(0, 0));

        ListAssert.assertEquals(topLeft, new ArrayList<>(queen.getMovementsForPoint(new Point(0, 0))));
        ListAssert.assertEquals(topRight, new ArrayList<>(queen.getMovementsForPoint(new Point(BOARD_WIDTH - 1, 0))));
        ListAssert.assertEquals(bottomLeft, new ArrayList<>(queen.getMovementsForPoint(new Point(0, BOARD_HEIGHT - 1))));
        ListAssert.assertEquals(bottomRight, new ArrayList<>(queen.getMovementsForPoint(new Point(BOARD_WIDTH - 1, BOARD_HEIGHT - 1))));
    }
}