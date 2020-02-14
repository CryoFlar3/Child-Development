package org.computermentors.childdevelopment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerFragment extends Fragment {

    public static final String KEY_AGE_INDEX = "age_index";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index= getArguments().getInt(KEY_AGE_INDEX);
        getActivity().setTitle(Milestones.headers[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        final PositiveFragment positiveFragment = new PositiveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_AGE_INDEX, index);
        positiveFragment.setArguments(bundle);
        final CautionFragment cautionFragment = new CautionFragment();


        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? positiveFragment : cautionFragment;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return  position == 0 ? "Good Signs" : "Caution";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
