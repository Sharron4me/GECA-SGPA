package com.example.sherrinford.first;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Button Go_button;
    Spinner spinner1,spinner2,spinner3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Go_button = (Button) findViewById(R.id.Go_button);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3= (Spinner) findViewById(R.id.spinner3);

        Go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BUTTON", "BTNPressed");
                String text = spinner1.getSelectedItem().toString();
                String text2 = spinner2.getSelectedItem().toString();
                String text3= spinner3.getSelectedItem().toString();
                Log.d("SPinner",text+" "+text2);
                Intent intent = new Intent(MainActivity.this, activity2.class);
                intent.putExtra("Year",text);
                intent.putExtra("Branch",text2);
                int yr_index,index,sem_index;
                if(text.equals("First Year")){
                    intent.putExtra("yr_index",1);
                    yr_index=1;
                }
                else if(text.equals("Second Year")){
                    intent.putExtra("yr_index",2);
                    yr_index=2;
                }
                else if(text.equals("Third Year")){
                    intent.putExtra("yr_index",3);
                    yr_index=3;
                }
                else if(text.equals("Fourth Year")){
                    intent.putExtra("yr_index",4);
                    yr_index=4;
                }
                else{
                    intent.putExtra("yr_index",-1);
                    yr_index=-1;
                }
                if(text2.equals("Computer Science Engineering")){
                    intent.putExtra("index",1);
                    index=1;
                }
                else if(text2.equals("Civil Engineering")){
                    intent.putExtra("index",2);
                    index=2;
                }
                else if(text2.equals("Information Technology")){
                    intent.putExtra("index",3);
                    index=3;
                }
                else if(text2.equals("Mechanical Engineering")){
                    intent.putExtra("index",4);
                    index=4;
                }
                else if(text2.equals("Electrical Engineering")){
                    intent.putExtra("index", 5);
                    index=5;
                }
                else if(text2.equals("Electronics and Electrical Engineering")){
                    intent.putExtra("index",6);
                    index=6;
                }
                else{
                    intent.putExtra("index",-1);
                    index=-1;
                }
                if(text3.equals("Odd Semester")){
                    intent.putExtra("sem_index",1);
                    sem_index=1;
                }
                else if(text3.equals("Even Semester")){
                    intent.putExtra("sem_index",2);
                    sem_index=2;
                }
                else{
                    intent.putExtra("sem_index",-1);
                    sem_index=-1;
                }
                if(yr_index==-1){
                    Toast Error_toast = Toast.makeText(getApplicationContext(),"Invalid Year Type",Toast.LENGTH_SHORT);
                    Error_toast.show();
                }

                else if(index==-1){
                    Toast Error_toast = Toast.makeText(getApplicationContext(),"Invalid Stream",Toast.LENGTH_SHORT);
                    Error_toast.show();
                }
                else if(sem_index==-1){
                    Toast Error_toast = Toast.makeText(getApplicationContext(),"Invalid Semester Name",Toast.LENGTH_SHORT);
                    Error_toast.show();
                }
                else {
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
		// commented just for fun
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            }
            System.exit(0);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
