package org.computermentors.childdevelopment;

public class ListAdapter extends RecyclerAdapter{
    private final ListFragment.OnAgeSelectedInterface listener;

    public ListAdapter(ListFragment.OnAgeSelectedInterface listener) {
        this.listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onAgeSelected(int index) {
        listener.onListAgeSelected(index);
    }

}
