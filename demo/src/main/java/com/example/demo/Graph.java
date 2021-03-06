package com.example.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A graph that should in the future represent a wave according to my inputs
 * 
 * @authorImprofane
 * @version 1
 */
public class Graph extends JFrame {
	private InnerGraph inner;

	private int width;
	private Random RNG;
	private int height;
	private int[][] series;

	private int xoffset;
	int prevx = 0;
	int prevy = 0;

	/**
	 * Constructor for objects of class Graph
	 */
	public Graph() throws InterruptedException {
		int width = 500;
		int height = 500;

		RNG = new Random();
		setTitle(" Graph");

		series = new int[width][2];

		this.width = width;
		this.height = height;
		inner = new InnerGraph(width, height);

		add(inner, BorderLayout.CENTER);

		setVisible(true);
		inner.preparePaint();
		pack();
		updateGraph();
	}

	public void updateGraph() throws InterruptedException {

		Vibration vibration = Vibration.getInstance();

		while (true) {

			VibrationData data = vibration.getData();
			System.out.println("draw " + data.getValue());
			inner.updateSeries((int) data.getTime(), (int) data.getValue());

			inner.repaint();
		}
		/*
		// virtual x is how far along on the x axis we are, I ignore the 'real' X axis
		int vx = 0;
		int point = 0;
		int xdecay = 0;
		int inc = 5;
		
		// how many times we need to plot a point
		int points = (int) java.lang.Math.floor(width / inc);
		System.out.println(points);
		inner.preparePaint();
		// draw all points to graph
		
		// make some junk data, a saw like graph
		for (vx = 0; vx < points; vx++) {
			series[vx] = new int[] { vx * inc, ((vx * inc) % 120) };
		}
		
		Thread.sleep(150);
		int n = 5;
		
		while (n > 0) {
			System.out.println(xdecay);
			inner.preparePaint();
			for (vx = 0; vx < points; vx++) {
				inner.updateSeries(vx, xdecay);
		
				inner.repaint();
				Thread.sleep(50);
			}
			xdecay += inc;
		
			// shift the data points to the left
			int[][] nseries = new int[points][2];
			// System.arraycopy(series, 1, nseries, 0, points-1);
			n--;
		}
		*/
	}

	public class InnerGraph extends JPanel {
		private Graphics g;
		private Image img;

		private int gwidth;
		private int gheight;

		Dimension size;

		private int xOld;
		private int yOld;

		public InnerGraph(int width, int height) {
			gwidth = width;
			gheight = height;
			size = new Dimension(1, 1);

		}

		/**
		 * Try make panel the requested size.
		 */
		public Dimension getPreferredSize() {
			return new Dimension(gwidth, gheight);
		}

		/**
		 * Create an image and graphics context
		 * 
		 */

		public void preparePaint() {
			size = getSize();
			img = inner.createImage((size.width | gwidth), (size.height | gheight));
			g = img.getGraphics();

		}

		/**
		 * Draw a point to the chart given the point to use and the decay. 
		 * Yes this is bad coding style until I work out the mathematics needed
		 * to do what I want.
		 */

		public void updateSeries(int x, int y) {

			g.setColor(Color.blue);
			/*	int nx = series[point][0];
			
				series[point][0] -= decay;
				if (point - 1 >= 0) {
					series[point - 1][0] -= decay;
				}
			
				int ny = series[point][1];
				//    prevx -= decay;
			
				//    g.drawLine(prevx-decay, prevy, nx-decay, ny );  
				 *        
				 */
			g.drawLine(xOld, height / 2 - yOld, x, height / 2 - y);
			xOld = x;
			yOld = y;
			//			prevx = nx - decay;
			//			prevy = ny;
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

}