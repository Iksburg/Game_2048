package logic

import tornadofx.*
import kotlin.random.Random

class MainLogic: Controller() {
    val currentField = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    fun random (): List<Int> {
        val listOfRandom = mutableListOf<Int>()
        for (i in 0..15) {
            if (currentField[i] == 0) {
                listOfRandom += i
            }
        }
        val cellForChange = Random.nextInt(0, listOfRandom.size)
        currentField[listOfRandom[cellForChange]] = 2
        return currentField
    }

    fun moveW() {

    }

    fun moveS() {

    }

    fun moveA() {

    }

    fun moveD() {

    }

    fun endGame (): Boolean {
        for (i in 0..15) {
            if (currentField[i] == 0) return false
        }
        return true
    }
}