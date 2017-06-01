package com.example.android.booklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Hp on 28/05/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
            // Populating the ViewHolder with date from the API
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) listItemView.findViewById(R.id.image);
            viewHolder.authors = (TextView) listItemView.findViewById(R.id.author_text_view);
            viewHolder.title = (TextView) listItemView.findViewById((R.id.title_text_view));
            listItemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) listItemView.getTag();
        }
        Book currentBook = getItem(position);

        // Using the Picassso library to set the image
        Picasso.with(getContext()).load(currentBook.getImage()).into(viewHolder.image);

        // Set the authors
        viewHolder.authors.setText(currentBook.getAuthor());

        // Set the title
        viewHolder.title.setText(currentBook.getTitle());

        return listItemView;
    }

    // Create the custom ViewHolder
    public static class ViewHolder {
        ImageView image;
        TextView authors;
        TextView title;
    }
}
