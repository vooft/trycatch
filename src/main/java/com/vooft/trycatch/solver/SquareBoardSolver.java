package com.vooft.trycatch.solver;

import com.vooft.trycatch.board.SquareChessBoard;
import com.vooft.trycatch.common.Point;
import com.vooft.trycatch.pieces.AbstractPiece;

import java.util.*;

/**
 * Created by vooft on 01.09.14.
 */
public class SquareBoardSolver implements AbstractSolver {
    private SquareChessBoard board;

    public SquareBoardSolver(SquareChessBoard board) {
        this.board = board;
    }

    @Override
    public Set<Map<Point, AbstractPiece>> solve(List<AbstractPiece> pieces) {
        Collections.sort(pieces);

        List<Point> boardSquares = new ArrayList<>();

        int width = board.getBoardSize().getWidth();
        int height = board.getBoardSize().getHeight();
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                boardSquares.add(new Point(i, j));
            }
        }

        return solveRecursively(boardSquares, pieces,
                new HashSet<Point>(), new HashMap<Point, AbstractPiece>(),
                null, null);
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
