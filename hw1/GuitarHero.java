import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdAudio;

//import javax.sound.midi.Synthesizer;
import synthesizer.GuitarString;
//import java.util.ArrayList;
//import java.util.stream.Stream;

public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    private static final double CONCERT_A = 440.0;
    public static void main(String[] args) {
        GuitarString[] buttom = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            buttom[i] = new GuitarString(CONCERT_A * Math.pow(2, (i - 24) / 12.0));
        }
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                if (i >= 0) {
                    buttom[i].pluck();
                }
            }

            double sample = 0;
            for (int j = 0; j < 37; j++) {
                sample += buttom[j].sample();
                buttom[j].tic();
            }
            StdAudio.play(sample);
        }
    }
}
