package org.computermentors.childdevelopment;

public class PositiveFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
        return Milestones.positives[index].split("`");
    }
}
