package com.ezetap.interview;

import com.ezetap.interview.Car.CarBuilder;

public class BuilderPatternTest {

	public static void main(String[] args) {

		Car c = CarBuilder.getInstance().enginePower(1000).color("white").wheelbase("80").length("400").build();
	
		Car d = CarBuilder.getInstance().color("23").wheelbase("1").length("a").build();
	}
}
