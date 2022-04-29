package com.example.schoolisfun;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.RoomDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildChoice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildChoice extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private AutoCompleteTextView actvLevel, actvPlan;
    ArrayList<String> chosenClasses;

    RoomDB database;
    List<ChildData> childDataList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChildChoice() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildChoice.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildChoice newInstance(String param1, String param2) {
        ChildChoice fragment = new ChildChoice();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_child_choice, container, false);

        Button btDialog = (Button) v.findViewById(R.id.btDialog);
        actvLevel = (AutoCompleteTextView) v.findViewById(R.id.actvLevel);
        actvPlan = (AutoCompleteTextView) v.findViewById(R.id.actvPlan);

        //Initialize database
        database = RoomDB.getInstance(getActivity());
        //Store database value in data list
        childDataList = database.childDao().getAll();

        // SI BUG METTRE DANS LE RESUME
        String[] levels = getResources().getStringArray(R.array.level);
        ArrayAdapter<String> arrayAdapterLevel = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, levels);
        actvLevel.setAdapter(arrayAdapterLevel);
        String[] plans = getResources().getStringArray(R.array.plan);
        ArrayAdapter<String> arrayAdapterPlan = new ArrayAdapter<String>(getActivity(), R.layout.dropdown_item, plans);
        actvPlan.setAdapter(arrayAdapterPlan);


        btDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose classes");

                // add a checkbox list
                String[] classes = {"Physics", "Mathematics", "Computer Science", "English", "French"};
                boolean[] classesCheckedItems = {false, false, false, false, false};
                chosenClasses = new ArrayList<>();
                builder.setMultiChoiceItems(classes, classesCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
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
                            if (classesCheckedItems[i]) {
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
        ChildData childData;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            childData = (ChildData) bundle.getSerializable("childData");
            Button btSignUpChildFragNext = (Button) v.findViewById(R.id.btSignUpChildFragNext);
            btSignUpChildFragNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    childData.setSchoolLevel(actvLevel.getText().toString());
                    childData.setPremiumPlan(actvPlan.getText().toString().equals("Premium Plan"));
                    childData.setClasses(chosenClasses);
                    database.childDao().insert(childData);
                }
            });
        }

        return v;
    }
}