package org.computermentors.childdevelopment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class DualPaneFragment extends Fragment {
    private static final String POSITIVE_FRAGMENT = "positive_fragment";
    private static final String CONCERNS_FRAGMENT = "concerns_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index= getArguments().getInt(ViewPagerFragment.KEY_AGE_INDEX);
        getActivity().setTitle(Milestones.headers[index]);
        View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();

        PositiveFragment savedPositiveFragment = (PositiveFragment) fragmentManager.findFragmentByTag(POSITIVE_FRAGMENT);

        if (savedPositiveFragment == null){
            PositiveFragment positiveFragment = new PositiveFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_AGE_INDEX, index);
            positiveFragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.leftPlaceholder, positiveFragment, POSITIVE_FRAGMENT).commit();
        }

        ConcernsFragment savedConcernsFragment = (ConcernsFragment) fragmentManager.findFragmentByTag(CONCERNS_FRAGMENT);

        if (savedConcernsFragment == null){
            ConcernsFragment concernsFragment = new ConcernsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ViewPagerFragment.KEY_AGE_INDEX, index);
            concernsFragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.rightPlaceholder, concernsFragment, CONCERNS_FRAGMENT).commit();
        }

        return view;
    }
}
