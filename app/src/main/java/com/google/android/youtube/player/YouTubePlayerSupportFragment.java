package com.google.android.youtube.player;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.B;
import com.google.android.youtube.player.internal.Validators;

public class YouTubePlayerSupportFragment extends Fragment implements Provider {
    private final YouTubePlayerSupportFragment.a a = new YouTubePlayerSupportFragment.a();
    private Bundle bundle;
    private YouTubePlayerView youTubePl;
    private String d;
    private OnInitializedListener onInitializedListener;
    private boolean f;

    public static YouTubePlayerSupportFragment newInstance() {
        return new YouTubePlayerSupportFragment();
    }

    public YouTubePlayerSupportFragment() {
    }

    public void initialize(String developerKey, OnInitializedListener listener) {
        this.d = Validators.notEmpty(developerKey, "Developer key cannot be null or empty");
        this.onInitializedListener = listener;
        this.a();
    }

    private void a() {
        if (this.youTubePl != null && this.onInitializedListener != null) {
            this.youTubePl.a(this.f);
            this.youTubePl.a(this.getActivity(), this, this.d, this.onInitializedListener, this.bundle);
            this.bundle = null;
            this.onInitializedListener = null;
        }

    }

    @Override
    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.bundle = var1 != null ? var1.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override
    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        this.youTubePl = new YouTubePlayerView(this.getActivity(), (AttributeSet)null, 0, this.a);
        this.a();
        return this.youTubePl;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.youTubePl.a();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.youTubePl.b();
    }

    @Override
    public void onPause() {
        this.youTubePl.c();
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle b) {
        super.onSaveInstanceState(b);
        Bundle var2 = this.youTubePl != null ? this.youTubePl.getBundle() : this.bundle;
        b.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", var2);
    }

    @Override
    public void onStop() {
        this.youTubePl.d();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        this.youTubePl.c(this.getActivity().isFinishing());
        this.youTubePl = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (this.youTubePl != null) {
            FragmentActivity var1 = this.getActivity();
            this.youTubePl.b(var1 == null || var1.isFinishing());
        }

        super.onDestroy();
    }

    private final class a implements B {
        private a() {
        }

        public final void initialize(YouTubePlayerView view, String developerKey, OnInitializedListener listener) {
            YouTubePlayerSupportFragment.this.initialize(developerKey, YouTubePlayerSupportFragment.this.onInitializedListener);
        }

        public final void a(YouTubePlayerView view) {
        }
    }
}
