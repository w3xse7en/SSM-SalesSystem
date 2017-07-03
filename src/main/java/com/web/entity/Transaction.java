package com.web.entity;

import java.util.Date;

/**
 * Created by Mew on 2017/6/30.
 */
public class Transaction {
    private int contentId;
    private int personId;
    private int price;

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
