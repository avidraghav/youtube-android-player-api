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
import com.google.android.youtube.player.impl.RemoteEmbeddedPlayer;
import com.google.android.youtube.player.impl.YouTubePlayerImpl;
import com.google.android.youtube.player.internal.IEmbeddedPlayer;
import com.google.android.youtube.player.network.Client;
import com.google.android.youtube.player.network.ConnectionClient;
import com.google.android.youtube.player.utils.Validators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class YouTubePlayerView extends ViewGroup implements Provider {

    private final OnGlobalFocusChangeListener globalFocusChangeListener;
    private final YouTubePlayerViewInitializer listener;
    private Set<View> focusedViews = new HashSet<>();
    private ConnectionClient client;
    private YouTubePlayerImpl youTubePlayer;

    /**
     * The playerView is the actual frame layout where the video is played.
     */
    private View playerView;
    private YouTubePlayerFrameLayout frameLayout;
    private Provider provider;
    private Bundle bundle;
    private OnInitializedListener onInitializedListener;
    private boolean k;
    private boolean isReleased;

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
     * @param listener     TODO Rename and describe the parameter
     * @throws IllegalArgumentException if the context is not a {@link YouTubeBaseActivity}.
     */
    YouTubePlayerView(final Context context, final AttributeSet attrs, final int defStyleAttr, YouTubePlayerViewInitializer listener) {
        super(Validators.notNull(context, "context cannot be null"), attrs, defStyleAttr);

        if (!(context instanceof YouTubeBaseActivity)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity which extends YouTubeBaseActivity as its context.");
        }

        if (listener == null) listener = ((YouTubeBaseActivity) context).getViewInitializer();
        this.listener = Validators.notNull(listener, "listener cannot be null");
        if (this.getBackground() == null) {
            this.setBackgroundColor(Color.BLACK);
        }

        this.setClipToPadding(false);
        this.frameLayout = new YouTubePlayerFrameLayout(context);
        this.requestTransparentRegion(this.frameLayout);
        this.addView(this.frameLayout);
        this.globalFocusChangeListener = new OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                if (youTubePlayer != null
                        && focusedViews.contains(newFocus)
                        && !focusedViews.contains(oldFocus)) {
                    youTubePlayer.kk();
                }
            }
        };
    }

    private static void initialize(final YouTubePlayerView youTubePlayerView, final Activity activity) {
        try {
            IEmbeddedPlayer player = LinkedFactory.getInstance().getPlayer(activity, youTubePlayerView.client, youTubePlayerView.k);
            youTubePlayerView.youTubePlayer = new YouTubePlayerImpl(youTubePlayerView.client, player);
            youTubePlayerView.playerView = youTubePlayerView.youTubePlayer.getPlayerView();
            youTubePlayerView.addView(youTubePlayerView.playerView);
            youTubePlayerView.removeView(youTubePlayerView.frameLayout);
            youTubePlayerView.listener.onViewInitialized(youTubePlayerView);
            if (youTubePlayerView.onInitializedListener != null) {
                boolean isBundleSet = false;
                if (youTubePlayerView.bundle != null) {
                    isBundleSet = youTubePlayerView.youTubePlayer.setBundle(youTubePlayerView.bundle);
                    youTubePlayerView.bundle = null;
                }
                youTubePlayerView.onInitializedListener.onInitializationSuccess(youTubePlayerView.provider, youTubePlayerView.youTubePlayer, isBundleSet);
                youTubePlayerView.onInitializedListener = null;
            }
        } catch (RemoteEmbeddedPlayer.RemotePlayerException e) {
            Log.w("YouTubePlayerAPI", "Error creating YouTubePlayerView", e);
            youTubePlayerView.onInitializationCompleted(YouTubeInitializationResult.INTERNAL_ERROR);
        }
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
        this.listener.initializeView(this, developerKey, listener);
    }

    final void initialize(final Activity activity, Provider provider, String developerKey, OnInitializedListener listener, Bundle bundle) {
        if (this.youTubePlayer == null && this.onInitializedListener == null) {
            Validators.notNull(activity, "activity cannot be null");
            this.provider = Validators.notNull(provider, "provider cannot be null");
            this.onInitializedListener = Validators.notNull(listener, "listener cannot be null");
            this.bundle = bundle;
            this.frameLayout.startLoading();
            this.client = LinkedFactory.getInstance().getClient(this.getContext(), developerKey, new Client.Connection() {
                public final void bind() {

                    if (client != null) {
                        YouTubePlayerView.initialize(YouTubePlayerView.this, activity);
                    }

                    client = null;
                }

                public final void release() {
                    if (!isReleased && youTubePlayer != null) {
                        youTubePlayer.stop();
                    }

                    frameLayout.stopLoading();
                    if (indexOfChild(frameLayout) < 0) {
                        addView(frameLayout);
                        removeView(playerView);
                    }

                    client = null;
                    youTubePlayer = null;
                    playerView = null;
                }
            }, new Client.OnInitializationResult() {
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
        this.frameLayout.showError();
        if (this.onInitializedListener != null) {
            this.onInitializedListener.onInitializationFailure(this.provider, result);
            this.onInitializedListener = null;
        }

    }

    final void onStart() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.onStart();
        }
    }

    final void onResume() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.onResume();
        }
    }

    final void onPause() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.onPause();
        }
    }

    final void onStop() {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.onStop();
        }
    }

    final void release(boolean isFinishing) {
        if (this.youTubePlayer != null) {
            this.youTubePlayer.stop(isFinishing);
            this.stopSelf(isFinishing);
        }
    }

    final void stopSelf(boolean isFinishing) {
        this.isReleased = true;
        if (this.youTubePlayer != null) {
            this.youTubePlayer.release(isFinishing);
        }
    }

    private void addChildView(View view) {
        if (view != this.frameLayout && (this.youTubePlayer == null || view != this.playerView)) {
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
        this.addChildView(child);
        super.addView(child);
    }

    @Override
    public final void addView(View child, int index) {
        this.addChildView(child);
        super.addView(child, index);
    }

    @Override
    public final void addView(View child, int index, LayoutParams params) {
        this.addChildView(child);
        super.addView(child, index, params);
    }

    @Override
    public final void addView(View child, int width, int height) {
        this.addChildView(child);
        super.addView(child, width, height);
    }

    @Override
    public final void addView(View child, LayoutParams params) {
        this.addChildView(child);
        super.addView(child, params);
    }


    @Override
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.getChildCount() > 0) {
            View view;
            (view = this.getChildAt(0)).measure(widthMeasureSpec, heightMeasureSpec);
            this.setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        } else {
            this.setMeasuredDimension(0, 0);
        }
    }

    @Override
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.getChildCount() > 0) {
            this.getChildAt(0).layout(0, 0, right - left, bottom - top);
        }
    }

    @Override
    public final void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        if (this.youTubePlayer != null) {
            this.youTubePlayer.onConfigurationChanged(config);
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
    public final void clearChildFocus(View child) {
        if (this.hasFocusable()) {
            this.requestFocus();
        } else {
            super.clearChildFocus(child);
        }
    }

    @Override
    public final void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        this.focusedViews.add(focused);
    }

    @Override
    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.focusedViews.add(view);
    }

    @Override
    public final void addFocusables(ArrayList<View> views, int direction) {
        ArrayList<View> focusableViews = new ArrayList<>();
        super.addFocusables(focusableViews, direction);
        views.addAll(focusableViews);
        this.focusedViews.clear();
        this.focusedViews.addAll(focusableViews);
    }

    @Override
    public final void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        ArrayList<View> focusableViews = new ArrayList<>();
        super.addFocusables(focusableViews, direction, focusableMode);
        views.addAll(focusableViews);
        this.focusedViews.clear();
        this.focusedViews.addAll(focusableViews);
    }

    @Override
    public final boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        return true;
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent event) {
        if (this.youTubePlayer != null) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                return this.youTubePlayer.dispatchKeyEventDown(event.getKeyCode(), event) || super.dispatchKeyEvent(event);
            }

            if (event.getAction() == KeyEvent.ACTION_UP) {
                return this.youTubePlayer.dispatchKeyEventUp(event.getKeyCode(), event) || super.dispatchKeyEvent(event);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    final Bundle getBundle() {
        return this.youTubePlayer == null ? this.bundle : this.youTubePlayer.getBundle();
    }

    interface YouTubePlayerViewInitializer {

        void initializeView(YouTubePlayerView view, String developerKey, OnInitializedListener listener);

        void onViewInitialized(YouTubePlayerView view);
    }
}
