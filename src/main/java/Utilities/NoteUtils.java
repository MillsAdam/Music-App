package Utilities;

public class NoteUtils {

    private final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};


    public int getMidiNumber(String noteWithOctave)
    {
        int octave = Integer.parseInt(noteWithOctave.substring(noteWithOctave.length() - 1));
        String noteName = noteWithOctave.substring(0, noteWithOctave.length() - 1).toUpperCase();
        int midiNumber = -1;

        for (int i = 0; i < notes.length; i++)
        {
            if (notes[i].equals(noteName))
            {
                midiNumber = 12 + (12 * octave) + i;
                break;
            }
        }
        return midiNumber;
    }

}
