package by.zhakov.tictactoe.logic;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import by.zhakov.tictactoe.model.Player;


public class ButtonController implements OnClickListener{
	private byte x;
	private byte y;
	private Player player;
	private Button button;
	
	public ButtonController(byte x, byte y, Button button){
		this.x = x;
		this.y = y;
		this.button = button;
		button.setOnClickListener(this);
	}

	public void update(Player player) {
			this.player = player;
			if (player == null){
				button.setText("");
			} else {
				changeButton();
			}
	}
	
	@Override
	public void onClick(View v) {
		if (this.player == null){
			FieldController.changeCell(x, y);
		}
	}
	
	private void changeButton(){
		button.setText(player.getSymbol() + "");
		button.setTextColor(Color.parseColor(player.getColor()));
	}
}
