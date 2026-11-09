package org.example.lessons.lesson17.homeworks

class GameMachine(
    val color: String,
    val model: String,
    val hasJoystick: Boolean,
    val sessionPrice: Double,
    private val pinCode: String
) {

    var isEnabled: Boolean = false
        private set

    var isOsLoaded: Boolean = false
        private set

    var owner: String = ""
        private set

    var supportPhone: String = ""
        private set

    private val installedGames = mutableListOf<String>()

    private var revenue: Double = 0.0

    private var isSessionPaid: Boolean = false

    fun turnOn(): Unit {
        isEnabled = true
        loadOs()
    }

    fun turnOff(): Unit {
        shutdownOs()
        isEnabled = false
    }

    fun loadOs(): Boolean {
        if (!isEnabled) {
            return false
        }

        isOsLoaded = true
        return true
    }

    private fun shutdownOs(): Unit {
        isOsLoaded = false
        isSessionPaid = false
    }

    fun showGames(): List<String> {
        return installedGames.toList()
    }

    fun launchGame(game: String): Boolean {
        if (!isEnabled || !isOsLoaded || !isSessionPaid) {
            return false
        }

        if (game !in installedGames) {
            return false
        }
        isSessionPaid = false
        return true
    }

    fun payForSession(amount: Double): Boolean {
        if (!isEnabled || !isOsLoaded || isSessionPaid) {
            return false
        }

        if (amount < sessionPrice) {
            return false
        }

        revenue += sessionPrice
        isSessionPaid = true
        return true
    }

    fun withdrawCash(pin: String): Double {
        if (pin != pinCode) {
            return 0.0
        }

        val cash = revenue
        revenue = 0.0

        return cash
    }

    private fun openSafe(pin: String): Boolean {
        return pin == pinCode
    }

    private fun issueCash(pin: String): Double {
        if (!openSafe(pin)) {
            return 0.0
        }

        val cash = revenue
        revenue = 0.0

        return cash
    }
}