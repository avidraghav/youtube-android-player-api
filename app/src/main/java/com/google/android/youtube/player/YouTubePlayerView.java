package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
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
import com.google.android.youtube.player.internal.YouTubePlayerImpl;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.Validators;
import com.google.android.youtube.player.internal.n;
import com.google.android.youtube.player.internal.y;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements Provider {
    private final OnGlobalFocusChangeListener globalFocusChangeListener;
    private final Set<View> b;
    private final YouTubePlayerView.b c;
    private com.google.android.youtube.player.internal.b d;
    private YouTubePlayerImpl youTubePlayer;
    private View f;
    private n g;
    private Provider provider;
    private Bundle bundle;
    private OnInitializedListener onInitializedListener;
    private boolean k;
    private boolean l;

    /**
     * Create a {@link YouTubePlayerView}.
     * <p>
     * Use this constructor to construct a {@link YouTubePlayerView} programmatically inside a
     * {@link YouTubeBaseActivity}.
     *
     * @param context The context this view should use. This must be a {@link YouTubeBaseActivity}.
     * @throws IllegalArgumentException if the context is not a {@link YouTubeBaseActivity}.
     */
    public YouTubePlayerView(Context context) {
        this(context, null);
    }

    /**
     * Create a {@link YouTubePlayerView}.
     * <p>
     * This constructor is for use by a LayoutInflater when the view is inflated from XML. This
     * version uses a default style of {@code 0}.
     *
     * @param context The context this view should use. This must be a {@link YouTubeBaseActivity}.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     * @throws IllegalArgumentException if the context is not a {@link YouTubeBaseActivity}.
     */
    public YouTubePlayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Create a {@link YouTubePlayerView}. This constructor is for use by a
     * {@link android.view.LayoutInflater} when the view is inflated from XML.
     *
     * @param context      The context this view should use. This must be a {@link YouTubeBaseActivity}.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr The default style to apply to this view.
     * @throws IllegalArgumentException if the context is not a {@link YouTubeBaseActivity}.
     */
    public YouTubePlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(Validators.notNull(context, "context cannot be null"), attrs, defStyleAttr);

        if (!(context instanceof YouTubeBaseActivity)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity which extends YouTubeBaseActivity as its context.");
        }

        YouTubePlayerView.b var4 = ((YouTubeBaseActivity) context).getA();
        this.c = Validators.notNull(var4, "listener cannot be null");
        if (this.getBackground() == null) {
            this.setBackgroundColor(Color.BLACK);
        }

        this.setClipToPadding(false);
        this.g = new n(context);
        this.requestTransparentRegion(this.g);
        this.addView(this.g);
        this.b = new HashSet<>();
        this.globalFocusChangeListener = new OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                if (YouTubePlayerView.this.youTubePlayer != null
                        && YouTubePlayerView.this.b.contains(newFocus)
                        && !YouTubePlayerView.this.b.contains(oldFocus)) {
                    YouTubePlayerView.this.youTubePlayer.g();
                }
            }
        };
    }

    @Override
    public final void initialize(String developerKey, OnInitializedListener listener) {
        Validators.notEmpty(developerKey, "Developer key cannot be null or empty");
        this.c.a(this, developerKey, listener);
    }

    /**
     * @deprecated
     */
    final void a(boolean var1) {
        if (var1 && VERSION.SDK_INT < 14) {
            y.a("Could not enable TextureView because API level is lower than 14", new Object[0]);
            this.k = false;
        } else {
            this.k = var1;
        }
    }

    final void a(final Activity var1, Provider var2, String var3, OnInitializedListener var4, Bundle var5) {
        if (this.youTubePlayer == null && this.onInitializedListener == null) {
            Validators.notNull(var1, "activity cannot be null");
            this.provider = Validators.notNull(var2, "provider cannot be null");
            this.onInitializedListener = Validators.notNull(var4, "listener cannot be null");
            this.bundle = var5;
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
        if (this.onInitializedListener != null) {
            this.onInitializedListener.onInitializationFailure(this.provider, var1);
            this.onInitializedListener = null;
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

    @Override
    public final void setPadding(int var1, int var2, int var3, int var4) {
    }

    @Override
    public final void setClipToPadding(boolean var1) {
    }

    @Override
    public final void addView(View var1) {
        this.a(var1);
        super.addView(var1);
    }

    @Override
    public final void addView(View var1, int var2) {
        this.a(var1);
        super.addView(var1, var2);
    }

    @Override
    public final void addView(View var1, int var2, LayoutParams var3) {
        this.a(var1);
        super.addView(var1, var2, var3);
    }

    @Override
    public final void addView(View var1, int var2, int var3) {
        this.a(var1);
        super.addView(var1, var2, var3);
    }

    @Override
    public final void addView(View var1, LayoutParams var2) {
        this.a(var1);
        super.addView(var1, var2);
    }

    @Override
    protected final void onMeasure(int var1, int var2) {
        if (this.getChildCount() > 0) {
            View var3;
            (var3 = this.getChildAt(0)).measure(var1, var2);
            this.setMeasuredDimension(var3.getMeasuredWidth(), var3.getMeasuredHeight());
        } else {
            this.setMeasuredDimension(0, 0);
        }
    }

    @Override
    protected final void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
        if (this.getChildCount() > 0) {
            this.getChildAt(0).layout(0, 0, var4 - var2, var5 - var3);
        }

    }

    @Override
    public final void onConfigurationChanged(Configuration var1) {
        super.onConfigurationChanged(var1);
        if (this.youTubePlayer != null) {
            this.youTubePlayer.a(var1);
        }

    }

    @Override
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getViewTreeObserver().addOnGlobalFocusChangeListener(this.globalFocusChangeListener);
    }

    @Override
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.globalFocusChangeListener);
    }

    @Override
    public final void clearChildFocus(View var1) {
        if (this.hasFocusable()) {
            this.requestFocus();
        } else {
            super.clearChildFocus(var1);
        }
    }

    @Override
    public final void requestChildFocus(View var1, View var2) {
        super.requestChildFocus(var1, var2);
        this.b.add(var2);
    }

    @Override
    public final void focusableViewAvailable(View var1) {
        super.focusableViewAvailable(var1);
        this.b.add(var1);
    }

    @Override
    public final void addFocusables(ArrayList<View> var1, int var2) {
        ArrayList var3 = new ArrayList();
        super.addFocusables(var3, var2);
        var1.addAll(var3);
        this.b.clear();
        this.b.addAll(var3);
    }

    @Override
    public final void addFocusables(ArrayList<View> views, int var2, int var3) {
        ArrayList<View> list = new ArrayList<>();
        super.addFocusables(list, var2, var3);
        views.addAll(list);
        this.b.clear();
        this.b.addAll(list);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent var1) {
        super.onTouchEvent(var1);
        return true;
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent event) {
        if (this.youTubePlayer != null) {
            if (event.getAction() == 0) {
                if (!this.youTubePlayer.a(event.getKeyCode(), event) && !super.dispatchKeyEvent(event)) {
                    return false;
                }

                return true;
            }

            if (event.getAction() == 1) {
                if (!this.youTubePlayer.b(event.getKeyCode(), event) && !super.dispatchKeyEvent(event)) {
                    return false;
                }

                return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }

    final Bundle getBundle() {
        return this.youTubePlayer == null ? this.bundle : this.youTubePlayer.h();
    }

    // TODO b = instance?
    interface b {

        // TODO a = initialize?
        void a(YouTubePlayerView view, String developerKey, OnInitializedListener listener);

        void a(YouTubePlayerView view);
    }
}
