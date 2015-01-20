package net.Haddox;

import java.io.File;
import java.io.SequenceInputStream;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;



public class ComposerV2 {
	public static void main (String[]args){
		Scanner stringReader1 = new Scanner(System.in);
		System.out.print("Enter an sound file name: ");
		String fileName1 = new String (stringReader1.nextLine());
		Scanner stringReader2 = new Scanner(System.in);
		System.out.print("Enter another sound file name: ");
		String fileName2 = new String (stringReader2.nextLine());

	 try {
		    AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(fileName1));
		    AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(fileName2));

		    AudioInputStream appendedFiles = 
                         new AudioInputStream(
                             new SequenceInputStream(clip1, clip2),     
                             clip1.getFormat(), 
                             clip1.getFrameLength() + clip2.getFrameLength());

		    AudioSystem.write(appendedFiles, 
                         AudioFileFormat.Type.WAVE, 
                         new File("F:\\wavAppended.wav"));
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
stringReader1.close();
stringReader2.close();
}
}
