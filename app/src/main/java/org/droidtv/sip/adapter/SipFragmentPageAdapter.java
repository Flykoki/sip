package org.droidtv.sip.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import org.droidtv.sip.R;
import org.droidtv.sip.fragments.ContactFragment;
import org.droidtv.sip.fragments.DialFragment;

public class SipFragmentPageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ArrayList<String> titleList = new ArrayList<>();

    public SipFragmentPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public SipFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        if (fragmentArrayList.isEmpty()) {
            fragmentArrayList.add(new DialFragment());
            fragmentArrayList.add(new ContactFragment());
        }
        titleList.add(context.getString(R.string.dial));
        titleList.add(context.getString(R.string.contact));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
