package ChessGame;

import java.util.List;

public class Chess {

	public enum PieceColor {
		BLACK, WHITE
	}

	public interface IPlayerEngine {
		void makeMove();
	}

	public class Square {
		int row;
		int col;

	}

	public class Piece {
		PieceColor color;
		Square placeAt;
		boolean moved;

		public Piece(PieceColor color, Square placeAt, boolean moved) {
			super();
			this.color = color;
			this.placeAt = placeAt;
			this.moved = moved;
		}

		public Square[] validModes() {
			return null;
		}

		public boolean toBeCaptured() {
			return false;
		}

		public Square[] attackSquares() {
			return null;
		}

		public Square[] captureFreeMoves() {
			return null;
		}
	}

	public class King extends Piece {

		public King(PieceColor color, Square placeAt, boolean moved) {
			super(color, placeAt, moved);
		}

	}

	public class Queen extends Piece {

		public Queen(PieceColor color, Square placeAt, boolean moved) {
			super(color, placeAt, moved);
		}

	}

	public class Knight extends Piece {

		public Knight(PieceColor color, Square placeAt, boolean moved) {
			super(color, placeAt, moved);
		}

	}

	public class Bishop extends Piece {

		public Bishop(PieceColor color, Square placeAt, boolean moved) {
			super(color, placeAt, moved);
		}

	}

	public class Rook extends Piece {

		public Rook(PieceColor color, Square placeAt, boolean moved) {
			super(color, placeAt, moved);
		}

	}

	public enum Result {
		BLACK_WON, WHITE_WON, STALE_MATE, DRAW
	}

	public enum CheckStatus {
		BLACK_IN_CHECK, WHITE_IN_CHECK, BLACK_CHECK_MATED, WHITE_CHECK_MATED, NONE
	}

	public enum MoveDirection {
		UP, DOWN
	}

	public class Pawn extends Piece {

		public Pawn(PieceColor color, Square placeAt, boolean moved) {
			super(color, placeAt, moved);
		}

		public boolean isPromoted() {
			return false;
		}

		public Piece promotedTo() {
			return null;
		}

		public MoveDirection direction() {
			return MoveDirection.UP;
		}
	}

	public class PieceSet {
		PieceColor color;
		Piece[] pieces;

	}

	public class Move {
		Square startSquare;
		Square endSquare;
		Piece piece;
		Piece capturedPiece;

		public Move(Square startSquare, Square endSquare, Piece piece, Piece capturedPiece) {
			super();
			this.startSquare = startSquare;
			this.endSquare = endSquare;
			this.piece = piece;
			this.capturedPiece = capturedPiece;
		}

	}

	public class Board {
		Square[][] squares;
		PieceSet[] pieceSets;
		PieceColor pieceSetOnTop;

		public void create() {
		}
	}

	public class HumanPlayer implements IPlayerEngine {

		@Override
		public void makeMove() {

		}

	}

	public class ComputedPlayer implements IPlayerEngine {

		@Override
		public void makeMove() {

		}

	}

	public class Player {
		PieceColor color;
		IPlayerEngine engine;

	}

	public class Game {
		PieceColor turn;
		List<Move> playedMoves;
		Player[] players;
		Result result;
		CheckStatus checkStatus;

		public void create() {

		}

		public void addMove() {

		}

		public boolean isEnded() {
			return false;
		}

		public boolean isChecked() {
			return false;
		}

		public void operation() {

		}
	}

	public static void main(String[] args) {

	}

}
