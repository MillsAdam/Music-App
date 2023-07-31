import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/sound/midi/MidiChannel.html
 */
public class Avicii {

    final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    Synthesizer synth;
    MidiChannel[] channels;
    int instrument;
    int volume;

    public Avicii(int instrument, int volume) {

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
        System.out.print("Bar 1: ");// bar 1
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        System.out.print("\nBar 2: "); // bar 2
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        System.out.print("\nBar 3: "); // bar 3
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        System.out.print("\nBar 4: "); // bar 4
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playChord2("G#6", "E6", 238);
        playNote("C#6", 238);
        playNote("G#6", 119);
        playNote("E6", 119);
        playNote("C#6", 119);
        playNote("G#5", 119);
        playNote("G#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("G#4", 119);
        System.out.print("\nBar 5: "); // bar 5
        rest(238);
        playChord3("E5", "C#5", "G#4", 238);
        playChord3("E5", "C#5", "G#4", 238);
        rest(238);
        playChord3("E5", "B5", "G#4", 238);
        playChord3("E5", "B4", "G#4", 238);
        playChord3("E5", "B4", "G#4", 238);
        playChord3("E5", "B4", "G#4", 238);
        System.out.print("\nBar 6: "); // bar 6
        playChord3("D#5", "B4", "F#4", 238);
        playChord3("D#5", "B4", "F#4", 238);
        playChord3("E5", "B4", "F#4", 238);
        playChord3("E5", "C#5", "A4", 238);
        rest(238);
        playChord2("C#6", "E5", 238);
        playChord2("B5", "E5", 238);
        playChord2("G#5", "E5", 238);
        System.out.print("\nBar 7: "); // bar 7
        playChord3("F#5", "C#5", "G#4", 238);
        playChord3("E5", "C#5", "G#4", 238);
        playChord3("E5", "C#5", "G#4", 238);
        rest(238);
        playChord3("E5", "B4", "G#4", 238);
        playChord3("E5", "B4", "G#4", 238);
        playChord3("E5", "B4", "G#4", 238);
        playChord3("E5", "B4", "G#4", 238);
        System.out.print("\nBar 8: "); // bar 8
        playChord2("C#5", "F#4", 238);
        playChord2("C#5", "F#4", 238);
        playNote("B4", 238);
        playNote("B4", 238);
        rest(238);
        playChord2("C#5", "E5", 238);
        playChord2("B5", "E5", 238);
        playChord2("G#5", "E5", 238);
        System.out.print("\nBar 9: "); // bar 9
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "F#5", 238);
        rest(238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 10: "); // bar 10
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("A4", "C#5", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 11: "); // bar 11
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        rest(238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 12: "); // bar 12
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 13: "); // bar 13
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 14: "); // bar 14
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 15: "); // bar 15
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 16: "); // bar 16
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 17: "); // bar 17
        playChord2("G#4", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 18: "); // bar 18
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 19: "); // bar 19
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 20: "); // bar 20
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 21: "); // bar 21
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 22: "); // bar 22
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 23: "); // bar 23
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 24: "); // bar 24
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 25: "); // bar 25
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 26: "); // bar 26
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 27: "); // bar 27
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 28: "); // bar 28
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 29: "); // bar 29
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 30: "); // bar 30
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 31: "); // bar 31
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 32: "); // bar 32
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 33: "); // bar 33
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 34: "); // bar 34
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 35: "); // bar 35
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 36: "); // bar 36
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 37: "); // bar 37
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 38: "); // bar 38
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 39: "); // bar 39
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 40: "); // bar 40
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 41: "); // bar 41
        rest(238);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476); // extended
        System.out.print("\nBar 42: "); // bar 42
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 43: "); // bar 43
        rest(238);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 476);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 44: "); // bar 44
        playNote("A3", 119);
        playNote("C#4", 119);
        playNote("E4", 119);
        playNote("C#4", 119);
        playNote("E4", 119);
        playNote("A4", 119);
        playNote("E4", 119);
        playNote("A4", 119);
        playNote("C#5", 119);
        playNote("A4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("G#5", 119);
        playNote("E5", 119);
        playNote("A5", 119);
        playNote("E5", 119);
        System.out.print("\nBar 45: "); // bar 45
        playNote("G#5", 714);
        playNote("F#5", 952);
        playNote("E5", 238);
        System.out.print("\nBar 46: "); // bar 46
        playNote("C#5", 1190);
        playNote("G#5", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        System.out.print("\nBar 47: "); // bar 47
        playChord2("E4", "C#5", 238);
        playChord2("E4", "C#5", 1428);
        playNote("G#4", 119);
        playNote("F#4", 119);
        System.out.print("\nBar 48: "); // bar 48
        playNote("E4", 1904);
        System.out.print("\nBar 49: "); // bar 49
        rest(476);
        playNote("B5", 238);
        playNote("G#5", 238);
        playNote("B5", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 50: "); // bar 50
        playNote("C#6", 238);
        playNote("C#6", 119);
        playNote("B5", 238);
        playNote("B5", 119);
        playNote("G#5", 119);
        playNote("F#5", 238);
        playNote("E5", 119);
        playNote("C#5", 238);
        playNote("E5", 238);
        playNote("C#5", 119);
        playNote("E4", 119);
        System.out.print("\nBar 51: "); // bar 51
        playNote("C#5", 476);
        playNote("C#5", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        playNote("B4", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        System.out.print("\nBar 52: "); // bar 52
        playNote("C#5", 238);
        playNote("C#5", 476);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 952);
        System.out.print("\nBar 53: "); // bar 53
        playNote("G#5", 714);
        playNote("F#5", 952);
        playNote("E5", 238);
        System.out.print("\nBar 54: "); // bar 54
        playNote("C#5", 1190);
        playNote("C#5", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        System.out.print("\nBar 55: "); // bar 55
        playChord2("E4", "C#5", 238);
        playChord2("E4", "C#5", 1428);
        playNote("G#4", 119);
        playNote("F#4", 119);
        System.out.print("\nBar 56: "); // bar 56
        playNote("E4", 1904);
        System.out.print("\nBar 57: "); // bar 57
        rest(476);
        playNote("B5", 238);
        playNote("G#5", 238);
        playNote("B5", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 58: "); // bar 58
        playNote("C#6", 238);
        playNote("C#6", 119);
        playNote("B5", 238);
        playNote("B5", 119);
        playNote("G#5", 119);
        playNote("F#5", 238);
        playNote("E5", 119);
        playNote("C#5", 238);
        playNote("E5", 238);
        playNote("C#5", 119);
        playNote("E4", 119);
        System.out.print("\nBar 59: "); // bar 59
        playNote("C#5", 476);
        playNote("C#5", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        playNote("B4", 238);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 238);
        System.out.print("\nBar 60: "); // bar 60
        playNote("C#5", 238);
        playNote("C#5", 476);
        playNote("G#4", 119);
        playNote("F#4", 119);
        playNote("E4", 952);
        System.out.print("\nBar 61: "); // bar 61
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 62: "); // bar 62
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 63: "); // bar 63
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 64: "); // bar 64
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 65: "); // bar 65
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 66: "); // bar 66
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 67: "); // bar 67
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 68: "); // bar 68
        playNote("C#5", 238);
        playNote("E5", 119);
        playNote("G#4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("C#5", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("G#5", 119);
        playNote("B4", 119);
        playNote("C#5", 119);
        playNote("E5", 119);
        playNote("B4", 119);
        System.out.print("\nBar 69: "); // bar 69
        playNote("E5", 238);
        playNote("E5", 238);
        playNote("E5", 238);
        playNote("E5", 238);
        playNote("E5", 238);
        playNote("E5", 238);
        playNote("E5", 238);
        playNote("E5", 238);
        System.out.print("\nBar 70: "); // bar 70
        playNote("D#5", 238);
        playNote("D#5", 238);
        playNote("D#5", 238);
        playNote("D#5", 476);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 71: "); // bar 71
        playChord2("F#5", "F#6", 238);
        playChord2("E5", "E6", 238);
        playChord2("E5", "E6", 238);
        playChord2("E5", "E6", 238);
        playChord2("E5", "E6", 238);
        playChord2("E5", "E6", 238);
        playChord2("E5", "E6", 238);
        playChord2("E5", "E6", 238);
        System.out.print("\nBar 72: "); // bar 72
        playChord2("D#5", "D#6", 238);
        playChord2("D#5", "D#6", 238);
        playChord2("D#5", "D#6", 238);
        playChord2("D#5", "D#6", 476);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 73: "); // bar 73
        playChord2("C#5", "F#5", 238);
        playChord2("C#5", "E5", 238);
        playChord2("C#5", "E5", 476);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        System.out.print("\nBar 74: "); // bar 74
        playChord2("G#4", "D#5", 238);
        playChord2("G#4", "D#5", 238);
        playChord2("G#4", "E5", 238);
        playChord2("G#4", "E5", 476);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 75: "); // bar 75
        playChord2("G#4", "F#5", 238);
        playNote("E5", 238);
        playNote("E5", 476);
        playChord2("G#4", "E5", 238);
        playChord2("G#4", "E5", 238);
        playChord2("G#4", "E5", 238);
        playChord2("G#4", "E5", 238);
        System.out.print("\nBar 76: "); // bar 76
        playChord2("G#4", "D#5", 238);
        playChord2("G#4", "D#5", 238);
        playChord2("G#4", "E5", 238);
        playChord2("G#4", "E5", 238);
        rest(238);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 77: "); // bar 77
        playNote("F#5", 238);
        playNote("E5", 238);
        playNote("E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 78: "); // bar 78
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playNote("E5", 238);
        playChord3("A4", "C#5", "E5", 476);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 79: "); // bar 79
        playNote("F#5", 238);
        playNote("E5", 238);
        playNote("E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 80: "); // bar 80
        playChord2("F#4", "C#5", 238);
        playNote("C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 81: "); // bar 81
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 82: "); // bar 82
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playNote("E5", 238);
        playChord3("A4", "C#5", "E5", 476);
        playNote("C#6", 238);
        playNote("B5", 238);
        playNote("G#5", 238);
        System.out.print("\nBar 83: "); // bar 83
        playNote("F#5", 238);
        playNote("E5", 238);
        playNote("E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 84: "); // bar 84
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 85: "); // bar 85
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 86: "); // bar 86
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playNote("E5", 238);
        playChord3("A4", "C#5", "E5", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 87: "); // bar 87
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 88: "); // bar 88
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 89: "); // bar 89
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 90: "); // bar 90
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 91: "); // bar 91
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 92: "); // bar 92
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 93: "); // bar 93
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 94: "); // bar 94
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playNote("E5", 238);
        playChord3("A4", "C#5", "E5", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 95: "); // bar 95
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 96: "); // bar 96
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 476);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 97: "); // bar 97
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 98: "); // bar 98
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "D#5", 238);
        playChord3("F#4", "B4", "E5", 238);
        playChord3("F#4", "B4", "E5", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
        System.out.print("\nBar 99: "); // bar 99
        playChord3("G#4", "C#5", "F#5", 238);
        playChord3("G#4", "C#5", "E5", 238);
        playChord3("G#4", "C#5", "E5", 476);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        playChord3("G#4", "B4", "E5", 238);
        System.out.print("\nBar 100: "); // bar 100
        playChord2("F#4", "C#5", 238);
        playChord2("F#4", "C#5", 238);
        playNote("B4", 238);
        playNote("B4", 238);
        rest(238);
        playChord2("E5", "C#6", 238);
        playChord2("E5", "B5", 238);
        playChord2("E5", "G#5", 238);
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
        // bar 41
        playChord2("A1", "A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        // bar 42
        playNote("A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        // bar 43
        playChord2("A1", "A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        // bar 44
        playNote("A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        playNote("A2", 476);
        // bar 45
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 46
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 1190);
        // bar 47
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 48
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 1190);
        // bar 49
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 50
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 1190);
        // bar 51
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 52
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 714);
        playNote("A2", 476);
        // bar 53
        playNote("C#2", 238);
        playNote("G#2", 238);
        playNote("C#3", 238);
        playNote("G#2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("E3", 238);
        playNote("B2", 238);
        // bar 54
        playNote("B1", 238);
        playNote("F#2", 238);
        playNote("B2", 238);
        playNote("A1", 476);
        playNote("E2", 238);
        playNote("A2", 238);
        playNote("E2", 238);
        // bar 55
        playNote("C#2", 238);
        playNote("G#2", 238);
        playNote("C#3", 238);
        playNote("G#2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("E3", 238);
        playNote("B2", 238);
        // bar 56
        playNote("B1", 238);
        playNote("F#2", 238);
        playNote("B2", 238);
        playNote("A1", 476);
        playNote("E2", 238);
        playNote("A2", 238);
        playNote("E2", 238);
        // bar 57
        playNote("C#2", 238);
        playNote("G#2", 238);
        playNote("C#3", 238);
        playNote("G#2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("E3", 238);
        playNote("B2", 238);
        // bar 58
        playNote("B1", 238);
        playNote("F#2", 238);
        playNote("B2", 238);
        playNote("A1", 476);
        playNote("E2", 238);
        playNote("A2", 238);
        playNote("E2", 238);
        // bar 59
        playNote("C#2", 238);
        playNote("G#2", 238);
        playNote("C#3", 238);
        playNote("G#2", 238);
        playNote("E2", 238);
        playNote("B2", 238);
        playNote("E3", 238);
        playNote("B2", 238);
        // bar 60
        playNote("B1", 238);
        playNote("F#2", 238);
        playNote("B2", 238);
        playNote("A1", 476);
        playNote("E2", 238);
        playNote("A2", 238);
        playNote("E2", 238);
        // bar 61
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 62
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 63
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 64
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 65
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 66
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 67
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 68
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 69 AND bar 70
        playChord2("C#2", "C#3", 3808);
        // bar 71 AND bar 72
        playChord2("C#2", "C#3", 3808);
        // bar 73
        playChord2("C#2", "C#3", 476);
        playNote("C#3", 476);
        playNote("C#3", 476);
        playNote("C#3", 357);
        playNote("G#2", 119);
        // bar 74
        playChord2("C#2", "C#3", 476);
        playNote("C#3", 476);
        playNote("C#3", 476);
        playNote("C#3", 357);
        playNote("G#2", 119);
        // bar 75
        playChord2("C#2", "C#3", 476);
        playChord2("C#2", "C#3", 476);
        playChord2("C#2", "C#3", 476);
        playChord2("C#2", "C#3", 476);
        // bar 76
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        playChord2("C#2", "C#3", 238);
        rest(952);
        // bar 77
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 78
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 714);
        playNote("A2", 476);
        // bar 79
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 80
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 714);
        playNote("A2", 476);
        // bar 81
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 82
        playChord2("B1", "B2", 714);
        playChord2("A1", "A2", 714);
        playNote("A2", 476);
        // bar 83
        playChord2("C#2", "C#3", 952);
        playChord2("E2", "E3", 952);
        // bar 84
        playChord2("B1", "B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        // bar 85
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 86
        playNote("B1", 238);
        playChord2("F#2", "B2", 238);
        playNote("B1", 238);
        playNote("A1", 476);
        playChord2("E2", "A2", 238);
        playNote("A1", 238);
        playChord2("E2", "A2", 238);
        // bar 87
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 88
        playNote("B1", 238);
        playChord2("F#2", "B2", 238);
        playNote("B1", 238);
        playNote("A1", 476);
        playChord2("E2", "A2", 238);
        playNote("A1", 238);
        playChord2("E2", "A2", 238);
        // bar 89
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 90
        playNote("B1", 238);
        playChord2("F#2", "B2", 238);
        playNote("B1", 238);
        playNote("A1", 476);
        playChord2("E2", "A2", 238);
        playNote("A1", 238);
        playChord2("E2", "A2", 238);
        // bar 91
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("C#2", 238);
        playChord2("G#2", "C#3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        playNote("E2", 238);
        playChord2("B2", "E3", 238);
        // bar 92
        playNote("B1", 238);
        playChord2("F#2", "B2", 238);
        playNote("B1", 238);
        playNote("A1", 476);
        playChord2("E2", "A2", 238);
        playNote("A1", 238);
        playChord2("E2", "A2", 238);
        // bar 93
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 94
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("A1", "A2", 476);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 95
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 96
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("A1", "A2", 476);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 97
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 98
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("A1", "A2", 476);
        playNote("A2", 238);
        playChord2("A1", "A2", 238);
        playNote("A2", 238);
        // bar 99
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("C#2", "C#3", 238);
        playNote("C#3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        playChord2("E2", "E3", 238);
        playNote("E3", 238);
        // bar 100
        playChord2("B1", "B2", 238);
        playNote("B2", 238);
        playChord2("B1", "B2", 238);
        playChord2("A1", "A2", 238);
        rest(238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
        playChord2("A1", "A2", 238);
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
