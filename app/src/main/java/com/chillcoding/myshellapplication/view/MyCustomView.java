package com.chillcoding.myshellapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.chillcoding.myshellapplication.R;


/**
 * Created by macha on 12/04/2017.
 */

public class MyCustomView extends View implements View.OnTouchListener {
    private static final String TAG = "My CUSTOM VIEW";
    private Paint mPaint;
    private int mScreenWith;
    private int mScreenHeight;
    private Bitmap mBitmap;
    private int mX, mY;
    private MediaPlayer mMediaPlayer;
    private Vibrator mVibrator;

    public MyCustomView(Context context) {
        super(context);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mScreenWith = getWidth();
        mScreenHeight = getHeight();
    }

    private void init() {
        super.setOnTouchListener(this);
        mPaint = new Paint();
        mPaint.setTextSize(25);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lollipop);
        mX = 0;
        mY = 0;

        mMediaPlayer = MediaPlayer.create(getContext(), R.raw.ding);
        mVibrator = (Vibrator) getContext().getSystemService(Activity.VIBRATOR_SERVICE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Hola", 50, 50, mPaint);
        canvas.drawBitmap(mBitmap, mX, mY, mPaint);
        updateCoordinate();
        invalidate();
    }

    public void updateCoordinate() {
        if (mX < (mScreenWith - mBitmap.getWidth()))
            mX++;
        if (mY < (mScreenHeight - mBitmap.getWidth()))
            mY++;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        playSound();
        return true;
    }

    private void playSound() {

        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
            mMediaPlayer = MediaPlayer.create(getContext(), R.raw.ding);
        }
        mMediaPlayer.start();
        mVibrator.vibrate(100);
    }
}
