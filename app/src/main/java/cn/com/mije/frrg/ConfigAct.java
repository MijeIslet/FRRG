package cn.com.mije.frrg;

import android.os.Bundle;

import java.util.List;

import cn.com.mije.frrg.utils.PatternLockUtils;
import cn.com.mije.frrg.utils.PreferenceContract;
import cn.com.mije.frrg.utils.PreferenceUtils;
import cn.com.mije.library.ConfirmPatternActivity;
import cn.com.mije.library.PatternView;

/**
 * Created by Administrator on 2017/5/16.
 */

public class ConfigAct extends ConfirmPatternActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean isStealthModeEnabled() {
        return !PreferenceUtils.getBoolean(PreferenceContract.KEY_PATTERN_VISIBLE,
                PreferenceContract.DEFAULT_PATTERN_VISIBLE, this);
    }

    @Override
    protected boolean isPatternCorrect(List<PatternView.Cell> pattern) {
        return PatternLockUtils.isPatternCorrect(pattern, this);
    }

    @Override
    protected void onForgotPassword() {

        //忘记密码操作
//        startActivity(new Intent(this, ResetPatternActivity.class));

        // Finish with RESULT_FORGOT_PASSWORD.
        super.onForgotPassword();
    }
}
