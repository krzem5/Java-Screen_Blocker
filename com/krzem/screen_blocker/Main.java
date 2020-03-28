import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;



public class Main{
	public static void main(String[] args){
		new Main();
	}



	public Main(){
		GraphicsDevice SCREEN=GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
		Rectangle WINDOW_SIZE=SCREEN.getDefaultConfiguration().getBounds();
		JFrame fr=new JFrame("Screen Blocker");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setUndecorated(true);
		fr.setResizable(false);
		fr.setAlwaysOnTop(true);
		SCREEN.setFullScreenWindow(fr);
		JComponent cnv=new JComponent(){
			public void paintComponent(Graphics g){
				g.setColor(Color.black);
				g.fillRect(0,0,WINDOW_SIZE.width,WINDOW_SIZE.height);
			}
		};
		cnv.setCursor(cnv.getToolkit().createCustomCursor(new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB),new Point(),null));
		cnv.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode()==27){
					System.exit(0);
				}
			}
			public void keyReleased(KeyEvent e){
				if (e.getKeyCode()==27){
					System.exit(0);
				}
			}
			public void keyTyped(KeyEvent e){
				if (e.getKeyCode()==27){
					System.exit(0);
				}
			}
		});
		cnv.setSize(WINDOW_SIZE.width,WINDOW_SIZE.height);
		cnv.setPreferredSize(new Dimension(WINDOW_SIZE.width,WINDOW_SIZE.height));
		fr.setContentPane(cnv);
		cnv.requestFocus();
	}
}