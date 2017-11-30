package com.kumar.mrdroid.admobtest01;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by mrdroid on 5/11/17.
 */

public class ToastAdListener extends AdListener {

    private Context mContext;
    private String mErrorReason;

    public ToastAdListener(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(mContext, "onAdClosed()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        mErrorReason ="" ;

        switch (errorCode){

            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                mErrorReason ="Internal Error";
                break;

            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                mErrorReason ="Invalid Request";
                break;

            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                mErrorReason ="Network Error";
                break;

            case AdRequest.ERROR_CODE_NO_FILL:
                mErrorReason = "No fill";
                break;

        }

        Toast.makeText(mContext, String.format("onAdFailedToLoad(%s)", mErrorReason), Toast.LENGTH_SHORT).show();

    }

    public String getmErrorReason() {
        return mErrorReason == null ? "" : mErrorReason;
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(mContext, "onAdLeftApplications()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdOpened() {
        Toast.makeText(mContext, "onAdOpened()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLoaded() {
        Toast.makeText(mContext, "onAdLoaded", Toast.LENGTH_SHORT).show();
    }
}
