package c346.rp.edu.sg.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDesc extends AppCompatActivity {

    ImageView ratedIv;
    TextView nameTv, infoTv, descTv, watchOnTv, inTheatreTv;
    RatingBar ratingBar;
    Button delBtn;

    String remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_desc);

        ratedIv = findViewById(R.id.ratedIv);

        nameTv = findViewById(R.id.nameTv);
        infoTv = findViewById(R.id.infoTv);
        descTv = findViewById(R.id.descTv);
        watchOnTv = findViewById(R.id.watchOnTv);
        inTheatreTv = findViewById(R.id.inTheatreTv);

        ratingBar = findViewById(R.id.ratingBar);

        delBtn = findViewById(R.id.delBtn);

        Intent getIntent = getIntent();

        remove = getIntent.getStringExtra("Title");

        nameTv.setText(getIntent.getStringExtra("Title"));
        infoTv.setText(getIntent.getStringExtra("Year") + " - " + getIntent.getStringExtra("Genre"));

        descTv.setText(getIntent.getStringExtra("Desc"));

        watchOnTv.setText("Watch On: " + getIntent.getStringExtra("Date"));

        inTheatreTv.setText("In theatre: " + getIntent.getStringExtra("Theatre"));

        if (getIntent.getStringExtra("Rated").equalsIgnoreCase("g")) {
            ratedIv.setImageResource(R.drawable.rating_g);
        }
        else if (getIntent.getStringExtra("Rated").equalsIgnoreCase("pg")) {
            ratedIv.setImageResource(R.drawable.rating_pg);
        }
        else if (getIntent.getStringExtra("Rated").equalsIgnoreCase("pg13")) {
            ratedIv.setImageResource(R.drawable.rating_pg13);
        }
        else if (getIntent.getStringExtra("Rated").equalsIgnoreCase("nc16")) {
            ratedIv.setImageResource(R.drawable.rating_nc16);
        }
        else if (getIntent.getStringExtra("Rated").equalsIgnoreCase("m18")) {
            ratedIv.setImageResource(R.drawable.rating_m18);
        }
        else {
            ratedIv.setImageResource(R.drawable.rating_r21);
        }

        ratingBar.setRating(getIntent.getIntExtra("Rating", 0));

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MovieDesc.this, MainActivity.class).putExtra("Remove", remove));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
