package com.example.mfaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mfaa.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button button_fragment1, button_fragment2, button_fragment3, button_fragment4;
    private TextView textView;
    private String nextFragmentTag;
    private FirstFragment fragment1 = new FirstFragment();
    private SecondFragment fragment2 = new SecondFragment();
    private ThirdFragment fragment3 = new ThirdFragment();
    private FourthFragment fragment4 = new FourthFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_fragment1 = findViewById(R.id.button_fragment1);
        button_fragment2 = findViewById(R.id.button_fragment2);
        button_fragment3 = findViewById(R.id.button_fragment3);
        button_fragment4 = findViewById(R.id.button_fragment4);
        textView = findViewById(R.id.frameName_textView);

        button_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(fragment1, "product_tag");
            }
        });
        button_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(fragment2, "count_tag");
            }
        });
        button_fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(fragment3, "delivery_tag");
            }
        });
        button_fragment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(fragment4, "submit_tag");
            }
        });
        Toast.makeText(this, "Please, login to your account.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "See you later!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "See you later!", Toast.LENGTH_LONG).show();
    }

    public void setFragment(Fragment fragment, String tag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment, tag);
        nextFragmentTag = tag;
        switch (nextFragmentTag){
            case "product_tag":
                textView.setText(R.string.btn_products);
                break;
            case "count_tag":
                textView.setText(R.string.btn_count);
                break;
            case "delivery_tag":
                textView.setText(R.string.btn_delivery);
                break;
            case "submit_tag":
                textView.setText(R.string.btn_submit);
                break;
        }
        ft.commit();
    }

    public void loginLink(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void nextFragment(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (nextFragmentTag){
            case "product_tag":
                nextFragmentTag = "count_tag";
                setFragment(fragment2, nextFragmentTag);
                break;
            case "count_tag":
                nextFragmentTag = "delivery_tag";
                setFragment(fragment3, nextFragmentTag);
                break;
            case "delivery_tag":
                nextFragmentTag = "submit_tag";
                setFragment(fragment4, nextFragmentTag);
                break;
            case "submit_tag":
                nextFragmentTag = "product_tag";
                setFragment(fragment1, nextFragmentTag);
                break;
        }
    }
    public void submitBTN(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}