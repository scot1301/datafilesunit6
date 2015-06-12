import processing.core.*;
import g4p_controls.*;
import javax.swing.*;

//change name of class:
public class ProcessTemplate extends PApplet
{
    int count=120;
    PImage imgAlien;
    int ax=100, ay=100;
    int bx, by; 
    int dx, dy;
    boolean isDown=false;
    GImageButton btnAlien;
    GTimer timer;
    String img[] = {"space_invader.gif"};
	public void setup()
	{
		size(640, 480, JAVA2D);
                imgAlien = loadImage("space_invader.gif");
                btnAlien = new GImageButton(this, bx, by, img);
                timer = new GTimer(this,this, "move", 1000);
                timer.start();
                
                
	}

	public void handleButtonEvents(GImageButton button, GEvent event) 
	{
            timer.stop();
            
	}
        public void mousePressed(){
            ax = mouseX;
            ay = mouseY;
            
        }
        public void mouseDragged(){
            ax = mouseX;
            ay = mouseY;
        }
        public void isRelaeased(){
            isDown=false;
        }
        public void keyPressed(){
            //JOptionPane.showMessageDialog(this, keyCode);
            isDown=true;
        }
        public void move(GTimer t){
            count--;
            bx=(int)random(1,600);
            by=(int)random(1,400);
            btnAlien.moveTo(bx,by);
        }
        

	public void draw()
	{
            background(255); //white
            fill(0);
            text("time: "+count, 100, 100);
            if(isDown==true){
                if(keyCode==37)ax-=5;
                if(keyCode==39)ax+=5;
                if(keyCode==38)ay-=5;
                if(keyCode==40)ay+=5;
            }
            image(imgAlien, ax, ay);
            
            
	}



}