package apkmarvel.loadingdot;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jcf on 6/22/2016.
 */
public class LoadingTextView extends LinearLayout {
    private ObjectAnimator[] objectAnimator = new ObjectAnimator[3];
    private TextView[] textView = new TextView[3];
    public LoadingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        for (int i = 0; i < objectAnimator.length; i++) {
            textView[i] = new TextView(context);
            textView[i].setText(".");
            textView[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
            textView[i].setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            addView(textView[i]);
            objectAnimator[i] = ObjectAnimator.ofFloat(textView[i], "translationY", 0, -40.0f);
            objectAnimator[i].setRepeatCount(-1);
            objectAnimator[i].setRepeatMode(ValueAnimator.REVERSE);
            objectAnimator[i].setDuration(300);
            objectAnimator[i].setStartDelay(100 * i);
            objectAnimator[i].start();
        }
    }
}
