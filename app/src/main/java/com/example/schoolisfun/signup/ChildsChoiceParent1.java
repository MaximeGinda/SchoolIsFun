package com.example.schoolisfun.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.schoolisfun.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildsChoiceParent1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildsChoiceParent1 extends Fragment {

    private boolean clickP = true;
    private boolean clickPB2 = false;
    private boolean clickPB3 = false;
    private AutoCompleteTextView actvLevel;
    private AutoCompleteTextView actvLevel2;
    private AutoCompleteTextView actvLevel3;
    private ArrayList<String> chosenClasses;
    private int count = 1;

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

        actvLevel = (AutoCompleteTextView) v.findViewById(R.id.actvLevelBT1);
        actvLevel2 = (AutoCompleteTextView) v.findViewById(R.id.actvLevelBT2);
        actvLevel3 = (AutoCompleteTextView) v.findViewById(R.id.actvLevelBT3);
        String[] levels = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> arrayAdapterLevel = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, levels);
        actvLevel.setAdapter(arrayAdapterLevel);
        actvLevel2.setAdapter(arrayAdapterLevel);
        actvLevel3.setAdapter(arrayAdapterLevel);

        LinearLayout choice = (LinearLayout) v.findViewById(R.id.choice);
        LinearLayout choice2 = (LinearLayout) v.findViewById(R.id.choice2);
        LinearLayout choice3 = (LinearLayout) v.findViewById(R.id.choice3);
        LinearLayout l = (LinearLayout) v.findViewById(R.id.linearLayoutBT1);
        LinearLayout l2 = (LinearLayout) v.findViewById(R.id.linearLayoutBT2);
        LinearLayout l3 = (LinearLayout) v.findViewById(R.id.linearLayoutBT3);
        ViewGroup.LayoutParams L1param = l.getLayoutParams();
        ViewGroup.LayoutParams L2param = l2.getLayoutParams();
        ViewGroup.LayoutParams L3param = l3.getLayoutParams();
        l2.setLayoutParams(new ViewGroup.LayoutParams(0,0));
        l3.setLayoutParams(new ViewGroup.LayoutParams(0,0));

        ImageView i1 = (ImageView) v.findViewById(R.id.imageViewBT1);
        ImageView i2 = (ImageView) v.findViewById(R.id.imageViewBT2);
        ImageView i3 = (ImageView) v.findViewById(R.id.imageViewBT3);

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

                    final ViewGroup.MarginLayoutParams lpt2 =(ViewGroup.MarginLayoutParams)choice2.getLayoutParams();
                    int dpLeft2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt2.setMargins(dpLeft2,dpTop2,dpRight2,0);

                    i1.setImageResource(R.drawable.ic_baseline_arrow_right_24);
                }
                else{
                    l.setLayoutParams(L1param);
                    l2.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                    l3.setLayoutParams(new ViewGroup.LayoutParams(0, 0));

                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice2.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 260, getResources().getDisplayMetrics());
                    lpt.setMargins(dpLeft,dpTop,dpRight,0);

                    final ViewGroup.MarginLayoutParams lpt2 =(ViewGroup.MarginLayoutParams)choice3.getLayoutParams();
                    int dpLeft2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt2.setMargins(dpLeft2,dpTop2,dpRight2,0);

                    i1.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
                    i2.setImageResource(R.drawable.ic_baseline_arrow_right_24);
                    i3.setImageResource(R.drawable.ic_baseline_arrow_right_24);

                    clickPB2 = false;
                    clickPB3 = false;
                }
                clickP = !clickP;
            }
        });


        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickPB2){
                    l2.setLayoutParams(new ViewGroup.LayoutParams(
                            0,
                            0));
                    i2.setImageResource(R.drawable.ic_baseline_arrow_right_24);

                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice3.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt.setMargins(dpLeft,dpTop,dpRight,0);
                }
                else{
                    l2.setLayoutParams(L2param);
                    l.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                    l3.setLayoutParams(new ViewGroup.LayoutParams(0, 0));

                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice3.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 260, getResources().getDisplayMetrics());
                    lpt.setMargins(dpLeft,dpTop,dpRight,0);

                    final ViewGroup.MarginLayoutParams lpt2 =(ViewGroup.MarginLayoutParams)choice2.getLayoutParams();
                    int dpLeft2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt2.setMargins(dpLeft2,dpTop2,dpRight2,0);

                    i2.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
                    i1.setImageResource(R.drawable.ic_baseline_arrow_right_24);
                    i3.setImageResource(R.drawable.ic_baseline_arrow_right_24);

                    clickP = false;
                    clickPB3 = false;
                }
                clickPB2 = !clickPB2;
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickPB3){
                    l3.setLayoutParams(new ViewGroup.LayoutParams(
                            0,
                            0));

                    i3.setImageResource(R.drawable.ic_baseline_arrow_right_24);

                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice3.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt.setMargins(dpLeft,dpTop,dpRight,0);

                }
                else{
                    l3.setLayoutParams(L3param);
                    l.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                    l2.setLayoutParams(new ViewGroup.LayoutParams(0, 0));

                    final ViewGroup.MarginLayoutParams lpt =(ViewGroup.MarginLayoutParams)choice3.getLayoutParams();
                    int dpLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt.setMargins(dpLeft,dpTop,dpRight,0);

                    final ViewGroup.MarginLayoutParams lpt2 =(ViewGroup.MarginLayoutParams)choice2.getLayoutParams();
                    int dpLeft2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpRight2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int dpTop2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
                    lpt2.setMargins(dpLeft2,dpTop2,dpRight2,0);

                    i3.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
                    i1.setImageResource(R.drawable.ic_baseline_arrow_right_24);
                    i2.setImageResource(R.drawable.ic_baseline_arrow_right_24);

                    clickP = false;
                    clickPB2 = false;
                }
                clickPB3 = !clickPB3;
            }
        });

        ImageButton ib = (ImageButton) v.findViewById(R.id.imageButton);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count < 3){
                    count++;
                }

                if(count == 2){
                    l2.setVisibility(View.VISIBLE);
                    choice2.setVisibility(View.VISIBLE);
                }

                if(count == 3){
                    l3.setVisibility(View.VISIBLE);
                    choice3.setVisibility(View.VISIBLE);
                }
            }
        });

        ImageButton ib2 = (ImageButton) v.findViewById(R.id.imageButton2);

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 1){
                    count--;
                }

                if(count == 2){
                    l3.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.INVISIBLE);

                }

                if(count == 1){
                    l3.setVisibility(View.INVISIBLE);
                    choice3.setVisibility(View.INVISIBLE);
                    l2.setVisibility(View.INVISIBLE);
                    choice2.setVisibility(View.INVISIBLE);
                }
            }
        });

        return v;
    }
}