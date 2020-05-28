package com.demo.mvvm

import com.alibaba.android.arouter.launcher.ARouter
import com.app.lib.base.BaseApplication
import com.demo.library.initconfig.ModuleLifecycleConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


class AppApplication :BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        // 初始化需要初始化的组件
        ModuleLifecycleConfig.instance.initModule(this)

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)

        //日志
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}