package com.kkbox.codelab.constraintlayout;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DemoConstraintSetFragment extends Fragment {
    ConstraintLayout rootView;

    public DemoConstraintSetFragment() {
        // Required empty public constructor
    }

    public static DemoConstraintSetFragment newInstance() {
        return new DemoConstraintSetFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ConstraintLayout) inflater.inflate(R.layout.fragment_demo_constraint_set, container, false);
        return rootView;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getActivity(), R.layout.fragment_demo_constraint_set);
        constraintSet.applyTo(rootView);
    }
}
