package com.example.composetask.navigation

sealed class NavRoute(val path: String) {

    data object Login: NavRoute("login")

    data object Dashboard: NavRoute("dashboard") {
        val email = "email"
    }

    data object Details: NavRoute("details") {
        const val obj = "obj"
    }

    data object Profile: NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    data object Search: NavRoute("search") {
        val query = "query"
    }

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(path)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}

