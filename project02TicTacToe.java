import java.util.Scanner;

public class project02TicTacToe {

    public static void main(String[] args) {
        char[] board = {'1', '2', '3',
                '4', '5', '6',
                '7', '8', '9'};
        var numberOfSquaresPlayed = 0;
        var whoseTurnItIs = 'x';
        var gameEndingMessage = "Game Over! Try again.";

        Scanner in = null;
        while (numberOfSquaresPlayed < 9) {
            printTheBoard(board);
            System.out.printf("Choose a square player %s: ", whoseTurnItIs);
            in = new Scanner(System.in);
            int input = in.nextInt();


            // έγκυρη επιλογή αριθμού
            if (input < 1 || input > 9) {
                System.out.println("Invalid square. Choose square between 1 and 9");
                continue;
            }


            // κατειλλημένη θέση
            if (board[input - 1] == 'x' || board[input - 1] == 'o') {
                System.out.println("This square is taken. Please choose another.");
                continue; // επιστρέφει στην αρχική loop
            }


            // ενημέρωση πίνακα
            board[input - 1] = whoseTurnItIs;


            // νίκη
            if ((board[0] + board[1] + board[2]) == (whoseTurnItIs * 3) //δλδ είναι ΧΧΧ
                    || (board[3] + board[4] + board[5]) == (whoseTurnItIs * 3)
                    || (board[6] + board[7] + board[8]) == (whoseTurnItIs * 3)
                    || (board[0] + board[3] + board[6]) == (whoseTurnItIs * 3)
                    || (board[1] + board[4] + board[7]) == (whoseTurnItIs * 3)
                    || (board[2] + board[5] + board[8]) == (whoseTurnItIs * 3)
                    || (board[0] + board[4] + board[8]) == (whoseTurnItIs * 3)
                    || (board[2] + board[4] + board[6]) == (whoseTurnItIs * 3)) {

                printTheBoard(board);
                gameEndingMessage = "Congats! You won.";
                break;

            } else { // αν δεν κερδίσει
                numberOfSquaresPlayed++; // αυξάνονται τα τετράγωνα
                whoseTurnItIs = (whoseTurnItIs == 'x') ? 'o' : 'x';
            }

        }
        System.out.println(gameEndingMessage);
        in.close();
    }

    //οπτικοποίηση του πίνακα
    private static void printTheBoard (char[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(" - + - + -");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(" - + - + -");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
}

