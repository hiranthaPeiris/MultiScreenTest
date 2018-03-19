package com.example.sandman.multiscreentest;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private  MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener afChangeListner = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
            }else if(i == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }else if (i == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list,container,false);



        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> wordList= new ArrayList<Word>();

        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.one));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.two));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.three));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.two));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.two));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.three));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.four));
        wordList.add(new Word("one","peep",R.drawable.number_eight,R.raw.three));


        AndroidWordAdapter itemsAdapter = new AndroidWordAdapter(getActivity(),wordList,R.color.category_numbers);

        ListView listView= (ListView) rootView.findViewById(R.id.rootList);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"item Clicked"+i,Toast.LENGTH_SHORT).show();
                Word word = wordList.get(i);
                releaseMediaPlayer();

                int rst = mAudioManager.requestAudioFocus(afChangeListner,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
                if (rst == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getActivity(),word.getmAudioResourceId());

                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompleteListener );
                }

            }
        });

        return rootView;
    }
    private void releaseMediaPlayer (){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(afChangeListner);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
