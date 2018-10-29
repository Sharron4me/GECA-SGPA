package com.example.sherrinford.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class activity3 extends AppCompatActivity {

    ImageView arrow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_activity3);

        arrow1 = (ImageView) findViewById(R.id.arrow1);
        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity3.this ,MainActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        float Total = bundle.getFloat("Total");
        TextView txtView = (TextView) findViewById(R.id.result);
        txtView.setText(Float.toString(Total));
    }
}
