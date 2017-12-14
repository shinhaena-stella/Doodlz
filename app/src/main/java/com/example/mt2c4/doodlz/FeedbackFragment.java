package com.example.mt2c4.doodlz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.content.Intent;
import android.util.Log;
import android.support.v4.app.DialogFragment;


/**
 * Created by MT2C4 on 12/13/2017.
 */

public class FeedbackFragment  extends DialogFragment {

    public Dialog onCreateDialog(Bundle bundle) {
        // create dialog
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        View feedbackDialogView = getActivity().getLayoutInflater().inflate(
                R.layout.fragment_feedback, null);
        builder.setView(feedbackDialogView); // add GUI to dialog

        // set the AlertDialog's message
        builder.setTitle(R.string.title_feedback_dialog);

        Button startBtn = (Button) feedbackDialogView.findViewById(R.id.sendEmailButton);
        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
        return builder.create(); // return dialog
    }


    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));


//        try {
//            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
//            finish();
//            Log.i("Finished sending email...", "");
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
//        }
    }
}