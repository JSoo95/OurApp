package com.hansung.android.ourapp;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView mSinsun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSinsun = (ImageView) findViewById(R.id.sinsun);
    }

    protected void onStart() {
        super.onStart();
        //   startFireworkValuePropertyAnimation();
        startFireworkObjectPropertyAnimation();
    }



    private void startFireworkObjectPropertyAnimation() {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mSinsun, "alpha",
                1, 0);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(mSinsun, "scaleX", 0, 1);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(mSinsun, "scaleY", 0, 1);

        ObjectAnimator scaleXAnimator1 = ObjectAnimator.ofFloat(mSinsun, "scaleX", 1, 0);
        ObjectAnimator scaleYAnimator1 = ObjectAnimator.ofFloat(mSinsun, "scaleY", 1, 0);

        ObjectAnimator RotateAnimator = ObjectAnimator.ofFloat(mSinsun, "rotation", 0, 1800);


        AnimatorSet scaleanimatorSet = new AnimatorSet();
        scaleanimatorSet.playTogether(scaleXAnimator, scaleYAnimator);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator).after(scaleanimatorSet);
        animatorSet.play(scaleanimatorSet).after(RotateAnimator);

        animatorSet.setDuration(5000);
        animatorSet.setStartDelay(2000);
        animatorSet.start();
        animatorSet.addListener(animatorListener);

        AnimatorSet scaleanimatorSet1 = new AnimatorSet();
        scaleanimatorSet.playTogether(scaleXAnimator1, scaleYAnimator1);

        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet.play(scaleanimatorSet).after(scaleanimatorSet1);

        animatorSet1.setDuration(2000);
        animatorSet.setStartDelay(2000);
        animatorSet1.start();
        animatorSet.addListener(animatorListener);

    }

    Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {


        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            finish();
            startActivity(new Intent(getApplicationContext(), RestaurantMap.class));
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }

    };


}