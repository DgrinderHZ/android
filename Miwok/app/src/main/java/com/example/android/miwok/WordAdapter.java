package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mBgColor;
    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects, int  bgColor) {
        super(context, 0, objects);
        this.mBgColor = bgColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        LinearLayout textContainerLinearLayout = listItemView.findViewById(R.id.text_container);
        // map the color
        int color = ContextCompat.getColor(getContext(), mBgColor);
        textContainerLinearLayout.setBackgroundColor(color);

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView =  listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());
        // Find the ImageView in the list_item.xml layout with the ID placeholder
        ImageView placeholderImageView =  listItemView.findViewById(R.id.placeholder);
        if(currentWord.hasImage() == false){
            placeholderImageView.setVisibility(View.GONE);
        }else{
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            placeholderImageView.setImageResource(currentWord.getImageResourceId());
        }


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
