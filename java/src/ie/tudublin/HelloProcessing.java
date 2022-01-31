package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB); //RGB red green blue, HSB Hue saturation brightness
		background(0);
	}

	float x1, y1, x2, y2;
	float x1dir, x2dir, y1dir, y2dir;
	float c = 0;
	
	public void draw()
	{	
		//x:0 and y:0 is the top left corner of the screen
		// stroke(0, 0 , 0);
		//background(200); //Greyscale
		background(255, 0, 0);
		// fill(0, 0, 255);
		// noFill();
		noStroke();
		// line(10, 10, 200, 200); //x1, y1, x2, y2
		// circle(200, 200, 50); // x, y, radius , x+y is the center of the circle
		// ellipse(50, 200, 90, 200); // x, y, width, height x+y is the center of the circle

		// rectMode(CENTER);
		// rect(300, 20, 100, 20); // x, y, width, height x+y is the top left of rect
		// rectMode(CORNER); //Changes the starting point for the 
		// rect(300, 20, 100, 20);

		// point(20, 300);

		// triangle(10, 400, 50, 450, 300, 200); // x1, y1, x2, y2, x3, y3
		fill(255, 255, 0);
		circle(250, 250, 400);
		fill(0, 255,255);
		triangle(50, 400, 450, 400, 250, 20);
		fill(180,180,180);
		ellipse(250, 225, 200, 100);
		fill(0,0,0);
		circle(250, 225, 80);
	}
}
