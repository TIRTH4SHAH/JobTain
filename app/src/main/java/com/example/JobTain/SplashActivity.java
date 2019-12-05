package com.example.JobTain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    Button sub;
    Animation frombottom, fromtop;
    ImageView ballon;
    TextView InterviewAir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sub = (Button) findViewById(R.id.sub);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        sub.setAnimation(frombottom);
        ballon = (ImageView) findViewById(R.id.ballon);
        InterviewAir = (TextView) findViewById(R.id.InterviewAir);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        ballon.setAnimation(fromtop);
        InterviewAir.setAnimation(fromtop);
        addListenerOnButton();



    }

    private void addListenerOnButton() {
        sub = (Button) findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
