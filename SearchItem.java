package com.example.mygift.giftit;

import java.io.Serializable;

/**
 * Created by NRV on 4/28/2015.
 */
public class SearchItem implements Serializable{
    String itemid;
    String title;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isReturn_accepted() {
        return return_accepted;
    }

    double price;

    public SearchItem(String itemid, String title, String globalId, String primaryCat, String gallURL, String itemUrl, String payment, String autopay, String location, String country, String shoppinginfo, String sellingStatus, String listinginfo, boolean return_accepted, String condition, String isMulti, String topRated,double pr) {
        this.itemid = itemid;
        this.title = title;
        this.globalId = globalId;
        this.primaryCat = primaryCat;
        this.gallURL = gallURL;
        this.itemUrl = itemUrl;
        this.payment = payment;
        this.autopay = autopay;
        this.location = location;
        this.country = country;
        this.shoppinginfo = shoppinginfo;
        this.sellingStatus = sellingStatus;
        this.listinginfo = listinginfo;
        this.return_accepted = return_accepted;
        this.condition = condition;
        this.isMulti = isMulti;
        this.topRated = topRated;
        this.price=pr;
    }

    String globalId;
    String primaryCat;
    String gallURL;
    String itemUrl;
    String payment;
    String autopay;
    String location;
    String country;
    String shoppinginfo;
    String sellingStatus;
    String listinginfo;
    boolean return_accepted;
    String condition;
    String isMulti;
    String topRated;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getPrimaryCat() {
        return primaryCat;
    }

    public void setPrimaryCat(String primaryCat) {
        this.primaryCat = primaryCat;
    }

    public String getGallURL() {
        return gallURL;
    }

    public void setGallURL(String gallURL) {
        this.gallURL = gallURL;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getAutopay() {
        return autopay;
    }

    public void setAutopay(String autopay) {
        this.autopay = autopay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShoppinginfo() {
        return shoppinginfo;
    }

    public void setShoppinginfo(String shoppinginfo) {
        this.shoppinginfo = shoppinginfo;
    }

    public String getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(String sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    public String getListinginfo() {
        return listinginfo;
    }

    public void setListinginfo(String listinginfo) {
        this.listinginfo = listinginfo;
    }

    public boolean getReturn_accepted() {
        return return_accepted;
    }

    public void setReturn_accepted(boolean return_accepted) {
        this.return_accepted = return_accepted;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(String isMulti) {
        this.isMulti = isMulti;
    }

    public String getTopRated() {
        return topRated;
    }

    public void setTopRated(String topRated) {
        this.topRated = topRated;
    }
}
