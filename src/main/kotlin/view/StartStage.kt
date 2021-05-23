package view

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import logic.MainLogic
import tornadofx.*

class StartStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    override val root = vbox(spacing = 100.0, alignment = Pos.CENTER) {
        label("Click on this button to start the game") {
            style {
                fontWeight = FontWeight.BOLD
                fontSize = 25.px
                fontFamily = "Comic Sans MS"
            }
        }
        button("Start") {
            style {
                fontSize = 30.px
                fontFamily = "Comic Sans MS"
            }
            action {
                controller.randomForField()
                controller.randomForField()
                replaceWith<MainStage>()
            }
        }
    }
}