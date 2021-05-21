package view

import javafx.stage.Stage
import tornadofx.*

class MyApp: App(StartStage::class) {
    override fun start(stage: Stage) {
        with(stage) {
            minWidth = 619.0
            minHeight = 641.0
            isResizable = false
            super.start(this)
        }
    }
}