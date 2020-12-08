package com.example.mobilprog_beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView szamTextView, muveletTextView;

    Double szam1, szam2, answer;
    String muveletiJel, szam1_String, szam2_String;
    boolean vanTizedesPont;

    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        szamTextView = findViewById(R.id.szamTextView);
        muveletTextView = findViewById(R.id.muveletTextView);

        vanTizedesPont = false;

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @SuppressLint("SetTextI18n")
    public void btn_0(View view) {
        szamTextView.setText(szamTextView.getText() + "0");
    }

    @SuppressLint("SetTextI18n")
    public void btn_1(View view) {
        szamTextView.setText(szamTextView.getText() + "1");
    }

    @SuppressLint("SetTextI18n")
    public void btn_2(View view) {
        szamTextView.setText(szamTextView.getText() + "2");
    }

    @SuppressLint("SetTextI18n")
    public void btn_3(View view) {
        szamTextView.setText(szamTextView.getText() + "3");
    }

    @SuppressLint("SetTextI18n")
    public void btn_4(View view) {
        szamTextView.setText(szamTextView.getText() + "4");
    }

    @SuppressLint("SetTextI18n")
    public void btn_5(View view) {
        szamTextView.setText(szamTextView.getText() + "5");
    }

    @SuppressLint("SetTextI18n")
    public void btn_6(View view) {
        szamTextView.setText(szamTextView.getText() + "6");
    }

    @SuppressLint("SetTextI18n")
    public void btn_7(View view) {
        szamTextView.setText(szamTextView.getText() + "7");
    }

    @SuppressLint("SetTextI18n")
    public void btn_8(View view) {
        szamTextView.setText(szamTextView.getText() + "8");
    }

    @SuppressLint("SetTextI18n")
    public void btn_9(View view) {
        szamTextView.setText(szamTextView.getText() + "9");
    }

    @SuppressLint("SetTextI18n")
    public void btn_pont(View view) {
        if (!vanTizedesPont) {
            if (szamTextView.getText().equals("")) {

                szamTextView.setText("0.");
            } else {

                szamTextView.setText(szamTextView.getText() + ".");
            }

            vanTizedesPont = true;
        }

    }

    public void btn_hozzaadas(View view) {
        muveletiJel = "+";
        szam1_String = szamTextView.getText().toString();
        szamTextView.setText(null);
        muveletTextView.setText("+");
        vanTizedesPont = false;
    }

    public void btn_kivonas(View view) {
        muveletiJel = "-";
        szam1_String = szamTextView.getText().toString();
        szamTextView.setText(null);
        muveletTextView.setText("-");
        vanTizedesPont = false;
    }

    public void btn_szorzas(View view) {
        muveletiJel = "*";
        szam1_String = szamTextView.getText().toString();
        szamTextView.setText(null);
        muveletTextView.setText("×");
        vanTizedesPont = false;
    }

    public void btn_osztas(View view) {
        muveletiJel = "/";
        szam1_String = szamTextView.getText().toString();
        szamTextView.setText(null);
        muveletTextView.setText("÷");
        vanTizedesPont = false;
    }

    @SuppressLint("SetTextI18n")
    public void btn_log(View view) {
        muveletiJel = "log";
        szamTextView.setText(null);
        muveletTextView.setText("log");
        vanTizedesPont = false;
    }

    @SuppressLint("SetTextI18n")
    public void btn_ln(View view) {
        muveletiJel = "ln";
        szamTextView.setText(null);
        muveletTextView.setText("ln");
        vanTizedesPont = false;
    }

    public void btn_negyzet(View view) {
        muveletiJel = "negyzet";
        szam1_String = szamTextView.getText().toString();
        szamTextView.setText(null);
        vanTizedesPont = false;
        muveletTextView.setText("xⁿ");
    }

    public void btn_faktorialis(View view) {
        muveletiJel = "faktorialis";
        szamTextView.setText(null);
        vanTizedesPont = false;
        muveletTextView.setText("!");
    }

    @SuppressLint("SetTextI18n")
    public void btn_sin(View view) {
        muveletiJel = "sin";
        szamTextView.setText(null);
        vanTizedesPont = false;
        muveletTextView.setText("sin");
    }

    @SuppressLint("SetTextI18n")
    public void btn_cos(View view) {
        muveletiJel = "cos";
        szamTextView.setText(null);
        vanTizedesPont = false;
        muveletTextView.setText("cos");
    }

    @SuppressLint("SetTextI18n")
    public void btn_tan(View view) {
        muveletiJel = "tan";
        szamTextView.setText(null);
        vanTizedesPont = false;
        muveletTextView.setText("tan");
    }

    public void btn_gyok(View view) {
        muveletiJel = "gyok";
        szamTextView.setText(null);
        vanTizedesPont = false;
        muveletTextView.setText("√");
    }

    @SuppressLint("SetTextI18n")
    public void btn_egyenlo(View view) {
        if (muveletiJel == null) {
            muveletTextView.setText("Error!");
        } else if (szamTextView.getText().equals("")) {
            muveletTextView.setText("Error!");
        } else if ((muveletiJel.equals("+") || muveletiJel.equals("-") || muveletiJel.equals("*") || muveletiJel.equals("/")) && szam1_String.equals("")) {
            muveletTextView.setText("Error!");
        } else {
            switch (muveletiJel) {
                default:
                    break;
                case "log":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble(szam1_String);
                    szamTextView.setText(Math.log10(szam1) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "ln":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble(szam1_String);
                    szamTextView.setText(Math.log(szam1) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "negyzet":
                    szam1 = Double.parseDouble((szam1_String));
                    szam2_String = szamTextView.getText().toString();
                    szam2 = Double.parseDouble(szam2_String);
                    szamTextView.setText(Math.pow(szam1, szam2) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "gyok":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble((szam1_String));
                    szamTextView.setText(Math.sqrt(szam1) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "faktorialis":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble((szam1_String));
                    int i = Integer.parseInt(szam1_String) - 1;

                    while (i > 0) {
                        szam1 = szam1 * i;
                        i--;
                    }

                    szamTextView.setText(szam1 + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "sin":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble((szam1_String));
                    szamTextView.setText(Math.sin(szam1) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "cos":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble((szam1_String));
                    szamTextView.setText(Math.cos(szam1) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "tan":
                    szam1_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble((szam1_String));
                    szamTextView.setText(Math.tan(szam1) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "+":
                    szam2_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble(szam1_String);
                    szam2 = Double.parseDouble(szam2_String);
                    szamTextView.setText((szam1 + szam2) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "-":
                    szam2_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble(szam1_String);
                    szam2 = Double.parseDouble(szam2_String);
                    szamTextView.setText((szam1 - szam2) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "*":
                    szam2_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble(szam1_String);
                    szam2 = Double.parseDouble(szam2_String);
                    szamTextView.setText((szam1 * szam2) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
                case "/":
                    szam2_String = szamTextView.getText().toString();
                    szam1 = Double.parseDouble(szam1_String);
                    szam2 = Double.parseDouble(szam2_String);
                    szamTextView.setText((szam1 / szam2) + "");
                    muveletiJel = null;
                    muveletTextView.setText(null);
                    break;
            }

        }
    }


    public void btn_torlesEgyet(View view) {
        if (szamTextView.getText().equals("")) {
            szamTextView.setText(null);
        } else {
            int len = szamTextView.getText().length();
            String s = szamTextView.getText().toString();
            if (s.charAt(len - 1) == '.') {
                vanTizedesPont = false;
                szamTextView.setText(szamTextView.getText().subSequence(0, szamTextView.getText().length() - 1));

            } else {
                szamTextView.setText(szamTextView.getText().subSequence(0, szamTextView.getText().length() - 1));
            }
        }
    }

    public void btn_torles(View view) {

        szamTextView.setText(null);
        muveletTextView.setText(null);
        szam1_String = null;
        szam2_String = null;
        muveletiJel = null;
        vanTizedesPont = false;
    }


    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            if (event.values[0] > 10 || event.values[1] > 10 || event.values[2] > 10)
            {
                szamTextView.setText(null);
                muveletTextView.setText(null);
                szam1_String = null;
                szam2_String = null;
                muveletiJel = null;
                vanTizedesPont = false;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        sm.unregisterListener(this);
    }
}































