data class Position(val latitude: Double, val longitude: Double)

data class Airport(val name: String, val position: Position)

data class Aircraft(
    val name: String,
    val capacity: Int,
    val price: Int,
    val perSeatPrice: Double,
    val perSeatLoss: Double
)

data class Trip(val originAirportName: String, val destinationAirportName: String, val numOfPassengers: Int)

data class Assignment(val trip: Trip, val aircraftSet: Set<Aircraft>)
