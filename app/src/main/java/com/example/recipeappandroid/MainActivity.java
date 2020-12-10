package com.example.recipeappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView ImageAnimation;
    private Animation animTranslate, animScale;
    private TextView welcome_anim, phrase_anim, hc_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActiviy(); }

        });

        ImageAnimation = (ImageView)findViewById(R.id.imageView);
        animTranslate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ttb);
        ImageAnimation.startAnimation(animTranslate);

        welcome_anim = (TextView)findViewById(R.id.welcome);
        animTranslate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ttb);
        welcome_anim.startAnimation(animTranslate);

        phrase_anim = (TextView)findViewById(R.id.phrase);
        animTranslate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ttb);
        phrase_anim.startAnimation(animTranslate);

        hc_anim = (TextView)findViewById(R.id.happy_cooking);
        animTranslate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ttb);
        hc_anim.startAnimation(animTranslate);

        animScale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ttb);
        button.startAnimation(animScale);

    }

    public  void  openSearchActiviy() {
        Intent intent = new Intent(this, searchActivity.class);
        startActivity(intent);
    }
}
