package com.example.t00036016.iuriishamkin_lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView results;
    Button button01, button02, button03;
    int start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button01).setOnClickListener(handlenumbers);
        findViewById(R.id.button02).setOnClickListener(handlenumbers);
        findViewById(R.id.button03).setOnClickListener(handlenumbers);
        start = 0;

    }

    private View.OnClickListener handlenumbers = new View.OnClickListener() {
        @Override
        public void onClick(View NumButtonView) {

            Button btn = (Button)NumButtonView;

            if (btn.getText().equals('0') && start == 0) {
                Integer temp = btn.getId();
            }
            else
                results.append(btn.getText());

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
