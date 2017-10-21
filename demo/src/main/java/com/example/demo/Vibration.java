package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Vibration {

	private List<VibrationData> datas = new ArrayList<>();

	private static Vibration singleton;

	public static Vibration getInstance() {
		if (singleton == null) {
			singleton = new Vibration();
		}
		return singleton;
	}

	public synchronized void addData(VibrationData data) {
		datas.add(data);
		notifyAll();
	}

	public synchronized VibrationData getData() {
		while (datas.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return datas.remove(0);
	}

}
