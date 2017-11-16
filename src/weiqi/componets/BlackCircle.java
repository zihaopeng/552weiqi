package weiqi.componets;

import java.awt.Color;
import java.awt.Graphics;

public class BlackCircle extends Shape {
	private int width,height;
	
	public BlackCircle(int x, int y, int width, int height) {
		super(x,y);
		this.width = width; this.height = height;
	}
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(getX(), getY(), width, height);
	}
        public void setPoint2(int x2, int y2) {
            width = x2 - getX();
            height = y2 - getY();
        }
}