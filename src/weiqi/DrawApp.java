package weiqi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import weiqi.componets.*;

public class DrawApp extends JFrame {
	

	private DrawArea da;
	private void handleEvents() {
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				int result = JOptionPane.showConfirmDialog(DrawApp.this, "Quit?",
				        "alert", JOptionPane.OK_CANCEL_OPTION);
				System.out.println(result);
				if (result == 0)
					System.exit(0);
				setVisible(true);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	

	public DrawApp( ) {
		Container c = getContentPane();
		da = new DrawArea();
		handleEvents();
		c.add(da, BorderLayout.CENTER);
		setSize(da.getsize()*20,da.getsize()*21);
		setVisible(true);
	}
}