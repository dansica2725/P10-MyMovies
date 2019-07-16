package c346.rp.edu.sg.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView movieLv;
    ArrayList<Movie> movieList;
    CustomAdapter adapter;

    String title, year, genre, rated, theatre, desc, date, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieLv = findViewById(R.id.movieLv);
        movieList = new ArrayList<>();


        movieList.add(new Movie("The Avengers", "2012", "pg13", "Action | Sci-Fi", "15/11/2014", "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.", 4));
        movieList.add(new Movie("Planes", "2013", "pg", "Animation | Comedy", "15/5/2015", "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", 2));

        adapter = new CustomAdapter(MainActivity.this, R.layout.row, movieList);
        movieLv.setAdapter(adapter);


        getIntentAddMovie();

        movieLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, MovieDesc.class)
                        .putExtra("Title", movieList.get(position).getTitle())
                        .putExtra("Year", movieList.get(position).getYear())
                        .putExtra("Genre", movieList.get(position).getGenre())
                        .putExtra("Rated", movieList.get(position).getRated())
                        .putExtra("Theatre", movieList.get(position).getIn_theatre())
                        .putExtra("Desc", movieList.get(position).getDescription())
                        .putExtra("Date", movieList.get(position).getWatched_on())
                        .putExtra("Rating", movieList.get(position).getRating()));
            }
        });

        getIntentRemove();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addMenu:
                startActivity(new Intent(MainActivity.this, AddMovie.class));
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    private void getIntentAddMovie() {

        Intent getIntent = getIntent();

        if (getIntent() != null) {
            title = getIntent.getStringExtra("Title");
            year = getIntent.getStringExtra("Year");
            genre = getIntent.getStringExtra("Genre");
            rated = getIntent.getStringExtra("Rated");
            theatre = getIntent.getStringExtra("Theatre");
            desc = getIntent.getStringExtra("Desc");
            date = getIntent.getStringExtra("Date");

            movieList.add(new Movie(title, year, rated, genre, date, theatre, desc, 0));
            adapter.notifyDataSetChanged();
        } else {

        }
    }

    private void getIntentRemove() {

        Intent getIntent = getIntent();

        remove = getIntent.getStringExtra("Remove");

        for (Movie i : movieList) {
            if (i.getTitle().equalsIgnoreCase(remove)) {
                movieList.remove(i);
            }
        }


    }

    private Calendar toCalendar(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = null;

        Calendar calendar = Calendar.getInstance();
        try {
            now = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.setTime(now);
        return calendar;
    }
}
