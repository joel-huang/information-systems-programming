package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

import java.util.ArrayList;


public class PianoMachine {
	
	private Midi midi;
	private Instrument instrument = Midi.DEFAULT_INSTRUMENT;
    private ArrayList<NoteEvent> noteLog = new ArrayList<>();

    private int semitoneChange = 0;
    private boolean isRecording = false;




	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }
    
    // begin the note and track the time if recording.
    public void beginNote(Pitch rawPitch) {
    	Pitch nextPitch = rawPitch.transpose(semitoneChange);

    	if (isRecording) {
    	    long time = (long)(System.currentTimeMillis()/10);
    	    noteLog.add(new NoteEvent(nextPitch, time, instrument, NoteEvent.Kind.start));
        }

        midi.beginNote(nextPitch.toMidiFrequency(), instrument);

    }
    
    // end the note and track the time if recording.
    public void endNote(Pitch rawPitch) {
    	Pitch nextPitch = rawPitch.transpose(semitoneChange);

        if (isRecording) {
            long time = (long) (System.currentTimeMillis() / 10);
            noteLog.add(new NoteEvent(nextPitch, time, instrument, NoteEvent.Kind.stop));
        }

        midi.endNote(nextPitch.toMidiFrequency(), instrument);

    }

    // cycles to the next instrument.
    public void changeInstrument() {
       	instrument = instrument.next();
    }

    // shift notes up by one octave.
    public void shiftUp() {
    	if (semitoneChange <= Pitch.OCTAVE * 2) semitoneChange += Pitch.OCTAVE;
    }

    // shift notes down by one octave.
    public void shiftDown() {
    	if (semitoneChange >= Pitch.OCTAVE * 2) semitoneChange -= Pitch.OCTAVE;
    }
    
    // toggles between the recording and not recording states.
    public boolean toggleRecording() {
        if (isRecording) {
            isRecording = false;
        }

        else {
            isRecording = true;

            // clear the noteLog.
            noteLog = new ArrayList<>();
        }

        return isRecording;

    }
    
    // play the notes that have been recorded.
    public void playback() {
        for (int i = 0; i < noteLog.size(); i++) {
            NoteEvent noteEvent = noteLog.get(i);
            NoteEvent.Kind noteEventKind = noteEvent.getKind();

            // begin the note and end the note as instructed.
            if (noteEventKind == NoteEvent.Kind.start) midi.beginNote(noteEvent.getPitch().toMidiFrequency(), noteEvent.getInstr());
            else midi.endNote(noteEvent.getPitch().toMidiFrequency(), noteEvent.getInstr());

            if (i < noteLog.size() - 1) {
                NoteEvent nextNoteEvent = noteLog.get(i+1);
                int delay = (int)(nextNoteEvent.getTime()-noteEvent.getTime());
                Midi.rest(delay);
            }
            
        }
    }

}
