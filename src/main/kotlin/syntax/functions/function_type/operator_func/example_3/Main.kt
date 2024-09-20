package syntax.functions.function_type.operator_func.example_3

fun main() {
    val board = ChessBoard().also {
        // Use operator function 'set' inside 'ChessBoard' class
        it[0, 4] = Piece.Queen
        it[8, 4] = Piece.Pawn
    }

    println(
        "Get piece from the board using operator function 'get':" +
        "\n\tpiece on [0, 0]: ${board[0, 0]}" +
        "\n\tpiece on [0, 4]: ${board[0, 4]}" +
        "\n\tpiece on [8, 4]: ${board[8, 4]}"
    )
}

enum class Piece {
    Empty, Pawn, Bishop, Knight, Rook, Queen, King
}

class ChessBoard {
    val board = Array<Piece>(64, { Piece.Empty })

    operator fun get(rank: Int, file: Int): Piece {
        return board[file * 8 + rank]
    }

    operator fun set(rank: Int, file: Int, value: Piece) {
        board[file * 8 + rank] = value
    }
}