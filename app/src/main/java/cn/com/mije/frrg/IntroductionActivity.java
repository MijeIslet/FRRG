package cn.com.mije.frrg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.mije.frrg.utils.PatternLockUtils;

public class IntroductionActivity extends AppCompatActivity implements PatternLockUtils.OnConfirmPatternResultListener{

    private boolean isSuccessFul = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        if(!PatternLockUtils.hasPattern(this)){
            startActivity(new Intent(this,SetAct.class).putExtra("isFrist",true));
            finish();
        }

        PatternLockUtils.confirmPatternIfHas(this);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(isSuccessFul) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (PatternLockUtils.checkConfirmPatternResult(this, requestCode, resultCode)) {
            // Do nothing.
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onConfirmPatternResult(boolean successful) {
        if (successful) {
            // Throws IllegalStateException if we add our fragment now.
            isSuccessFul = true;
        } else {
            finish();
        }
    }
}
