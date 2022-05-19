package com.example.schoolisfun.signup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolisfun.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildsChoiceParent1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildsChoiceParent1 extends Fragment {

    private boolean clickP = true;
    private AutoCompleteTextView actvLevel;
    private ArrayList<String> chosenClasses;

    public ChildsChoiceParent1() {
        // Required empty public constructor
    }

    public static ChildsChoiceParent1 newInstance(String param1, String param2) {
        ChildsChoiceParent1 fragment = new ChildsChoiceParent1();
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
        View v = inflater.inflate(R.layout.fragment_childs_choice_parent1, container, false);

        actvLevel = (AutoCompleteTextView) v.findViewById(R.id.actvLevel);
        String[] levels = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> arrayAdapterLevel = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, levels);
        actvLevel.setAdapter(arrayAdapterLevel);

        LinearLayout choice = (LinearLayout) v.findViewById(R.id.choice);
        LinearLayout choice2 = (LinearLayout) v.findViewById(R.id.choice2);
        LinearLayout l = (LinearLayout) v.findViewById(R.id.linearLayout2);
        ViewGroup.LayoutParams test = l.getLayoutParams();

        choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickP){
                    l.setLayoutParams(new ViewGroup.LayoutParams(
                            0,
                            0));
                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice2.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

                    lpt.setMargins(dpLeft,dpTop,dpRight,0);

                }
                else{
                    l.setLayoutParams(test);
                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice2.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 220, getResources().getDisplayMetrics());
                    lpt.setMargins(dpLeft,dpTop,dpRight,0);
                }
                clickP = !clickP;
            }
        });

        return v;
    }
}