package com.example.android.healthcare;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class InformationDialog extends AppCompatDialogFragment {
    AlertDialog.Builder builder;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Infomation of Jumping Jacks")
                .setMessage("Start by standing with your legs straight and your arms to your sides."+
                        "Jump up and spread your feet beyond hip-width apart while bringing your arms above your head, nearly touching."+
                        "Jump again, lowering your arms and bringing your legs together. Return to your starting position.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();

    }
}
