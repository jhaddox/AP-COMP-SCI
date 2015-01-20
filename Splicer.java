package net.Haddox;
import java.io.File;
import java.io.SequenceInputStream;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class SplicerV2 {
    public static void main(String[] args) {
    	Scanner stringReader1 = new Scanner(System.in);
    	System.out.print("Enter an sound file name: ");
		String fileName1 = stringReader1.nextLine();
		Scanner stringReader2 = new Scanner(System.in);
    	System.out.print("Enter an sound file name: ");
		String fileName2 = stringReader2.nextLine();
		Scanner stringReader3 = new Scanner(System.in);
    	System.out.print("Enter a new file name: ");
		String fileName3 = stringReader3.nextLine();
    	
	    String wavFile1 = (fileName1);
	    String wavFile2 = (fileName2);

	    try {
		    AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(wavFile1));
		    AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(wavFile2));

		    AudioInputStream appendedFiles = 
                            new AudioInputStream(
                                new SequenceInputStream(clip1, clip2),     
                                clip1.getFormat(), 
                                clip1.getFrameLength() + clip2.getFrameLength());

		    AudioSystem.write(appendedFiles, 
                            AudioFileFormat.Type.WAVE, 
                            new File(fileName3));
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
	    stringReader1.close();
	    stringReader2.close();
	    stringReader3.close();
    }
    
}
