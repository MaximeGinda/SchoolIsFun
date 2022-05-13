package com.example.schoolisfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ru.noties.markwon.Markwon;


public class CourseSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_summary);


        Markwon.setMarkdown((TextView) findViewById(R.id.text), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fife cad, mujaji, manataquoed mipa, joe meraseb ler, me queboebybide mecam. Bar fybahebeda dulat quihil sedimim sinoe doede deci miloe lelal nyloehic, mibadir. Quebade jemy, fefunymup, jepy bepud tofe, byn tir jyb jihereloe leb. Cima mifoelaca hyl vehy rihe toemupif mole, buh, paqu mab cijevina didadu jivylebo, dehe lefe.<br />\n" +
                "<br />\n" +
                "Tibal facelali det bicidome, la dasimi cyp bola mida coedem cib cedaco quoebela. Veme me fi vulelel jerelem defoece, toseri, lyma vala daj lyhu vi. Lehen doeta, fehabib nileme piheludoeh coedej sefade moenodipa fub, ces, ce mata fudenabe. Lyfileles muc biqua lolar tycedifoed cad fima, lom, cetate luma. Bajipoboju, mali tamelu melyme to lej poed mim bute cyde, laj que.<br />\n" +
                "<br />\n" +
                "Mafo dimebarefa, laselemi cad loe noca vudi myvime dyme fudi. Da fas by, neni bebym niduj quymeb nub lideta demoj. Dedeleb, boequidece, myb miloe, lim byran te fol saf lamuda lu lu bidifun hi. Quira cobusala camyqui sib ce vov, pupires micymel lurub dyn mim foes leb biti, moecofeb. Li lamelymu beb boeb bedoeba cafuda bimed vubumybasy hedanu relys lemo hyb, quab vyc.<br />\n" +
                "<br />\n" +
                "Vofi, cilelemav lebof li bim, mebe, dijemy, quab bo sati, sinef bijufo. Sy bidoe, bih midalebaf ba, dado lafe lef que bi bab, jih. Boeleda lapa pa, tide myma dihemynoem bilefa selabo quyj dybisi nosulera doem. Nyf fem, disebuf, boeladofi, roe, cadibe seva, jamob qui balabe, quifi lesiby biliboem, feledihuh. Libave fom fi bato he damo mim manomi ba celice.");

    }

}