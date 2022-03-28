package ie.tudublin;

import processing.data.TableRow;

public class Star {
    private boolean hap;
    private String displayName = null;
    private float distance;
    private float xG;
    private float yG;
    private float zG;
    private float absMaps;
     
    public Star(TableRow tr) 
    {
        //Calls the other constructor
        this(tr.getInt("Hab?") == 1, 
             tr.getString("Display Name"),
             tr.getFloat("Distance"),
             tr.getFloat("Xg"), 
             tr.getFloat("Yg"), 
             tr.getFloat("Zg"), 
             tr.getFloat("AbsMaps"));   
    }


    public Star(boolean hap, String displayName, float distance, float xG, float yG, float zG, float absMaps) {
        this.hap = hap;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMaps = absMaps;
    }


    public boolean isHap() {
        return hap;
    }
    public void setHap(boolean hap) {
        this.hap = hap;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public float getDistance() {
        return distance;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public float getxG() {
        return xG;
    }
    public void setxG(float xG) {
        this.xG = xG;
    }
    public float getyG() {
        return yG;
    }
    public void setyG(float yG) {
        this.yG = yG;
    }
    public float getzG() {
        return zG;
    }
    public void setzG(float zG) {
        this.zG = zG;
    }
    public float getAbsMaps() {
        return absMaps;
    }
    public void setAbsMaps(float absMaps) {
        this.absMaps = absMaps;
    }

}
