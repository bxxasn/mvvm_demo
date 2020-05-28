package com.demo.home.debug

import com.app.lib.base.BaseApplication
import com.demo.home.init.HomeModuleInit
import com.demo.library.config.AppConfig

class HomeApplicaion: BaseApplication()  {
    override fun onCreate() {
        super.onCreate()
        AppConfig.init(this)

       var init = HomeModuleInit()
        init.onInitMain(this)
        init.onInitAsyn(this)
    }

}