package com.google.android.youtube.player.internal;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public final class YouTubePlayerFrameLayout extends FrameLayout {

    private static final String TAG = "YouTubePlayerFrameLayou";

    private final ProgressBar progressBar;
    private final TextView textView;

    public YouTubePlayerFrameLayout(Context context) {
        super(context, null, ApplicationUtils.getDefaultStyleAttribute(context));
        Log.d(TAG, "YouTubePlayerFrameLayout: Constructor called.");
        LocalizedYouTubePlayerTexts var2 = new LocalizedYouTubePlayerTexts(context);
        this.setBackgroundColor(Color.BLACK);
        this.progressBar = new ProgressBar(context);
        this.progressBar.setVisibility(GONE);
        this.addView(this.progressBar, new LayoutParams(-2, -2, Gravity.CENTER));
        int var3 = (int) (10.0F * context.getResources().getDisplayMetrics().density + 0.5F);
        this.textView = new TextView(context);
        this.textView.setTextAppearance(context, android.R.style.TextAppearance_Small);
        this.textView.setTextColor(-1);
        this.textView.setVisibility(GONE);
        this.textView.setPadding(var3, var3, var3, var3);
        this.textView.setGravity(Gravity.CENTER);
        this.textView.setText(var2.errorInitializingPlayer);
        this.addView(this.textView, new LayoutParams(-2, -2, Gravity.CENTER));
    }

    public final void stopLoading() {
        Log.d(TAG, "a: called.");
        this.progressBar.setVisibility(GONE);
        this.textView.setVisibility(GONE);
    }

    public final void startLoading() {
        Log.d(TAG, "startLoading: called.");
        this.progressBar.setVisibility(VISIBLE);
        this.textView.setVisibility(GONE);
    }

    public final void showError() {
        Log.d(TAG, "stopLoading: called.");
        this.progressBar.setVisibility(GONE);
        this.textView.setVisibility(VISIBLE);
    }

    @Override
    protected final void onMeasure(int width, int height) {
        Log.d(TAG, "onMeasure: called.");
        int widthMode = MeasureSpec.getMode(width);
        int heightMode = MeasureSpec.getMode(height);
        int widthSize = MeasureSpec.getSize(width);
        int heightSize = MeasureSpec.getSize(height);
        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            widthMode = widthSize;
            heightMode = heightSize;
        } else if (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.UNSPECIFIED) {
            widthMode = widthSize;
            heightMode = (int) (widthSize / 1.777F);
        } else if (heightMode == MeasureSpec.EXACTLY || heightMode == MeasureSpec.AT_MOST && widthMode == MeasureSpec.UNSPECIFIED) {
            heightMode = heightSize;
            widthMode = (int) (heightSize * 1.777F);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            if (heightSize < widthSize / 1.777F) {
                widthMode = (int) (heightSize * 1.777F);
                heightMode = heightSize;
            } else {
                widthMode = widthSize;
                heightMode = (int) (widthSize / 1.777F);
            }
        } else {
            widthMode = MeasureSpec.UNSPECIFIED;
            heightMode = MeasureSpec.UNSPECIFIED;
        }

        widthMode = resolveSize(widthMode, width);
        heightMode = resolveSize(heightMode, height);
        width = MeasureSpec.makeMeasureSpec(widthMode, MeasureSpec.EXACTLY);
        height = MeasureSpec.makeMeasureSpec(heightMode, MeasureSpec.EXACTLY);
        super.onMeasure(width, height);
    }
}
