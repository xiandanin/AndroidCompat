package com.dyhdyh.compat.platform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * @author dengyuhan
 * created 2019/3/19 13:33
 */
public final class UriCompat {

    public static Uri fromFile(Context context, File file, Intent intent) {
        if (intent != null) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }
        return fromFile(context, file);
    }

    public static Uri fromFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
        } else {
            return Uri.fromFile(file);
        }
    }
}
