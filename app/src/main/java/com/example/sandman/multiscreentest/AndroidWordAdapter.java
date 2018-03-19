package com.example.sandman.multiscreentest;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sandman on 1/14/2018.
 */

public class AndroidWordAdapter extends ArrayAdapter<Word> {

    private int mColorResoursId;

    public AndroidWordAdapter(Activity context, ArrayList<Word> words,int colorResoursId) {
        super(context,0,words);
        mColorResoursId = colorResoursId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView deafultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.ic_launcher);

        miwokTextView.setText(currentWord.getmMiwokTranslation());
        deafultTextView.setText(currentWord.getmDefaultTranslation());

        //Setting Image visible or gone from the model's method
        if(currentWord.hasImage()){
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }


        //get container of textView Layout
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(),mColorResoursId);
        //set the background color of the text container view
        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
