package com.example.schoolisfun;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildInformation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildInformation extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btSignUpChildFragNext;
    private EditText etUserName, etName, etFirstName, etPhoneNumber;
    private boolean activated;

    private String mParam1;
    private String mParam2;

    public ChildInformation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment childInformation.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildInformation newInstance(String param1, String param2) {
        ChildInformation fragment = new ChildInformation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_child_information, container, false);

        btSignUpChildFragNext = (Button) v.findViewById(R.id.btSignUpChildFragNext);
        etUserName = (EditText) v.findViewById(R.id.etUsername);
        etName = (EditText) v.findViewById(R.id.etName);
        etFirstName = (EditText) v.findViewById(R.id.etFirstName);

        etUserName.addTextChangedListener(textWatcher);
        etName.addTextChangedListener(textWatcher);
        etFirstName.addTextChangedListener(textWatcher);


        checkFieldsForEmptyValues();
        btSignUpChildFragNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bundle bundle = new Bundle();

                bundle.putString("Name",String.valueOf(etName.getText()));

                bundle.putString("FirstName", String.valueOf(etFirstName.getText()));

                bundle.putString("UserName", String.valueOf(etUserName.getText()));

                bundle.putString("PhoneNumber", String.valueOf(etPhoneNumber.getText()));*/
                if(activated){
                    ChildInformationActivity childInformationActivity = (ChildInformationActivity) getActivity();
                    childInformationActivity.fragment1to2();
                }
                else{
                    Toast.makeText(getActivity(), "You have to complete form", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    private void checkFieldsForEmptyValues() {

        String s1 = etUserName.getText().toString();
        String s2 = etName.getText().toString();
        String s3 = etFirstName.getText().toString();

        if (s1.length() > 0 && s2.length() > 0 && s3.length() > 0) {
            activated = true;
            //btSignUpChildFragNext.setEnabled(true);
        } else {
            activated = false;
            //btSignUpChildFragNext.setEnabled(false);
        }
    }
}