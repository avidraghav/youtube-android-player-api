package com.google.android.youtube.player;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView.b;

public class YouTubePlayerSupportFragment extends Fragment implements Provider {
    private final YouTubePlayerSupportFragment.a a = new YouTubePlayerSupportFragment.a((byte)0);
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
        this.d = ab.a(developerKey, "Developer key cannot be null or empty");
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

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.bundle = var1 != null ? var1.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
        this.youTubePl = new YouTubePlayerView(this.getActivity(), (AttributeSet)null, 0, this.a);
        this.a();
        return this.youTubePl;
    }

    public void onStart() {
        super.onStart();
        this.youTubePl.a();
    }

    public void onResume() {
        super.onResume();
        this.youTubePl.b();
    }

    public void onPause() {
        this.youTubePl.c();
        super.onPause();
    }

    public void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        Bundle var2 = this.youTubePl != null ? this.youTubePl.getBundle() : this.bundle;
        var1.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", var2);
    }

    public void onStop() {
        this.youTubePl.d();
        super.onStop();
    }

    public void onDestroyView() {
        this.youTubePl.c(this.getActivity().isFinishing());
        this.youTubePl = null;
        super.onDestroyView();
    }

    public void onDestroy() {
        if (this.youTubePl != null) {
            FragmentActivity var1 = this.getActivity();
            this.youTubePl.b(var1 == null || var1.isFinishing());
        }

        super.onDestroy();
    }

    private final class a implements b {
        private a() {
        }

        public final void a(YouTubePlayerView var1, String var2, OnInitializedListener var3) {
            YouTubePlayerSupportFragment.this.initialize(var2, YouTubePlayerSupportFragment.this.onInitializedListener);
        }

        public final void a(YouTubePlayerView var1) {
        }
    }
}
