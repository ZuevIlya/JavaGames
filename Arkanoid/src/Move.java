import java.net.URISyntaxException;

public class Move {

    public static void BonusBall(int ballX, int ballY, int bonus1X, int bonus1Y, int dot_size){
        if ((ballX == bonus1X) && (ballY == bonus1Y) && GameField.bonus1_enter){
            GameField.bonus1_enter = false;
            GameField.bonus1_counter = 3;
            TryGameSound(GameField.bonus1Sound);
        }
        if (((ballX == (bonus1X + dot_size)) || (ballX == (bonus1X - dot_size))) && (ballY == bonus1Y) && GameField.bonus1_enter){
            GameField.bonus1_enter = false;
            GameField.bonus1_counter = 3;
            TryGameSound(GameField.bonus1Sound);
        }
        if ((ballX == bonus1X) && ((ballY == (bonus1Y + dot_size)) || (ballY == (bonus1Y - dot_size))) && GameField.bonus1_enter){
            GameField.bonus1_enter = false;
            GameField.bonus1_counter = 3;
            TryGameSound(GameField.bonus1Sound);
        }
    }
    public static void MoveBall(boolean left, boolean right, boolean up, boolean down, int lengthPoint, int dot_size){
        if (left) {
            GameField.ballX = GameField.ballX - dot_size;
            if ((GameField.ballX != 0) && GameField.platformBorderLeft) {
                GameField.ballX = GameField.ballX - dot_size;
                GameField.platformBorderLeft = false;
            }
        }
        if (right) {
            GameField.ballX = GameField.ballX + dot_size;
            if ((GameField.ballX != ((lengthPoint - 1) * dot_size)) && GameField.platformBorderRight) {
                GameField.ballX = GameField.ballX + dot_size;
                GameField.platformBorderRight = false;
            }
        }
        if (up) {
            GameField.ballY = GameField.ballY - dot_size;
        }
        if (down) {
            GameField.ballY = GameField.ballY + dot_size;
        }
    }

    public static void Border(int ballX, int ballY, int lengthPoint, int dot_size){
        if (ballX == 0) {
            GameField.left = false;
            GameField.right = true;
        }
        if (ballX == (lengthPoint - 1) * dot_size) {
            GameField.left = true;
            GameField.right = false;
        }
        if (ballY == 0) {
            GameField.up = false;
            GameField.down = true;
        }
    }

    public static void MovePlatform(boolean platformLeft, boolean platformRight, int lengthPoint, int lengthPlatform, int dot_size){
        if ((platformLeft) && (GameField.platformX[0] != 0)) {
            for (int i = 0; i < lengthPlatform; i++) {
                GameField.platformX[i] = GameField.platformX[i] - dot_size;
            }
        }
        if ((platformRight) && (GameField.platformX[lengthPlatform - 1] != ((lengthPoint - 1) * dot_size))) {
            for (int i = 0; i < lengthPlatform; i++) {
                GameField.platformX[i] = GameField.platformX[i] + dot_size;
            }
        }
    }

    public static void GameSound(Audio sound) throws URISyntaxException {
        try {
            sound.sound();
            sound.setVolume();
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void TryGameSound(Audio sound) {
        try {
            GameSound(sound);
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }
}
