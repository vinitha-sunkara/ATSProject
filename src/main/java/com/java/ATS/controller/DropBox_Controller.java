package com.java.ATS.controller;

import com.java.ATS.service.DropBox_Service;
import com.java.ATS.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DropBox_Controller {

    private DropBox_Service serviceObjb;

    public DropBox_Controller() {
        serviceObjb = new DropBox_Service();
    }


    public String getDataFromDropBoxLink() {
        String dataDropBoxLink = serviceObjb.getDataFromDropBoxLink();
        return dataDropBoxLink;
    }


    @RequestMapping(Constants.GET_FULL_JSON_OBJECT)
    public ArrayList<String> getFullJSONObject() {
        ArrayList<String> fullJSONStringArrayList = serviceObjb.getFullJSONObject();
        return fullJSONStringArrayList;
    }


    @RequestMapping(Constants.GET_ADDRESS_JSON_BY_CITY_NAME)
    public ArrayList<String> getAddressJSONObject() {
        ArrayList<String> addressStringArrayList = serviceObjb.getAddressJSONObject();
        return addressStringArrayList;
    }


    @RequestMapping(Constants.GET_CITY_BY_NAME)
    public ArrayList<String> getCityArrayObject() {
        ArrayList<String> cityStringArrayList = serviceObjb.getCityArrayObject();
        return cityStringArrayList;
    }
}
