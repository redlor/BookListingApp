package com.example.android.booklistingapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    private SearchManager searchManager;

    public static final String LOG_TAG = MainActivity.class.getName();

    private String searchedTitle;

    private ImageButton searchButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        final SearchView searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                hideSoftKeyboard(MainActivity.this);
          //      searchedTitle = editText.getText().toString();
                String text = searchView.getQuery().toString();
                Intent i = new Intent(getApplicationContext(), QueryResult.class);
                i.putExtra("Title", text);
                startActivity(i);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading_indicator);
        progressBar.setVisibility(View.GONE);

     /*   editText = (EditText) findViewById(R.id.search_edit_text);
        searchButton = (ImageButton) findViewById(R.id.search_button);*/

        // Start {@link QueryResult} activity on click
 /*       searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(MainActivity.this);
                searchedTitle = editText.getText().toString();
                Intent i = new Intent(getApplicationContext(), QueryResult.class);
                i.putExtra("Title", searchedTitle);
                startActivity(i);
            }
        });*/

    }

    // hide the soft keyboard when clicking the search button
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
