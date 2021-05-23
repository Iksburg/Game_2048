package logic

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import kotlin.random.Random

class MainLogic: Controller() {
    val currentField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))
    val beforeField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))
    var score = SimpleStringProperty("0")
    private val summationCheck = mutableListOf(
        mutableListOf(false, false, false, false),
        mutableListOf(false, false, false, false),
        mutableListOf(false, false, false, false),
        mutableListOf(false, false, false, false)
    )

    var firstCell = SimpleStringProperty()
    var secondCell = SimpleStringProperty()
    var thirdCell = SimpleStringProperty()
    var fourthCell = SimpleStringProperty()
    var fifthCell = SimpleStringProperty()
    var sixthCell = SimpleStringProperty()
    var seventhCell = SimpleStringProperty()
    var eighthCell = SimpleStringProperty()
    var ninthCell = SimpleStringProperty()
    var tenthCell = SimpleStringProperty()
    var eleventhCell = SimpleStringProperty()
    var twelfthCell = SimpleStringProperty()
    var thirteenthCell = SimpleStringProperty()
    var fourteenthCell = SimpleStringProperty()
    var fifteenthCell = SimpleStringProperty()
    var sixteenthCell = SimpleStringProperty()

    fun randomForField() {
        val listOfRandom = mutableListOf<Pair<Int, Int>>()
        for (i in 0..15) {
            if (currentField[i / 4][i % 4] == 0) {
                listOfRandom += Pair(i / 4, i % 4)
            }
        }
        val cellForChange = Random.nextInt(listOfRandom.size)
        val twoOrFour = Random.nextInt(10)
        if (twoOrFour != 9) {
            currentField[listOfRandom[cellForChange].first][listOfRandom[cellForChange].second] = 2
        } else {
            currentField[listOfRandom[cellForChange].first][listOfRandom[cellForChange].second] = 4
        }
        updateField()
    }

    private fun score(number: Int) {
        score.value = (score.value.toInt() + number).toString()
    }

    private fun renewalBeforeField() {
        for (i in 0..15) {
            beforeField[i / 4][i % 4] = currentField[i / 4][i % 4]
        }
    }

    private fun fillFalse() {
        for (i in 0..15) {
            summationCheck[i / 4][i % 4] = false
        }
    }

    private fun equalityToNull(cell: Int):String {
        return if (cell != 0) {
            cell.toString()
        } else {
            ""
        }
    }

    private fun updateField() {
        firstCell.value = equalityToNull(currentField[0][0])
        secondCell.value = equalityToNull(currentField[0][1])
        thirdCell.value = equalityToNull(currentField[0][2])
        fourthCell.value = equalityToNull(currentField[0][3])
        fifthCell.value = equalityToNull(currentField[1][0])
        sixthCell.value = equalityToNull(currentField[1][1])
        seventhCell.value = equalityToNull(currentField[1][2])
        eighthCell.value = equalityToNull(currentField[1][3])
        ninthCell.value = equalityToNull(currentField[2][0])
        tenthCell.value = equalityToNull(currentField[2][1])
        eleventhCell.value = equalityToNull(currentField[2][2])
        twelfthCell.value = equalityToNull(currentField[2][3])
        thirteenthCell.value = equalityToNull(currentField[3][0])
        fourteenthCell.value = equalityToNull(currentField[3][1])
        fifteenthCell.value = equalityToNull(currentField[3][2])
        sixteenthCell.value = equalityToNull(currentField[3][3])
    }

    fun moveW() {
        renewalBeforeField()
        for (i in 1..3) {
            for (j in 0..3) {
                if (currentField[i][j] != 0) {
                    when (i) {
                        1 -> {
                            if (currentField[i - 1][j] == 0) {
                                currentField[i - 1][j] = currentField[i][j]
                                currentField[i][j] = 0
                            } else if (currentField[i - 1][j] == currentField[i][j]) {
                                currentField[i - 1][j] += currentField[i][j]
                                score(currentField[i - 1][j])
                                currentField[i][j] = 0
                                summationCheck[i - 1][j] = true
                            }
                        }
                        2 -> {
                            if (currentField[i - 1][j] == 0) {
                                if (currentField[i - 2][j] == 0) {
                                    currentField[i - 2][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i - 2][j] == currentField[i][j] && !summationCheck[i - 2][j]) {
                                    currentField[i - 2][j] += currentField[i][j]
                                    score(currentField[i - 2][j])
                                    currentField[i][j] = 0
                                    summationCheck[i - 2][j] = true
                                } else {
                                    currentField[i - 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i - 1][j] == currentField[i][j]) {
                                currentField[i - 1][j] += currentField[i][j]
                                score(currentField[i - 1][j])
                                currentField[i][j] = 0
                                summationCheck[i - 1][j] = true
                            }
                        }
                        3 -> {
                            if (currentField[i - 1][j] == 0) {
                                if (currentField[i - 2][j] == 0) {
                                    if (currentField[i - 3][j] == 0) {
                                        currentField[i - 3][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i - 3][j] == currentField[i][j] && !summationCheck[i - 3][j]) {
                                        currentField[i - 3][j] += currentField[i][j]
                                        score(currentField[i - 3][j])
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i - 2][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i - 2][j] == currentField[i][j] && !summationCheck[i - 2][j]) {
                                    currentField[i - 2][j] += currentField[i][j]
                                    score(currentField[i - 2][j])
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i - 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i - 1][j] == currentField[i][j]) {
                                currentField[i - 1][j] += currentField[i][j]
                                score(currentField[i - 1][j])
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
        fillFalse()
    }

    fun moveS() {
        renewalBeforeField()
        for (i in 2 downTo 0) {
            for (j in 0..3) {
                if (currentField[i][j] != 0) {
                    when (i) {
                        2 -> {
                            if (currentField[i + 1][j] == 0) {
                                currentField[i + 1][j] = currentField[i][j]
                                currentField[i][j] = 0
                            } else if (currentField[i + 1][j] == currentField[i][j]) {
                                currentField[i + 1][j] += currentField[i][j]
                                score(currentField[i + 1][j])
                                currentField[i][j] = 0
                                summationCheck[i + 1][j] = true
                            }
                        }
                        1 -> {
                            if (currentField[i + 1][j] == 0) {
                                if (currentField[i + 2][j] == 0) {
                                    currentField[i + 2][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i + 2][j] == currentField[i][j] && !summationCheck[i + 2][j]) {
                                    currentField[i + 2][j] += currentField[i][j]
                                    score(currentField[i + 2][j])
                                    currentField[i][j] = 0
                                    summationCheck[i + 2][j] = true
                                } else {
                                    currentField[i + 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i + 1][j] == currentField[i][j]) {
                                currentField[i + 1][j] += currentField[i][j]
                                score(currentField[i + 1][j])
                                currentField[i][j] = 0
                                summationCheck[i + 1][j] = true
                            }
                        }
                        0 -> {
                            if (currentField[i + 1][j] == 0) {
                                if (currentField[i + 2][j] == 0) {
                                    if (currentField[i + 3][j] == 0) {
                                        currentField[i + 3][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i + 3][j] == currentField[i][j] && !summationCheck[i + 3][j]) {
                                        currentField[i + 3][j] += currentField[i][j]
                                        score(currentField[i + 3][j])
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i + 2][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i + 2][j] == currentField[i][j] && !summationCheck[i + 2][j]) {
                                    currentField[i + 2][j] += currentField[i][j]
                                    score(currentField[i + 2][j])
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i + 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i + 1][j] == currentField[i][j]) {
                                currentField[i + 1][j] += currentField[i][j]
                                score(currentField[i + 1][j])
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
        fillFalse()
    }

    fun moveA() {
        renewalBeforeField()
        for (i in 0..3) {
            for(j in 1..3) {
                if (currentField[i][j] != 0) {
                    when (j) {
                        1 -> {
                            if (currentField[i][j - 1] == 0) {
                                currentField[i][j - 1] = currentField[i][j]
                                currentField[i][j] = 0
                            } else if (currentField[i][j - 1] == currentField[i][j]) {
                                currentField[i][j - 1] += currentField[i][j]
                                score(currentField[i][j - 1])
                                currentField[i][j] = 0
                                summationCheck[i][j - 1] = true
                            }
                        }
                        2 -> {
                            if (currentField[i][j - 1] == 0) {
                                if (currentField[i][j - 2] == 0) {
                                    currentField[i][j - 2] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i][j - 2] == currentField[i][j] && !summationCheck[i][j - 2]) {
                                    currentField[i][j - 2] += currentField[i][j]
                                    score(currentField[i][j - 2])
                                    currentField[i][j] = 0
                                    summationCheck[i][j - 2] = true
                                } else {
                                    currentField[i][j  - 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j  - 1] == currentField[i][j]) {
                                currentField[i][j  - 1] += currentField[i][j]
                                score(currentField[i][j - 1])
                                currentField[i][j] = 0
                                summationCheck[i][j - 1] = true
                            }
                        }
                        3 -> {
                            if (currentField[i][j - 1] == 0) {
                                if (currentField[i][j - 2] == 0) {
                                    if (currentField[i][j - 3] == 0) {
                                        currentField[i][j - 3] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i][j - 3] == currentField[i][j] && !summationCheck[i][j - 3]) {
                                        currentField[i][j - 3] += currentField[i][j]
                                        score(currentField[i][j - 3])
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i][j  - 2] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i][j  - 2] == currentField[i][j] && !summationCheck[i][j - 2]) {
                                    currentField[i][j  - 2] += currentField[i][j]
                                    score(currentField[i][j - 2])
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i][j - 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j - 1] == currentField[i][j]) {
                                currentField[i][j - 1] += currentField[i][j]
                                score(currentField[i][j - 1])
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
        fillFalse()
    }

    fun moveD() {
        renewalBeforeField()
        for (i in 0..3) {
            for(j in 2 downTo 0) {
                if (currentField[i][j] != 0) {
                    when (j) {
                        2 -> {
                            if (currentField[i][j + 1] == 0) {
                                currentField[i][j + 1] = currentField[i][j]
                                currentField[i][j] = 0
                            } else if (currentField[i][j + 1] == currentField[i][j]) {
                                currentField[i][j + 1] += currentField[i][j]
                                score(currentField[i][j + 1])
                                currentField[i][j] = 0
                                summationCheck[i][j + 1] = true
                            }
                        }
                        1 -> {
                            if (currentField[i][j + 1] == 0) {
                                if (currentField[i][j+ 2] == 0) {
                                    currentField[i][j + 2] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i][j + 2] == currentField[i][j] && !summationCheck[i][j + 2]) {
                                    currentField[i][j + 2] += currentField[i][j]
                                    score(currentField[i][j + 2])
                                    currentField[i][j] = 0
                                    summationCheck[i][j + 2] = true
                                } else {
                                    currentField[i][j + 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j + 1] == currentField[i][j]) {
                                currentField[i][j  + 1] += currentField[i][j]
                                score(currentField[i][j + 1])
                                currentField[i][j] = 0
                                summationCheck[i][j + 1] = true
                            }
                        }
                        0 -> {
                            if (currentField[i][j  + 1] == 0) {
                                if (currentField[i][j  + 2] == 0) {
                                    if (currentField[i][j + 3] == 0) {
                                        currentField[i][j + 3] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i][j + 3] == currentField[i][j] && !summationCheck[i][j + 3]) {
                                        currentField[i][j + 3] += currentField[i][j]
                                        score(currentField[i][j + 3])
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i][j + 2] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i][j + 2] == currentField[i][j] && !summationCheck[i][j + 2]) {
                                    currentField[i][j + 2] += currentField[i][j]
                                    score(currentField[i][j + 2])
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i][j + 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j + 1] == currentField[i][j]) {
                                currentField[i][j + 1] += currentField[i][j]
                                score(currentField[i][j + 1])
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
        fillFalse()
    }

    fun endGame(): Boolean {
        for (i in 0..15) {
            if (currentField[i / 4][i % 4] == 0) return false
        }
        for (i in 0..15) {
            currentField[i / 4][i % 4] = 0
            beforeField[i / 4][i % 4] = 0
        }
        return true
    }
}