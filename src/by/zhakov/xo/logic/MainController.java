package by.zhakov.xo.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import by.zhakov.xo.R;
import by.zhakov.xo.model.Player;

public class MainController {
	private static Activity activity;
	
	private static List<Player> players;
	private static Iterator<Player> playersIterator;
	
	public static Player getPlayer(){
		if (!playersIterator.hasNext()){
			playersIterator = players.iterator();
		}
		return playersIterator.next();
	}
	
	public static void victory(Player player){
		showToast(player.getName() + " won!");
		FieldController.cleanField();
	}
	
	public static void draw(){
		showToast("Draw!");
		FieldController.cleanField();
	}
	
	public static void start (Button[][] buttons, Activity activity){
		MainController.activity = activity;
		players = new ArrayList<Player>();
		players.add(new Player("Crosses", 'X', activity.getResources().getString(R.color.player_1_color)));
		players.add(new Player("Zeroes", 'O', activity.getResources().getString(R.color.player_2_color)));
		playersIterator = players.iterator();
		activity.findViewById(R.id.restart_button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FieldController.cleanField();
			}
		});
		FieldController.start(buttons);
	}
	
	private static void showToast(String msg){
		Toast toast = Toast.makeText(activity.getApplicationContext(), 
				   msg, Toast.LENGTH_LONG); 
				toast.show();
	}
}
