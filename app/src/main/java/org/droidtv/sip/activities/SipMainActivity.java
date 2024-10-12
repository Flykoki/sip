package org.droidtv.sip.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import org.droidtv.sip.R;
import org.droidtv.sip.adapter.SipFragmentPageAdapter;

public class SipMainActivity extends FragmentActivity implements View.OnClickListener {
    public static final String TAG = "SipMainActivity";
    private ViewPager viewPager;
    private Context context;
    private TabLayout tabLayout;
    private TextView tvAccountConfig;
    private TextView tvAccountInfoTips;
    private ImageView ivSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sip_main);

        initData();
        initView();
    }

    private void initData() {
        context = this;
    }

    private void initView() {
        tvAccountInfoTips = findViewById(R.id.tv_account_tip);
        tvAccountConfig = findViewById(R.id.tv_config_account);
        tvAccountConfig.setOnClickListener(this);
        tvAccountConfig.requestFocus();
        ivSetting = findViewById(R.id.iv_setting);
        ivSetting.setOnClickListener(this);
        viewPager = findViewById(R.id.viewpage);
        tabLayout = findViewById(R.id.tab_container);
        viewPager.setAdapter(new SipFragmentPageAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout
                .getTabAt(0)
                .view
                .setBackground(context.getDrawable(R.drawable.full_tab_indicator));
        tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        tab.view.setBackground(context.getDrawable(R.drawable.full_tab_indicator));
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        tab.view.setBackground(
                                context.getDrawable(R.drawable.tab_indicator_selector));
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_config_account:
                // 配置账户
                Log.d(TAG, "onClick: 配置账户");
                break;
            case R.id.iv_setting:
                // setting
                Log.d(TAG, "onClick: 设置");
                break;
            default:
                break;
        }
    }
}
