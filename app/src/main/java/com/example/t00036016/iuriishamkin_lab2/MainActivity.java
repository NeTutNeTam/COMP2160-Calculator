package com.example.t00036016.iuriishamkin_lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

//Implementation of event listener in Activity
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MAX = 999999999;
    final int ALTSIGN = -1;
    final double PERCENT = 0.01;

    //declaring necessary variables
    TextView result_display, history_display;

    double result, memory = 0;
    String history;
    operations operation;

    boolean dp_flag = false;
    boolean running_flag = false;
    boolean reset_input = false;

    public enum operations {
        ADD, SUB, MUL, DIV
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing displays
        result_display = (TextView) findViewById(R.id.display);
//        history_display = (TextView) findViewById(R.id.history);

        result_display.setText("0");
//        history_display.setText("");
        reset_input = true;
        //setting listener on buttons
        findViewById(R.id.button01).setOnClickListener(this);
        findViewById(R.id.button02).setOnClickListener(this);
        findViewById(R.id.button03).setOnClickListener(this);
        findViewById(R.id.button04).setOnClickListener(this);
        findViewById(R.id.button05).setOnClickListener(this);
        findViewById(R.id.button06).setOnClickListener(this);
        findViewById(R.id.button07).setOnClickListener(this);
        findViewById(R.id.button08).setOnClickListener(this);
        findViewById(R.id.button09).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);
        findViewById(R.id.button13).setOnClickListener(this);
        findViewById(R.id.button14).setOnClickListener(this);
        findViewById(R.id.button15).setOnClickListener(this);
        findViewById(R.id.button16).setOnClickListener(this);
        findViewById(R.id.button17).setOnClickListener(this);
        findViewById(R.id.button18).setOnClickListener(this);
        findViewById(R.id.button19).setOnClickListener(this);
        findViewById(R.id.button20).setOnClickListener(this);
        findViewById(R.id.button21).setOnClickListener(this);
        findViewById(R.id.button22).setOnClickListener(this);
        findViewById(R.id.button23).setOnClickListener(this);
        findViewById(R.id.button24).setOnClickListener(this);
        findViewById(R.id.button25).setOnClickListener(this);
        findViewById(R.id.button26).setOnClickListener(this);
        findViewById(R.id.button27).setOnClickListener(this);
        findViewById(R.id.button28).setOnClickListener(this);
        findViewById(R.id.button29).setOnClickListener(this);
        findViewById(R.id.button30).setOnClickListener(this);
    }


    @Override
    public void onClick(View arg0) {

        //initializing button that fired listener
        Button btn = (Button)arg0;

        switch (btn.getText().toString()) {


            // dealing with numeric input
            case "1":case "2":case "3":
            case "4":case "5":case"6":
            case "7":case"8":case"9":
                if (!reset_input)
                    result_display.append(btn.getText());
                else {
                    result_display.setText(btn.getText());
                    reset_input = false;
                }
                break;


            // handling special numeric case - zero
            case "0":
                if (!reset_input) {
                    if (isInput())
                        result_display.append(btn.getText());
                    else{
                        result_display.setText(btn.getText());
                        reset_input = true;
                    }
                } else {
                    result_display.setText(btn.getText());
                    reset_input = true;
                }
                break;


            // handling decimal point
            case ".":
                if (!reset_input) {
                    if (!dp_flag) {
                    dp_flag = true;
                    if (!isInput())
                        result_display.setText("0.");
                    else
                        result_display.append(btn.getText());
                    }
                } else {
                        result_display.setText("0.");
                }
                reset_input = false;
                break;


            // dealing with "All Clear" button
            case "AC":
                allClear();
                break;


            // CHECK DP_FLAG !!!!
            // handing backspace button
            case "⌫":
                if (isInput())
                    result_display.setText(result_display.getText().toString().substring(0,
                            result_display.getText().toString().length()-1));
                else
                    allClear();
                break;


            // handling change sign operator
            case "±":
                if (isInput()) {
                    output(Double.valueOf(result_display.getText().toString()) * ALTSIGN);
                }
                break;


            // handling equal operator
            case "＝":
                calculate();
                break;


            // handling addition operator
            case "+":
                if (!reset_input)
                    calculate();
                if (isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    operation = operations.ADD;
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling subtraction operator
            case "-":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    operation = operations.SUB;
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling multiplication operator
            case "×":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    operation = operations.MUL;
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling division operator
            case "÷":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    operation = operations.DIV;
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling factorial
            case "x!":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    output(factorial((long) result));
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling square root operation
            case "√":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    output(Math.sqrt(result));
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling inverse operation
            case "1/x":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    output(1/result);
                    running_flag = true;
                    reset_input = true;
                }
                break;



            // handling square operation
            case "x²":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    output(Math.pow(result,2));
                    running_flag = true;
                    reset_input = true;
                }
                break;


            // handling random number call
            case "RAND":
                Random ran = new Random();
                result = ran.nextInt(100000);
                output(result);
                break;


            // resetting memory value
            case "MC":
                memory = 0;
                Toast.makeText(getBaseContext(), "Memory Cleared", Toast.LENGTH_SHORT).show();

                break;


            // recalling value from memory
            case "MR":
                result = memory;
                output(result);
                break;


            // adding value into memory
            case "M+":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    memory += result;
                    reset_input = true;
                }
                break;


            // subtracting value from ones in memory
            case "M-":
                if (!reset_input)
                    calculate();
                if(isInput()) {
                    result = Double.valueOf(result_display.getText().toString());
                    memory -= result;
                    reset_input = true;
                }
                break;


            // percent operation
            case "%":
                if (!reset_input)
                    percent();
                reset_input = true;
                break;


            // handling welcoming button
            case "☻":
                Toast.makeText(getBaseContext(), "Flatty calculator created by Iurii Shamkin. Enjoy!", Toast.LENGTH_LONG).show();



            default:
