package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ddf.minim.analysis.WindowFunction;
import processing.core.PApplet;

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
        // ap = minim.loadFile("heroplanet.mp3", 1024);
        // ap.play();
        // ab = ap.mix;
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
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

}        

