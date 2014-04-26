package by.zhakov.xo.logic;

import android.widget.Button;
import by.zhakov.xo.model.Field;
import by.zhakov.xo.model.Player;

public class FieldController{
	private static final int winConditions[][] = {{11,12,13},{21,22,23},{31,32,33},{11,21,31},{12,22,32},{13,23,33},{11,22,33},{31,22,13}};
	private static Field field = new Field();
	private static ButtonController buttonControllers[][] = new ButtonController[3][3];

	public static void start(Button[][] buttons){
		for (byte i = 0; i < 3; i++){
			for (byte q = 0; q < 3; q++){
				buttonControllers[i][q] = new ButtonController(i, q, buttons[i][q]);
			}
		}
	}
	
	public static void changeCell(int x, int y){
		Player player = MainController.getPlayer();
		field.setCell(x, y, player.getSymbol());
		buttonControllers[x][y].update(player);
		if (checkVictory(player)){
			MainController.victory(player);
		}
		if (checkDraw()){
			MainController.draw();
		}
	}
	
	private static boolean checkVictory(Player player){
		boolean victory = false;
		for (int i = 0; i < winConditions.length; i++){
			int x1 = (winConditions[i][0] % 10) - 1;
			int y1 = (winConditions[i][0] / 10) - 1;
			int x2 = (winConditions[i][1] % 10) - 1;
			int y2 = (winConditions[i][1] / 10) - 1;
			int x3 = (winConditions[i][2] % 10) - 1;
			int y3 = (winConditions[i][2] / 10) - 1;
			if ((field.getCell(x1, y1) == field.getCell(x2, y2)) && (field.getCell(x2, y2) == field.getCell(x3, y3)) &&
					 (field.getCell(x1, y1) == player.getSymbol())){
				victory = true;
			}
		}
		return victory;
	}
	
	private static boolean checkDraw(){
		for (int i = 0; i < 3; i++){
			for (int q = 0; q < 3; q++){
				if (field.getCell(i, q) == ' '){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void cleanField(){
		for (byte i = 0; i < 3; i++){
			for (byte q = 0; q < 3; q++){
				buttonControllers[i][q].update(null);
			}
		}
		field = new Field();
	}
}
