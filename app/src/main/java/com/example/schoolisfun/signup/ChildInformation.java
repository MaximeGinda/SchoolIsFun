package com.example.schoolisfun.signup;

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

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildInformation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildInformation extends Fragment {

    private Button btSignUpChildFragNext;
    private EditText etUserName, etLastName, etFirstName, etPhoneNumber;
    private boolean activated;

    String sUserName;
    String sLastName;
    String sFirstName;
    String sPhoneNumber;

    public ChildInformation() {
        // Required empty public constructor
    }

    public static ChildInformation newInstance(String param1, String param2) {
        ChildInformation fragment = new ChildInformation();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_child_information, container, false);

        btSignUpChildFragNext = (Button) v.findViewById(R.id.btSignUpChildFragNext);
        etUserName = (EditText) v.findViewById(R.id.etUsername);
        etLastName = (EditText) v.findViewById(R.id.etLastName);
        etFirstName = (EditText) v.findViewById(R.id.etFirstName);
        etPhoneNumber = (EditText) v.findViewById(R.id.etPhoneNumber);

        etUserName.addTextChangedListener(textWatcher);
        etLastName.addTextChangedListener(textWatcher);
        etFirstName.addTextChangedListener(textWatcher);

        ChildData childData;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            childData = (ChildData) bundle.getSerializable("childData");

            checkFieldsForEmptyValues();
            btSignUpChildFragNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (activated) {
                        childData.setUserName(sUserName);
                        childData.setFirstName(sFirstName);
                        childData.setLastName(sLastName);
                        childData.setPhoneNumber(sPhoneNumber);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("childData", childData);

                        ChildChoice childChoice = new ChildChoice();
                        childChoice.setArguments(bundle);
                        requireActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.childFrameLayout, childChoice)
                                .setReorderingAllowed(true)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        Toast.makeText(getActivity(), "You have to complete form", Toast.LENGTH_SHORT).show();
                        if(sUserName.length() < 2){
                            Toast.makeText(getActivity(), "UserName -> at least 3 characters", Toast.LENGTH_SHORT).show();
                        }

                        if(sLastName.length() < 1){
                            Toast.makeText(getActivity(), "LastName -> at least 1 character", Toast.LENGTH_SHORT).show();
                        }

                        if(sFirstName.length() < 1) {
                            Toast.makeText(getActivity(), "FirstName -> at least 1 character", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        sUserName = etUserName.getText().toString();
        sLastName = etLastName.getText().toString();
        sFirstName = etFirstName.getText().toString();
        sPhoneNumber = etPhoneNumber.getText().toString();


        if (sUserName.length() > 2 && sLastName.length() > 0 && sFirstName.length() > 0) {
            activated = true;
        } else {
            activated = false;
        }
    }
}