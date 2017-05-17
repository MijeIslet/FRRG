package cn.com.mije.frrg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.com.mije.frrg.utils.PatternLockUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_SetPatternLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_SetPatternLock = (Button) findViewById(R.id.btn_setPatternLock);
        btn_SetPatternLock.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!PatternLockUtils.hasPattern(this)){
            startActivity(new Intent(this,SetAct.class));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_setPatternLock :
                startActivity(new Intent(this,SetAct.class));
                break;
        }
    }

}
