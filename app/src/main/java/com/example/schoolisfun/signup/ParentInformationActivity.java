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

        ChildsChoiceParent1 pi2 = new ChildsChoiceParent1();

        // On lance le premier fragment
        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .replace(R.id.parentFrameLayout, pi2)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    // Permet de passer du fragment 1 au 2 dans les informations de l'enfant
    public void fragment1to2() {
        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .replace(R.id.childFrameLayout, ChildChoice.class, null, "tag")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}