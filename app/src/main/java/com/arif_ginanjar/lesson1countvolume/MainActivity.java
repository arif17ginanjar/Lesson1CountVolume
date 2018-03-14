package com.arif_ginanjar.lesson1countvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText activity_main_leght, activity_main_width, activity_main_height;
    private Button activity_main_calculate;
    private TextView activity_main_result;

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main_leght = (EditText)findViewById(R.id.activity_main_leght);
        activity_main_width = (EditText)findViewById(R.id.activity_main_width);
        activity_main_height = (EditText)findViewById(R.id.activity_main_height);
        activity_main_calculate = (Button)findViewById(R.id.activity_main_calculate);
        activity_main_result = (TextView)findViewById(R.id.activity_main_result);
        activity_main_calculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_HASIL);
            activity_main_result.setText(result);
        }
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.activity_main_calculate){
            String leght = activity_main_leght.getText().toString().trim();
            String widht = activity_main_width.getText().toString().trim();
            String height = activity_main_height.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(leght)){
                isEmptyFields = true;
                activity_main_leght.setError("Semua Field Wajib Diisi!!!");
            }
            if (TextUtils.isEmpty(widht)){
                isEmptyFields = true;
                activity_main_width.setError("Semua Field Wajib Diisi!!!");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields = true;
                activity_main_height.setError("Semua Field Wajib Diisi!!!");
            }
            if (!isEmptyFields){
                double l = Double.parseDouble(leght);
                double w = Double.parseDouble(widht);
                double h = Double.parseDouble(height);

                double volume = l*w*h;

                activity_main_result.setText(String.valueOf(volume));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, activity_main_result.getText().toString());
        super.onSaveInstanceState(outState);
    }
}