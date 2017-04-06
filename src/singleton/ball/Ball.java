package singleton.ball;

import java.util.HashMap;
import java.util.Map;

public class Ball {

	private static Map<String, Ball> toybox = new HashMap<String, Ball>();

	private String color;

	private Ball(String color) {
		this.color = color;
	}

	public static Ball getInstance(String color) {
		if (!toybox.containsKey(color)) {
			toybox.put(color, new Ball(color));
		}
		return toybox.get(color);
	}

	public void bounce() {
		System.out.println("boing!");
	}

	public static void main(String[] args) {
		Ball red = Ball.getInstance("red");
		Ball red2 = Ball.getInstance("red");
		Ball green = Ball.getInstance("green");
		if (red == red2) {
			System.out.println("red and red2 are the same object");
			System.out.println("\tred : " + red);
			System.out.println("\tred2: " + red2);
		}
		if (red != green) {
			System.out.println("red and green are NOT the same object");
			System.out.println("\tred  : " + red);
			System.out.println("\tgreen: " + green);
		}
	}

}
