package com.demo.library.router

/**
 * activity的路由
 */
object RouterActivityPath {
    const val PREFIX = "/activity"

    object Main {
        private const val HOME = "$PREFIX/home"
        const val MAIN = "$HOME/main"
    }

    object Mine {
        private const val MINE = "$PREFIX/mine"
        const val MINE_MAIN = "$MINE/main"
    }
}