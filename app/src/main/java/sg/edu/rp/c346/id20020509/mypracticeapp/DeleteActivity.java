package sg.edu.rp.c346.id20020509.mypracticeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    EditText etID;
    Button btDelete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etID = findViewById(R.id.etID);
        btDelete = findViewById(R.id.btDelete2);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(DeleteActivity.this);
                int result = dbh.deletePractice(Integer.parseInt(etID.getText().toString()));
            }
        });
    }

}
