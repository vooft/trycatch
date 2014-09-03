package com.vooft.trycatch.solver;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.AbstractPiece;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by vooft on 03.09.14.
 */
public class ThreadedSquareBoardSolver implements AbstractSolver {
    private SquareChessBoard board;
    private int threadCount = 1;

    public ThreadedSquareBoardSolver(SquareChessBoard board) {
        this.board = board;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public Set<Map<Point, AbstractPiece>> solve(final List<AbstractPiece> pieces) {
        final Set<Map<Point, AbstractPiece>> result =
                Collections.synchronizedSet(new HashSet<Map<Point, AbstractPiece>>());

        if(pieces.isEmpty())
            return result;

        Collections.sort(pieces);

        final List<Point> boardSquares = new ArrayList<>();

        int width = board.getBoardSize().getWidth();
        int height = board.getBoardSize().getHeight();
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                boardSquares.add(new Point(i, j));
            }
        }

        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        List<Future<?>> futures = new ArrayList<>();

        final List<AbstractPiece> restPiecesSub = new ArrayList<>(pieces);
        final AbstractPiece currentPiece = restPiecesSub.remove(0);

        // check all the branches
        for (final Point possibleSquare : boardSquares) {
            Set<Point> possibleMovements = currentPiece.getMovementsForPoint(possibleSquare);

            final Set<Point> underAttackSub = new HashSet<>();
            underAttackSub.addAll(possibleMovements);

            final List<Point> restSquaresSub = new ArrayList<>(boardSquares);
            restSquaresSub.removeAll(possibleMovements);

            final Map<Point, AbstractPiece> filledPiecesSub = new HashMap<>();
            filledPiecesSub.put(possibleSquare, currentPiece);

            Future<?> submit = service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Started execution: " + possibleSquare);

                    result.addAll(solveRecursively(restSquaresSub, restPiecesSub,
                            underAttackSub, filledPiecesSub,
                            possibleSquare, currentPiece));

                    System.out.println("Finished execution " + possibleSquare);
                }
            });
            futures.add(submit);

        }

        while(futures.size()>0) {
            Future<?> future = futures.get(0);
            if(future.isDone()) {
                futures.remove(0);
            }
        }

        service.shutdown();

        return result;
    }

    public Set<Map<Point, AbstractPiece>> solveRecursively(List<Point> restSquares,
                                                           List<AbstractPiece> restPieces,
                                                           Set<Point> underAttack,
                                                           Map<Point, AbstractPiece> filledPieces,
                                                           Point previousPoint,
                                                           AbstractPiece previousPiece) {
        Set<Map<Point, AbstractPiece>> result = null;

        Set<Point> filledSquares = filledPieces.keySet();

        List<AbstractPiece> restPiecesSub = new ArrayList<>(restPieces);
        if(restPiecesSub.isEmpty()==false && restSquares.isEmpty()==false) {
            AbstractPiece currentPiece = restPiecesSub.remove(0);

            int startIndex = 0;
            if(previousPoint!=null) {
                startIndex = restSquares.indexOf(previousPoint);
                restSquares.remove(startIndex);
            }

            if(previousPiece==null || currentPiece.equals(previousPiece)==false)
                startIndex = 0;

            Set<Point> possibleSquares = new HashSet<>();
            for (int i = startIndex; i < restSquares.size(); i++) {
                Point currentSquare = restSquares.get(i);
                Set<Point> possibleMovements = currentPiece.getMovementsForPoint(currentSquare);
                if(Collections.disjoint(possibleMovements, filledSquares)
                        && underAttack.contains(currentSquare)==false) {
                    possibleSquares.add(currentSquare);
                }
            }

            // check all the branches
            for (Point possibleSquare : possibleSquares) {
                Set<Point> possibleMovements = currentPiece.getMovementsForPoint(possibleSquare);

                Set<Point> underAttackSub = new HashSet<>(underAttack);
                underAttackSub.addAll(possibleMovements);

                List<Point> restSquaresSub = new ArrayList<>(restSquares);
                //restSquaresSub.remove(possibleSquare);
                restSquaresSub.removeAll(possibleMovements);

                Map<Point, AbstractPiece> filledPiecesSub = new HashMap<>(filledPieces);
                filledPiecesSub.put(possibleSquare, currentPiece);

                Set<Map<Point, AbstractPiece>> subResult = solveRecursively(restSquaresSub, restPiecesSub,
                        underAttackSub, filledPiecesSub,
                        possibleSquare, currentPiece);
                if(subResult!=null) {
                    if(result==null)
                        result = new HashSet<>();

                    result.addAll(subResult);
                }
            }

        }

        if(restPieces.isEmpty()) {
            if(result==null)
                result = new HashSet<>();

            result.add(filledPieces);
        }

        return result;
    }
}
