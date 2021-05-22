package logic

import tornadofx.*
import kotlin.random.Random

class MainLogic: Controller() {
    val currentField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))
    val beforeField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))
    var totalScore = 0
    private val summationCheck = mutableListOf(
        mutableListOf(false, false, false, false),
        mutableListOf(false, false, false, false),
        mutableListOf(false, false, false, false),
        mutableListOf(false, false, false, false)
    )

    fun randomForField(): List<List<Int>> {
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
        return currentField
    }

    private fun score(number: Int) {
        totalScore += number
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

    fun moveW(): List<List<Int>> {
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
        return currentField
    }

    fun moveS(): List<List<Int>> {
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
                            } else if (currentField[i + 1][j] == currentField[i][j] && !summationCheck[i + 1][j]) {
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
        return currentField
    }

    fun moveA(): List<List<Int>> {
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
        return currentField
    }

    fun moveD(): List<List<Int>> {
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
        return currentField
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