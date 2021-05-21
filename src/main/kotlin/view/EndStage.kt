package view

import logic.MainLogic
import tornadofx.*

class EndStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    override val root = vbox {
        label("End of the game!")
    }
}