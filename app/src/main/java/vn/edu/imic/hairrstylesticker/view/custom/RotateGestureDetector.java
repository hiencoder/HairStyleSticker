package vn.edu.imic.hairrstylesticker.view.custom;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by MyPC on 27/04/2018.
 */

public class RotateGestureDetector extends TwoFingerGestureDetector{
    private final OnRotateGestureListener mListener;
    private boolean mSloppyGesture;

    public interface OnRotateGestureListener {
        boolean onRotate(RotateGestureDetector rotateGestureDetector);

        boolean onRotateBegin(RotateGestureDetector rotateGestureDetector);

        void onRotateEnd(RotateGestureDetector rotateGestureDetector);
    }

    public static class SimpleOnRotateGestureListener implements OnRotateGestureListener {
        public boolean onRotate(RotateGestureDetector rotateGestureDetector) {
            return false;
        }

        public boolean onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            return true;
        }

        public void onRotateEnd(RotateGestureDetector rotateGestureDetector) {
        }
    }

    public RotateGestureDetector(Context context, OnRotateGestureListener onRotateGestureListener) {
        super(context);
        this.mListener = onRotateGestureListener;
    }

    protected void a() {
        super.a();
        this.mSloppyGesture = false;
    }

    protected void a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                if (this.mSloppyGesture) {
                    this.mSloppyGesture = b(motionEvent);
                    if (!this.mSloppyGesture) {
                        this.b = this.mListener.onRotateBegin(this);
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
                    this.b = this.mListener.onRotateBegin(this);
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

    protected void b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                a(motionEvent);
                if (this.e / this.f > 0.67f && this.mListener.onRotate(this)) {
                    this.c.recycle();
                    this.c = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            case 3:
                if (!this.mSloppyGesture) {
                    this.mListener.onRotateEnd(this);
                }
                a();
                return;
            case 6:
                a(motionEvent);
                if (!this.mSloppyGesture) {
                    this.mListener.onRotateEnd(this);
                }
                a();
                return;
            default:
                return;
        }
    }

    public float getRotationDegreesDelta() {
        return (float) (((Math.atan2((double) this.i, (double) this.h) - Math.atan2((double) this.k, (double) this.j)) * 180.0d) / 3.141592653589793d);
    }
}
