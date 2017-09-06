package com.wwx.study.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 作者：wwx on 2017/5/13 0013 15:03
 * 邮箱：wanwenxiu0709@foxmail.com
 * 描述：
 */

public class comm {
    /**
     * 检查模块是否安装
     *
     * @param context
     * @param packageName
     *            需要检查的包名称
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for (int i = 0; i < pinfo.size(); i++) {
            if (pinfo.get(i).packageName.equalsIgnoreCase(packageName)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public static boolean copyApkFromAssets(Context context, String fileName, String path) {
        boolean copyIsFinish = false;
        try {
            InputStream is = context.getAssets().open(fileName);
            File file = new File(path);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }
            fos.close();
            is.close();
            copyIsFinish = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copyIsFinish;
    }

    /**
     *
     * 安装apk apk路径在：/data/data/" + ctx.getPackageName() + "/files下
     *
     * @param ctx
     * @param apkPath
     */
    public static void Install_New(Context ctx, String apkPath) {

        // 如果文件不存在则再次复制一遍
        File file = new File(apkPath);
        Log.d("geek", "Install_New: file"+file.toString());
        if (!file.exists()) {
            return;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        ctx.startActivity(i);
    }
}
