
public class Chess {
    public static void main(String[] args){
        Chessboard board = new Chessboard();
        System.out.println(board.toString());
        Chessboard.Chesspiece rook = board.new Rook('b','R');
        Chessboard.Chesspiece pawn = board.new Pawn('w','P');
        rook.moveTo('d',(byte)4);
        rook.markReachableFields();
        System.out.println(board.toString());

    }
}
