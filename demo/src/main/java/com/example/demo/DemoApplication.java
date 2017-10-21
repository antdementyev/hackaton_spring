package com.example.demo;

import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Main.DrawPanel;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);

		System.setProperty("java.awt.headless", "false");

		/*
		boolean headless = GraphicsEnvironment.isHeadless();
		
		System.out.println("Headless: " + headless);
		XYSeries series = new XYSeries("sin(a)");
		
		for (float i = 0; i < Math.PI; i += 0.1) {
			series.add(i, Math.sin(i));
		}
		
		XYDataset xyDataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory
				.createXYLineChart("y = sin(x)", "x", "y",
						xyDataset,
						PlotOrientation.VERTICAL,
						true, true, true);
		JFrame frame = new JFrame("MinimalStaticChart");
		// Помещаем график на фрейм
		frame.getContentPane()
				.add(new ChartPanel(chart));
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.show();
		*/
		/*
				new Thread(new Runnable() {
		
					@Override
					public void run() {
						try {
							new Graph();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
				*/

		JFrame window = new JFrame("SENSOR DATA");
		window.setContentPane(new DrawPanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
