package org.computermentors.childdevelopment;

public class ConcernsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Milestones.concerns[index].split("`");
    }
}
