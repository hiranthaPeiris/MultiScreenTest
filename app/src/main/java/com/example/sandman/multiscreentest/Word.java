package com.example.sandman.multiscreentest;

/**
 * Created by Sandman on 1/14/2018.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    //image resource id for the word
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    //Constant value that represents no image was provided for this world
    private static final int NO_IMAGE_PROVIDED=-1;

    //Audio resource id for the word
    private int mAudioResourceId;

    public Word(String mDefaultTranslation, String mMiwokTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;

    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
