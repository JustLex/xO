package by.zhakov.tictactoe.model;


public class Field{
	private static char[][] field = new char[3][3];
	
	public Field(){
		for (int i = 0; i < 3; i++){
			field[i] = new char[3];
			for (int q = 0; q < 3; q++){
				field[i][q] = ' ';
			}
		}
	}
	
	public char getCell(int x, int y){
		return field[x][y];
	}
	
	public void setCell(int x, int y, char state){
		field[x][y] = state;
	}
}
