package c346.rp.edu.sg.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDesc extends AppCompatActivity {

    ImageView ratedIv;
    TextView nameTv, infoTv, descTv, watchOnTv, inTheatreTv;
    RatingBar ratingBar;

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

        Intent getIntent = getIntent();

        nameTv.setText(getIntent.getStringExtra("Title"));
        infoTv.setText(getIntent.getStringExtra("Year") + " - " + getIntent.getStringExtra("Genre"));

        descTv.setText(getIntent.getStringExtra("Desc"));

        watchOnTv.setText(getIntent.getStringExtra("Date"));

        inTheatreTv.setText(getIntent.getStringExtra("Theatre"));

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

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
