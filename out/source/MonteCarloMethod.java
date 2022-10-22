/* autogenerated by Processing revision 1286 on 2022-10-22 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class MonteCarloMethod extends PApplet {

PVector pMid;
double counterInner = 0;
float totalCounter = 0;
boolean isRunning = false;
int n = 10000;
double pie = -1;

 public void setup() {
    /* size commented out by preprocessor */;
    pMid = new PVector(width/2, height/2);
    background(255);
    arc(width/2, height/2, width, height, 0, TWO_PI);
}

 public void draw() {
    if(isRunning) {
        PVector[] pArr = getPArr();

        for(int i = 0; i < pArr.length; i++) {
            PVector pTemp = pArr[i];

            if(pMid.dist(pTemp) > width/2) {
                stroke(208, 199, 158);
            }
            else {
                stroke(77, 49, 165);
                counterInner++;
            }
            totalCounter++;
    
            point(pTemp.x, pTemp.y);
        }
        
    }
}

 public void keyPressed() {
    if(key == ' ') {
        isRunning = !isRunning;
    }

    if(totalCounter > 0 && key == 'p' || key == 'P') {
        pie = 4*(counterInner/totalCounter);
        surface.setTitle("" + pie);
        println("totalCounter: " + totalCounter + " | approx: " + pie);
    }

    if(!isRunning && key == 'c' || key == 'C') {
        surface.setTitle("MonteCarloMethod");
        pie = -1;
        totalCounter = 0;
        counterInner = 0;
        background(255);
        stroke(0);
        arc(width/2, height/2, width, height, 0, TWO_PI);
    }
}

 public PVector[] getPArr() {
    PVector[] pArr = new PVector[n];

    for(int i = 0; i < n; i++) {
        pArr[i] = new PVector(random(0, width), random(0, height));
    }

    return pArr;
}


  public void settings() { size(800, 800); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MonteCarloMethod" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
