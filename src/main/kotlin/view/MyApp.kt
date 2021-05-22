package view

import javafx.stage.Stage
import tornadofx.*

class MyApp: App(StartStage::class) {
    override fun start(stage: Stage) {
        stage.minWidth = 619.0
        stage.minHeight = 641.0
        stage.isResizable = false
        super.start(stage)
    }
}