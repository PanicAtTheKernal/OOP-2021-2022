package ie.tudublin;

import processing.core.PApplet;

public class LifeBorad {
    boolean[][] borad;
    boolean[][] next;
    int size;
    float cellSize;
    PApplet pa;

    public LifeBorad(int size, PApplet pa)
    {
        borad = new boolean[size][size];
        next = new boolean[size][size];
        this.size = size;
        this.pa = pa;
        cellSize = pa.width / (float) size;
    }

    public void randomise()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                borad[row][col] = pa.random(1.0f) > 0.5f;
            }
        }
    }

    //Bounds checking 
    public boolean isAlive(int row, int col) {
        if(row < size && row > -1 && col < size && col > -1){
            return borad[row][col];
        }
        else {
            return false;
        }
    }

    public int countCellAround(int row, int col)
    {
        int count = 0;

        for (int nRow = row -1; nRow <= row+1; nRow++)
        {
            for(int nCol = col-1; nCol <= col+1; nCol++)
            {
                if(isAlive(nRow, nCol))
                {
                    count++;
                }
            }
        }

        //Do this so the cell won't count cell
        if (isAlive(row, col)) count--;
        return count;
    }

    public void update()
    {
        //Cell is alive
        //If the cell has 2 - 3 live neighbours it lives. Less than 2 is dies

        //If a dead cell has 3 neighbours comes to life

        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                int count = countCellAround(row, col);

                if(isAlive(row, col))
                {
                    if(count == 2 || count == 3) {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }
                else {
                    if(count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }
            }
        }

        boolean[][] temp;
        temp = borad;
        borad = next;
        next = temp;
    }

    public void render()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float xOffest = cellSize * row;
                float yOffset = cellSize * col;
                if (borad[row][col]) pa.fill(0,255,255);
                else pa.fill(255);
                pa.noStroke();
                pa.rect(xOffest, yOffset, cellSize, cellSize);
            }
        }
    }
}
