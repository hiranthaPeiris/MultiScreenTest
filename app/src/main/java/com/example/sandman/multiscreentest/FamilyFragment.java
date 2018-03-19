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
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);


        ArrayList<Word> wordList= new ArrayList<Word>();

        wordList.add(new Word("one","peep",R.drawable.family_daughter,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));


        AndroidWordAdapter itemsAdapter = new AndroidWordAdapter(getActivity(),wordList,R.color.category_family);

        ListView listView= (ListView) rootView.findViewById(R.id.rootList);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}
