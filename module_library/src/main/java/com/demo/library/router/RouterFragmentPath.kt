package com.demo.library.router

//        RouterFragmentPath.Home.HOME_MINE 访问
object RouterFragmentPath {
    private const val PREFIX = "/fragment"
    object Home{
        private const val HOME = PREFIX+"/home"
        const val HOME_MINE =HOME+"/main"
    }




}