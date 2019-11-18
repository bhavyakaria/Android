package com.bhavyakaria.simpleanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_one, btn_two, btn_three, btn_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_one = findViewById(R.id.button_one);
        btn_two = findViewById(R.id.button_two);
        btn_three = findViewById(R.id.button_three);
        btn_four = findViewById(R.id.button_four);

//        btn_one.setVisibility(View.VISIBLE);
        btn_one.setAlpha(0.0f);
        btn_two.setAlpha(0.0f);
        btn_three.setAlpha(0.0f);
        btn_four.setAlpha(0.0f);

//        btn_one.setTranslationX(0);
//        btn_one.animate()
//                .translationXBy(100)
//                .translationX(0)
//                .setDuration(500)
//                .setInterpolator(new AccelerateDecelerateInterpolator());


        slideUp(btn_one, 500);
        slideUp(btn_two, 600);
        slideUp(btn_three, 700);
        slideUp(btn_four, 800);


        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                selectRightAnswer(btn_one);
            }
        }, 5000);

    }

    private void selectRightAnswer(Button btn) {
        int colorStart=btn.getSolidColor();
        int colorEnd=getResources().getColor(R.color.colorPrimary);
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(btn,"backgroundColor",colorStart,colorEnd);
        valueAnimator.setDuration(300);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        btn.setTextColor(getResources().getColor(R.color.color_white));

        valueAnimator.setRepeatCount(0);
        valueAnimator.start();

        hideButtons();
    }

    private void hideButtons() {
        btn_two.animate()
                .translationY(50)
                .alpha(0.0f)
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(null);

        btn_three.animate()
                .translationY(50)
                .alpha(0.0f)
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(null);

        btn_four.animate()
                .translationY(50)
                .alpha(0.0f)
                .setDuration(500)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(null);
    }

    public static void slideUp(final View view, final int delay) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0.f);

        if (view.getWidth() > 0) {
            slideUpNow(view, delay);
        } else {
            // wait till height is measured
            view.post(new Runnable() {
                @Override
                public void run() {
                    slideUpNow(view, delay);
                }
            });
        }
    }

    private static void slideUpNow(final View view, final int delay) {

        view.setTranslationY(view.getWidth());
        view.animate()
                .translationY(100)
                .alpha(1.0f)
                .setDuration(500)
                .setStartDelay(delay)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.VISIBLE);
                        view.setAlpha(1.f);
                    }
                });

    }


}
