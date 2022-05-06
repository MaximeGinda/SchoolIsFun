package com.example.schoolisfun.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;

public class ChildInformationActivity extends AppCompatActivity {

    private FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_information);

        Intent intent = getIntent();
        ChildData childData = (ChildData) getIntent().getSerializableExtra("child_data");
//        Log.d("test", str);

        Bundle bundle = new Bundle();
        bundle.putSerializable("childData", childData);
        ChildInformation childInformation = new ChildInformation();
        childInformation.setArguments(bundle);

        fragMan = getSupportFragmentManager();
        fragMan.beginTransaction()
                .replace(R.id.childFrameLayout, childInformation)
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