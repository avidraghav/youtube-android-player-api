package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.internal.ConnectionClient;
import com.google.android.youtube.player.internal.IEmbeddedPlayer;
import com.google.android.youtube.player.internal.RemoteEmbeddedPlayer;
import com.google.android.youtube.player.internal.Validators;
import com.google.android.youtube.player.internal.YouTubePlayerFrameLayout;
import com.google.android.youtube.player.internal.YouTubePlayerImpl;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.t;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements Provider {
    private final OnGlobalFocusChangeListener globalFocusChangeListener;
    private Set<View> focusedViews;
    private final B c;
    private ConnectionClient client;
    private YouTubePlayerImpl youTubePlayer;
    private View f;
    private YouTubePlayerFrameLayout frameLayout;
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
    public YouTubePlayerView(Context context, final AttributeSet attrs, final int defStyleAttr) {
        this(context, attrs, defStyleAttr, null);
    }

    /**
     * Create a {@link YouTubePlayerView}. This constructor is for use by a
     * {@link android.view.LayoutInflater} when the view is inflated from XML.
     *
     * @param context      The context this view should use. This must be a {@link YouTubeBaseActivity}.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr The default style to apply to this view.
     * @param t            TODO Rename and describe the parameter
     * @throws IllegalArgumentException if the context is not a {@link YouTubeBaseActivity}.
     */
    YouTubePlayerView(final Context context, final AttributeSet attrs, final int defStyleAttr, B t) {
        super(Validators.notNull(context, "context cannot be null"), attrs, defStyleAttr);

        if (!(context instanceof YouTubeBaseActivity)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity which extends YouTubeBaseActivity as its context.");
        }

        if (t == null) t = ((YouTubeBaseActivity) context).getA();
        this.c = Validators.notNull(t, "listener cannot be null");
        if (this.getBackground() == null) {
            this.setBackgroundColor(Color.BLACK);
        }

        this.setClipToPadding(false);
        this.frameLayout = new YouTubePlayerFrameLayout(context);
        this.requestTransparentRegion(this.frameLayout);
        this.addView(this.frameLayout);
        this.focusedViews = new HashSet<>();
        this.globalFocusChangeListener = new OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                if (youTubePlayer != null
                        && focusedViews.contains(newFocus)
                        && !focusedViews.contains(oldFocus)) {
                    youTubePlayer.g();
                }
            }
        };
    }

    @Deprecated
    final void a(final boolean k) {
        if (k && Build.VERSION.SDK_INT < 14) {
            Log.w("YouTubePlayerAPI", "Could not enable TextureView because API level is lower than 14");
            this.k = false;
            return;
        }
        this.k = k;
    }

    @Override
    public final void initialize(String developerKey, OnInitializedListener listener) {
        Validators.notEmpty(developerKey, "Developer key cannot be null or empty");
        this.c.initialize(this, developerKey, listener);
    }

    private static void a(final YouTubePlayerView youTubePlayerView, final Activity activity) {
        IEmbeddedPlayer player;
        try {
            player = aa.getInstance().a(activity, youTubePlayerView.client, youTubePlayerView.k);
        } catch (RemoteEmbeddedPlayer.RemotePlayerException e) {
            Log.w("YouTubePlayerAPI", "Error creating YouTubePlayerView", e);
            youTubePlayerView.onInitializationCompleted(YouTubeInitializationResult.INTERNAL_ERROR);
            return;
        }
        youTubePlayerView.youTubePlayer = new YouTubePlayerImpl(youTubePlayerView.client, player);
        youTubePlayerView.addView(youTubePlayerView.f = youTubePlayerView.youTubePlayer.a());
        youTubePlayerView.removeView((View) youTubePlayerView.frameLayout);
        youTubePlayerView.c.a(youTubePlayerView);
        if (youTubePlayerView.onInitializedListener != null) {
            boolean a3 = false;
            if (youTubePlayerView.bundle != null) {
                a3 = youTubePlayerView.youTubePlayer.a(youTubePlayerView.bundle);
                youTubePlayerView.bundle = null;
            }
            youTubePlayerView.onInitializedListener.onInitializationSuccess(youTubePlayerView.provider, youTubePlayerView.youTubePlayer, a3);
            youTubePlayerView.onInitializedListener = null;
        }
    }

    final void a(final Activity activity, Provider provider, String developerKey, OnInitializedListener listener, Bundle bundle) {
        if (this.youTubePlayer == null && this.onInitializedListener == null) {
            Validators.notNull(activity, "activity cannot be null");
            this.provider = Validators.notNull(provider, "provider cannot be null");
            this.onInitializedListener = Validators.notNull(listener, "listener cannot be null");
            this.bundle = bundle;
            this.frameLayout.startLoading();
            this.client = aa.getInstance().a(this.getContext(), developerKey, new t.C() {
                public final void a() {

                    if (client != null) {
                        YouTubePlayerView.a(YouTubePlayerView.this, activity);
                    }

                    focusedViews = null;
                }

                public final void b() {
                    if (!l && youTubePlayer != null) {
                        youTubePlayer.f();
                    }

                    frameLayout.a();
                    if (indexOfChild(frameLayout) < 0) {
                        addView(frameLayout);
                        removeView(f);
                    }

                    client = null;
                    youTubePlayer = null;
                    f = null;
                }
            }, new t.OnInitializationResult() {
                public final void onResult(YouTubeInitializationResult result) {
                    onInitializationCompleted(result);
                    client = null;
                }
            });
            this.client.connect();
        }
    }

    private void onInitializationCompleted(YouTubeInitializationResult result) {
        this.youTubePlayer = null;
        this.frameLayout.stopLoading();
        if (this.onInitializedListener != null) {
            this.onInitializedListener.onInitializationFailure(this.provider, result);
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

    // TODO Called from within addView / checkIfSelf?
    private void a(View view) {
        if (view != this.frameLayout && (this.youTubePlayer == null || view != this.f)) {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        }
    }

    @Override
    public final void setPadding(int left, int top, int right, int bottom) {
    }

    @Override
    public final void setClipToPadding(boolean clipToPadding) {
    }

    @Override
    public final void addView(View child) {
        this.a(child);
        super.addView(child);
    }

    @Override
    public final void addView(View child, int index) {
        this.a(child);
        super.addView(child, index);
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
    public final void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        this.focusedViews.add(focused);
    }

    @Override
    public final void focusableViewAvailable(View var1) {
        super.focusableViewAvailable(var1);
        this.focusedViews.add(var1);
    }

    @Override
    public final void addFocusables(ArrayList<View> views, int direction) {
        ArrayList<View> focusables = new ArrayList<>();
        super.addFocusables(focusables, direction);
        views.addAll(focusables);
        this.focusedViews.clear();
        this.focusedViews.addAll(focusables);
    }

    @Override
    public final void addFocusables(ArrayList<View> views, int var2, int var3) {
        ArrayList<View> list = new ArrayList<>();
        super.addFocusables(list, var2, var3);
        views.addAll(list);
        this.focusedViews.clear();
        this.focusedViews.addAll(list);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent var1) {
        super.onTouchEvent(var1);
        return true;
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent event) {
        if (this.youTubePlayer != null) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                return this.youTubePlayer.a(event.getKeyCode(), event) || super.dispatchKeyEvent(event);
            }

            if (event.getAction() == KeyEvent.ACTION_UP) {
                return this.youTubePlayer.b(event.getKeyCode(), event) || super.dispatchKeyEvent(event);
            }
        }

        return super.dispatchKeyEvent(event);
    }

    final Bundle getBundle() {
        return this.youTubePlayer == null ? this.bundle : this.youTubePlayer.h();
    }

    // TODO b = instantiation listener?
    interface B {

        void initialize(YouTubePlayerView view, String developerKey, OnInitializedListener listener);

        void a(YouTubePlayerView view);
    }
}
