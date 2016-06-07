package com.purvin.demoapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("detail1")
    @Expose
    private String detail1;
    @SerializedName("detail2")
    @Expose
    private String detail2;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("parentid")
    @Expose
    private String parentid;
    @SerializedName("path")
    @Expose
    private String path;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     *
     * @param detail
     * The detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     *
     * @return
     * The detail1
     */
    public String getDetail1() {
        return detail1;
    }

    /**
     *
     * @param detail1
     * The detail1
     */
    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    /**
     *
     * @return
     * The detail2
     */
    public String getDetail2() {
        return detail2;
    }

    /**
     *
     * @param detail2
     * The detail2
     */
    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The parentid
     */
    public String getParentid() {
        return parentid;
    }

    /**
     *
     * @param parentid
     * The parentid
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     *
     * @return
     * The path
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @param path
     * The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.detail);
        dest.writeString(this.detail1);
        dest.writeString(this.detail2);
        dest.writeString(this.type);
        dest.writeString(this.status);
        dest.writeString(this.date);
        dest.writeString(this.parentid);
        dest.writeString(this.path);
    }

    public Gallery() {
    }

    protected Gallery(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.detail = in.readString();
        this.detail1 = in.readString();
        this.detail2 = in.readString();
        this.type = in.readString();
        this.status = in.readString();
        this.date = in.readString();
        this.parentid = in.readString();
        this.path = in.readString();
    }

    public static final Parcelable.Creator<Gallery> CREATOR = new Parcelable.Creator<Gallery>() {
        @Override
        public Gallery createFromParcel(Parcel source) {
            return new Gallery(source);
        }

        @Override
        public Gallery[] newArray(int size) {
            return new Gallery[size];
        }
    };
}
