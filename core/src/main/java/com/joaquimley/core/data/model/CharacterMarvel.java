package com.joaquimley.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for Marvel character
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterMarvel implements Parcelable {

    @JsonProperty(value = "id")
    private long mId;
    @JsonProperty(value = "name")
    private String mName;
    @JsonProperty(value = "description")
    private String mDescription;
    @JsonProperty(value = "thumbnail")
    private Image mThumbnail;
    @JsonProperty(value = "comics")
    private CharacterComicDataContainer mComics;
    @JsonProperty(value = "series")
    private CharacterComicDataContainer mSeries;
    @JsonProperty(value = "stories")
    private CharacterComicDataContainer mStories;
    @JsonProperty(value = "events")
    private CharacterComicDataContainer mEvents;
    @JsonProperty(value = "urls")
    private List<Url> mUrls;

    public CharacterMarvel() {
    }

    /**
     * START of custom methods
     */

    public String getImageUrl() {
        return mThumbnail.buildCompleteImagePath();
    }

    @Override
    public String toString() {
        return mName;
    }

    /**
     * END of custom methods
     */

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Image getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        mThumbnail = thumbnail;
    }

    public CharacterComicDataContainer getComics() {
        return mComics;
    }

    public void setComics(CharacterComicDataContainer comics) {
        mComics = comics;
    }

    public CharacterComicDataContainer getSeries() {
        return mSeries;
    }

    public void setSeries(CharacterComicDataContainer series) {
        mSeries = series;
    }

    public CharacterComicDataContainer getStories() {
        return mStories;
    }

    public void setStories(CharacterComicDataContainer stories) {
        mStories = stories;
    }

    public CharacterComicDataContainer getEvents() {
        return mEvents;
    }

    public void setEvents(CharacterComicDataContainer events) {
        mEvents = events;
    }

    public List<Url> getUrls() {
        return mUrls;
    }

    public void setUrls(List<Url> urls) {
        mUrls = urls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeParcelable(mThumbnail, flags);
        dest.writeList(mUrls);
    }

    protected CharacterMarvel(Parcel in) {
        mId = in.readLong();
        mName = in.readString();
        mDescription = in.readString();
        mThumbnail = in.readParcelable(Image.class.getClassLoader());
        mUrls = new ArrayList<>();
        in.readList(mUrls, Url.class.getClassLoader());
    }

    public static final Parcelable.Creator<CharacterMarvel> CREATOR = new Parcelable.Creator<CharacterMarvel>() {
        @Override
        public CharacterMarvel createFromParcel(Parcel source) {
            return new CharacterMarvel(source);
        }

        @Override
        public CharacterMarvel[] newArray(int size) {
            return new CharacterMarvel[size];
        }
    };
}
