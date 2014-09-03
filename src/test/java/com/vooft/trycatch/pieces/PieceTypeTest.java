package com.vooft.trycatch.pieces;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class PieceTypeTest {
    @Test
    public void testToString() throws Exception {
        for(PieceType t: PieceType.values()) {
            assertNotNull(t.toString());
        }
    }
}