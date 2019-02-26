PImage simon;
int tint, alph, picX, picY, length;

public void setup(){
  background(0);
  size(300, 300);
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
    tint = (int(random(0,255)));
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
