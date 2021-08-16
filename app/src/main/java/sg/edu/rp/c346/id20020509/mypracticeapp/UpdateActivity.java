package sg.edu.rp.c346.id20020509.mypracticeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText etID, etPracticeDescription;
    RatingBar rb;
    Button btUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etID = findViewById(R.id.etID);
        etPracticeDescription = findViewById(R.id.etPracticeDescription);
        rb = findViewById(R.id.rb);
        btUpdate = findViewById(R.id.btUpdate2);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(UpdateActivity.this);
                Practice currentPractice = new Practice(Integer.parseInt(etID.getText().toString()), etPracticeDescription.getText().toString(), (int) rb.getRating());
                currentPractice.setDescription(etPracticeDescription.getText().toString().trim());
                currentPractice.setStars((int)rb.getRating());

                int result = dbh.updatePractice(currentPractice);
            }
        });
    }

}
