package com.example.android.miwok;

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    public Word(String DefaultTranslation, String MiwokTranslation, int AudioResourceId) {
        this.mDefaultTranslation = DefaultTranslation;
        this.mMiwokTranslation = MiwokTranslation;
        this.mAudioResourceId = AudioResourceId;
    }

    public Word(String DefaultTranslation, String MiwokTranslation, int ImageResourceId, int AudioResourceId) {
        this.mDefaultTranslation = DefaultTranslation;
        this.mMiwokTranslation = MiwokTranslation;
        this.mImageResourceId = ImageResourceId;
        this.mAudioResourceId = AudioResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public  boolean hasImage(){
        return this.mImageResourceId != this. NO_IMAGE_PROVIDED;
    }
}
