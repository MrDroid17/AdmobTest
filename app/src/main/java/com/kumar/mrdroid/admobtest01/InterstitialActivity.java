package com.kumar.mrdroid.admobtest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {
    private Button mShowButton;
    private InterstitialAd mInterstitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mShowButton = (Button) findViewById(R.id.showButton);
        mShowButton.setEnabled(false);
    }

    public void loadInterstitialAd(View view) {

        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.interstitial_loading));

        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));

        mInterstitial.setAdListener(new ToastAdListener(this){
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);

                mShowButton.setText(getmErrorReason());
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                mShowButton.setText("Show loaded Interstitial");
                mShowButton.setEnabled(true);

            }

        });

        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);
    }

    public void showInterstitialAd(View view) {

        if(mInterstitial.isLoaded()){

            mInterstitial.show();
        }

        mShowButton.setText(getResources().getString(R.string.interstitial_not_ready));
        mShowButton.setEnabled(false);
    }
}
