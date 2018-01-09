package com.kkbox.codelab.constraintlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DemoBarrierFragment extends Fragment {

    private Button button1;
    private Button button2;
    private Button button3;

    public DemoBarrierFragment() {
        // Required empty public constructor
    }

    public static DemoBarrierFragment newInstance() {
        DemoBarrierFragment fragment = new DemoBarrierFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_demo_barrier, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        button1 = getActivity().findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setText(getRandomNumberString());
            }
        });
        button2 = getActivity().findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setText(getRandomNumberString());
            }
        });
        button3 = getActivity().findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button3.setText(getRandomNumberString());
            }
        });
    }

    private String getRandomNumberString() {
        int rnd = (int) (Math.random() * 24)+1;
        String text="";
        for (int i =0 ; i < rnd ;i++) {
            text+=i;
        }
        return text;
    }
}
