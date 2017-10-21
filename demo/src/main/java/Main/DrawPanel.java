package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.example.demo.Values;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel implements Runnable, KeyListener {

	// dimensions
	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;
	public static final int SCALE = 2;

	// game thread
	private Thread thread;
	private boolean running;
	// private int FPS = 60;
	// private long targetTime = 1000 / FPS;

	// image
	private BufferedImage image;
	private Graphics2D g;
	int x = 10;
	int y = 0; // HEIGHT * SCALE - 10;
	CSVReader csvr;

	Font font;

	int oldV = (HEIGHT * SCALE - 2 * 10);

	public DrawPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		csvr = new CSVReader();

		font = new Font("Serif", Font.PLAIN, 40);
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}

	private void init() {

		running = true;
	}

	public void run() {

		init();
		while (running) {

			drawToScreen();

			try {
				Thread.sleep(25);
				x += 1;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void drawToScreen() {
		g = (Graphics2D) getGraphics();
		g.setColor(Color.BLACK);
		g.setBackground(Color.BLACK);
		g.setFont(font);
		g.drawString("SENSOR DATA", 400, 100);
		int v = (int) (Values.v * 50);
		/*if (v > 15)
			g.setColor(Color.RED);*/
		//g.drawString(".", x, (HEIGHT * SCALE - 2 * v));

		v = (HEIGHT * SCALE - 2 * v);

		g.drawLine(x - 1, oldV, x, v);
		g.dispose();
		oldV = v;
	}

	public void keyTyped(KeyEvent key) {
	}

	public void keyPressed(KeyEvent key) {
	}

	public void keyReleased(KeyEvent key) {
	}

}
