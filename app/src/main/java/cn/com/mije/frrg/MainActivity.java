package cn.com.mije.frrg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.com.mije.frrg.utils.ThemeUtils;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }


}
