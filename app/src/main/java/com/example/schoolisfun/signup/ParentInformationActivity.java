package com.example.schoolisfun.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.ParentData;

public class ParentInformationActivity extends AppCompatActivity {

    private FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_information);

        Intent intent = getIntent();
        ParentData parentData = (ParentData) getIntent().getSerializableExtra("parent_data");

        Bundle bundle = new Bundle();
        bundle.putSerializable("parentData", parentData);
        ParentInformation pi = new ParentInformation();
        pi.setArguments(bundle);

        // On lance le premier fragment
        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .replace(R.id.parentFrameLayout, pi)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}