package sg.edu.rp.c346.id22012867.mymovies;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;


    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.movieTitle);
        TextView tvYear = rowView.findViewById(R.id.year);
        ImageView ivrate = rowView.findViewById(R.id.imageView);
        TextView tvGenre = rowView.findViewById(R.id.genre);

        // Obtain the Android Version information based on the position
        Movie currentVersion = movieList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvGenre.setText(currentVersion.getGenre());
        Picasso.with(parent_context).load(currentVersion.URLratings()).into(ivrate);
        if ("G".equals(currentVersion.getRating())) {
            ivrate.setImageResource(R.drawable.rating_g);
        } else if ("PG".equals(currentVersion.getRating())) {
            ivrate.setImageResource(R.drawable.rating_pg);
        } else if ("PG13".equals(currentVersion.getRating())) {
            ivrate.setImageResource(R.drawable.rating_pg13);
        } else if ("NC16".equals(currentVersion.getRating())) {
            ivrate.setImageResource(R.drawable.rating_nc16);
        } else if ("M18".equals(currentVersion.getRating())) {
            ivrate.setImageResource(R.drawable.rating_m18);
        } else if ("R21".equals(currentVersion.getRating())) {
            ivrate.setImageResource(R.drawable.rating_r21);
        } else {
            // Set a default image if the rating is not recognized
            ivrate.setImageResource(R.drawable.rating_m18);
        }

        tvYear.setText(String.valueOf(currentVersion.getYear()));
        // Use the corrected method to get the date string

        return rowView;
    }


}

