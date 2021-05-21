package view

import javafx.scene.paint.Color
import javafx.scene.text.Font
import logic.MainLogic
import tornadofx.*

class MainStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    override val root = hbox {
        shortcut("w") {
            controller.random()
            println(controller.currentField)
        }
        shortcut("s") {
            controller.random()
            println(controller.currentField)
        }
        shortcut("a") {
            controller.random()
            println(controller.currentField)
        }
        shortcut("d") {
            controller.random()
            println(controller.currentField)
        }
        vbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[0].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[1].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[2].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[3].toString()) {
                    font = Font(75.0)
                }
            }
        }
        vbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[4].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[5].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[6].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[7].toString()) {
                    font = Font(75.0)
                }
            }
        }
        vbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[8].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[9].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[10].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[11].toString()) {
                    font = Font(75.0)
                }
            }
        }
        vbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[12].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[13].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[14].toString()) {
                    font = Font(75.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.currentField[15].toString()) {
                    font = Font(75.0)
                }
            }
        }
    }
}