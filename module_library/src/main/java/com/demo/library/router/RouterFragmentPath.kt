package com.demo.library.router


/**
 * fragment的路由
 */
object RouterFragmentPath {

    private const val PREFIX = "/fragment"

    object Home {
        private const val HOME = "$PREFIX/home"
        const val HOME_MINE = "$HOME/main"
    }


    object Mine {
        private const val MINE = "$PREFIX/mine"
        const val MINE_MAIN = "$MINE/main"
    }


}