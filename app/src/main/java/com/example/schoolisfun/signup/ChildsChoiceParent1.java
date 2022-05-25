package com.example.schoolisfun.signup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.ParentData;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.ui.login.LoginActivity;

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
    private ArrayList<String> chosenClasses2;
    private ArrayList<String> chosenClasses3;
    private int count = 1;
    private RoomDB database;

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

        database = RoomDB.getInstance(getActivity());

        actvLevel = (AutoCompleteTextView) v.findViewById(R.id.actvLevelBT1);
        actvLevel2 = (AutoCompleteTextView) v.findViewById(R.id.actvLevelBT2);
        actvLevel3 = (AutoCompleteTextView) v.findViewById(R.id.actvLevelBT3);
        String[] levels = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> arrayAdapterLevel = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, levels);
        actvLevel.setAdapter(arrayAdapterLevel);
        actvLevel2.setAdapter(arrayAdapterLevel);
        actvLevel3.setAdapter(arrayAdapterLevel);

        AutoCompleteTextView actvPlan1 = (AutoCompleteTextView) v.findViewById(R.id.actvPlan);
        AutoCompleteTextView actvPlan2 = (AutoCompleteTextView) v.findViewById(R.id.actvPlan2);
        AutoCompleteTextView actvPlan3 = (AutoCompleteTextView) v.findViewById(R.id.actvPlan3);
        String[] plans = getResources().getStringArray(R.array.plan);
        ArrayAdapter<String> arrayAdapterPlan = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, plans);
        actvPlan1.setAdapter(arrayAdapterPlan);
        actvPlan2.setAdapter(arrayAdapterPlan);
        actvPlan3.setAdapter(arrayAdapterPlan);

        Button btDialog1 = (Button) v.findViewById(R.id.btDialog2);
        Button btDialog2 = (Button) v.findViewById(R.id.btDialog3);
        Button btDialog3 = (Button) v.findViewById(R.id.btDialog4);


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

        boolean[] classesCheckedItems1 = {false, false, false, false, false};
        btDialog1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose classes");

                // add a checkbox list
                String[] classes = {"Physics", "Mathematics", "Computer Science", "English", "French"};

                chosenClasses = new ArrayList<>();
                builder.setMultiChoiceItems(classes, classesCheckedItems1, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // user checked or unchecked a box
                    }
                });

                // add OK and Cancel buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                        for (int i = 0; i < 5; i++) {
                            if (classesCheckedItems1[i]) {
                                chosenClasses.add(classes[i]);
                            }
                        }

                    }
                });
                builder.setNegativeButton("Cancel", null);

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        boolean[] classesCheckedItems2 = {false, false, false, false, false};
        btDialog2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose classes");

                // add a checkbox list
                String[] classes = {"Physics", "Mathematics", "Computer Science", "English", "French"};

                chosenClasses2 = new ArrayList<>();
                builder.setMultiChoiceItems(classes, classesCheckedItems2, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // user checked or unchecked a box
                    }
                });

                // add OK and Cancel buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                        for (int i = 0; i < 5; i++) {
                            if (classesCheckedItems2[i]) {
                                chosenClasses2.add(classes[i]);
                            }
                        }

                    }
                });
                builder.setNegativeButton("Cancel", null);

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        boolean[] classesCheckedItems3 = {false, false, false, false, false};
        btDialog3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose classes");

                // add a checkbox list
                String[] classes = {"Physics", "Mathematics", "Computer Science", "English", "French"};

                chosenClasses3 = new ArrayList<>();
                builder.setMultiChoiceItems(classes, classesCheckedItems3, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // user checked or unchecked a box
                    }
                });

                // add OK and Cancel buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                        for (int i = 0; i < 5; i++) {
                            if (classesCheckedItems3[i]) {
                                chosenClasses3.add(classes[i]);
                            }
                        }

                    }
                });
                builder.setNegativeButton("Cancel", null);

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        Bundle bundle = this.getArguments();
        v.findViewById(R.id.btSignUpParentNextFrag2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParentData pd = (ParentData) bundle.getSerializable("parentData");

                ChildData cd = new ChildData();
                cd.setEmail(pd.getEmail());
                cd.setPassword(pd.getPassword());
                EditText et1 = (EditText) v.findViewById(R.id.etLastNameBT1);
                EditText et2 = (EditText) v.findViewById(R.id.etFirstNameBT1);
                cd.setUserName(et1.getText().toString()+et2.getText().toString());
                cd.setLastName(et1.getText().toString());
                cd.setFirstName(et2.getText().toString());
                cd.setSchoolLevel(actvLevel.getText().toString());
                cd.setPremiumPlan(actvPlan1.getText().toString().equals("Prenium Plan"));
                cd.setClasses(chosenClasses);

                database.childDao().insert(cd);

                if (count == 2){

                    ChildData cd2 = new ChildData();
                    cd2.setEmail(pd.getEmail());
                    cd2.setPassword(pd.getPassword());
                    EditText et3 = (EditText) v.findViewById(R.id.etLastNameBT2);
                    EditText et4 = (EditText) v.findViewById(R.id.etFirstNameBT2);
                    cd2.setUserName(et3.getText().toString()+et4.getText().toString());
                    cd2.setLastName(et3.getText().toString());
                    cd2.setFirstName(et4.getText().toString());
                    cd2.setSchoolLevel(actvLevel2.getText().toString());
                    cd2.setPremiumPlan(actvPlan2.getText().toString().equals("Prenium Plan"));
                    cd2.setClasses(chosenClasses2);

                    database.childDao().insert(cd2);
                }
                else if (count == 3){
                    ChildData cd3 = new ChildData();
                    cd3.setEmail(pd.getEmail());
                    cd3.setPassword(pd.getPassword());
                    EditText et5 = (EditText) v.findViewById(R.id.etLastNameBT3);
                    EditText et6 = (EditText) v.findViewById(R.id.etFirstNameBT3);
                    cd3.setUserName(et5.getText().toString()+et6.getText().toString());
                    cd3.setLastName(et5.getText().toString());
                    cd3.setFirstName(et6.getText().toString());
                    cd3.setSchoolLevel(actvLevel3.getText().toString());
                    cd3.setPremiumPlan(actvPlan3.getText().toString().equals("Prenium Plan"));
                    cd3.setClasses(chosenClasses3);

                    database.childDao().insert(cd3);
                }

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}