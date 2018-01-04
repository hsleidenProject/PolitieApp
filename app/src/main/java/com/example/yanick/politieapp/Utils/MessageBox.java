package com.example.yanick.politieapp.Utils;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by 0x000000 on 4-1-2018.
 */

public class MessageBox {
    public MessageBox(Context context, String title, String message)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.create().show();
    }
}
