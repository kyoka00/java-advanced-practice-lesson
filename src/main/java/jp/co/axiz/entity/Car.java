package jp.co.axiz.entity;

public class Car {
	private String carName;
	private  String bodyColor;
	private int maxSpeed;
	private int speed;
	
	
	public Car() {
		
	}
	public Car(String carName, String bodyColor, int maxSpeed) {
		setCarName(carName);
		setBodyColor(bodyColor);
		setMaxSpeed(maxSpeed);
	}
	
	public Car(String carName, String bodyColor, int maxSpeed, int speed) {
		setCarName(carName);
		setBodyColor(bodyColor);
		setMaxSpeed(maxSpeed);
		setSpeed(speed);
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getBodyColor() {
		return bodyColor;
	}
	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		if(maxSpeed < 0) {
			System.out.println("最高速度に、この値（"+ maxSpeed + ")をセットすることはできません");
		}else {
			this.maxSpeed = maxSpeed;
		}
		
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed < 0 || speed > maxSpeed) {
			System.out.println("現在速度に、この値（"+ speed + ")をセットすることはできません");
		}else {
			this.speed = speed;
		}
	}
	
	
}
