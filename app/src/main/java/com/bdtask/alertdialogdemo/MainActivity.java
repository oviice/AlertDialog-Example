package com.bdtask.alertdialogdemo;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button alertDialog, customAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialog = findViewById(R.id.alertDialogId);
        customAlertDialog = findViewById(R.id.customAlertDialogId);
        alertDialog.setOnClickListener(v -> AlertDialogCode());
        customAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialogCode();
            }
        });

    }

    private void AlertDialogCode() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure to Press the button ?");
        builder.setPositiveButton("Yes", (dialog, id) -> {
            Toast.makeText(this, "Yes button pressed ", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });

        builder.setNegativeButton("No", (dialog, id) -> {
            Toast.makeText(this, "No button pressed", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    private void CustomAlertDialogCode() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_alert_dialog);
        // Custom Android Allert Dialog Title
        dialog.setTitle("Custom Dialog Example");

        Button dialogButtonCancel = dialog.findViewById(R.id.customDialogCancel);
        Button dialogButtonOk = dialog.findViewById(R.id.customDialogOk);
        // Click cancel to dismiss android custom dialog box
        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cancel Button Pressed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        // Your android custom dialog ok action
        // Action for custom dialog ok button click
        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ok button Pressed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

