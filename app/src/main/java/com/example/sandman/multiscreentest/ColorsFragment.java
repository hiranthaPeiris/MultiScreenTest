package com.example.sandman.multiscreentest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);

        ArrayList<Word> wordList= new ArrayList<Word>();

        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));
        wordList.add(new Word("one","peep"));


        AndroidWordAdapter itemsAdapter = new AndroidWordAdapter(getActivity(),wordList,R.color.category_colors);

        ListView listView= (ListView) rootView.findViewById(R.id.rootList);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
