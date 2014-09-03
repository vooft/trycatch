package com.vooft.trycatch;

import com.vooft.trycatch.board.AbstractPieceFactory;
import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.drawer.SquareBoardDrawer;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.solver.SquareBoardSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws WrongBoardTypeException {
        SquareChessBoard board = new SquareChessBoard(new BoardSize(4, 4));
        AbstractPieceFactory factory = board.getPieceFactory();

        List<AbstractPiece> pieces = new ArrayList<>();
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.KNIGHT));
        pieces.add(factory.createPiece(PieceType.ROOK));
        pieces.add(factory.createPiece(PieceType.ROOK));

        SquareBoardSolver solver = new SquareBoardSolver(board);
        Set<Map<Point, AbstractPiece>> result = solver.solve(pieces);

        System.out.println("Board size: " + board.getBoardSize());
        System.out.print("Configuration: ");
        for(AbstractPiece p: pieces) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println("Results amount: " + result.size());

        SquareBoardDrawer drawer = new SquareBoardDrawer();
        drawer.setBoard(board);
        for (Map<Point, AbstractPiece> pointAbstractPieceMap : result) {
            drawer.draw(pointAbstractPieceMap);
            System.out.println();
        }
    }
}
