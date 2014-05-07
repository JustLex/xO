package by.zhakov.tictactoe.model;


public class Player {
	private String name;
	private char symbol;
	private String color;
	
	public char getSymbol() {
		return symbol;
	}
	public String getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public Player(String name, char symbol, String color) {
		this.name = name;
		this.symbol = symbol;
		this.color = color;
	}
	
}
