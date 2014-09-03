package com.vooft.trycatch.drawer;

import com.vooft.trycatch.board.AbstractChessBoard;
import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.AbstractPiece;

import java.util.Map;

/**
 * Created by vooft on 03.09.14.
 */
public class SquareBoardDrawer extends AbstractBoardDrawer {
    @Override
    public void setBoard(AbstractChessBoard board) {
        if(board instanceof SquareChessBoard == false)
            throw new WrongBoardTypeException();

        this.board = board;
    }

    @Override
    public void draw(Map<Point, AbstractPiece> pieces) {
        SquareChessBoard squareChessBoard = (SquareChessBoard) board;
        int width = squareChessBoard.getBoardSize().getWidth();
        int height = squareChessBoard.getBoardSize().getHeight();

        int a = (int) 'a';
        System.out.print("  ");
        for (int i = 0; i < width; i++) {
            char c = (char) (a+i);
            System.out.print("  " + c);
        }
        System.out.println();

        System.out.print(" \u2554");
        for (int i = 0; i < width; i++) {
            System.out.print("\u2550\u2550\u2550");
        }
        System.out.print("\u2550\u2550\u2557\n");

        for (int i = 0; i < height; i++) {
            System.out.print((i+1) + "\u2551  ");
            for (int j = 0; j < width; j++) {
                Point p = new Point(i, j);
                if(pieces.containsKey(p)==false) {
                    System.out.print("\u00B7");
                } else {
                    System.out.print(pieces.get(p).toString());
                }

                System.out.print("  ");
            }

            System.out.println("\u2551");
        }

        System.out.print(" \u255A");
        for (int i = 0; i < width; i++) {
            System.out.print("\u2550\u2550\u2550");
        }
        System.out.print("\u2550\u2550\u255D\n");
    }
}
