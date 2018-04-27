package vn.edu.imic.hairrstylesticker.view.custom;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by MyPC on 27/04/2018.
 */

public class ShoveGestureDetector extends TwoFingerGestureDetector{
    private float mCurrAverageY;
    private final OnShoveGestureListener mListener;
    private float mPrevAverageY;
    private boolean mSloppyGesture;

    public interface OnShoveGestureListener {
        boolean onShove(ShoveGestureDetector shoveGestureDetector);

        boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector);
    }

    public static class SimpleOnShoveGestureListener implements OnShoveGestureListener {
        public boolean onShove(ShoveGestureDetector shoveGestureDetector) {
            return false;
        }

        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            return true;
        }

        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector) {
        }
    }

    public ShoveGestureDetector(Context context, OnShoveGestureListener onShoveGestureListener) {
        super(context);
        this.mListener = onShoveGestureListener;
    }

    protected void a() {
        super.a();
        this.mSloppyGesture = false;
        this.mPrevAverageY = 0.0f;
        this.mCurrAverageY = 0.0f;
    }

    protected void a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                if (this.mSloppyGesture) {
                    this.mSloppyGesture = b(motionEvent);
                    if (!this.mSloppyGesture) {
                        this.b = this.mListener.onShoveBegin(this);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                a();
                this.c = MotionEvent.obtain(motionEvent);
                this.g = 0;
                a(motionEvent);
                this.mSloppyGesture = b(motionEvent);
                if (!this.mSloppyGesture) {
                    this.b = this.mListener.onShoveBegin(this);
                    return;
                }
                return;
            case 6:
                if (!this.mSloppyGesture) {
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.c;
        this.mPrevAverageY = (motionEvent2.getY(1) + motionEvent2.getY(0)) / 2.0f;
        this.mCurrAverageY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    protected void b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                a(motionEvent);
                if (this.e / this.f > 0.67f && Math.abs(getShovePixelsDelta()) > 0.5f && this.mListener.onShove(this)) {
                    this.c.recycle();
                    this.c = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            case 3:
                if (!this.mSloppyGesture) {
                    this.mListener.onShoveEnd(this);
                }
                a();
                return;
            case 6:
                a(motionEvent);
                if (!this.mSloppyGesture) {
                    this.mListener.onShoveEnd(this);
                }
                a();
                return;
            default:
                return;
        }
    }

    protected boolean b(MotionEvent motionEvent) {
        if (super.b(motionEvent)) {
            return true;
        }
        double abs = Math.abs(Math.atan2((double) this.k, (double) this.j));
        return (0.0d >= abs || abs >= 0.3499999940395355d) && (2.7899999618530273d >= abs || abs >= 3.141592653589793d);
    }

    public float getShovePixelsDelta() {
        return this.mCurrAverageY - this.mPrevAverageY;
    }

}
