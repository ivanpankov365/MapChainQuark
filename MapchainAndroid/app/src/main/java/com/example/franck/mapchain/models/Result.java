package com.example.franck.mapchain.models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("address_description")
    @Expose
    private AddressDescription addressDescription;
    @SerializedName("address_type")
    @Expose
    private String addressType;
    @SerializedName("booking")
    @Expose
    private Booking booking;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;
    @SerializedName("container")
    @Expose
    private String container;
    @SerializedName("count_favorites")
    @Expose
    private Integer countFavorites;
    @SerializedName("count_likes")
    @Expose
    private Integer countLikes;
    @SerializedName("count_views")
    @Expose
    private Integer countViews;
    @SerializedName("cover")
    @Expose
    private List<Cover> cover = null;
    @SerializedName("default_lang")
    @Expose
    private String defaultLang;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expires_on")
    @Expose
    private String expiresOn;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_external")
    @Expose
    private Boolean isExternal;
    @SerializedName("is_html")
    @Expose
    private Boolean isHtml;
    @SerializedName("langs")
    @Expose
    private List<String> langs = null;
    @SerializedName("last_mile")
    @Expose
    private LastMile lastMile;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("map_visibility")
    @Expose
    private Boolean mapVisibility;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("naviaddress")
    @Expose
    private String naviaddress;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("point")
    @Expose
    private Point point;
    @SerializedName("postal_address")
    @Expose
    private String postalAddress;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("sharable_cover")
    @Expose
    private List<SharableCover> sharableCover = null;
    @SerializedName("working_hours")
    @Expose
    private List<WorkingHour> workingHours = null;

    public AddressDescription getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(AddressDescription addressDescription) {
        this.addressDescription = addressDescription;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Integer getCountFavorites() {
        return countFavorites;
    }

    public void setCountFavorites(Integer countFavorites) {
        this.countFavorites = countFavorites;
    }

    public Integer getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(Integer countLikes) {
        this.countLikes = countLikes;
    }

    public Integer getCountViews() {
        return countViews;
    }

    public void setCountViews(Integer countViews) {
        this.countViews = countViews;
    }

    public List<Cover> getCover() {
        return cover;
    }

    public void setCover(List<Cover> cover) {
        this.cover = cover;
    }

    public String getDefaultLang() {
        return defaultLang;
    }

    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Boolean isExternal) {
        this.isExternal = isExternal;
    }

    public Boolean getIsHtml() {
        return isHtml;
    }

    public void setIsHtml(Boolean isHtml) {
        this.isHtml = isHtml;
    }

    public List<String> getLangs() {
        return langs;
    }

    public void setLangs(List<String> langs) {
        this.langs = langs;
    }

    public LastMile getLastMile() {
        return lastMile;
    }

    public void setLastMile(LastMile lastMile) {
        this.lastMile = lastMile;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Boolean getMapVisibility() {
        return mapVisibility;
    }

    public void setMapVisibility(Boolean mapVisibility) {
        this.mapVisibility = mapVisibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNaviaddress() {
        return naviaddress;
    }

    public void setNaviaddress(String naviaddress) {
        this.naviaddress = naviaddress;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<SharableCover> getSharableCover() {
        return sharableCover;
    }

    public void setSharableCover(List<SharableCover> sharableCover) {
        this.sharableCover = sharableCover;
    }

    public List<WorkingHour> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkingHour> workingHours) {
        this.workingHours = workingHours;
    }

}