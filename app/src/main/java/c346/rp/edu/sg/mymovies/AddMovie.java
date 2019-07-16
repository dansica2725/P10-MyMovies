package c346.rp.edu.sg.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddMovie extends AppCompatActivity {

    EditText titleEt, yearEt, genreEt, ratedEt, theatreEt, descEt;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        titleEt = findViewById(R.id.titleEt);
        yearEt = findViewById(R.id.yearEt);
        genreEt = findViewById(R.id.genreEt);
        ratedEt = findViewById(R.id.ratedEt);
        theatreEt = findViewById(R.id.theatreEt);
        descEt = findViewById(R.id.descEt);

        addBtn = findViewById(R.id.addBtn);

        int day = Calendar.DAY_OF_MONTH;
        int mth = Calendar.MONTH;
        int year = Calendar.YEAR;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        final String date = sdf.format(calendar.getTime());

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AddMovie.this, MainActivity.class)
                        .putExtra("Title", titleEt.getText().toString())
                        .putExtra("Year", yearEt.getText().toString())
                        .putExtra("Genre", genreEt.getText().toString())
                        .putExtra("Rated", ratedEt.getText().toString())
                        .putExtra("Theatre", theatreEt.getText().toString())
                        .putExtra("Desc", descEt.getText().toString())
                        .putExtra("Date", date));

            }
        });

    }
}
