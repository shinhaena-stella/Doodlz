package com.example.mt2c4.doodlz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static com.example.mt2c4.doodlz.MainActivityFragment.getBgMusic_state;

/**
 * Created by MT2C4 on 12/13/2017.
 */

public class MusicDialogFragment extends DialogFragment {

    private Switch musicSwitch;

    public Dialog onCreateDialog(Bundle bundle) {
        // create dialog
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        View bgmusicDialogView = getActivity().getLayoutInflater().inflate(
                R.layout.fragment_back_music, null);
        builder.setView(bgmusicDialogView); // add GUI to dialog



        // set the AlertDialog's message
        builder.setTitle(R.string.title_back_music_dialog);

        musicSwitch = (Switch)bgmusicDialogView.findViewById(R.id.bgmusicSwitch);

        if(getBgMusic_state()){
            musicSwitch.setChecked(true);
        }
        else{
            musicSwitch.setChecked(false);
        }


        return builder.create(); // return dialog


        musicSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener(){

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                         if(isChecked){
                             MainActivityFragment.setBgMusic_state(true);
                             MainActivityFragment.musicPlay();
                         }
                        else{
                             MainActivityFragment.setBgMusic_state(false);
                             MainActivityFragment.musicStop();
                    }

                }
    }

        );


    }


        private MainActivityFragment getDoodleFragment() {
            return (MainActivityFragment) getFragmentManager().findFragmentById(
                    R.id.doodleFragment);
        }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MainActivityFragment fragment = getDoodleFragment();

        if (fragment != null)
            fragment.setDialogOnScreen(true);
    }

    // tell MainActivityFragment that dialog is no longer displayed
    @Override
    public void onDetach() {
        super.onDetach();
        MainActivityFragment fragment = getDoodleFragment();

        if (fragment != null)
            fragment.setDialogOnScreen(false);
    }