//                result_display.setText(btn.getText()); ;
                break;
        }
    }


    // helper method that allows running calculations
    private void calculate() {

        double intermediate;

        if (isInput() && running_flag) {

            running_flag = false;

            switch (operation) {

                // calculating addition
                case ADD:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result += intermediate;
                    output(result);
                    break;

                // calculating subtraction
                case SUB:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result -= intermediate;
                    output(result);
                    break;

                // calculating multiplication
                case MUL:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result *=  intermediate;
                    output(result);
                    break;


                // calculating division
                case DIV:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result /=  intermediate;
                    output(result);
                    break;


            }
        }

    }


    // helper method that allows running calculations
    private void percent() {

        double intermediate;

        if (isInput() && running_flag) {

            running_flag = false;

            switch (operation) {

                // calculating addition
                case ADD:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result += result * intermediate * PERCENT;
                    output(result);
                    break;

                // calculating subtraction
                case SUB:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result -= result * intermediate * PERCENT;
                    output(result);
                    break;

                // calculating multiplication
                case MUL:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result *= result * intermediate * PERCENT;
                    output(result);
                    break;


                // calculating division
                case DIV:
                    intermediate = Double.valueOf(result_display.getText().toString());
                    result /= result * intermediate *PERCENT;
                    output(result);
                    break;


            }
        }

    }


    // helper method to check if user provide input
    private boolean isInput() {

        return result_display.getText().toString().trim().length() > 0;
    }


    // output result onto screen
    private void output(double value) {

//        result_display.setText(String.valueOf(value));

        if (value == (int)value) {
            if (value <= MAX)
                result_display.setText(String.valueOf((int) value));
            else
                result_display.setText(String.format("%6.1e",value));
        } else {
            if (value <= MAX)
                result_display.setText(String.valueOf((double) Math.round(value * 10000d) / 10000d));
            else
                result_display.setText(String.format("%6.1e",(value)));
        }
    }


    // helper method for complete reset
    private void allClear() {

        result_display.setText("0");
        dp_flag = false;
        running_flag = false;
        reset_input = true;
    }




    //helper method performing factorial
    private long factorial(long n) {
        return recfact(1, n); }


    //auxiliary method for factorial
    private long recfact(long start, long n) {
        long i;
        if (n <= 16) {
            long r = start;
            for (i = start + 1; i < start + n; i++) r *= i;
            return r;
        }
        i = n / 2;
        return recfact(start, i) * recfact(start + i, n - i);
    }






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
