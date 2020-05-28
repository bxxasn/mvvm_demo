package com.demo.library.router

import android.provider.ContactsContract.CommonDataKinds.StructuredName.PREFIX

/**
 * Iprovider的路由
 */
object RouterProviderPath {

    private const val PREFIX = "/provider"

    object Mine {
        private const val MINE = "$PREFIX/mine"
        const val MINE_PROVIDER = "$MINE/main"
    }
}