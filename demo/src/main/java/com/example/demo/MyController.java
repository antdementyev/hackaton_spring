package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@PostMapping("/hello")
	@ResponseBody
	public String provider(@RequestBody double value) {
		//Values.values.add(value);
		Values.v = value;
		System.out.println("Accelation Square Root: " + value);
		return "ok";
	}
}