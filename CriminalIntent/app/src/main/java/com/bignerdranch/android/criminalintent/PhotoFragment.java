package com.bignerdranch.android.criminalintent;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.UUID;

import static com.bignerdranch.android.criminalintent.R.id.photo;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends DialogFragment {

    public static final String ARG_CRIME = "crime";


    public PhotoFragment() {
        // Required empty public constructor
    }


    public static PhotoFragment newInstance( UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME, crimeId);
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
        } else {
            setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_NoActionBar);
        }
        super.onCreate(savedInstanceState);

    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME);
        Crime crime = CrimeLab.get(getActivity()).getCrime(crimeId);
        File photoFile = CrimeLab.get(getActivity()).getPhotoFile(crime);


        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_photo, null);
        ImageView photoImage = (ImageView) v.findViewById(photo);
        TextView text = (TextView) v.findViewById(R.id.text);
        if (photoFile == null || !photoFile.exists()) {
            photoImage.setImageDrawable(null);
            text.setText("No File");
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
            photoImage.setImageBitmap(bitmap);
            text.setVisibility(View.GONE);
        }



        return new AlertDialog.Builder( getActivity())
                .setView(v)
                .setTitle("Suspect Photo")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();



    }
}
