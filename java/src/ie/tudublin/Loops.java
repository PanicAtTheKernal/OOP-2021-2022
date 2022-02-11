package ie.tudublin;

import processing.core.PApplet;



public class Loops extends PApplet
{
	int mode = 0;
	//Bad pratice but temp only
	int noOfStars = 20;
	StarsObj[] stars = new StarsObj[noOfStars];
	// int[] segmentsSizes = new int[noOfStars];
	// int[] xLoc = new int[noOfStars];
	// int[] yLoc = new int[noOfStars];
	// int[] radiuses = new int[noOfStars];

	public void settings()
	{
		size(500, 500);
		for (int i = 0; i < noOfStars; i++) {
		 	int segmentsSizes = (int)random(5, 8);
			int xLoc = (int)random(50, width-50);
			int yLoc = (int)random(50, height-50);
			int radiuses = (int)random(20, 60);
			stars[i] = new StarsObj(segmentsSizes, radiuses, xLoc, yLoc);
		}
	}

	public void setup() 
	{
		colorMode(HSB);
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	
	public void draw()
	{
		background(0);
		switch(mode)	
		{
			case 0:
				forExerise1();
				break;
			case 1:
				forExerise2();
				break;
			case 2:
				forExerise3();
				break;
			case 3:
				forExerise4();
				break;
			case 4:
				forExerise5();
				break;
			case 5:
				forExerise6();
				break;
			case 6:
				forExerise7();
				break;
			case 7:
				mathExerise1();
				break;
			case 8:
				mathExerise2();
				break;
			case 9:
				mathExerise3();
				break;
		}
	}

	private void forExerise1() 
	{
		for (int i = 0; i < 10; i++) 
		{
			noStroke();
			fill(map(i, 0, 10, 0, 200), 255, 255);
			rect(map(i, 0, 10, 0, width), 0, width/10, height);
		}
	}

	private void forExerise2()
	{
		int startingColour = 250;
		int colourGap = startingColour/10;
		for (int i = 0; i < 10; i++) 
		{
			noStroke();
			fill((colourGap*i), 255, 255);
			rect((i * (width/10)), (i * (height/10)), width/10, height/10);
		}
	}

	private void forExerise3()
	{
		for (int i = 0; i < 10; i++) 
		{
			noStroke();
			fill(map(i, 0, 10, 0, 210), 255, 255);
			rect(map(i, 0, 10, 0, width), map(i, 0, 10, 0, height), width/10, height/10);
			rect(map(i, 10, 0, -50, 450),map(i, 0, 10, 0, height), width/10, height/10);
		}		
	}

	private void forExerise4() 
	{
		for (int i = 0; i < 10; i++) 
		{
			noStroke();
			fill(map(i, 0, 10, 255, 0), 255, 255);
			ellipse(width/2, height/2, map(i, 10, 0, 0, 500), map(i, 10, 0, 0, 500));
		}
	}

	private void forExerise5() 
	{
		background(0,0,255);
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				noStroke();
				fill(map(i, 10, 0, 70 - (j * 10), 180 - (j * 10)), 255, 255);
				ellipse(map(i, 10, 0, -25, width-25), map(j, 10, 0, -25, height-25), width/10, height/10);
			}
		}
		
	}
	
	private void forExerise6()
	{
		for (int i = 0; i < 11; i++) 
		{
			fill(100,255,255);
			textAlign(CENTER, CENTER);
			text((int)map(i, 0, 11, -5, 6), map(i, 0, 11, 50, 500), 25);
			textAlign(CENTER, CENTER);
			text((int)map(i, 0, 11, -5, 6), 25, map(i, 0, 11, 50, 500));
			

			stroke(100,255,255);
			line(map(i, 0, 11, 50, 500), 50, map(i, 0, 11, 50, 500), height-40);
			line(50, map(i, 0, 11, 50, 500), width-40, map(i, 0, 11, 50, 500));

		}
	}

	private void forExerise7()
	{
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				noStroke();
				if ((i % 2) == 0)
				{
					if ((j % 2) == 0) fill(150, 255, 255);
					else fill(170, 255, 255);
				}
				else
				{
					if ((j % 2) == 0) fill(170, 255, 255);
					else fill(150, 255, 255);
				}
				rect(map(i, 0, 10, 0, width), map(j, 0, 10, 0, height), width/10, height/10);
			}
		}
	}

	private void mathExerise1()
	{
		float centerX = width/2;
		float centerY = height/2;
		float radius = 50;
		int segments = 5;
		float angle = (float)360/segments;

		background(0);
		stroke(0,255,255);
		for(int i = 1; i < segments+1; i++)
		{
			line(centerX, centerY, centerX+(radius*sin(radians(angle*i))), centerY+(radius*cos(radians(angle*i))));
		}
	}

	private void mathExerise2()
	{
		float centerX = width/2;
		float centerY = height/2;
		float radius = 50;
		int segments = 5;
		float angle = (float)360/segments;

		background(0);
		stroke(0,255,255);
		for(int i = 1; i < segments+2; i++)
		{
			if (i != segments+1) 
			{
				// line(centerX+(radius*sin(radians(angle*(i-1)) ) ), centerY+(radius*cos(radians(angle*(i-1)) ) ), centerX+(radius*sin(angle*(i-2))), centerY+(radius*cos(radians(angle*(i-2)) ) ) );
				line(centerX+(radius*sin(radians(angle*i) ) ), centerY+(radius*cos(radians(angle*i) ) ), centerX+(radius*sin(radians(angle*(i+1)) ) ), centerY+(radius*cos(radians(angle*(i+1)) ) ) );
			}
			else {

			}
		}
	}

	private void mathExerise3()
	{
		for (int i = 0; i < noOfStars; i++) {
			// int size = segmentsSizes[i];
			// int r = radiuses[i];
			// int x = xLoc[i];
			// int y = yLoc[i];
			// drawStars(size, r, x, y);
			stars[i].display();
		}
	}

	class StarsObj {
		float centerX;
		float centerY;
		int segments;
		int radius;
		float angle;
		int colour; 

		public StarsObj(int segments, int radius, int x, int y) {
			centerX = x;
			centerY = y;
			this.radius = radius;
			this.segments = segments;
			angle  = (float)360/segments;
			colour = (int)random(0, 255);
		}

		public void display() {
			stroke(colour,255,155);
			strokeWeight(3f);
			for(int i = 1; i < segments+2; i++)
			{
				if (i != segments+1) 
				{
					if (i != segments+1) 
					{
						float halfwayX = ( centerX+(radius*sin(radians(angle*i) ) ) + centerX+(radius*sin(radians(angle*(i+1) ) ) ) )/ 2;
						float halfwayY = ( centerY+(radius*cos(radians(angle*i) ) ) + centerY+(radius*cos(radians(angle*(i+1) ) ) ) )/ 2;

						float halfHalfwayX = (halfwayX + centerX ) /2; 
						float halfHalfwayY = (halfwayY + centerY ) /2;

						line(centerX+(radius*sin(radians(angle*i) ) ), centerY+(radius*cos(radians(angle*i) ) ), halfHalfwayX, halfHalfwayY );
						line(halfHalfwayX, halfHalfwayY, centerX+(radius*sin(radians(angle*(i+1)) ) ), centerY+(radius*cos(radians(angle*(i+1)) ) ) );
					
					}
				}
			}
		}
	}

	// An example of map function 
	public float magicMap(float i,float rangeStart0,float rangeEnd0,float colourStart,float colourEnd)
	{
		float output;

		i -= rangeStart0;
		rangeEnd0 -= rangeStart0;
		colourEnd -= colourStart;

		output = ((i/rangeEnd0)*colourEnd) + colourStart;
		return output;
	}

	// An example of map function 
	public float magicMap1(float i,float rangeStart0,float rangeEnd0,float colourStart,float colourEnd)
	{
		float r1 = rangeEnd0 = rangeStart0;
		float r2 = colourEnd - colourStart;
		float howFar = i - rangeStart0;

		return colourStart + ((howFar/r1) * r2);
	}
}
