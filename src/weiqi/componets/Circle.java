package weiqi.componets;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private int width,height;
	
	public Circle(int x, int y, int width, int height) {
		super(x,y);
		this.width = width; this.height = height;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(getX(), getY(), width, height);
		g.setColor(Color.black);
		g.drawOval(getX(), getY(), width, height);
		
		
	}
        public void setPoint2(int x2, int y2) {
            width = x2 - getX();
            height = y2 - getY();
        }
}