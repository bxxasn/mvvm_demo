package com.demo.mine.debug

import com.app.lib.base.BaseApplication
import com.demo.library.config.AppConfig
import com.demo.mine.init.MineModuleInit


class MineApplicaion: BaseApplication()  {
    override fun onCreate() {
        super.onCreate()
        AppConfig.init(this)

       var init = MineModuleInit()
        init.onInitMain(this)
        init.onInitAsyn(this)
    }

}