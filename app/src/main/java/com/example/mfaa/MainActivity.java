package com.example.mfaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.NonNull;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private ConstraintLayout layout;
    private  static final String SUBMIT_DIALOG="submit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_fragment1 = findViewById(R.id.button_fragment1);
        button_fragment2 = findViewById(R.id.button_fragment2);
        button_fragment3 = findViewById(R.id.button_fragment3);
        button_fragment4 = findViewById(R.id.button_fragment4);
        textView = findViewById(R.id.frameName_textView);
        layout = findViewById(R.id.layout_main);

        registerForContextMenu(textView);

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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        String[] settingLabels = getResources().getStringArray(R.array.settings_list);
        menu.findItem(R.id.change_theme).setTitle(settingLabels[0]);
        menu.findItem(R.id.change_password).setTitle(settingLabels[1]);
        menu.findItem(R.id.exit).setTitle(settingLabels[2]);
        String[] settingsLabelsColors = getResources().getStringArray(R.array.settings_colors);
        menu.findItem(R.id.color1).setTitle(settingsLabelsColors[0]);
        menu.findItem(R.id.color2).setTitle(settingsLabelsColors[1]);
        menu.findItem(R.id.color3).setTitle(settingsLabelsColors[2]);
        menu.findItem(R.id.color4).setTitle(settingsLabelsColors[3]);
        menu.findItem(R.id.color5).setTitle(settingsLabelsColors[4]);
        menu.findItem(R.id.color6).setTitle(settingsLabelsColors[5]);
        menu.findItem(R.id.color7).setTitle(settingsLabelsColors[6]);
        menu.findItem(R.id.color8).setTitle(settingsLabelsColors[7]);
        menu.findItem(R.id.color9).setTitle(settingsLabelsColors[8]);
        menu.findItem(R.id.color10).setTitle(settingsLabelsColors[9]);
        menu.findItem(R.id.color11).setTitle(settingsLabelsColors[10]);
        menu.findItem(R.id.color12).setTitle(settingsLabelsColors[11]);
        menu.findItem(R.id.color13).setTitle(settingsLabelsColors[12]);
        menu.findItem(R.id.color14).setTitle(settingsLabelsColors[13]);
        menu.findItem(R.id.color15).setTitle(settingsLabelsColors[14]);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String option = "menu";
        switch (item.getItemId()){
            case R.id.color1:
                return changeBackgroundColor(getColor(R.color.black), item, option);
            case R.id.color2:
                return changeBackgroundColor(getColor(R.color.white), item, option);
            case R.id.color3:
                return changeBackgroundColor(getColor(R.color.pink), item, option);
            case R.id.color4:
                return changeBackgroundColor(getColor(R.color.orange), item, option);
            case R.id.color5:
                return changeBackgroundColor(getColor(R.color.yellow), item, option);
            case R.id.color6:
                return changeBackgroundColor(getColor(R.color.purple), item, option);
            case R.id.color7:
                return changeBackgroundColor(getColor(R.color.green), item, option);
            case R.id.color8:
                return changeBackgroundColor(getColor(R.color.blue), item, option);
            case R.id.color9:
                return changeBackgroundColor(getColor(R.color.brown), item, option);
            case R.id.color10:
                return changeBackgroundColor(getColor(R.color.gray), item, option);
            case R.id.color11:
                return changeBackgroundColor(getColor(R.color.cyan), item, option);
            case R.id.color12:
                return changeBackgroundColor(getColor(R.color.teal), item, option);
            case R.id.color13:
                return changeBackgroundColor(getColor(R.color.ligthSkyBlue), item, option);
            case R.id.color14:
                return changeBackgroundColor(getColor(R.color.lime), item, option);
            case R.id.color15:
                return changeBackgroundColor(getColor(R.color.orchid), item, option);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        String[] settingsLabelsColors = getResources().getStringArray(R.array.settings_colors);
        menu.findItem(R.id.contex_menu_color1).setTitle(settingsLabelsColors[0]);
        menu.findItem(R.id.contex_menu_color2).setTitle(settingsLabelsColors[1]);
        menu.findItem(R.id.contex_menu_color3).setTitle(settingsLabelsColors[2]);
        menu.findItem(R.id.contex_menu_color4).setTitle(settingsLabelsColors[3]);
        menu.findItem(R.id.contex_menu_color5).setTitle(settingsLabelsColors[4]);
        menu.findItem(R.id.contex_menu_color6).setTitle(settingsLabelsColors[5]);
        menu.findItem(R.id.contex_menu_color7).setTitle(settingsLabelsColors[6]);
        menu.findItem(R.id.contex_menu_color8).setTitle(settingsLabelsColors[7]);
        menu.findItem(R.id.contex_menu_color9).setTitle(settingsLabelsColors[8]);
        menu.findItem(R.id.contex_menu_color10).setTitle(settingsLabelsColors[9]);
        menu.findItem(R.id.contex_menu_color11).setTitle(settingsLabelsColors[10]);
        menu.findItem(R.id.contex_menu_color12).setTitle(settingsLabelsColors[11]);
        menu.findItem(R.id.contex_menu_color13).setTitle(settingsLabelsColors[12]);
        menu.findItem(R.id.contex_menu_color14).setTitle(settingsLabelsColors[13]);
        menu.findItem(R.id.contex_menu_color15).setTitle(settingsLabelsColors[14]);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {

        String option = "context-menu";
        switch (item.getItemId())
        {
            case R.id.change_color_text:
                ColorDrawable viewColor = (ColorDrawable) layout.getBackground();
                textView.setTextColor(viewColor.getColor());
                return true;
            case R.id.contex_menu_color1:
                return changeBackgroundColor(getColor(R.color.black), item, option);
            case R.id.contex_menu_color2:
                return changeBackgroundColor(getColor(R.color.white), item, option);
            case R.id.contex_menu_color3:
                return changeBackgroundColor(getColor(R.color.pink), item, option);
            case R.id.contex_menu_color4:
                return changeBackgroundColor(getColor(R.color.orange), item, option);
            case R.id.contex_menu_color5:
                return changeBackgroundColor(getColor(R.color.yellow), item, option);
            case R.id.contex_menu_color6:
                return changeBackgroundColor(getColor(R.color.purple), item, option);
            case R.id.contex_menu_color7:
                return changeBackgroundColor(getColor(R.color.green), item, option);
            case R.id.contex_menu_color8:
                return changeBackgroundColor(getColor(R.color.blue), item, option);
            case R.id.contex_menu_color9:
                return changeBackgroundColor(getColor(R.color.brown), item, option);
            case R.id.contex_menu_color10:
                return changeBackgroundColor(getColor(R.color.gray), item, option);
            case R.id.contex_menu_color11:
                return changeBackgroundColor(getColor(R.color.cyan), item, option);
            case R.id.contex_menu_color12:
                return changeBackgroundColor(getColor(R.color.teal), item, option);
            case R.id.contex_menu_color13:
                return changeBackgroundColor(getColor(R.color.ligthSkyBlue), item, option);
            case R.id.contex_menu_color14:
                return changeBackgroundColor(getColor(R.color.lime), item, option);
            case R.id.contex_menu_color15:
                return changeBackgroundColor(getColor(R.color.orchid), item, option);
            default:
                return super.onContextItemSelected(item);
        }
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

    public boolean changeBackgroundColor(Integer color, MenuItem item, String option){
        if (option == "menu"){
            layout.setBackgroundColor(color);
            if (item.isChecked()) item.setChecked(false);
            else item.setChecked(true);
            return true;
        } else if (option == "context-menu") {
            textView.setBackgroundColor(color);
            if (item.isChecked()) item.setChecked(false);
            else item.setChecked(true);
            return true;
        }
        else {
            return true;
        }
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
        FragmentManager fm = this.getSupportFragmentManager();
        DialogSubmit dialog = new DialogSubmit();
        dialog.show(fm, SUBMIT_DIALOG);
    }
}