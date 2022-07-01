/**
 * Mochammad Faishal
 * 10119048
 * IF2
 */
package com.example.tugas_sensor_2022_akb_if2_10119048;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tugas_sensor_2022_akb_if2_10119048.MainActivity;
import com.example.tugas_sensor_2022_akb_if2_10119048.R;

public class SlideActivity extends AppCompatActivity {
    ViewPager viewPager;
    Button btnNext;
    int[] layouts;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        viewPager = findViewById(R.id.pager);
        btnNext = findViewById(R.id.BtnNext);

        layouts = new int[] {
                R.layout.layout1,
                R.layout.layout2,
                R.layout.layout3
        };

        adapter = new Adapter(this, layouts);
        viewPager.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<layouts.length){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //kembali ke main activity
                    startActivity(new Intent(SlideActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i == layouts.length -1 ){
                btnNext.setText("Gass");
            }else {
                btnNext.setText("Lesgooo");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
