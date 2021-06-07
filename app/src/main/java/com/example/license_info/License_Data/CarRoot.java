package com.example.license_info.License_Data;

import java.util.List;

public class CarRoot {








    public int statusCode;
    public String statusMessage;
    public List<Datum> data;

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public List<Datum> getData() {
        return data;
    }
}
