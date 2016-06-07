package com.purvin.demoapplication.models;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tops on 6/2/2016.
 */
public class ActivitiesInfo {
    private String id;
    private String userId;
    private String categoryId;
    private String activityTitle;
    private String activityDesc;
    private String photo;
    private String activityTime;
    private String venue;
    private String trainer;
    private String noOfParticipants;
    private String noOfBeneficiary;
    private String activityStatus;
    private String status;
    private String crdate;
    private String photoName;
    private List<Object> photos = new ArrayList<Object>();
    private String activityTimeForm;

    public ActivitiesInfo(JSONObject object) {

        setActivityTitle(object.optString("activity_title"));
        setActivityDesc(object.optString("activity_desc"));
    }

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
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The activityTitle
     */
    public String getActivityTitle() {
        return activityTitle;
    }

    /**
     *
     * @param activityTitle
     * The activity_title
     */
    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    /**
     *
     * @return
     * The activityDesc
     */
    public String getActivityDesc() {
        return activityDesc;
    }

    /**
     *
     * @param activityDesc
     * The activity_desc
     */
    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    /**
     *
     * @return
     * The photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     *
     * @return
     * The activityTime
     */
    public String getActivityTime() {
        return activityTime;
    }

    /**
     *
     * @param activityTime
     * The activity_time
     */
    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    /**
     *
     * @return
     * The venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     *
     * @param venue
     * The venue
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }

    /**
     *
     * @return
     * The trainer
     */
    public String getTrainer() {
        return trainer;
    }

    /**
     *
     * @param trainer
     * The trainer
     */
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    /**
     *
     * @return
     * The noOfParticipants
     */
    public String getNoOfParticipants() {
        return noOfParticipants;
    }

    /**
     *
     * @param noOfParticipants
     * The no_of_participants
     */
    public void setNoOfParticipants(String noOfParticipants) {
        this.noOfParticipants = noOfParticipants;
    }

    /**
     *
     * @return
     * The noOfBeneficiary
     */
    public String getNoOfBeneficiary() {
        return noOfBeneficiary;
    }

    /**
     *
     * @param noOfBeneficiary
     * The no_of_beneficiary
     */
    public void setNoOfBeneficiary(String noOfBeneficiary) {
        this.noOfBeneficiary = noOfBeneficiary;
    }

    /**
     *
     * @return
     * The activityStatus
     */
    public String getActivityStatus() {
        return activityStatus;
    }

    /**
     *
     * @param activityStatus
     * The activity_status
     */
    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
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
     * The crdate
     */
    public String getCrdate() {
        return crdate;
    }

    /**
     *
     * @param crdate
     * The crdate
     */
    public void setCrdate(String crdate) {
        this.crdate = crdate;
    }

    /**
     *
     * @return
     * The photoName
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     *
     * @param photoName
     * The photo_name
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     *
     * @return
     * The photos
     */
    public List<Object> getPhotos() {
        return photos;
    }

    /**
     *
     * @param photos
     * The photos
     */
    public void setPhotos(List<Object> photos) {
        this.photos = photos;
    }

    /**
     *
     * @return
     * The activityTimeForm
     */
    public String getActivityTimeForm() {
        return activityTimeForm;
    }

    /**
     *
     * @param activityTimeForm
     * The activity_time_form
     */
    public void setActivityTimeForm(String activityTimeForm) {
        this.activityTimeForm = activityTimeForm;
    }
}

