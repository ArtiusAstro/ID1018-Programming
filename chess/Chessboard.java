public class Chessboard {
    public static class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        public Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        public void put(Chesspiece piece) {
            this.piece = piece;
        }

        public Chesspiece take() {
            Chesspiece p = this.piece;
            this.piece = null;
            return p;
        }

        public void mark() {
            this.marked = true;
        }

        public void unmark() {
            this.marked = false;
        }

        public String toString() {
            String s = (marked) ? " xx" : " --";
            return (piece == null) ? s : piece.toString();
        }
    }

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;
    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;
        byte column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int j = 0; j < NUMBER_OF_ROWS; j++) {
            for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
                if (i == NUMBER_OF_COLUMNS - 1)
                    out.append(fields[j][i] + "\n");
                else
                    out.append(fields[j][i]);
            }
        }
        return out.toString();
    }

    public boolean isValidField(char row, byte column) {
        if (row > FIRST_ROW + NUMBER_OF_ROWS - 1 || row < FIRST_ROW)
            return false;
        else if (column > NUMBER_OF_COLUMNS || column < FIRST_COLUMN)
            return false;
        else
            return true;
    }

    public abstract class Chesspiece {
        private char color;
        // w - white , b - black
        private char name;
        // K - King , Q - Queen , R - Rook , B - Bishop , N - Knight ,
        // P Pawn
        protected char row = 0;
        protected byte column = -1;

        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        public String toString() {
            return " " + color + name;
        }

        public boolean isOnBoard() {
            return Chessboard.this.isValidField(row, column);
        }

        public void moveTo(char row, byte column) {
        /*throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column))
                throw new NotValidFieldException
                        (" bad field : " + row + column);
                        */
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put(this);
        }

        public void moveOut() {
            this.row = 0;
            this.column = -1;
        }

        public abstract void markReachableFields();

        public abstract void unmarkReachableFields();
    }

    public class Pawn extends Chesspiece {
        public Pawn(char color, char name) {
            super(color, name);
        }

        private Field[] reachableFields(char row, byte column){
            Field[] fields = new Field[2];
        }
        public void markReachableFields() {
            if (Chessboard.this.isValidField(this.row, this.column)) {

            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();
            }
        }
    }

    public class Rook extends Chesspiece {
        public Rook(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {

        }

        public void unmarkReachableFields() {

        }
    }

    public class Knight extends Chesspiece {
        public Knight(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {

            }
        }
    }

    public class Bishop extends Chesspiece {
        public Bishop(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {

            }
        }
    }

    public class Queen extends Chesspiece {
        public Queen(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {

            }
        }
    }

    public class King extends Chesspiece {
        public King(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {

            }
        }
    }
}