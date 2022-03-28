package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
<<<<<<< HEAD
import ddf.minim.analysis.WindowFunction;
=======
>>>>>>> 51779e88c5f70100bbc46691d11b90cfec6b4f41
import processing.core.PApplet;

/*

The infinite number of waves make up the mind, and all minds are made up of these waves which then interact with one another to form reality via Fourier transformations
Science is not supposed to give meaning to ones life or the reason behind their existence; science only explains the testable and provable mechanisms that run the universe

*/

public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    FFT fft;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        // fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
<<<<<<< HEAD
        // ap = minim.loadFile("heroplanet.mp3", 1024);
        // ap.play();
        // ab = ap.mix;
=======
        //ap = minim.loadFile("heroplanet.mp3", 1024);
        //ap.play();
        //ab = ap.mix;
>>>>>>> 51779e88c5f70100bbc46691d11b90cfec6b4f41
        colorMode(RGB);

        fft = new FFT(1024, 44100);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);
<<<<<<< HEAD
        float halfH = height/2;
        // for (int i = 0; i < ab.size(); i++) 
        // {
        //     // ab.get(i) will be between 1 and -1. halfH+ab.get(i) with set the line above/below the half waypoint. 
        //     // Then multiple the half line by half the height. E.g (250+0.2) * 250 will draw a line above with a length of somthing
        //     line(i, halfH, i, halfH+ab.get(i)* halfH);
        // }

        fft.window(FFT.HAMMING);
        fft.forward(ab);

        stroke(0, 255, 255);
        //As the pitch goes higher the line goes futher right than left
        for (int i = 0; i < fft.specSize(); i++) 
        {
            line(i, 0, i, fft.getBand(i)*10);
        }

        int maxIndex = 0;
        for (int i = 0; i < fft.specSize(); i++) 
        {
            if (fft.getBand(i) > fft.getBand(maxIndex)) {
                maxIndex = i;
            }
        }

        

        float freq = fft.indexToFreq(maxIndex);

        textSize(20);
        fill(255);
        text("Freq: " + freq, 100, 200);
    }
        
=======
        float halfH = height / 2;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            line(i, halfH, i, halfH + ab.get(i) * halfH);
        }

        fft.window(FFT.HAMMING);
        fft.forward(ab);

        stroke(0, 255, 0);
        for(int i = 0 ; i < fft.specSize(); i ++)
        {
            line(i, 0, i,fft.getBand(i) * 10);
        }
>>>>>>> 51779e88c5f70100bbc46691d11b90cfec6b4f41


        int maxIndex = 0;

        for(int i = 0 ; i < fft.specSize(); i ++)
        {
            if (fft.getBand(i) > fft.getBand(maxIndex))
            {
                maxIndex = i;
            }
        }

        // Fill out missing code!!

        float freq = fft.indexToFreq(maxIndex);

        textSize(20);
        fill(255);
        text("Freq: " + freq, 100, 200);

}        

