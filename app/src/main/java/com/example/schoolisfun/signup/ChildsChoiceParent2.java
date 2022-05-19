package com.example.schoolisfun.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolisfun.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildsChoiceParent2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildsChoiceParent2 extends Fragment {

    public ChildsChoiceParent2() {
        // Required empty public constructor
    }

    public static ChildsChoiceParent2 newInstance(String param1, String param2) {
        ChildsChoiceParent2 fragment = new ChildsChoiceParent2();
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
        return inflater.inflate(R.layout.fragment_childs_choice_parent2, container, false);
    }
}