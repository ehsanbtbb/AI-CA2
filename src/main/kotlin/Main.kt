import java.io.File

fun main(args: Array<String>) {
    val airports: ArrayList<Airport> = getAirportsData()
    val aircraftAndAvailableNumbers: HashMap<Aircraft, Int> = getAircraftData()
    val trips: ArrayList<Trip> = getTripsData()
}

fun getAirportsData(): ArrayList<Airport> {
    val airports: ArrayList<Airport> = arrayListOf()
    File("airports.txt").forEachLine { currentLine ->
        currentLine.split(" ".toRegex()).takeIf { it.size == 3 }?.let { lineElements ->
            val currentAirport =
                Airport(lineElements[0], Position(lineElements[1].toDouble(), lineElements[2].toDouble()))
            airports.add(currentAirport)
        }
    }
    return airports
}

fun getAircraftData(): HashMap<Aircraft, Int> {
    val aircraftAndAvailableNumbers: HashMap<Aircraft, Int> = hashMapOf()
    File("aircrafts.txt").forEachLine { currentLine ->
        currentLine.split(" ".toRegex()).takeIf { it.size == 6 }?.let { lineElements ->
            val currentAircraft =
                Aircraft(
                    lineElements[0],
                    lineElements[1].toInt(),
                    lineElements[2].toInt(),
                    lineElements[3].toDouble() / 100,
                    lineElements[4].toDouble() / 100)
            val availableNumber = lineElements[5].toInt()
            aircraftAndAvailableNumbers.put(currentAircraft, availableNumber)
        }
    }
    return aircraftAndAvailableNumbers
}

fun getTripsData(): ArrayList<Trip> {
    val trips: ArrayList<Trip> = arrayListOf()
    File("passengers.txt").forEachLine { currentLine ->
        currentLine.split(" ".toRegex()).takeIf { it.size == 4 }?.let { lineElements ->
            val firstTrip =
                Trip(lineElements[0], lineElements[1], lineElements[2].toInt())
            val secondTrip = Trip(lineElements[1], lineElements[0], lineElements[3].toInt())
            trips.add(firstTrip)
            trips.add(secondTrip)
        }
    }
    return trips
}