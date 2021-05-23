package view

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import logic.MainLogic
import tornadofx.*

class EndStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    override val root = vbox(spacing = 100.0, alignment = Pos.CENTER) {
        hbox(alignment = Pos.CENTER) {
            label("End of the game! Your total score = ") {
                style {
                    fontWeight = FontWeight.BOLD
                    fontSize = 25.px
                    fontFamily = "Comic Sans MS"
                }
            }
            label(controller.score) {
                style {
                    fontWeight = FontWeight.BOLD
                    fontSize = 25.px
                    fontFamily = "Comic Sans MS"
                }
            }
        }
        hbox (spacing = 50.0, alignment = Pos.CENTER) {
            button("Resume game") {
                style {
                    fontSize = 30.px
                    fontFamily = "Comic Sans MS"
                }
                action {
                    replaceWith<StartStage>()
                    controller.score.value = "0"
                }
            }
            button("Quit") {
                style {
                    fontSize = 30.px
                    fontFamily = "Comic Sans MS"
                }
                action {
                    currentStage!!.close()
                }
            }
        }
    }
}