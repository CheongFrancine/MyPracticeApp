package sg.edu.rp.c346.id20020509.mypracticeapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Practice> practiceList;
    CustomAdapter caPractice;

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(this);
        practiceList.clear();
        practiceList.addAll(dbh.getAllPractices());
        caPractice.notifyDataSetChanged();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        lv = this.findViewById(R.id.lv);

        DBHelper dbh = new DBHelper(this);
        practiceList = dbh.getAllPractices();
        dbh.close();

        caPractice = new CustomAdapter(this, R.layout.lv_row, practiceList);

        lv.setAdapter(caPractice);
    }

}
