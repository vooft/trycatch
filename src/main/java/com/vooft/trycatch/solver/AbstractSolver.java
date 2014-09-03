package com.vooft.trycatch.solver;

import com.vooft.trycatch.pieces.AbstractPiece;

import java.util.List;

/**
 * Created by vooft on 01.09.14.
 */
public interface AbstractSolver {
    public java.util.Set<java.util.Map<com.vooft.trycatch.common.Point, AbstractPiece>> solve(List<AbstractPiece> pieces);
}
