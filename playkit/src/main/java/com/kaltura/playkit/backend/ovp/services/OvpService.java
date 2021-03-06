package com.kaltura.playkit.backend.ovp.services;

import com.google.gson.JsonObject;
import com.kaltura.playkit.PlayKitManager;
import com.kaltura.playkit.backend.ovp.OvpConfigs;
import com.kaltura.playkit.connect.MultiRequestBuilder;

/**
 * Created by tehilarozin on 14/11/2016.
 */
public class OvpService {

    public static String[] getRequestConfigKeys(){
        return new String[]{"clientTag", "apiVersion", "format"};
    }

    public static JsonObject getOvpConfigParams(){
        JsonObject params = new JsonObject();
        params.addProperty("clientTag", PlayKitManager.CLIENT_TAG);
        params.addProperty("apiVersion",OvpConfigs.ApiVersion);
        params.addProperty("format",1); //json format

        return params;
    }

    public static MultiRequestBuilder getMultirequest(String baseUrl, String ks){
        return getMultirequest(baseUrl, ks, -1);
    }

    public static MultiRequestBuilder getMultirequest(String baseUrl, String ks, int partnerId){
        JsonObject ovpParams = OvpService.getOvpConfigParams();
        ovpParams.addProperty("ks", ks);
        if(partnerId > 0) {
            ovpParams.addProperty("partnerId", partnerId);
        }
        return (MultiRequestBuilder) new MultiRequestBuilder().method("POST")
                .url(baseUrl)
                .params(ovpParams)
                .service("multirequest");
    }
}
