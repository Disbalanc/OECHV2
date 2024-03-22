package com.example.oech.Profile.ui.track;

public class Item {
    String Title;
    String Address;
    String State;
    String Phone;
    String Others;
    //Данные от пользователя
    String dataTitle;
    String dataAddress;
    String dataState;
    String dataPhone;
    String dataOthers;

    public Item(String title, String address, String state, String phone, String others) {
        Address = address;
        State = state;
        Phone = phone;
        Others = others;
        Title = title;
    }
    public Item(String title,String address, String state, String phone) {
        Title = title;
        Address = address;
        State = state;
        Phone = phone;
    }

    public String save(){
        return dataTitle;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
//-------------------------------------
    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
//-------------------------------------
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
//-------------------------------------
    public String getOthers() {
        return Others;
    }

    public void setOthers(String others) {
        Others = others;
    }
//-------------------------------------
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
    //------------------------------------- Пользователь
    public String getDataTitleTitle() {
        return dataTitle;
    }

    public void setDataTitleTitle(String data) {
        dataTitle = data;
    }
}
