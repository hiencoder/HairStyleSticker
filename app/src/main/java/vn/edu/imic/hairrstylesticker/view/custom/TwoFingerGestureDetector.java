package vn.edu.imic.hairrstylesticker.view.custom;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by MyPC on 27/04/2018.
 */

public abstract class TwoFingerGestureDetector extends BaseGestureDetector{
    protected float h;
    protected float i;
    protected float j;
    protected float k;
    private float mBottomSlopEdge;
    private float mCurrLen;
    private final float mEdgeSlop;
    private float mPrevLen;
    private float mRightSlopEdge;

    public TwoFingerGestureDetector(Context context) {
        super(context);
        this.mEdgeSlop = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float a(MotionEvent motionEvent, int i) {
        return i < motionEvent.getPointerCount() ? (motionEvent.getX() - motionEvent.getRawX()) + motionEvent.getX(i) : 0.0f;
    }

    protected static float b(MotionEvent motionEvent, int i) {
        return i < motionEvent.getPointerCount() ? (motionEvent.getY() - motionEvent.getRawY()) + motionEvent.getY(i) : 0.0f;
    }

    protected abstract void a(int i, MotionEvent motionEvent);

    protected void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.c;
        this.mCurrLen = -1.0f;
        this.mPrevLen = -1.0f;
        float x = motionEvent2.getX(0);
        float y = motionEvent2.getY(0);
        float x2 = motionEvent2.getX(1);
        float y2 = motionEvent2.getY(1) - y;
        this.h = x2 - x;
        this.i = y2;
        y2 = motionEvent.getX(0);
        x = motionEvent.getY(0);
        x = motionEvent.getY(1) - x;
        this.j = motionEvent.getX(1) - y2;
        this.k = x;
    }

    protected abstract void b(int i, MotionEvent motionEvent);

    protected boolean b(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.mRightSlopEdge = ((float) displayMetrics.widthPixels) - this.mEdgeSlop;
        this.mBottomSlopEdge = ((float) displayMetrics.heightPixels) - this.mEdgeSlop;
        float f = this.mEdgeSlop;
        float f2 = this.mRightSlopEdge;
        float f3 = this.mBottomSlopEdge;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a = a(motionEvent, 1);
        float b = b(motionEvent, 1);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2 = a < f || b < f || a > f2 || b > f3;
        return (z && z2) || z || z2;
    }

    public float getCurrentSpan() {
        if (this.mCurrLen == -1.0f) {
            this.mPrevLen = (float) Math.hypot((double) this.j, (double) this.k);
        }
        return this.mCurrLen;
    }

    public float getPreviousSpan() {
        if (this.mPrevLen == -1.0f) {
            this.mPrevLen = (float) Math.hypot((double) this.h, (double) this.i);
        }
        return this.mPrevLen;
    }

}
