package com.reflection;

public class RentCar {

	private int rate;
    private String type;
	public int price;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RentCar{" +
				"rate=" + rate +
				", type='" + type + '\'' +
				", price=" + price +
				'}';
	}
}