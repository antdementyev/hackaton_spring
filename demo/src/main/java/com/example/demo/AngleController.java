package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class AngleController {

	@PostMapping("/angle")
	@ResponseBody
	public String provider(@RequestBody double value) {

		System.out.println("angle: " + value);
		return "ok";
	}

}
