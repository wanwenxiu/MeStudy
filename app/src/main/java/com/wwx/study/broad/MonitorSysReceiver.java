package com.wwx.study.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 作者：wwx on 2017/5/10 0010 16:41
 * 邮箱：wanwenxiu0709@foxmail.com
 * 描述：
 */

public class MonitorSysReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Log.d("geek", "onReceive: MonitorSysReceiver");
        //接收安装广播
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String packageName = intent.getDataString();
            System.out.println("安装了:" +packageName + "包名的程序");
            Log.d("geek", "onReceive:安装了:" +packageName + "包名的程序");
        }
        //接收卸载广播
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            String packageName = intent.getDataString();
            Log.d("geek", "onReceive: 卸载了:"  + packageName + "包名的程序");
        }
    }
}