package com.kaltura.playkit.backend.ovp.data;

import com.kaltura.playkit.backend.BaseResult;

import java.util.ArrayList;

/**
 * Created by tehilarozin on 02/11/2016.
 */

public class KalturaEntryContextDataResult extends BaseResult {

    ArrayList<KalturaFlavorAsset> flavorAssets;


    public ArrayList<KalturaFlavorAsset> getFlavorAssets() {
        return flavorAssets;
    }


}
