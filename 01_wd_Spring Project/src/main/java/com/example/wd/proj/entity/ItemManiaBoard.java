package com.example.wd.proj.entity;

import java.util.Date;

public class ItemManiaBoard {
    private int customerNo;
    private String userId;
    private String userPw;
    private String nickName;
    private String itemName;
    private int price;
    private Date regDate;
    private String content;

    // custNo======================================================
    public int getCustomerNo() {
        return customerNo;
    }
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    // userId======================================================
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // userPw======================================================
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    // nickName======================================================
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    // itemName======================================================
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // price======================================================
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    // regDate======================================================
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    // content======================================================
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
