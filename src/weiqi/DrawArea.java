package weiqi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import weiqi.componets.*;
import weiqi.componets.Shape;

public class DrawArea extends JPanel {
	private int count=0;
	private int size = 40;
    private ArrayList<Shape> shapes;
    private ArrayList<Line> qipan = new ArrayList<Line>(38);
    private int[][] qizi = new int[20][20];
    private Mode mode;
    public int getsize(){
    	return size;
    }
    public void setMode(Mode m) {
        mode = m;
    }
    public void setqizi(){
    	for(int i =0; i< 20;i++) {
    		for(int j = 0; j<20; j++) {
    			qizi[i][j]=0;
    		}
    	}
    }
    public DrawArea() {
    	setqizi();
    	//setMode(new BlackCircleMode());
    	shapes = new ArrayList<>(361);
        setBackground(Color.white);
        MyMouseListener ml = new MyMouseListener();
        addMouseListener(ml);
        addMouseMotionListener(ml);
    }

    public void setboard() {
    	for( int i =1; i<20; i++) {
    		qipan.add(new Line(i*size, size, i*size, 20*size-size));
    		qipan.add(new Line(size, i*size, 20*size-size, i*size));
    	}
    }
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(getForeground());
        setboard();
        for(Line a: qipan) {
        	a.draw(g);
        }
        for (Shape s : shapes) {
            s.draw(g);
        }
    }
    public boolean checkduplicate(int x, int y) {
    	int x1=(x+size/2)/size;
    	int y1=(y+size/2)/size;
    	if(qizi[x1][y1]==1) {
    		return false;
    	}
    	return true;
    }

    class MyMouseListener implements MouseListener, MouseMotionListener {
    	
    	
        private int x, y;
        private int lastx, lasty;
        private Shape current;
        @Override
        public void mouseClicked(MouseEvent arg0) {
        
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

        @Override
        public void mousePressed(MouseEvent e) {
        	if(count%2==1) {
        		setMode(new CircleMode());
        	}
        	else {
        		setMode(new BlackCircleMode());
        	}
        	x = e.getX();
            y = e.getY();
            if(x>=size/2&&y>=size/2&&x<=(20-1)*size+size/2&&y<=(20-1)*size+size/2&&checkduplicate(x,y)) {
                count++;
                int x1=(x+size/2)/size;
            	int y1=(y+size/2)/size;
            	qizi[x1][y1]=1;
            	x=(x+size/2)/size * size-18;
                y=(y+size/2)/size * size-18;
                lastx = x+36;
                lasty = y+36;
                current = mode.create(x, y, lastx, lasty);
                Graphics g = getGraphics();
                g.setXORMode(Color.white);
                current.draw(g);
                g.setPaintMode();
                
                current.draw(g);
                
                shapes.add(current);
        	}
        	
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            
        }

        @Override
        public void mouseDragged(MouseEvent arg0) {
            
        }

        @Override
        public void mouseMoved(MouseEvent arg0) {
            // TODO Auto-generated method stub
        }

    }

}