package fpt.gstpro.testviewpager.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fpt.gstpro.testviewpager.R;
import fpt.gstpro.testviewpager.model.Photo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PHOTO_TITLE = "PHOTO";
    private static final String ARG_PHOTO_URL = "URL";

    private String mTitle;
    private String mUrl;

    public PhotoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PhotoFragment.
     */
    public static PhotoFragment newInstance(Photo photo) {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        // Set photo's information to pass by argument
        args.putString(ARG_PHOTO_TITLE, photo.getTitle());
        args.putString(ARG_PHOTO_URL, photo.getUrl());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_PHOTO_TITLE);
            mUrl = getArguments().getString(ARG_PHOTO_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        TextView lbTitle = view.findViewById(R.id.lbTitle);
        ImageView imageView = view.findViewById((R.id.imageView));

        lbTitle.setText(mTitle);
        Glide.with(view.getContext())
                .load(mUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(imageView);

        return view;
    }
}