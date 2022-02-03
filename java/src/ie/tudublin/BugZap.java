package ie.tudublin;

import processing.core.PApplet;


public class BugZap extends PApplet {
    float playerX = 0.0f;
    float playerY = 0.0f;
    float playerWidth = 50.0f;
    float bugX = 0.0f;
    float bugY = 0.0f;
    float bugWidth = 50.0f;
    int score = 0;
    boolean lose = false;
    static final int WHITE = 255;
    static final int BLACK = 0;
    static final int STARAMOUNT = 100;

    public void settings() 
    {
        size(500, 500);
    }

    public void setup() 
    {
        colorMode(HSB);
        background(BLACK);
        playerX = (float)width / 2;
        playerY = (float)height - playerWidth;
        bugX = random((bugWidth+10), (width-(bugWidth+10)));
        bugY = bugWidth;

    }
    
    public void draw()
    {
        background(BLACK);

        if (lose == false) 
        {
            drawPlayer(playerX, playerY, playerWidth);
            drawBug(bugWidth);
            textSize(24);
            text("Score: "+score, 400, 50);
        }
        else
        {
            fill(WHITE);
            textSize(64);
            rectMode(CENTER);
            text("Game over\n", (width/2)-150, (height/2)-65);
            text("score: "+score, (width/2)-110, (height/2));
            textSize(32);
            text("Press y to restart", (width/2)-120, (height/2)+65);

        }
    }

    private void drawPlayer(float x, float y, float w) 
    {
        float h = w/2;
        stroke(WHITE);
        rectMode(CENTER);
        fill(WHITE);
        rect(x, y, w, h);
        fill(WHITE);
    }

    private void drawBug(float w) 
    {
        if ((frameCount % 10) == 0) 
        {
            float tempX = bugX + random(-15, 15);  
            
            if (tempX > (bugWidth) || tempX < (width-bugWidth)) 
            {
                bugX = tempX;
            }

            bugY += 5;
            if (bugY > height - 150) 
            {
                lose = true;
            }
        }
        stroke(WHITE);
        fill(WHITE);
        fill(WHITE);
        rectMode(CENTER);
        rect(bugX, bugY, w, w);
    }

    private void fire() {
        fill(WHITE);
        line(playerX, playerY, playerX, 0);
        if (playerX > bugX-bugWidth && playerX < bugX+bugWidth) 
        {
            score += 1;
            bugX = random((bugWidth+10), width-(bugWidth+10));
            bugY = bugWidth;
        }
        if ((frameCount % 30) == 0) 
        {
            fill(BLACK);
        }
    }

    public void keyPressed() 
    {
        if (keyCode == LEFT) 
        {
            //System.out.println("Left arrow pressed");
            if (playerX > 5.0f) {
                playerX -= 8.0f;
            }
        }
        if (keyCode == RIGHT) 
        {
            //System.out.println("Right arrow pressed");
            if (playerX < width) {
                playerX += 8.0f;
            }
        }
        if (key == ' ') 
        {
            //System.out.println("spaced pressed");
            fire();
        }
        if (key == 'y')
        {
            if (lose == true) 
            {
                lose = false;
                bugX = random(bugWidth+10, width - (bugWidth+10));
                bugY = bugWidth;
            }
        }
    }
}
