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
                label(checkEqualityNull(controller.currentField[0][0])) {
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
                label(checkEqualityNull(controller.currentField[0][1])) {
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
                label(checkEqualityNull(controller.currentField[0][2])) {
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
                label(checkEqualityNull(controller.currentField[0][3])) {
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
                label(checkEqualityNull(controller.currentField[1][0])) {
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
                label(checkEqualityNull(controller.currentField[1][1])) {
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
                label(checkEqualityNull(controller.currentField[1][2])) {
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
                label(checkEqualityNull(controller.currentField[1][3])) {
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
                label(checkEqualityNull(controller.currentField[2][0])) {
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
                label(checkEqualityNull(controller.currentField[2][1])) {
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
                label(checkEqualityNull(controller.currentField[2][2])) {
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
                label(checkEqualityNull(controller.currentField[2][3])) {
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
                label(checkEqualityNull(controller.currentField[3][0])) {
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
                label(checkEqualityNull(controller.currentField[3][1])) {
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
                label(checkEqualityNull(controller.currentField[3][2])) {
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
                label(checkEqualityNull(controller.currentField[3][3])) {
                    font = Font(55.0)
                }
            }
        }
    }
}