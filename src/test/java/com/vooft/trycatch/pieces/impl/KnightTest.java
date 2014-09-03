package com.vooft.trycatch.pieces.impl;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import junitx.framework.ListAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KnightTest {
    private static final int BOARD_WIDTH = 3;
    private static final int BOARD_HEIGHT = 3;

    private Knight knight;
    private SquareChessBoard board;

    @Before
    public void setUp() throws Exception {
        knight = new Knight();

        board = new SquareChessBoard(new BoardSize(BOARD_WIDTH, BOARD_HEIGHT));
        knight.setBoard(board);
    }

    @Test
    public void testGetMovements() throws Exception {
        List<Point> topLeft = new ArrayList<>();
        topLeft.add(new Point(1, 2));
        topLeft.add(new Point(2, 1));

        List<Point> topRight = new ArrayList<>();
        topRight.add(new Point(0, 1));
        topRight.add(new Point(1, 2));

        List<Point> bottomLeft = new ArrayList<>();
        bottomLeft.add(new Point(1, 0));
        bottomLeft.add(new Point(2, 1));

        List<Point> bottomRight = new ArrayList<>();
        bottomRight.add(new Point(1, 0));
        bottomRight.add(new Point(0, 1));

        ListAssert.assertEquals(topLeft, new ArrayList<>(knight.getMovementsForPoint(new Point(0, 0))));
        ListAssert.assertEquals(topRight, new ArrayList<>(knight.getMovementsForPoint(new Point(BOARD_WIDTH-1, 0))));
        ListAssert.assertEquals(bottomLeft, new ArrayList<>(knight.getMovementsForPoint(new Point(0, BOARD_HEIGHT-1))));
        ListAssert.assertEquals(bottomRight, new ArrayList<>(knight.getMovementsForPoint(new Point(BOARD_WIDTH-1, BOARD_HEIGHT-1))));
    }
}