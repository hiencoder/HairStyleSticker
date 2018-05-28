package vn.edu.imic.hairrstylesticker.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by MyPC on 24/05/2018.
 */

public class VerticalSeekBar extends AppCompatSeekBar{

    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void a(Canvas canvas) {
        Drawable drawable = null;
        if (Build.VERSION.SDK_INT >= 16) {
            drawable = getThumb();
        }
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            canvas.save();
            canvas.rotate(90.0f, bounds.exactCenterX(), bounds.exactCenterY());
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    protected void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate((float) (-getHeight()), 0.0f);
        int i = Build.VERSION.SDK_INT;
        System.out.print("currentapiVersion" + i);
        if (i <= 23 && i >= 21) {
            a(canvas);
        }
        super.onDraw(canvas);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
            case 2:
                setProgress(getMax() - ((int) ((((float) getMax()) * motionEvent.getY()) / ((float) getHeight()))));
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;
        }
        return true;
    }

    public synchronized void setProgress(int i) {
        super.setProgress(i);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }
}
