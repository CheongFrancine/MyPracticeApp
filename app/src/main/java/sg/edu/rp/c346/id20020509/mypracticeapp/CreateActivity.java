package sg.edu.rp.c346.id20020509.mypracticeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    EditText etPracticeDescription;
    RatingBar rb;
    Button btCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etPracticeDescription = findViewById(R.id.etPracticeDescription);
        rb = findViewById(R.id.rb);
        btCreate = findViewById(R.id.btCreate2);

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = etPracticeDescription.getText().toString().trim();

                DBHelper dbh = new DBHelper(CreateActivity.this);

                int stars = getStars();
                dbh.insertPractice(description, stars);
                dbh.close();
            }
        });

    }

    private int getStars() {
        int stars = 1;
        stars = (int) rb.getRating();
        return stars;
    }

}
