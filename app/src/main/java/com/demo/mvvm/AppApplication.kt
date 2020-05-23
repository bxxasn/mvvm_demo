package com.demo.mvvm

import com.alibaba.android.arouter.launcher.ARouter
import com.app.lib.base.BaseApplication
import com.demo.library.initconfig.ModuleLifecycleConfig

class AppApplication :BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        // 初始化需要初始化的组件
        ModuleLifecycleConfig.instance.initModule(this)

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}