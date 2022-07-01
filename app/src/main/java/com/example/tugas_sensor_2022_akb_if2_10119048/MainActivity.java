/**
 * Mochammad Faishal
 * 10119048
 * IF2
 */
package com.example.tugas_sensor_2022_akb_if2_10119048;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.tugas_sensor_2022_akb_if2_10119048.Map;
import com.example.tugas_sensor_2022_akb_if2_10119048.CafeMap;
import com.example.tugas_sensor_2022_akb_if2_10119048.Info;
import com.example.tugas_sensor_2022_akb_if2_10119048.Profile;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        animatedBottomBar = findViewById(R.id.animatedBottomBar);

//        if (savedInstanceState==null){
//            animatedBottomBar.selectTabById(R.id.navigation_cafe, true);
//            fragmentManager = getSupportFragmentManager();
//            CafeMap mapsResto = new CafeMap();
//            fragmentManager.beginTransaction().replace(R.id.fragment_container, mapsResto)
//                    .commit();
//        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NonNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()){
                    case  R.id.navigation_home:
                        fragment = new Profile();
                        break;
                    case R.id.navigation_cafe:
                        fragment = new CafeMap();
                        break;
                    case R.id.navigation_locatio_user:
                        fragment = new Map();
                        break;
                    case  R.id.navigation_info:
                        fragment = new Info();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                }else{
                    Log.e(TAG, "Error in creating fragment");
                }
            }

            @Override
            public void onTabReselected(int lastIndex, @NonNull AnimatedBottomBar.Tab lastTab) {

            }
        });
    }
}