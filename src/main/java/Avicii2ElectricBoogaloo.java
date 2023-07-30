import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/*
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html
 */
public class Avicii2ElectricBoogaloo {



    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public Avicii2ElectricBoogaloo(int instrument, int volume) {

        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }

    public void run(){

        try {

            levels();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        closeSynth();
    }




    public void levels() throws InterruptedException
    {
        combineLeftHandRightHand();
        rest(238);
    }


    public void rightHand() throws InterruptedException
    {
        // bar 1
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        System.out.println(); // bar 2
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        System.out.println(); // bar 3
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        System.out.println(); // bar 4
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playChord2("G#5", "E5", 238);
        playNote("C#5", 238);
        playNote("G#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("G#4", 119);
        playNote("G#4", 119);
        playNote("E4", 119);
        playNote("C#4", 119);
        playNote("G#3", 119);
        System.out.println(); // bar 5
        rest(238);
        playChord3("E4", "C#4", "G#3", 238);
        playChord3("E4", "C#4", "G#3", 238);
        rest(238);
        playChord3("E4", "B3", "G#3", 238);
        playChord3("E4", "B3", "G#3", 238);
        playChord3("E4", "B3", "G#3", 238);
        playChord3("E4", "B3", "G#3", 238);
        System.out.println(); // bar 6
        playChord3("D#4", "B3", "F#3", 238);
        playChord3("D#4", "B3", "F#3", 238);
        playChord3("E4", "B3", "F#3", 238);
        playChord3("E4", "C#4", "A3", 238);
        rest(238);
        playChord2("C#5", "E4", 238);
        playChord2("B4", "E4", 238);
        playChord2("G#4", "E4", 238);
        System.out.println(); // bar 7
        playChord3("F#4", "C#4", "G#3", 238);
        playChord3("E4", "C#4", "G#3", 238);
        playChord3("E4", "C#4", "G#3", 238);
        rest(238);
        playChord3("E4", "B3", "G#3", 238);
        playChord3("E4", "B3", "G#3", 238);
        playChord3("E4", "B3", "G#3", 238);
        playChord3("E4", "B3", "G#3", 238);
        System.out.println(); // bar 8
        playChord2("C#4", "F#3", 238);
        playChord2("C#4", "F#3", 238);
        playNote("B3", 238);
        playNote("B3", 238);
        rest(238);
        playChord2("C#5", "E4", 238);
        playChord2("B4", "E4", 238);
        playChord2("G#4", "E4", 238);
        System.out.println(); // bar 9
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "F#4", 238);
        rest(238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 10
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("A3", "C#4", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 11
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        rest(238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 12
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 13
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 14
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 15
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 16
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 17
        playChord2("G#3", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 18
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 19
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 20
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 21
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 22
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 23
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 24
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 25
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 26
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 27
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 28
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 29
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 30
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 31
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 32
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 33
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 34
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 35
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 36
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 37
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 38
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "D#4", 238);
        playChord3("F#3", "B3", "E4", 238);
        playChord3("F#3", "B3", "E4", 238);
        rest(238);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
        System.out.println(); // bar 39
        playChord3("G#3", "C#4", "F#4", 238);
        playChord3("G#3", "C#4", "E4", 238);
        playChord3("G#3", "C#4", "E4", 476);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        playChord3("G#3", "B3", "E4", 238);
        System.out.println(); // bar 40
        playChord2("F#3", "C#4", 238);
        playChord2("F#3", "C#4", 238);
        playNote("B3", 238);
        playNote("B3", 476);
        playChord2("E4", "C#5", 238);
        playChord2("E4", "B4", 238);
        playChord2("E4", "G#4", 238);
    }


    public void leftHand() throws InterruptedException
    {
        // bar 1
        playChord2("G#4", "E4", 476);
        playChord2("G#4", "E4", 476);
        playChord2("G#4", "E4", 476);
        playChord2("G#4", "E4", 476);
        // bar 2
        playChord2("G#4", "E4", 476);
        playChord2("G#4", "E4", 476);
        playChord2("G#4", "E4", 476);
        playChord2("G#4", "E4", 476);
        // bar 3
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        playChord2("E4", "C#3", 238);
        // bar 4
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        // bar 5
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        rest(119);
        playNote("B2", 119);
        playChord2("E3", "E2",238);
        playChord2("E3", "E2",238);
        playChord2("E3", "E2",238);
        playChord2("E3", "E2",238);
        // bar 6
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("A2", "A1", 238);
        rest(238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        // bar 7
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        playChord2("C#3", "C#2", 238);
        rest(119);
        playNote("B2", 119);
        playChord2("E3", "E2",238);
        playChord2("E3", "E2",238);
        playChord2("E3", "E2",238);
        playChord2("E3", "E2",238);
        // bar 8
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("A2", "A1", 238);
        rest(238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        // bar 9
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        rest(119);
        playNote("B2", 119);
        playChord2("E2", "E3", 238);
        playChord2("E2", "E3", 238);
        playChord2("E2", "E3", 238);
        playChord2("E2", "E3", 238);
        // bar 10
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("A2", "A1", 238);
        rest(238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        // bar 11
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        rest(119);
        playNote("B2", 119);
        playChord2("E2", "E3", 238);
        playChord2("E2", "E3", 238);
        playChord2("E2", "E3", 238);
        playChord2("E2", "E3", 238);
        // bar 12
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("B2", "B1", 238);
        playChord2("A2", "A1", 238);
        rest(238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        playChord2("A2", "A1", 238);
        // bar 13
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 14
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        // bar 15
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 16
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        // bar 17
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 18
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        // bar 19
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 20
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("B2", 238);
        playChord2("F#3", "B3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        playNote("A2", 238);
        playChord2("E3", "A3", 238);
        // bar 21
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 22
        playChord2("B1", "B2", 952);
        playChord2("A1", "A2", 952);
        // bar 23
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 24
        playChord2("B1", "B2", 952);
        playChord2("A1", "A2", 952);
        // bar 25
        playNote("C#2", 238);
        playNote("G#2", 238);
        playNote("C#3", 238);
        playNote("G#2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("E3", 238);
        playNote("B2", 238);
        // bar 26
        playNote("B1", 238);
        playNote("F#2", 238);
        playNote("B2", 238);
        playNote("F#2", 238);
        playNote("A1", 238);
        playNote("E2", 238);
        playNote("A2", 238);
        playNote("E2", 238);
        // bar 27
        playNote("C#2", 238);
        playNote("G#2", 238);
        playNote("C#3", 238);
        playNote("G#2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("E3", 238);
        playNote("B2", 238);
        // bar 28
        playChord2("B1", "B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        // bar 29
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 30
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 31
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 32
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 33
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 34
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 35
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 36
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 37
        playChord2("C#2", "C#3", 476);
        playChord3("G#3", "C#4", "E4", 476);
        playChord2("E2", "E3", 476);
        playChord3("G#3", "B3", "E4", 476);
        // bar 38
        playChord2("B1", "B2", 476);
        playChord3("F#3", "B3", "D#4", 476);
        playChord2("A1", "A2", 476);
        playChord3("A3", "C#4", "E4", 476);
        // bar 39
        playChord2("C#2", "C#3", 476);
        playChord3("G#3", "C#4", "E4", 476);
        playChord2("E2", "E3", 476);
        playChord3("G#3", "B3", "E4", 476);
        // bar 40
        playChord2("B1", "B2", 476);
        playChord3("F#3", "B3", "D#4", 476);
        playChord2("A1", "A2", 476);
        playChord3("A3", "C#4", "E4", 476);
    }


    public void combineLeftHandRightHand() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                rightHand();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                leftHand();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads to play simultaneously
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();
    }





    /*
     * Delay program, i.e. rest
     */
    public static void rest(int duration) throws InterruptedException {
        System.out.print("rest " );
        Thread.sleep(duration);
    }

    /*
     * Play a note in the form <octave><note>, e.g. "C4" for middle C
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html#noteOn(int,int)
     */
    public void playNote(String note) throws InterruptedException {
        System.out.print(note + " " );
        playNote(note, 238); // 238 milliseconds = 1/8 beat for 126 bpm
    }

    public void playNote(String note, int durationMs) throws InterruptedException {
        System.out.print(note + " " );
        playNote(note, this.volume, durationMs);
    }

    public void playNote(String note, int volume, int durationMs) throws InterruptedException {
        int octave = Integer.parseInt(note.substring(note.length() - 1));
        int tone = note.length() > 2 ? getToneIndex(note.substring(0, 2)) : getToneIndex(note.substring(0, 1));
        int midi_note = 12 + (12 * octave) + tone;

        /*
         * Play note for duration using Thread.sleep, then turn off note
         */
        channels[this.instrument].noteOn(midi_note, volume );
        Thread.sleep( durationMs );
        channels[this.instrument].noteOff(midi_note);
    }

    private Integer getToneIndex(String note){
        Integer toneIndex = null;

        for(int i = 0; i < notes.length; i++){
            if( notes[i].equals(note) ){
                toneIndex = i;
                break;
            }
        }

        return toneIndex;
    }


    // ********** playChord METHODS **********

    public void playChord2(String note1, String note2, int durationMs) throws InterruptedException {
        System.out.print(note1 + " " + note2 + " ");
        playChord2(note1, note2, this.volume, durationMs);;
    }
    public void playChord2(String note1, String note2, int volume, int durationMs) throws InterruptedException {

        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2)};

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }

        // wait for specified duration
        Thread.sleep(durationMs);

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    public void playChord3(String note1, String note2, String note3, int durationMs) throws InterruptedException {
        System.out.print(note1 + " " + note2 + " " + note3 + " ");
        playChord3(note1, note2, note3, this.volume, durationMs);;
    }
    public void playChord3(String note1, String note2, String note3, int volume, int durationMs) throws InterruptedException {

        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2), getMidiNumber(note3)};

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }

        // wait for specified duration
        Thread.sleep(durationMs);

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    public void playChord4(String note1, String note2, String note3, String note4, int durationMs) throws InterruptedException {
        System.out.print("\t" + note1 + "\t\t" + note2 + "\t\t" + note3 + "\t\t" + note4 + "\t");
        playChord4(note1, note2, note3, note4, this.volume, durationMs);;
    }

    public void playChord4(String note1, String note2, String note3, String note4, int volume, int durationMs) throws InterruptedException {

        int[] midiNotes = {getMidiNumber(note1), getMidiNumber(note2), getMidiNumber(note3), getMidiNumber(note4)};

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOn(midiNote, volume);
            }
        }

        // wait for specified duration
        Thread.sleep(durationMs);

        for (int midiNote : midiNotes) {
            if (midiNote != -1) {
                channels[this.instrument].noteOff(midiNote);
            }
        }
    }

    private int getMidiNumber(String noteWithOctave) {
        int octave = Integer.parseInt(noteWithOctave.substring(noteWithOctave.length() - 1));
        String noteName = noteWithOctave.substring(0, noteWithOctave.length() - 1).toUpperCase();
        int noteIndex = -1;

        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(noteName)) {
                noteIndex = 12 + (12 * octave) + i;
                break;
            }
        }
        return noteIndex;
    }





    // ********** OPEN / CLOSE SYNTH **********
    private void openSynth(){
        try {

            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.channels = synth.getChannels();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void closeSynth(){
        if(synth != null && synth.isOpen()) {
            synth.close();
        }
    }
}

