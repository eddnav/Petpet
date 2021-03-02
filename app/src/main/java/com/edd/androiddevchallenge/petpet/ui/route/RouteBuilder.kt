package com.edd.androiddevchallenge.petpet.ui.route

class RouteBuilder(private val route: Route) {

    private val args = mutableMapOf<String, String>()

    fun setArg(arg: String, value: String): RouteBuilder {
        args[arg] = value
        return this
    }

    fun build(): String {
        var route = route.value
        args.forEach { (arg, value) ->
            route = route.replace("{${arg}}", value)
        }
        return route
    }
}