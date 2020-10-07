package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public final class n extends FrameLayout {
    private final ProgressBar a;
    private final TextView b;

    public n(Context var1) {
        super(var1, (AttributeSet)null, z.c(var1));
        m var2 = new m(var1);
        this.setBackgroundColor(-16777216);
        this.a = new ProgressBar(var1);
        this.a.setVisibility(8);
        this.addView(this.a, new LayoutParams(-2, -2, 17));
        int var3 = (int)(10.0F * var1.getResources().getDisplayMetrics().density + 0.5F);
        this.b = new TextView(var1);
        this.b.setTextAppearance(var1, 16973894);
        this.b.setTextColor(-1);
        this.b.setVisibility(8);
        this.b.setPadding(var3, var3, var3, var3);
        this.b.setGravity(17);
        this.b.setText(var2.a);
        this.addView(this.b, new LayoutParams(-2, -2, 17));
    }

    public final void a() {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
    }

    public final void b() {
        this.a.setVisibility(0);
        this.b.setVisibility(8);
    }

    public final void c() {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
    }

    protected final void onMeasure(int var1, int var2) {
        int var3 = MeasureSpec.getMode(var1);
        int var4 = MeasureSpec.getMode(var2);
        int var5 = MeasureSpec.getSize(var1);
        int var6 = MeasureSpec.getSize(var2);
        if (var3 == 1073741824 && var4 == 1073741824) {
            var3 = var5;
            var4 = var6;
        } else if (var3 == 1073741824 || var3 == -2147483648 && var4 == 0) {
            var3 = var5;
            var4 = (int)((float)var5 / 1.777F);
        } else if (var4 == 1073741824 || var4 == -2147483648 && var3 == 0) {
            var4 = var6;
            var3 = (int)((float)var6 * 1.777F);
        } else if (var3 == -2147483648 && var4 == -2147483648) {
            if ((float)var6 < (float)var5 / 1.777F) {
                var3 = (int)((float)var6 * 1.777F);
                var4 = var6;
            } else {
                var3 = var5;
                var4 = (int)((float)var5 / 1.777F);
            }
        } else {
            var3 = 0;
            var4 = 0;
        }

        var3 = resolveSize(var3, var1);
        var4 = resolveSize(var4, var2);
        var1 = MeasureSpec.makeMeasureSpec(var3, 1073741824);
        var2 = MeasureSpec.makeMeasureSpec(var4, 1073741824);
        super.onMeasure(var1, var2);
    }
}
