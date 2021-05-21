package view

import logic.MainLogic
import tornadofx.*

class StartStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    override val root = vbox {
        label("Click on this button to start the game")
        button("Start") {
            action {
                controller.random()
                controller.random()
                replaceWith<MainStage>()
            }
        }
    }
}