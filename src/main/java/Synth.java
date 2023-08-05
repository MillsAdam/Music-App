import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Synth {

    private Synthesizer synth;
    private MidiChannel[] channels;



    public MidiChannel[] getChannels() {
        return channels;
    }



    // ********** OPEN / CLOSE SYNTH **********
    public void openSynth()
    {
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.channels = synth.getChannels();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void closeSynth()
    {
        if(synth != null && synth.isOpen())
        {
            synth.close();
        }
    }
}
