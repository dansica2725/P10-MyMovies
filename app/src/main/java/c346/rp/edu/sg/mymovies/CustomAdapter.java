package c346.rp.edu.sg.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context mContext;
    ArrayList<Movie> movieList;
    int layout_id;
    LayoutInflater inflater;

    public CustomAdapter(Context mContext, int layout_id, ArrayList<Movie> movieList) {
        super(mContext, layout_id, movieList);
        this.mContext = mContext;
        this.movieList = movieList;
        this.layout_id = layout_id;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(layout_id, null);

        ImageView ratedIv;
        TextView nameTv, infoTv;

        ratedIv = convertView.findViewById(R.id.ratedIv);
        nameTv = convertView.findViewById(R.id.nameTv);
        infoTv = convertView.findViewById(R.id.infoTv);

        Movie currentItem = movieList.get(position);

        if (currentItem.getRated() != null) {
            if (currentItem.getRated().equalsIgnoreCase("g")) {
                ratedIv.setImageResource(R.drawable.rating_g);
            }
            else if (currentItem.getRated().equalsIgnoreCase("pg")) {
                ratedIv.setImageResource(R.drawable.rating_pg);
            }
            else if (currentItem.getRated().equalsIgnoreCase("pg13")) {
                ratedIv.setImageResource(R.drawable.rating_pg13);
            }
            else if (currentItem.getRated().equalsIgnoreCase("nc16")) {
                ratedIv.setImageResource(R.drawable.rating_nc16);
            }
            else if (currentItem.getRated().equalsIgnoreCase("m18")) {
                ratedIv.setImageResource(R.drawable.rating_m18);
            }
            else {
                ratedIv.setImageResource(R.drawable.rating_r21);
            }
        }
        else {

        }

        nameTv.setText(currentItem.getTitle());
        infoTv.setText(currentItem.getYear() + " - " + currentItem.getGenre());

        return convertView;
    }
}
