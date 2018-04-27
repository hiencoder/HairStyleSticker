package vn.edu.imic.hairrstylesticker.view.custom;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by MyPC on 27/04/2018.
 */

public abstract class BaseGestureDetector {
    protected final Context a;
    protected boolean b;
    protected MotionEvent c;
    protected MotionEvent d;
    protected float e;
    protected float f;
    protected long g;

    public BaseGestureDetector(Context context) {
        this.a = context;
    }

    protected void a() {
        if (this.c != null) {
            this.c.recycle();
            this.c = null;
        }
        if (this.d != null) {
            this.d.recycle();
            this.d = null;
        }
        this.b = false;
    }

    protected abstract void a(int i, MotionEvent motionEvent);

    protected void a(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.c;
        if (this.d != null) {
            this.d.recycle();
            this.d = null;
        }
        this.d = MotionEvent.obtain(motionEvent);
        this.g = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.e = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    protected abstract void b(int i, MotionEvent motionEvent);

    public long getEventTime() {
        return this.d.getEventTime();
    }

    public long getTimeDelta() {
        return this.g;
    }

    public boolean isInProgress() {
        return this.b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.b) {
            b(action, motionEvent);
        } else {
            a(action, motionEvent);
        }
        return true;
    }

}
