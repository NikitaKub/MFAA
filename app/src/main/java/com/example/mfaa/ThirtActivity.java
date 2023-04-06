package com.example.mfaa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

public class ThirtActivity extends AppCompatActivity {

    private Integer bonuses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirt);
        bonuses = 0;
    }

    public void sendButton(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.youtubePromo:
                try {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://MVubdRyU3Mc"));
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=MVubdRyU3Mc"));
                }
                break;
            case R.id.marketPromo:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=Spotify"));
                break;
            case R.id.searchPromo:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "Warhammer");
                break;
            case R.id.twitterPromo:
                try {
                    this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=warhammer"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/warhammer"));
                }
                break;
            case R.id.settingsWireless:
                intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                break;
        }
        bonuses++;
        startActivity(intent);
    }

    public void backToMainActivity(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("PROMO", bonuses);
        startActivity(intent);
    }
}