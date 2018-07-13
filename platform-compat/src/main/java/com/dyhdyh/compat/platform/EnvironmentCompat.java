package com.dyhdyh.compat.platform;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;

/**
 * @author dengyuhan
 *         created 2018/7/13 13:44
 */
public final class EnvironmentCompat {
    private static final String[] MODEL_PACKAGE = new String[]{"com.htc", "com.meizu.mstore", "com.sonyericsson.android.camera", "com.yulong.android.settings.backup", "com.bbk.account", "com.gionee.account"};


    /**
     * 获取相机目录
     *
     * @param context
     * @return
     */
    public static File getCameraDirectory(Context context) {
        int index = -1;
        for (int i = 0; i < MODEL_PACKAGE.length; i++) {
            try {
                if (context.getPackageManager().getPackageInfo(MODEL_PACKAGE[i], 0) != null) {
                    index = i;
                    break;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        final File storageDirectory = Environment.getExternalStorageDirectory();
        File file = null;
        switch (index) {
            case 0:
                file = new File(storageDirectory, "/DCIM/100MEDIA");
                break;
            case 1:
                file = new File(storageDirectory, "/Camera");
                if (!file.exists()) {
                    file = new File(storageDirectory, "/DCIM");
                }
                break;
            case 2:
                file = new File(storageDirectory, "/DCIM/100ANDRO");
                break;
            case 3:
                file = new File(storageDirectory, "/Camera");
                break;
            case 4:
                file = new File(storageDirectory, "/相机");
                if (!file.exists()) {
                    file = new File(storageDirectory, "/相机/照片");
                }
                break;
            case 5:
                file = new File(storageDirectory, "/照相机/Camera");
                break;
        }
        if (file != null && file.exists()) {
            return file;
        }
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "/Camera");
    }

}
