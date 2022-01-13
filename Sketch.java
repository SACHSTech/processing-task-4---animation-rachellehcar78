import processing.core.PApplet;

public class Sketch extends PApplet {

  /**
   * state global variables
   *  
   * */ 
  public float sunX = 0;
  public float sunY = 250;
  public float speedX = 1;
  public float speedY = 1;
  public int p2BGsr = 0;
  public int p1BGss = 230;
  public int p2BGss = 118;
	
  /**
   * Called once at the beginning of execution. Assign initial values here.
   */
  public void settings() {
	  //put your size call here
    size(500, 500);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // clear out old frames
    background(32);
    
    // sunrise
    if (sunX < 251) {
      p2BGsr = p2BGsr+1;
      background(24, p2BGsr, 120);
      // beach
      fill(72, 86, 212);
      rect(0, 400, 500, 100); //rect(x,y,w,h)
      // sun
      fill(255, 211, 0);
      ellipse(sunX, sunY, 50, 50);         
    }
    
    // modify state 
    sunX = sunX + speedX; 
    sunY = sunY - speedY; 
         
    // sunset
    if (sunX > 250 && sunX < 401) {
      p1BGss = p1BGss-1;
      p2BGss = p2BGss-1;
      background(p1BGss, p2BGss, 0);
      // beach
      fill(28, 37, 117);
      rect(0, 400, 500, 100); //rect(x,y,w,h)
      // sun
      fill(255, 211, 0);
      ellipse(sunX, sunY, 50, 50);
    }

    // night 
    if (sunX > 250 && sunX > 400){
      // stars
      fill(199, 212, 199);
      ellipse(200,100, 15, 15);
      fill(199, 212, 199);
      ellipse(250, 200, 15, 15);
      fill(199, 212, 199);
      ellipse(200, 150, 15, 15);
      fill(199, 212, 199);
      ellipse(375, 225, 15, 15);
      fill(199, 212, 199);
      ellipse(425, 200, 15, 15);
      // moon
      fill(199, 212, 199);
      ellipse(400, 100, 30, 30);
    }
    
    // bounce off top and bottom for sunset
    if (sunY < 0 || sunY > 500) {
      speedY = speedY * -1; 
    }

    // Reset values to start the day over
    if (sunX > 500) {
      sunX = 0;
      sunY = 250;
      speedY = 1;
      p2BGsr = 0;
      p1BGss = 230;
      p2BGss = 118;
    }
  }
  
  // define other methods down here.


}