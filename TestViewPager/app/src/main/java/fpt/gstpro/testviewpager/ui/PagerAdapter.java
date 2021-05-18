package fpt.gstpro.testviewpager.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import fpt.gstpro.testviewpager.model.Photo;

public class PagerAdapter extends FragmentStateAdapter {
    private List<Photo> photoList;

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Photo> photoList) {
        super(fragmentActivity);
        this.photoList = photoList;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PhotoFragment.newInstance(photoList.get(position));
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
