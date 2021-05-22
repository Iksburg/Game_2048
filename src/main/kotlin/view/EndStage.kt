package view

import logic.MainLogic
import tornadofx.*

class EndStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    override val root = vbox {
        hbox {
            label("End of the game! Your total score = " + controller.totalScore)
        }
        hbox {
            button("Resume game") {
                action {
                    replaceWith<StartStage>()
                }
            }
        }
        hbox {
            button("Quit") {
                action {
                    currentStage!!.close()
                }
            }
        }
    }
}