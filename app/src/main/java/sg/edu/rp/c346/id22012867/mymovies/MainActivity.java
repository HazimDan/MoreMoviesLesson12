package sg.edu.rp.c346.id22012867.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   EditText etMovie, etGenre, etYear;
   TextView tvMovie, tvGenre, tvYear;
   Spinner spnMovies;
   Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("My Movies - Insert Movies");

        etMovie = findViewById(R.id.etMovieTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spnMovies = findViewById(R.id.spnMovies);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow  = findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String newMovieTitle = etMovie.getText().toString();
                String newGenre = etGenre.getText().toString();
                int newYear = Integer.parseInt(etYear.getText().toString());
                String newRating = spnMovies.getSelectedItem().toString();

                db.insertMovie(newMovieTitle, newGenre, newYear, newRating);

                Toast.makeText(MainActivity.this, "Movie " + newMovieTitle + " has been inserted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, ShowMovies.class);
                startActivity(intent);

            }
        });
    }
}