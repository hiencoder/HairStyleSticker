package vn.edu.imic.hairrstylesticker.view.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.io.InputStream;

import vn.edu.imic.hairrstylesticker.R;

/**
 * Created by MyPC on 21/04/2018.
 */

public class GifView extends View{
    private InputStream gifInputStream;
    private Movie gifMovie;
    private long movieStart;
    private long movieDuration;
    private int movieHeight;
    private int movieWidth;

    public GifView(Context context) {
        super(context);
        init(context);
    }

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GifView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     *
     * @param context
     */
    @SuppressLint("ResourceType")
    private void init(Context context) {
        setFocusable(true);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float f = metrics.widthPixels;
        Log.d("Width",("Width: " + f + "\nHeight: " + metrics.heightPixels));
        if (f <= 600.0f){
            gifInputStream = context.getResources().openRawResource(R.drawable.animation25);
        }else {
            gifInputStream = context.getResources().openRawResource(R.drawable.animation35);
        }
        gifMovie = Movie.decodeStream(gifInputStream);
        movieWidth = gifMovie.width();
        movieHeight = gifMovie.height();
        movieDuration = gifMovie.duration();
    }

    public long getMovieDuration(){
        return movieDuration;
    }

    public int getMovieHeight(){
        return movieHeight;
    }

    public int getMovieWidth(){
        return movieWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (movieStart == 0){
            movieStart = uptimeMillis;
        }
        if (gifMovie != null){
            int duration = gifMovie.duration();
            if (duration == 0){
                duration = 1000;
            }
            gifMovie.setTime((int) ((uptimeMillis - movieStart) % (duration)));
            gifMovie.draw(canvas,0.0f,0.0f);
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(movieWidth,movieHeight);
    }

}
