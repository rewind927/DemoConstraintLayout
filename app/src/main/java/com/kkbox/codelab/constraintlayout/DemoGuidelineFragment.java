package com.kkbox.codelab.constraintlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Guideline;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class DemoGuidelineFragment extends Fragment {

    private Guideline guidelinePercent;
    private SeekBar seekbar;

    public DemoGuidelineFragment() {
        // Required empty public constructor
    }

    public static DemoGuidelineFragment newInstance() {
        DemoGuidelineFragment fragment = new DemoGuidelineFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guideline, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        seekbar = view.findViewById(R.id.seekbar);
        seekbar.setMax(100);
        seekbar.setProgress(87);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                guidelinePercent.setGuidelinePercent((float) i / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        guidelinePercent = view.findViewById(R.id.guideline_percent);

    }
}
