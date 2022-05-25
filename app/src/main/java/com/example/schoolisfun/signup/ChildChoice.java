package com.example.schoolisfun.signup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.schoolisfun.R;
import com.example.schoolisfun.data.ChildData;
import com.example.schoolisfun.data.CourseContentData;
import com.example.schoolisfun.data.RoomDB;
import com.example.schoolisfun.data.RoomDBcontent;
import com.example.schoolisfun.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildChoice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildChoice extends Fragment {

    private AutoCompleteTextView actvLevel, actvPlan;
    private ArrayList<String> chosenClasses;

    RoomDB database;
    RoomDBcontent databaseContent;
    private List<ChildData> childDataList = new ArrayList<>();

    public ChildChoice() {
        // Required empty public constructor
    }

    public static ChildChoice newInstance(String param1, String param2) {
        ChildChoice fragment = new ChildChoice();
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

        boolean[] classesCheckedItems = {false, false, false, false, false};
        btDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Choose classes");

                // add a checkbox list
                String[] classes = {"Physics", "Mathematics", "Computer Science", "English", "French"};

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

                    if(classesCheckedItems[0]){
                        //createPhysicsCoursesDataBase(childData);
                    }

                    if(classesCheckedItems[1]){
                        //createMathCoursesDataBase(childData);
                    }

                    if(classesCheckedItems[2]){
                        //createCSCoursesDataBase(childData);
                    }

                    if(classesCheckedItems[3]){
                        //createEnglishCoursesDataBase(childData);
                    }

                    if(classesCheckedItems[4]){
                        //createFrenchCoursesDataBase(childData);
                    }
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            });
        }

        return v;
    }

    // Permet de créer les cours de la bdd
    private void createMathCoursesDataBase(ChildData childData){
        CourseContentData cc = new CourseContentData();
        cc.setBoolQuiz(false);
        cc.setBoolExercise(false);
        cc.setBoolSummary(false);
        cc.setBoolVideo(false);
        cc.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fife cad, mujaji, manataquoed mipa, joe meraseb ler, me queboebybide mecam. Bar fybahebeda dulat quihil sedimim sinoe doede deci miloe lelal nyloehic, mibadir. Quebade jemy, fefunymup, jepy bepud tofe, byn tir jyb jihereloe leb. Cima mifoelaca hyl vehy rihe toemupif mole, buh, paqu mab cijevina didadu jivylebo, dehe lefe.<br />\n" +
                "<br />\n" +
                "Tibal facelali det bicidome, la dasimi cyp bola mida coedem cib cedaco quoebela. Veme me fi vulelel jerelem defoece, toseri, lyma vala daj lyhu vi. Lehen doeta, fehabib nileme piheludoeh coedej sefade moenodipa fub, ces, ce mata fudenabe. Lyfileles muc biqua lolar tycedifoed cad fima, lom, cetate luma. Bajipoboju, mali tamelu melyme to lej poed mim bute cyde, laj que.<br />\n" +
                "<br />\n" +
                "Mafo dimebarefa, laselemi cad loe noca vudi myvime dyme fudi. Da fas by, neni bebym niduj quymeb nub lideta demoj. Dedeleb, boequidece, myb miloe, lim byran te fol saf lamuda lu lu bidifun hi. Quira cobusala camyqui sib ce vov, pupires micymel lurub dyn mim foes leb biti, moecofeb. Li lamelymu beb boeb bedoeba cafuda bimed vubumybasy hedanu relys lemo hyb, quab vyc.<br />\n" +
                "<br />\n" +
                "Vofi, cilelemav lebof li bim, mebe, dijemy, quab bo sati, sinef bijufo. Sy bidoe, bih midalebaf ba, dado lafe lef que bi bab, jih. Boeleda lapa pa, tide myma dihemynoem bilefa selabo quyj dybisi nosulera doem. Nyf fem, disebuf, boeladofi, roe, cadibe seva, jamob qui balabe, quifi lesiby biliboem, feledihuh. Libave fom fi bato he damo mim manomi ba celice.");
        cc.setCourseName("Mathematics");
        cc.setUserID(database.childDao().findIdWithUserName(childData.getUserName()));

        databaseContent.courseContentDao().insert(cc);
    }

    private void createFrenchCoursesDataBase(ChildData childData){
        CourseContentData cc = new CourseContentData();
        cc.setBoolQuiz(false);
        cc.setBoolExercise(false);
        cc.setBoolSummary(false);
        cc.setBoolVideo(false);
        cc.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fife cad, mujaji, manataquoed mipa, joe meraseb ler, me queboebybide mecam. Bar fybahebeda dulat quihil sedimim sinoe doede deci miloe lelal nyloehic, mibadir. Quebade jemy, fefunymup, jepy bepud tofe, byn tir jyb jihereloe leb. Cima mifoelaca hyl vehy rihe toemupif mole, buh, paqu mab cijevina didadu jivylebo, dehe lefe.<br />\n" +
                "<br />\n" +
                "Tibal facelali det bicidome, la dasimi cyp bola mida coedem cib cedaco quoebela. Veme me fi vulelel jerelem defoece, toseri, lyma vala daj lyhu vi. Lehen doeta, fehabib nileme piheludoeh coedej sefade moenodipa fub, ces, ce mata fudenabe. Lyfileles muc biqua lolar tycedifoed cad fima, lom, cetate luma. Bajipoboju, mali tamelu melyme to lej poed mim bute cyde, laj que.<br />\n" +
                "<br />\n" +
                "Mafo dimebarefa, laselemi cad loe noca vudi myvime dyme fudi. Da fas by, neni bebym niduj quymeb nub lideta demoj. Dedeleb, boequidece, myb miloe, lim byran te fol saf lamuda lu lu bidifun hi. Quira cobusala camyqui sib ce vov, pupires micymel lurub dyn mim foes leb biti, moecofeb. Li lamelymu beb boeb bedoeba cafuda bimed vubumybasy hedanu relys lemo hyb, quab vyc.<br />\n" +
                "<br />\n" +
                "Vofi, cilelemav lebof li bim, mebe, dijemy, quab bo sati, sinef bijufo. Sy bidoe, bih midalebaf ba, dado lafe lef que bi bab, jih. Boeleda lapa pa, tide myma dihemynoem bilefa selabo quyj dybisi nosulera doem. Nyf fem, disebuf, boeladofi, roe, cadibe seva, jamob qui balabe, quifi lesiby biliboem, feledihuh. Libave fom fi bato he damo mim manomi ba celice.");
        cc.setCourseName("French");
        cc.setUserID(database.childDao().findIdWithUserName(childData.getUserName()));

        databaseContent.courseContentDao().insert(cc);
    }
    private void createPhysicsCoursesDataBase(ChildData childData){
        CourseContentData cc = new CourseContentData();
        cc.setBoolQuiz(false);
        cc.setBoolExercise(false);
        cc.setBoolSummary(false);
        cc.setBoolVideo(false);
        cc.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fife cad, mujaji, manataquoed mipa, joe meraseb ler, me queboebybide mecam. Bar fybahebeda dulat quihil sedimim sinoe doede deci miloe lelal nyloehic, mibadir. Quebade jemy, fefunymup, jepy bepud tofe, byn tir jyb jihereloe leb. Cima mifoelaca hyl vehy rihe toemupif mole, buh, paqu mab cijevina didadu jivylebo, dehe lefe.<br />\n" +
                "<br />\n" +
                "Tibal facelali det bicidome, la dasimi cyp bola mida coedem cib cedaco quoebela. Veme me fi vulelel jerelem defoece, toseri, lyma vala daj lyhu vi. Lehen doeta, fehabib nileme piheludoeh coedej sefade moenodipa fub, ces, ce mata fudenabe. Lyfileles muc biqua lolar tycedifoed cad fima, lom, cetate luma. Bajipoboju, mali tamelu melyme to lej poed mim bute cyde, laj que.<br />\n" +
                "<br />\n" +
                "Mafo dimebarefa, laselemi cad loe noca vudi myvime dyme fudi. Da fas by, neni bebym niduj quymeb nub lideta demoj. Dedeleb, boequidece, myb miloe, lim byran te fol saf lamuda lu lu bidifun hi. Quira cobusala camyqui sib ce vov, pupires micymel lurub dyn mim foes leb biti, moecofeb. Li lamelymu beb boeb bedoeba cafuda bimed vubumybasy hedanu relys lemo hyb, quab vyc.<br />\n" +
                "<br />\n" +
                "Vofi, cilelemav lebof li bim, mebe, dijemy, quab bo sati, sinef bijufo. Sy bidoe, bih midalebaf ba, dado lafe lef que bi bab, jih. Boeleda lapa pa, tide myma dihemynoem bilefa selabo quyj dybisi nosulera doem. Nyf fem, disebuf, boeladofi, roe, cadibe seva, jamob qui balabe, quifi lesiby biliboem, feledihuh. Libave fom fi bato he damo mim manomi ba celice.");
        cc.setCourseName("Physics");
        cc.setUserID(database.childDao().findIdWithUserName(childData.getUserName()));

        databaseContent.courseContentDao().insert(cc);
    }

    private void createCSCoursesDataBase(ChildData childData){
        CourseContentData cc = new CourseContentData();
        cc.setBoolQuiz(false);
        cc.setBoolExercise(false);
        cc.setBoolSummary(false);
        cc.setBoolVideo(false);
        cc.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fife cad, mujaji, manataquoed mipa, joe meraseb ler, me queboebybide mecam. Bar fybahebeda dulat quihil sedimim sinoe doede deci miloe lelal nyloehic, mibadir. Quebade jemy, fefunymup, jepy bepud tofe, byn tir jyb jihereloe leb. Cima mifoelaca hyl vehy rihe toemupif mole, buh, paqu mab cijevina didadu jivylebo, dehe lefe.<br />\n" +
                "<br />\n" +
                "Tibal facelali det bicidome, la dasimi cyp bola mida coedem cib cedaco quoebela. Veme me fi vulelel jerelem defoece, toseri, lyma vala daj lyhu vi. Lehen doeta, fehabib nileme piheludoeh coedej sefade moenodipa fub, ces, ce mata fudenabe. Lyfileles muc biqua lolar tycedifoed cad fima, lom, cetate luma. Bajipoboju, mali tamelu melyme to lej poed mim bute cyde, laj que.<br />\n" +
                "<br />\n" +
                "Mafo dimebarefa, laselemi cad loe noca vudi myvime dyme fudi. Da fas by, neni bebym niduj quymeb nub lideta demoj. Dedeleb, boequidece, myb miloe, lim byran te fol saf lamuda lu lu bidifun hi. Quira cobusala camyqui sib ce vov, pupires micymel lurub dyn mim foes leb biti, moecofeb. Li lamelymu beb boeb bedoeba cafuda bimed vubumybasy hedanu relys lemo hyb, quab vyc.<br />\n" +
                "<br />\n" +
                "Vofi, cilelemav lebof li bim, mebe, dijemy, quab bo sati, sinef bijufo. Sy bidoe, bih midalebaf ba, dado lafe lef que bi bab, jih. Boeleda lapa pa, tide myma dihemynoem bilefa selabo quyj dybisi nosulera doem. Nyf fem, disebuf, boeladofi, roe, cadibe seva, jamob qui balabe, quifi lesiby biliboem, feledihuh. Libave fom fi bato he damo mim manomi ba celice.");
        cc.setCourseName("Computer Science");
        cc.setUserID(database.childDao().findIdWithUserName(childData.getUserName()));

        databaseContent.courseContentDao().insert(cc);
    }

    private void createEnglishCoursesDataBase(ChildData childData){
        CourseContentData cc = new CourseContentData();
        cc.setBoolQuiz(false);
        cc.setBoolExercise(false);
        cc.setBoolSummary(false);
        cc.setBoolVideo(false);
        cc.setSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fife cad, mujaji, manataquoed mipa, joe meraseb ler, me queboebybide mecam. Bar fybahebeda dulat quihil sedimim sinoe doede deci miloe lelal nyloehic, mibadir. Quebade jemy, fefunymup, jepy bepud tofe, byn tir jyb jihereloe leb. Cima mifoelaca hyl vehy rihe toemupif mole, buh, paqu mab cijevina didadu jivylebo, dehe lefe.<br />\n" +
                "<br />\n" +
                "Tibal facelali det bicidome, la dasimi cyp bola mida coedem cib cedaco quoebela. Veme me fi vulelel jerelem defoece, toseri, lyma vala daj lyhu vi. Lehen doeta, fehabib nileme piheludoeh coedej sefade moenodipa fub, ces, ce mata fudenabe. Lyfileles muc biqua lolar tycedifoed cad fima, lom, cetate luma. Bajipoboju, mali tamelu melyme to lej poed mim bute cyde, laj que.<br />\n" +
                "<br />\n" +
                "Mafo dimebarefa, laselemi cad loe noca vudi myvime dyme fudi. Da fas by, neni bebym niduj quymeb nub lideta demoj. Dedeleb, boequidece, myb miloe, lim byran te fol saf lamuda lu lu bidifun hi. Quira cobusala camyqui sib ce vov, pupires micymel lurub dyn mim foes leb biti, moecofeb. Li lamelymu beb boeb bedoeba cafuda bimed vubumybasy hedanu relys lemo hyb, quab vyc.<br />\n" +
                "<br />\n" +
                "Vofi, cilelemav lebof li bim, mebe, dijemy, quab bo sati, sinef bijufo. Sy bidoe, bih midalebaf ba, dado lafe lef que bi bab, jih. Boeleda lapa pa, tide myma dihemynoem bilefa selabo quyj dybisi nosulera doem. Nyf fem, disebuf, boeladofi, roe, cadibe seva, jamob qui balabe, quifi lesiby biliboem, feledihuh. Libave fom fi bato he damo mim manomi ba celice.");
        cc.setCourseName("English");
        cc.setUserID(database.childDao().findIdWithUserName(childData.getUserName()));

        databaseContent.courseContentDao().insert(cc);
    }
}