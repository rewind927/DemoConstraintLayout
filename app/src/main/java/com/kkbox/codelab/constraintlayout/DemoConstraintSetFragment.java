package com.kkbox.codelab.constraintlayout;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DemoConstraintSetFragment extends Fragment {
    ConstraintLayout rootView;
    ConstraintSet originalConstraintSet = new ConstraintSet();
    ConstraintSet fullscreenConstrainSet = new ConstraintSet();
    boolean isFullscreen = false;

    public DemoConstraintSetFragment() {
        // Required empty public constructor
    }

    public static DemoConstraintSetFragment newInstance() {
        return new DemoConstraintSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullscreenConstrainSet.clone(getActivity(), R.layout.fragment_demo_constraint_set_fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ConstraintLayout) inflater.inflate(R.layout.fragment_demo_constraint_set, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.view_face).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(rootView);
                if (isFullscreen) {
                    originalConstraintSet.clone(getActivity(), R.layout.fragment_demo_constraint_set);
                    originalConstraintSet.applyTo(rootView);
                } else {
                    fullscreenConstrainSet.applyTo(rootView);
                }
                isFullscreen = !isFullscreen;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        originalConstraintSet.clone(getActivity(), R.layout.fragment_demo_constraint_set);
        originalConstraintSet.applyTo(rootView);
    }
}
