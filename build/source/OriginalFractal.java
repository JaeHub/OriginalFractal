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

public class OriginalFractal extends PApplet {

PImage simon;
int tint, alph, picX, picY, length;

public void setup(){
  background(0);
  
  tint = 0;
  alph = 255;
  picX = 300;
  picY = 300;
  length = 300;
  simon = loadImage("data/Simon.jpg");
}

public void draw(){
  tint(tint, tint, tint, alph);
  fractal(picX, picY, length, simon);
  if(mousePressed == true){
    tint = (PApplet.parseInt(random(0,255)));
    length = length + 10;
  }
}

public void fractal(int x, int y, int len, PImage pic){
  image(pic, x-len, y-len, len, len);
  if(len >= 1){
    fractal(x+len/2, y, len/2, pic);
    fractal(x-len/2, y, len/2, pic);
  }
}
  public void settings() {  size(300, 300); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
