package com.vooft.trycatch.board;

import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.pieces.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;

public class SquareBoardPieceFactoryTest {
    private SquareBoardPieceFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SquareBoardPieceFactory(new SquareChessBoard(new BoardSize(2, 2)));
    }

    @Test
    public void testCreatePiece() throws Exception {
        Assert.assertThat(factory.createPiece(PieceType.KING), instanceOf(King.class));
        Assert.assertThat(factory.createPiece(PieceType.QUEEN), instanceOf(Queen.class));
        Assert.assertThat(factory.createPiece(PieceType.BISHOP), instanceOf(Bishop.class));
        Assert.assertThat(factory.createPiece(PieceType.ROOK), instanceOf(Rook.class));
        Assert.assertThat(factory.createPiece(PieceType.KNIGHT), instanceOf(Knight.class));
    }
}