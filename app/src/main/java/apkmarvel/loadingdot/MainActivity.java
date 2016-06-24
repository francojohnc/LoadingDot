package apkmarvel.loadingdot;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ObjectAnimator[] objectAnimator = new ObjectAnimator[3];
    private TextView[] textView = new TextView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout LL = new LinearLayout(this);
        LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LL.setOrientation(LinearLayout.HORIZONTAL);
        LL.setLayoutParams(LLParams);
        for (int i = 0; i < objectAnimator.length; i++) {
            textView[i] = new TextView(this);
            textView[i].setText(".");
            textView[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
            LL.addView(textView[i]);
            objectAnimator[i] = ObjectAnimator.ofFloat(textView[i], "translationY", 0, -40.0f);
            objectAnimator[i].setRepeatCount(-1);
            objectAnimator[i].setRepeatMode(ValueAnimator.REVERSE);
            objectAnimator[i].setDuration(300);
            objectAnimator[i].setStartDelay(100 * i);
            objectAnimator[i].start();
        }
        setContentView(LL);
    }
}
