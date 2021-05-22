package logic

import tornadofx.*
import kotlin.random.Random

class MainLogic: Controller() {
    val currentField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))
    val beforeField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))
    var totalScore = 0

    fun randomForField(): List<List<Int>> {
        val listOfRandom = mutableListOf<Pair<Int, Int>>()
        for (i in 0..15) {
            if (currentField[i / 4][i % 4] == 0) {
                listOfRandom += Pair(i / 4, i % 4)
            }
        }
        val cellForChange = Random.nextInt(0, listOfRandom.size)
        currentField[listOfRandom[cellForChange].first][listOfRandom[cellForChange].second] = 2
        return currentField
    }

    private fun renewalBeforeField() {
        for (i in 0..15) {
            beforeField[i / 4][i % 4] = currentField[i / 4][i % 4]
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
                                totalScore += currentField[i - 1][j]
                                currentField[i][j] = 0
                            }
                        }
                        2 -> {
                            if (currentField[i - 1][j] == 0) {
                                if (currentField[i - 2][j] == 0) {
                                    currentField[i - 2][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i - 2][j] == currentField[i][j]) {
                                    currentField[i - 2][j] += currentField[i][j]
                                    totalScore += currentField[i - 2][j]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i - 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i - 1][j] == currentField[i][j]) {
                                currentField[i - 1][j] += currentField[i][j]
                                totalScore += currentField[i - 1][j]
                                currentField[i][j] = 0
                            }
                        }
                        3 -> {
                            if (currentField[i - 1][j] == 0) {
                                if (currentField[i - 2][j] == 0) {
                                    if (currentField[i - 3][j] == 0) {
                                        currentField[i - 3][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i - 3][j] == currentField[i][j]) {
                                        currentField[i - 3][j] += currentField[i][j]
                                        totalScore += currentField[i - 3][j]
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i - 2][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i - 2][j] == currentField[i][j]) {
                                    currentField[i - 2][j] += currentField[i][j]
                                    totalScore += currentField[i - 2][j]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i - 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i - 1][j] == currentField[i][j]) {
                                currentField[i - 1][j] += currentField[i][j]
                                totalScore += currentField[i - 1][j]
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
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
                                totalScore += currentField[i + 1][j]
                                currentField[i][j] = 0
                            }
                        }
                        1 -> {
                            if (currentField[i + 1][j] == 0) {
                                if (currentField[i + 2][j] == 0) {
                                    currentField[i + 2][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i + 2][j] == currentField[i][j]) {
                                    currentField[i + 2][j] += currentField[i][j]
                                    totalScore += currentField[i + 2][j]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i + 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i + 1][j] == currentField[i][j]) {
                                currentField[i + 1][j] += currentField[i][j]
                                totalScore += currentField[i + 1][j]
                                currentField[i][j] = 0
                            }
                        }
                        0 -> {
                            if (currentField[i + 1][j] == 0) {
                                if (currentField[i + 2][j] == 0) {
                                    if (currentField[i + 3][j] == 0) {
                                        currentField[i + 3][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i + 3][j] == currentField[i][j]) {
                                        currentField[i + 3][j] += currentField[i][j]
                                        totalScore += currentField[i + 3][j]
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i + 2][j] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i + 2][j] == currentField[i][j]) {
                                    currentField[i + 2][j] += currentField[i][j]
                                    totalScore += currentField[i + 2][j]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i + 1][j] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i + 1][j] == currentField[i][j]) {
                                currentField[i + 1][j] += currentField[i][j]
                                totalScore += currentField[i + 1][j]
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
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
                                totalScore += currentField[i][j - 1]
                                currentField[i][j] = 0
                            }
                        }
                        2 -> {
                            if (currentField[i][j - 1] == 0) {
                                if (currentField[i][j - 2] == 0) {
                                    currentField[i][j - 2] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i][j - 2] == currentField[i][j]) {
                                    currentField[i][j - 2] += currentField[i][j]
                                    totalScore += currentField[i][j - 2]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i][j  - 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j  - 1] == currentField[i][j]) {
                                currentField[i][j  - 1] += currentField[i][j]
                                totalScore += currentField[i][j - 1]
                                currentField[i][j] = 0
                            }
                        }
                        3 -> {
                            if (currentField[i][j - 1] == 0) {
                                if (currentField[i][j - 2] == 0) {
                                    if (currentField[i][j - 3] == 0) {
                                        currentField[i][j - 3] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i][j - 3] == currentField[i][j]) {
                                        currentField[i][j - 3] += currentField[i][j]
                                        totalScore += currentField[i][j - 3]
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i][j  - 2] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i][j  - 2] == currentField[i][j]) {
                                    currentField[i][j  - 2] += currentField[i][j]
                                    totalScore += currentField[i][j - 2]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i][j - 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j - 1] == currentField[i][j]) {
                                currentField[i][j - 1] += currentField[i][j]
                                totalScore += currentField[i][j - 1]
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
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
                                totalScore += currentField[i][j + 1]
                                currentField[i][j] = 0
                            }
                        }
                        1 -> {
                            if (currentField[i][j + 1] == 0) {
                                if (currentField[i][j+ 2] == 0) {
                                    currentField[i][j + 2] = currentField[i][j]
                                    currentField[i][j] = 0
                                } else if (currentField[i][j + 2] == currentField[i][j]) {
                                    currentField[i][j + 2] += currentField[i][j]
                                    totalScore += currentField[i][j + 2]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i][j + 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j + 1] == currentField[i][j]) {
                                currentField[i][j  + 1] += currentField[i][j]
                                totalScore += currentField[i][j + 1]
                                currentField[i][j] = 0
                            }
                        }
                        0 -> {
                            if (currentField[i][j  + 1] == 0) {
                                if (currentField[i][j  + 2] == 0) {
                                    if (currentField[i][j + 3] == 0) {
                                        currentField[i][j + 3] = currentField[i][j]
                                        currentField[i][j] = 0
                                    } else if (currentField[i][j + 3] == currentField[i][j]) {
                                        currentField[i][j + 3] += currentField[i][j]
                                        totalScore += currentField[i][j + 3]
                                        currentField[i][j] = 0
                                    } else {
                                        currentField[i][j + 2] = currentField[i][j]
                                        currentField[i][j] = 0
                                    }
                                } else if (currentField[i][j + 2] == currentField[i][j]) {
                                    currentField[i][j + 2] += currentField[i][j]
                                    totalScore += currentField[i][j + 2]
                                    currentField[i][j] = 0
                                } else {
                                    currentField[i][j + 1] = currentField[i][j]
                                    currentField[i][j] = 0
                                }
                            } else if (currentField[i][j + 1] == currentField[i][j]) {
                                currentField[i][j + 1] += currentField[i][j]
                                totalScore += currentField[i][j + 1]
                                currentField[i][j] = 0
                            }
                        }
                    }
                }
            }
        }
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