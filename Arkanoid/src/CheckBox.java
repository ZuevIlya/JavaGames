import java.net.URISyntaxException;

public class CheckBox {
    public static void CheckPlatform(int ballX, int ballY, int[] platformX, int platformY, int lengthPlatform, int dot_size) {

        if ((ballY == platformY) && (ballX == platformX[0] - dot_size)) {
            GameField.left = true;
            GameField.right = false;

        }
        if ((ballY == platformY) && (ballX == platformX[lengthPlatform - 1] + dot_size)) {
            GameField.left = false;
            GameField.right = true;
        }
        if (ballY == (platformY - dot_size)) {
            for (int i = 0; i < lengthPlatform; i++) {
                if (ballX == platformX[i]) {
                    GameField.up = true;
                    GameField.down = false;
                    TryGameSound(GameField.platformSound);
                }
            }
            if ((ballX == (platformX[0] - dot_size)) && GameField.right) {
                GameField.platformBorderLeft = true;
                GameField.left = true;
                GameField.right = false;
                GameField.up =true;
                GameField.down = false;
                TryGameSound(GameField.platformSound);
            }
            if ((ballX == (platformX[lengthPlatform - 1] + dot_size)) && GameField.left) {
                GameField.platformBorderRight = true;
                GameField.left = false;
                GameField.right = true;
                GameField.up =true;
                GameField.down = false;
                TryGameSound(GameField.platformSound);
            }
        }
    }

    public static void CheckPoint(int ballX, int ballY, int lengthPoint, int dot_size,
                           int[] pointX, int pointY, int number, boolean[][] delete) {
        border(ballX, ballY, lengthPoint, dot_size);
        for (int i = 0; i < lengthPoint; i++) {
            if ((ballX == pointX[i]) && (ballY == (pointY + dot_size)) && GameField.up && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.up = false;  // Вверх
                GameField.down = true;
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
            if ((ballX == pointX[i]) && (ballY == (pointY - dot_size)) && GameField.down && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.up = true;  // Вниз
                GameField.down = false;
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
            if ((ballX == (pointX[i] - dot_size)) && (ballY == pointY) && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.left = true;  // Слева
                GameField.right = false;
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
            if ((ballX == (pointX[i] + dot_size)) && (ballY == pointY) && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.left = false;  // Справа
                GameField.right = true;
                TryGameSound(GameField.pointSound);
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }

            if ((ballX == (pointX[i] + dot_size)) && (ballY == (pointY + dot_size))
                    && (!delete[i + 1][number]) && GameField.left && GameField.up && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.left = false;
                GameField.right = true;   // Влевый угол снизу
                GameField.up = false;
                GameField.down = true;
                TryGameSound(GameField.pointSound);
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
            if ((ballX == (pointX[i] - dot_size)) && (ballY == (pointY + dot_size))
                    && (!delete[i - 1][number]) && GameField.right && GameField.up && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.left = true;
                GameField.right = false;  // Вправый угол снизу
                GameField.up = false;
                GameField.down = true;
                TryGameSound(GameField.pointSound);
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
            if ((ballX == (pointX[i] - dot_size)) && (ballY == (pointY - dot_size))
                    && (!delete[i - 1][number]) && GameField.right && GameField.down && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.left = true;
                GameField.right = false;  // Вправый угол сверху
                GameField.up = true;
                GameField.down = false;
                TryGameSound(GameField.pointSound);
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
            if ((ballX == (pointX[i] + dot_size)) && (ballY == (pointY - dot_size))
                    && (!delete[i + 1][number]) && GameField.left && GameField.down && (delete[i][number])) {
                GameField.delete[i][number] = false;
                GameField.left = false;
                GameField.right = true;  // Влевый угол сверху
                GameField.up = true;
                GameField.down = false;
                TryGameSound(GameField.pointSound);
                if (GameField.bonus1_counter > 0){
                    Bonus1Function(i, number, lengthPoint);
                    TryGameSound(GameField.pointBoomSound);
                } else{
                    TryGameSound(GameField.pointSound);
                }
            }
        }
    }

    public static void border(int ballX, int ballY, int lengthPoint, int dot_size) {
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
    public static void Bonus1Function (int i, int number, int lengthPoint){
        GameField.bonus1_counter = GameField.bonus1_counter - 1;
        if ((i > 0) && (number > 0)) {
            GameField.delete[i - 1][number - 1] = false;
        }
        if ((i < (lengthPoint - 1)) && (number < 5)) {
            GameField.delete[i + 1][number + 1] = false;
        }
        if ((i < (lengthPoint - 1)) && (number > 0)) {
            GameField.delete[i + 1][number - 1] = false;
        }
        if ((i > 0) && (number < 5)) {
            GameField.delete[i - 1][number + 1] = false;
        }
        if (i > 0) {
            GameField.delete[i - 1][number] = false;
        }
        if (i < (lengthPoint - 1)) {
            GameField.delete[i + 1][number] = false;
        }
        if (number > 0) {
            GameField.delete[i][number - 1] = false;
        }
        if (number < 5) {
        GameField.delete[i][number + 1] = false;
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
