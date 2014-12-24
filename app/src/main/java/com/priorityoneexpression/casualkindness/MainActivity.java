package com.priorityoneexpression.casualkindness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends ActionBarActivity {

    private int moneyRadioButton = R.id.freeMoney;
    private SeekBar timeSeekBar = null;
    private double timeAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeSeekBar = (SeekBar) findViewById(R.id.timeSeekBar);
        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //timeAmount = progress;
                double time = progress;
                timeAmount = 4.0733*Math.exp(time*0.1212)-3.00; // used excel to figure out a progression that worked
                TextView timeAmountText = (TextView) findViewById(R.id.timeAmount);
                if (progress == 100) {
                    timeAmount = -1;
                    timeAmountText.setText("Forever!");
                } else if (timeAmount > 60.0) {
                    double hours = timeAmount / 60.0;
                    if (hours > 24.0) {
                        double days = hours / 24.0;
                        if (days > 30.0) {
                            double months = days / 24.0;
                            if (months > 12.0) {
                                double years = months / 12.0;
                                if ((int) years == 1.0)
                                    timeAmountText.setText(String.valueOf((int) years) + " year");
                                else
                                    timeAmountText.setText(String.valueOf((int) years) + " years");
                            } else {
                                if ((int) months == 1.0)
                                    timeAmountText.setText(String.valueOf((int) months) + " month");
                                else
                                    timeAmountText.setText(String.valueOf((int) months) + " months");
                            }
                        } else {
                            if ((int) days == 1.0)
                                timeAmountText.setText(String.valueOf((int) days) + " day");
                            else
                                timeAmountText.setText(String.valueOf((int) days) + " days");
                        }
                    } else {
                        if ((int) hours == 1.0)
                            timeAmountText.setText(String.valueOf((int) hours) + " hour");
                        else
                            timeAmountText.setText(String.valueOf((int) hours) + " hours");
                    }
                } else {
                    if ((int) timeAmount == 1.0)
                        timeAmountText.setText(String.valueOf((int) timeAmount) + " minute");
                    else
                        timeAmountText.setText(String.valueOf((int) timeAmount) + " minutes");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.freeMoney:
                if (checked)
                    moneyRadioButton = R.id.freeMoney;
                    break;
            case R.id.littleMoney:
                if (checked)
                    moneyRadioButton = R.id.littleMoney;
                    break;
            case R.id.middleMoney:
                if (checked)
                    moneyRadioButton = R.id.middleMoney;
                    break;
            case R.id.bigMoney:
                if (checked)
                    moneyRadioButton = R.id.bigMoney;
                    break;
            case R.id.hugeMoney:
                if (checked)
                    moneyRadioButton = R.id.hugeMoney;
                    break;
            case R.id.pricelessMoney:
                if (checked)
                    moneyRadioButton = R.id.pricelessMoney;
                    break;
        }
    }
}
