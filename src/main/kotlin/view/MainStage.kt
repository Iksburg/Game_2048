package view

import javafx.scene.paint.Color
import javafx.scene.text.Font
import logic.MainLogic
import tornadofx.*

class MainStage : View(title = "Game 2048") {
    private val controller: MainLogic by inject()

    private fun randomAndEndGame(): List<List<Int>> {
        if (controller.currentField != controller.beforeField) {
            controller.randomForField()
        } else if (controller.endGame()) {
            replaceWith<EndStage>()
        }
        return controller.currentField
    }

    private fun checkEqualityNull (number: Int): String {
        return if (number == 0) {
            ""
        } else {
            number.toString()
        }
    }

    override val root = vbox {
        shortcut("w") {
            controller.moveW()
            randomAndEndGame()
        }
        shortcut("s") {
            controller.moveS()
            randomAndEndGame()
        }
        shortcut("a") {
            controller.moveA()
            randomAndEndGame()
        }
        shortcut("d") {
            controller.moveD()
            randomAndEndGame()
        }

        hbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.firstCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.secondCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.thirdCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.fourthCell) {
                    font = Font(55.0)
                }
            }
        }
        hbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.fifthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.sixthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.seventhCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.eighthCell) {
                    font = Font(55.0)
                }
            }
        }
        hbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.ninthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.tenthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.eleventhCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.twelfthCell) {
                    font = Font(55.0)
                }
            }
        }
        hbox {
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.thirteenthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.fourteenthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.fifteenthCell) {
                    font = Font(55.0)
                }
            }
            stackpane {
                rectangle {
                    fill = Color.BEIGE
                    width = 150.0
                    height = 150.0
                    stroke = Color.DARKGREY
                }
                label(controller.sixteenthCell) {
                    font = Font(55.0)
                }
            }
        }
    }
}