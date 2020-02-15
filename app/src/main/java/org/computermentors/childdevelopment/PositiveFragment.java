package org.computermentors.childdevelopment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PositiveFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_AGE_INDEX);
        View view = inflater.inflate(R.layout.fragment_positive, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.positiveLayout);
        String[] positives = Milestones.positives[index].split("`");
        setUpCheckBoxes(positives, linearLayout);

        return view;
    }

    private void setUpCheckBoxes(String[] positives, ViewGroup container){
        for (String positive : positives){
            CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setPadding(8,16,8,16);
            checkBox.setTextSize(20f);
            checkBox.setText(positive);
            container.addView(checkBox);
        }
    }
}
