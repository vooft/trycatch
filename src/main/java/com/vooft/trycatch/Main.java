package com.vooft.trycatch;

import com.vooft.trycatch.board.AbstractPieceFactory;
import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.BoardSize;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.drawer.SquareBoardDrawer;
import com.vooft.trycatch.exception.WrongBoardTypeException;
import com.vooft.trycatch.pieces.AbstractPiece;
import com.vooft.trycatch.pieces.PieceType;
import com.vooft.trycatch.solver.ThreadedSquareBoardSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static final int OUTPUT_LIMIT = 100;

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws WrongBoardTypeException {
        double startTime = System.nanoTime();

        boolean hasNonIntegerArgument = false;
        for(String s: args) {
            if(isInteger(s)==false) {
                hasNonIntegerArgument = true;
                break;
            }
        }
        if(args.length<7 || hasNonIntegerArgument) {
            System.err.println("Program requires at least 7 arguments. All arguments should be integers.\n");
            System.out.println("Arguments should be: board_width board_height kings queens bishops rooks knights [threads_count]\n");
            System.out.println("Example: mvn -q compile && mvn -q exec:java -Dexec.args=\"7 7 2 2 2 0 1 4\"");
            System.out.println("This will compile and run application with 7x7 board, 2 kings, 2 queens, 2 bishops, 0 rooks and 1 knight and use 4 threads to calculate");
            return;
        }

        int width = Integer.valueOf(args[0]);
        int height = Integer.valueOf(args[1]);

        SquareChessBoard board = new SquareChessBoard(new BoardSize(width, height));
        AbstractPieceFactory factory = board.getPieceFactory();

        int kings = Integer.valueOf(args[2]);
        int queens = Integer.valueOf(args[3]);
        int bishops = Integer.valueOf(args[4]);
        int rooks = Integer.valueOf(args[5]);
        int knights = Integer.valueOf(args[6]);

        int threadsCount = 1;
        if(args.length>7)
            threadsCount = Integer.valueOf(args[7]);

        List<AbstractPiece> pieces = new ArrayList<>();

        for(int i=0; i<kings; i++)
            pieces.add(factory.createPiece(PieceType.KING));

        for(int i=0; i<queens; i++)
            pieces.add(factory.createPiece(PieceType.QUEEN));

        for(int i=0; i<bishops; i++)
            pieces.add(factory.createPiece(PieceType.BISHOP));

        for(int i=0; i<rooks; i++)
            pieces.add(factory.createPiece(PieceType.ROOK));

        for(int i=0; i<knights; i++)
            pieces.add(factory.createPiece(PieceType.KNIGHT));

        System.out.println("Board size: " + board.getBoardSize());
        System.out.print("Configuration: ");
        for(AbstractPiece p: pieces) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println("Threads count: " + threadsCount);

        ThreadedSquareBoardSolver solver = new ThreadedSquareBoardSolver(board);
        solver.setThreadCount(threadsCount);

        Set<Map<Point, AbstractPiece>> result = solver.solve(pieces);

        SquareBoardDrawer drawer = new SquareBoardDrawer();
        drawer.setBoard(board);

        int limit = OUTPUT_LIMIT;
        for (Map<Point, AbstractPiece> pointAbstractPieceMap : result) {
            drawer.draw(pointAbstractPieceMap);
            System.out.println();

            if(limit--<0)
                break;
        }

        if(result.size()>OUTPUT_LIMIT) {
            System.out.println("Printed first " + OUTPUT_LIMIT + " solutions");
        }

        System.out.println("Board size: " + board.getBoardSize());
        System.out.print("Configuration: ");
        for(AbstractPiece p: pieces) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println("Threads count: " + threadsCount);
        System.out.println("Results amount: " + result.size());

        double time = (System.nanoTime()-startTime)/(1000*1000*1000);
        System.out.println(String.format("Execution time: %.2f secs.", time));
    }
}
