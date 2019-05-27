package com.example.myapplication.model;

import android.arch.lifecycle.LiveData;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakesh Prajapat on 2019-05-26
 * Copyright (c) 2019. All rights reserved by mobikode studio.
 * Last modified 16:19
 */


public class ArticlePojo implements Parcelable {
    private String status;
    private String copyright;
    private int num_results;
    private List<ArticlePojo> results;
    private String url;
    private String adx_keywords;
    private String column;
    private String section;
    private String byline;
    private String type;
    private String title;

    @SerializedName(value="abstract")
    private String abstract_data;
    private String published_date;
    private String source;
    private String id;
    private String asset_id;
    private int views;
    private ArrayList<ArticlePojo>media;
    private String subtype;
    private String caption;
    private int approved_for_syndication;
    @SerializedName(value="media-metadata")
    private ArrayList<ArticlePojo>media_metadata;
    private String format;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<ArticlePojo> getResults() {
        return results;
    }

    public void setResults(List<ArticlePojo> results) {
        this.results = results;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract_data() {
        return abstract_data;
    }

    public void setAbstract_data(String abstract_data) {
        this.abstract_data = abstract_data;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public ArrayList<ArticlePojo> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<ArticlePojo> media) {
        this.media = media;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getApproved_for_syndication() {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication(int approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }

    public ArrayList<ArticlePojo> getMedia_metadata() {
        return media_metadata;
    }

    public void setMedia_metadata(ArrayList<ArticlePojo> media_metadata) {
        this.media_metadata = media_metadata;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    protected ArticlePojo(Parcel in) {
        status = in.readString();
        copyright = in.readString();
        num_results = in.readInt();
        results = in.createTypedArrayList(ArticlePojo.CREATOR);
        url = in.readString();
        adx_keywords = in.readString();
        column = in.readString();
        section = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        abstract_data = in.readString();
        published_date = in.readString();
        source = in.readString();
        id = in.readString();
        asset_id = in.readString();
        views = in.readInt();
        media = in.createTypedArrayList(ArticlePojo.CREATOR);
        subtype = in.readString();
        caption = in.readString();
        approved_for_syndication = in.readInt();
        media_metadata = in.createTypedArrayList(ArticlePojo.CREATOR);
        format = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(copyright);
        dest.writeInt(num_results);
        dest.writeTypedList(results);
        dest.writeString(url);
        dest.writeString(adx_keywords);
        dest.writeString(column);
        dest.writeString(section);
        dest.writeString(byline);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(abstract_data);
        dest.writeString(published_date);
        dest.writeString(source);
        dest.writeString(id);
        dest.writeString(asset_id);
        dest.writeInt(views);
        dest.writeTypedList(media);
        dest.writeString(subtype);
        dest.writeString(caption);
        dest.writeInt(approved_for_syndication);
        dest.writeTypedList(media_metadata);
        dest.writeString(format);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArticlePojo> CREATOR = new Creator<ArticlePojo>() {
        @Override
        public ArticlePojo createFromParcel(Parcel in) {
            return new ArticlePojo(in);
        }

        @Override
        public ArticlePojo[] newArray(int size) {
            return new ArticlePojo[size];
        }
    };
}
