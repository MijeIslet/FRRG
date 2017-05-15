package cn.com.mije.frrg;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.List;

import cn.com.mije.frrg.utils.AppUtils;
import cn.com.mije.frrg.utils.PatternLockUtils;
import cn.com.mije.library.PatternView;


/**
 * Created by Administrator on 2017/5/15.
 */

public class SetAct extends cn.com.mije.library.SetPatternActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppUtils.setActionBarDisplayUp(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                AppUtils.navigateUp(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSetPattern(List<PatternView.Cell> pattern) {
        PatternLockUtils.setPattern(pattern, this);
    }
}
