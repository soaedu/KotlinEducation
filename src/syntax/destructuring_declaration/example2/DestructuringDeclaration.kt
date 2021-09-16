package syntax.destructuring_declaration.example2

/**
 * Destructuring in lambdas
 */
fun main() {
    val trip1 = Trip(id = 123456, duration = 25, driverId = "D-01234", address = "Pushkin str. 45")
    val trip2 = Trip(id = 234567, duration = 45, driverId = "D-23456", address = "Decebal str. 55")
    val trips = mapOf(trip1.id to trip1, trip2.id to trip2)

    // One parameter { a -> ... }
    println("1. trip data:")
    val showTripData = { trip: Trip ->
        println("$trip")
    }
    showTripData(trip1)

    // Two parameters { a, b -> ... }
    println("2. trip data:")
    val showTripIdAndDuration = { id: Int, duration: Int ->
        println("\tid: $id, duration: $duration")
    }
    showTripIdAndDuration(trip1.id, trip1.duration)

    // A destructured pair { (a, b) -> ... }
    println("3. trip data:")
    val showPairOfTripIdAndAddress = { (id, _, _, address): Trip ->
        println("\tid: $id, address: $address")
    }
    // showPairOfTripIdAndAddress(trip1)
    trips.forEach { showPairOfTripIdAndAddress(it.value) }

    // A destructured pair and another parameter { (a, b), c -> ... }

    println("4. trip data:")
    val showPairOfTripWithOneMoreParameter = { (id, duration): Trip, address: String ->
        println("\tid: $id, duration: $duration, address: $address")
    }
    trips.forEach { showPairOfTripWithOneMoreParameter(it.value, it.value.address) }
}

data class Trip(val id: Int, val duration: Int, val driverId: String, val address: String) {
    override fun toString(): String {
        return "\tTrip(" +
                "\n\t\tid: $id" +
                "\n\t\tduration: $duration" +
                "\n\t\tdriverId: $driverId" +
                "\n\t\taddress: $address" +
                "\n\t)"
    }
}
