package com.ezetap.interview;

public class Car {

	private Integer enginePower;

	private String color;

	private String wheelbase;

	private String length;

	private Car() {
	}

	public Integer getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(Integer enginePower) {
		this.enginePower = enginePower;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWheelbase() {
		return wheelbase;
	}

	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public static class CarBuilder implements EnginePower, Color, WheelBase, Length {

		private Integer enginePower;

		private String color;

		private String wheelbase;

		private String length;

		public static CarBuilder getInstance() {
			return new CarBuilder();
		}

		@Override
		public Color color(String color) {
			this.color = color;
			return this;
		}

		@Override
		public EnginePower enginePower(Integer power) {
			this.enginePower = power;
			return this;
		}

		@Override
		public CarBuilder length(String length) {
			this.length = length;
			return this;
		}

		@Override
		public WheelBase wheelbase(String wheelBase) {
			this.wheelbase = wheelBase;
			return this;
		}

		public Car build() {
			Car car = new Car();
			car.setEnginePower(this.enginePower);
			car.setColor(this.color);
			car.setWheelbase(this.wheelbase);
			car.setLength(this.length);
			return car;
		}
	}

}
