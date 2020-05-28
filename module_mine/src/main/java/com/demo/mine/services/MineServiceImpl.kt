package com.demo.mine.services

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.demo.library.services.IMineService

@Route(path = "/testAAA/single")
 class MineServiceImpl : IMineService {
    override fun getNewsName(): String {
        return "AAAAAAAAAAAAAAAAAA"
    }

    override fun sayHello(msg: String) {
        Log.e("AAAAAAAAAAAAA", "AAAAAAAAAAAA___" + msg)
    }

    override fun init(context: Context?) {
    }
}