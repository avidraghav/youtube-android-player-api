package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements Provider {
    private final YouTubePlayerView.a a;
    private final Set<View> b;
    private final YouTubePlayerView.b c;
    private com.google.android.youtube.player.internal.b d;
    private YouTubePlayerImpl youTubePlayer;
    private View f;
    private n g;
    private Provider h;
    private Bundle i;
    private OnInitializedListener j;
    private boolean k;
    private boolean l;

    public YouTubePlayerView(Context var1) {
        this(var1, (AttributeSet)null);
    }

    public YouTubePlayerView(Context var1, AttributeSet var2) {
        this(var1, var2, 0);
    }

    public YouTubePlayerView(Context var1, AttributeSet var2, int var3) {
        if (!(var1 instanceof YouTubeBaseActivity)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
        } else {
            this(var1, var2, var3, ((YouTubeBaseActivity)var1).a());
        }
    }

    YouTubePlayerView(Context var1, AttributeSet var2, int var3, YouTubePlayerView.b var4) {
        super((Context)ab.a(var1, "context cannot be null"), var2, var3);
        this.c = (YouTubePlayerView.b)ab.a(var4, "listener cannot be null");
        if (this.getBackground() == null) {
            this.setBackgroundColor(-16777216);
        }

        this.setClipToPadding(false);
        this.g = new n(var1);
        this.requestTransparentRegion(this.g);
        this.addView(this.g);
        this.b = new HashSet();
        this.a = new YouTubePlayerView.a((byte)0);
    }

    public final void initialize(String developerKey, OnInitializedListener listener) {
        ab.a(developerKey, "Developer key cannot be null or empty");
        this.c.a(this, developerKey, listener);
    }

    /** @deprecated */
    final void a(boolean var1) {
        if (var1 && VERSION.SDK_INT < 14) {
            y.a("Could not enable TextureView because API level is lower than 14", new Object[0]);
            this.k = false;
        } else {
            this.k = var1;
        }
    }

    final void a(final Activity var1, Provider var2, String var3, OnInitializedListener var4, Bundle var5) {
        if (this.youTubePlayer == null && this.j == null) {
            ab.a(var1, "activity cannot be null");
            this.h = (Provider)ab.a(var2, "provider cannot be null");
            this.j = (OnInitializedListener)ab.a(var4, "listener cannot be null");
            this.i = var5;
            this.g.b();
            this.d = aa.a().a(this.getContext(), var3, new com.google.android.youtube.player.internal.t.a() {
                public final void a() {
                    if (YouTubePlayerView.this.d != null) {
                        YouTubePlayerView.a(YouTubePlayerView.this, var1);
                    }

                    YouTubePlayerView.b(YouTubePlayerView.this);
                }

                public final void b() {
                    if (!YouTubePlayerView.this.l && YouTubePlayerView.this.youTubePlayer != null) {
                        YouTubePlayerView.this.youTubePlayer.f();
                    }

                    YouTubePlayerView.this.g.a();
                    if (YouTubePlayerView.this.indexOfChild(YouTubePlayerView.this.g) < 0) {
                        YouTubePlayerView.this.addView(YouTubePlayerView.this.g);
                        YouTubePlayerView.this.removeView(YouTubePlayerView.this.f);
                    }

                    YouTubePlayerView.g(YouTubePlayerView.this);
                    YouTubePlayerView.h(YouTubePlayerView.this);
                    YouTubePlayerView.b(YouTubePlayerView.this);
                }
            }, new com.google.android.youtube.player.internal.t.b() {
                public final void a(YouTubeInitializationResult var1) {
                    YouTubePlayerView.this.a(var1);
                    YouTubePlayerView.b(YouTubePlayerView.this);
                }
            });
            this.d.e();
        }
    }

    private void a(YouTubeInitializationResult var1) {
        this.youTubePlayer = null;
        this.g.c();
        if (this.j != null) {
            this.j.onInitializationFailure(this.h, var1);
            this.j = null;
        }

    }

    final void a() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.b();
        }

    }

    final void b() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.c();
        }

    }

    final void c() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.d();
        }

    }

    final void d() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.e();
        }

    }

    final void b(boolean var1) {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.b(var1);
            this.c(var1);
        }

    }

    final void c(boolean var1) {
        this.l = true;
        if (this.youTubePlayer != null) {
            this.youTubePlayer.a(var1);
        }

    }

    private void a(View var1) {
        if (var1 != this.g && (this.youTubePlayer == null || var1 != this.f)) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    public final void setPadding(int var1, int var2, int var3, int var4) {
    }

    public final void setClipToPadding(boolean var1) {
    }

    public final void addView(View var1) {
        this.a(var1);
        super.addView(var1);
    }

    public final void addView(View var1, int var2) {
        this.a(var1);
        super.addView(var1, var2);
    }

    public final void addView(View var1, int var2, LayoutParams var3) {
        this.a(var1);
        super.addView(var1, var2, var3);
    }

    public final void addView(View var1, int var2, int var3) {
        this.a(var1);
        super.addView(var1, var2, var3);
    }

    public final void addView(View var1, LayoutParams var2) {
        this.a(var1);
        super.addView(var1, var2);
    }

    protected final void onMeasure(int var1, int var2) {
        if (this.getChildCount() > 0) {
            View var3;
            (var3 = this.getChildAt(0)).measure(var1, var2);
            this.setMeasuredDimension(var3.getMeasuredWidth(), var3.getMeasuredHeight());
        } else {
            this.setMeasuredDimension(0, 0);
        }
    }

    protected final void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
        if (this.getChildCount() > 0) {
            this.getChildAt(0).layout(0, 0, var4 - var2, var5 - var3);
        }

    }

    public final void onConfigurationChanged(Configuration var1) {
        super.onConfigurationChanged(var1);
        if (this.youTubePlayer != null) {
            this.youTubePlayer.a(var1);
        }

    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getViewTreeObserver().addOnGlobalFocusChangeListener(this.a);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.a);
    }

    public final void clearChildFocus(View var1) {
        if (this.hasFocusable()) {
            this.requestFocus();
        } else {
            super.clearChildFocus(var1);
        }
    }

    public final void requestChildFocus(View var1, View var2) {
        super.requestChildFocus(var1, var2);
        this.b.add(var2);
    }

    public final void focusableViewAvailable(View var1) {
        super.focusableViewAvailable(var1);
        this.b.add(var1);
    }

    public final void addFocusables(ArrayList<View> var1, int var2) {
        ArrayList var3 = new ArrayList();
        super.addFocusables(var3, var2);
        var1.addAll(var3);
        this.b.clear();
        this.b.addAll(var3);
    }

    public final void addFocusables(ArrayList<View> var1, int var2, int var3) {
        ArrayList var4 = new ArrayList();
        super.addFocusables(var4, var2, var3);
        var1.addAll(var4);
        this.b.clear();
        this.b.addAll(var4);
    }

    public final boolean onTouchEvent(MotionEvent var1) {
        super.onTouchEvent(var1);
        return true;
    }

    public final boolean dispatchKeyEvent(KeyEvent var1) {
        if (this.youTubePlayer != null) {
            if (var1.getAction() == 0) {
                if (!this.youTubePlayer.a(var1.getKeyCode(), var1) && !super.dispatchKeyEvent(var1)) {
                    return false;
                }

                return true;
            }

            if (var1.getAction() == 1) {
                if (!this.youTubePlayer.b(var1.getKeyCode(), var1) && !super.dispatchKeyEvent(var1)) {
                    return false;
                }

                return true;
            }
        }

        return super.dispatchKeyEvent(var1);
    }

    final Bundle e() {
        return this.youTubePlayer == null ? this.i : this.youTubePlayer.h();
    }

    private final class a implements OnGlobalFocusChangeListener {
        private a() {
        }

        public final void onGlobalFocusChanged(View var1, View var2) {
            if (YouTubePlayerView.this.youTubePlayer != null && YouTubePlayerView.this.b.contains(var2) && !YouTubePlayerView.this.b.contains(var1)) {
                YouTubePlayerView.this.youTubePlayer.g();
            }

        }
    }

    interface b {
        void a(YouTubePlayerView var1, String var2, OnInitializedListener var3);

        void a(YouTubePlayerView var1);
    }
}
