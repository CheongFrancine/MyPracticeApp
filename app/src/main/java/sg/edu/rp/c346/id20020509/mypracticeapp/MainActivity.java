package sg.edu.rp.c346.id20020509.mypracticeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btCreate, btUpdate, btDelete, btDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCreate = findViewById(R.id.btCreate);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);
        btDisplay = findViewById(R.id.btDisplay);

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainToCreate = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(MainToCreate);
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainToUpdate = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(MainToUpdate);
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainToDelete = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(MainToDelete);
            }
        });

        btDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainToDisplay = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(MainToDisplay);
            }
        });

    }
}