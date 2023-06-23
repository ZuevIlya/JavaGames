import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.sound.sampled.*;

public class Audio {
    private URL track; // Адрес трека (файла)
    private Clip clip = null; // Ссылка на объект класса
    private FloatControl volumeC = null; //Контроллер громкости
    private double wt; // Уровень громкости

    // Конструктор (адрес файла, уровень громкости)
    public Audio(URL track, double wt){ //String track
        this.track = track; //this.track = track;
        this.wt = wt;
    }

    public void sound() throws URISyntaxException {
        File file1 = new File(this.track.toURI()); // Передаём звуковой файл в file1
        // Поток для записи и считывания
        AudioInputStream track1 = null; // Объект потока AudioInputStream пуст
        try {
            track1 = AudioSystem.getAudioInputStream(file1); // Получаем AudioInputStream (нужный файл)
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip(); // Получаем реализацию интерфейса clip
            clip.open(track1); // Загружаем наш звуковой поток в clip
            // Получаем контроллер громкости
            volumeC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            clip.setFramePosition(0); // Устанавливаем указатель на старт
            clip.start(); // Стартуем
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
    // Уровень громкости
    public void setVolume() {
        if (wt<0) wt = 0;
        if (wt>1) wt = 1;
        float min = volumeC.getMinimum();
        float max = volumeC.getMaximum();
        volumeC.setValue((max - min)*(float)wt + min);
    }
}
