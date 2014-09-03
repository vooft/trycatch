package com.vooft.trycatch.board;

import com.vooft.trycatch.common.BoardSize;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class SquareChessBoardTest {
    private static final int BOARD_WIDTH = 3;
    private static final int BOARD_HEIGHT = 3;

    private SquareChessBoard board;
    private BoardSize boardSize;

    @Before
    public void setUp() throws Exception {
        boardSize = new BoardSize(BOARD_WIDTH, BOARD_HEIGHT);
        board = new SquareChessBoard(boardSize);
    }

    @Test
    public void testGetBoardSize() throws Exception {
        assertEquals(board.getBoardSize(), boardSize);
    }

    @Test
    public void testGetPieceFactory() throws Exception {
        assertNotNull(board.getPieceFactory());
    }
}