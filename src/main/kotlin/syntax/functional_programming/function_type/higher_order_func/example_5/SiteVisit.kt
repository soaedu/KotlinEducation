package syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_5

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os : OS
)

fun getLogs() = listOf(
    SiteVisit( "/", 34.0, OS.WINDOWS),
    SiteVisit( "/", 22.0, OS.MAC),
    SiteVisit( "/login", 12.0, OS.WINDOWS),
    SiteVisit( "/signup", 8.0, OS.IOS),
    SiteVisit( "/", 16.3, OS.ANDROID)
)