package org.computermentors.childdevelopment;

class GridAdapter extends RecyclerAdapter{
    private final GridFragment.OnAgeSelectedInterface listener;

    public GridAdapter(GridFragment.OnAgeSelectedInterface listener) {
        this.listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onAgeSelected(int index) {
        listener.onGridAgeSelected(index);
    }

}
