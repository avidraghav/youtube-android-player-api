package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.B;
import com.google.android.youtube.player.internal.Validators;

public class YouTubePlayerFragment extends Fragment implements Provider {
    private final YouTubePlayerFragment.a a = new YouTubePlayerFragment.a();
    private Bundle bundle;
    private YouTubePlayerView youTubePlayerView;
    private String d;
    private OnInitializedListener onInitializedListener;
    private boolean f;

    public static YouTubePlayerFragment newInstance() {
        return new YouTubePlayerFragment();
    }

    public YouTubePlayerFragment() {
    }

    @Override
    public void initialize(String developerKey, OnInitializedListener listener) {
        this.d = Validators.notEmpty(developerKey, "Developer key cannot be null or empty");
        this.onInitializedListener = listener;
        this.a();
    }

    private void a() {
        if (this.youTubePlayerView != null && this.onInitializedListener != null) {
            this.youTubePlayerView.a(this.f);
            this.youTubePlayerView.a(this.getActivity(), this, this.d, this.onInitializedListener, this.bundle);
            this.bundle = null;
            this.onInitializedListener = null;
        }
    }

    @Override
    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.bundle = var1 != null ? var1.getBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override
    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        this.youTubePlayerView = new YouTubePlayerView(this.getActivity(), (AttributeSet)null, 0, this.a);
        this.a();
        return this.youTubePlayerView;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.youTubePlayerView.a();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.youTubePlayerView.b();
    }

    @Override
    public void onPause() {
        this.youTubePlayerView.c();
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        Bundle var2 = this.youTubePlayerView != null ? this.youTubePlayerView.getBundle() : this.bundle;
        var1.putBundle("YouTubePlayerFragment.KEY_PLAYER_VIEW_STATE", var2);
    }

    @Override
    public void onStop() {
        this.youTubePlayerView.d();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        this.youTubePlayerView.c(this.getActivity().isFinishing());
        this.youTubePlayerView = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (this.youTubePlayerView != null) {
            Activity var1 = this.getActivity();
            this.youTubePlayerView.b(var1 == null || var1.isFinishing());
        }

        super.onDestroy();
    }

    private final class a implements B {
        private a() {
        }

        public final void initialize(YouTubePlayerView view, String developerKey, OnInitializedListener listener) {
            YouTubePlayerFragment.this.initialize(developerKey, YouTubePlayerFragment.this.onInitializedListener);
        }

        public final void a(YouTubePlayerView view) {
        }
    }
}
