package com.demo.library.init

import android.util.Log
import com.app.lib.base.BaseApplication
import com.demo.library.initconfig.IModuleInit

//com.app.invest.InvestModuleInit

//com.demo.library.init.LibModuleInit
class LibModuleInit : IModuleInit {


    override fun onInitMain(application: BaseApplication?) {
        Log.e("AAAAAAAAAAAA","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
    }

    override fun onInitAsyn(application: BaseApplication?) {

    }
}