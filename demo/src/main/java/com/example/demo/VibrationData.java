package com.example.demo;

public class VibrationData {

	private long time;
	private float value;

	public VibrationData(long time, float value) {
		super();
		this.time = time;
		this.value = value;
	}

	public long getTime() {
		return time;
	}

	public float getValue() {
		return value;
	}
}
