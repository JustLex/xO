package by.zhakov.xo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import by.zhakov.xo.R;
import by.zhakov.xo.logic.MainController;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttons[][] = new Button[3][3];
        buttons[0][0] = (Button) findViewById(R.id.btn_1_1);
        buttons[0][1] = (Button) findViewById(R.id.btn_1_2);
        buttons[0][2] = (Button) findViewById(R.id.btn_1_3);
        buttons[1][0] = (Button) findViewById(R.id.btn_2_1);
        buttons[1][1] = (Button) findViewById(R.id.btn_2_2);
        buttons[1][2] = (Button) findViewById(R.id.btn_2_3);
        buttons[2][0] = (Button) findViewById(R.id.btn_3_1);
        buttons[2][1] = (Button) findViewById(R.id.btn_3_2);
        buttons[2][2] = (Button) findViewById(R.id.btn_3_3);
        MainController.start(buttons, this);
    }
    
}
