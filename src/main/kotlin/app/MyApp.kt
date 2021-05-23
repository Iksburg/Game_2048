package app

import javafx.stage.Stage
import tornadofx.*
import view.StartStage

class MyApp: App(StartStage::class) {
    override fun start(stage: Stage) {
        stage.width = 619.0
        stage.height = 641.0
        stage.isResizable = false
        super.start(stage)
    }
}