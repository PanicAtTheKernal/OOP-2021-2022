package ie.tudublin;

import java.io.File;

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

    public void settings() 
    {
        size(500, 500);
    }

    public void setup() 
    {
        colorMode(HSB);
        background(255);
        playerX = (float)width / 2;
        playerY = (float)height - playerWidth;
        bugX = random((bugWidth+10), (width-(bugWidth+10)));
        bugY = bugWidth;
    }
    
    public void draw()
    {
        background(255);
        if (lose == false) 
        {
            drawPlayer(playerX, playerY, playerWidth);
            drawBug(bugWidth);
            textSize(24);
            text("Score: "+score, 400, 50);
        }
        else
        {
            fill(0);
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
        stroke(0);
        rectMode(CENTER);
        fill(0);
        rect(x, y, w, h);
        fill(0);
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
        stroke(0);
        fill(0);
        fill(0);
        rectMode(CENTER);
        rect(bugX, bugY, w, w);
    }

    private void fire() {
        fill(0);
        line(playerX, playerY, playerX, 0);
        if (playerX > bugX-bugWidth && playerX < bugX+bugWidth) 
        {
            score += 1;
            bugX = random(width);
            bugY = bugWidth;
        }
        if ((frameCount % 30) == 0) 
        {
            fill(255);
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
