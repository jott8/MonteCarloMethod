PVector pMid;
double counterInner = 0;
double totalCounter = 0;
boolean isRunning = false;
int n = 10000;
double pie = -1;

void setup() {
    size(800, 800);
    pMid = new PVector(width/2, height/2);
    background(255);
    arc(width/2, height/2, width, height, 0, TWO_PI);
}

void draw() {
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

void keyPressed() {

    // start and stop generating points with space-bar
    if(key == ' ') {
        isRunning = !isRunning;
    }

    // calculate pi approximation and update window title with p
    if(totalCounter > 0 && key == 'p' || key == 'P') {
        pie = 4*(counterInner/totalCounter);
        surface.setTitle("" + pie);
        println("totalCounter: " + totalCounter + " | approx: " + pie);
    }

    // clear all points with c
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

PVector[] getPArr() {
    PVector[] pArr = new PVector[n];

    for(int i = 0; i < n; i++) {
        pArr[i] = new PVector(random(0, width), random(0, height));
    }

    return pArr;
}


