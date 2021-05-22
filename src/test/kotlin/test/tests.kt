package test

import junit.framework.Assert.*
import logic.MainLogic
import org.junit.Assert.assertThrows
import org.junit.Test

class Tests {
    private fun countingNumberOfNotNull(field: List<List<Int>>): Int {
        var count = 0
        for (i in 0..15) {
            if (field[i / 4][i % 4] != 0) {
                count++
            }
        }
        return count
    }

    @Test
    fun randomForField() {
        val stage = MainLogic()

        stage.randomForField()
        assertEquals(1, countingNumberOfNotNull(stage.currentField))

        stage.randomForField()
        assertEquals(2, countingNumberOfNotNull(stage.currentField))

        stage.randomForField()
        assertEquals(3, countingNumberOfNotNull(stage.currentField))

        stage.randomForField()
        assertEquals(4, countingNumberOfNotNull(stage.currentField))

        stage.randomForField()
        assertEquals(5, countingNumberOfNotNull(stage.currentField))

        for (i in 0..15) {
            stage.currentField[i / 4][i % 4] = 2
        }

        assertThrows(IllegalArgumentException::class.java){
            stage.randomForField()
        }
    }

    @Test
    fun moveW() {
        val stage = MainLogic()
        val expectedField = mutableListOf(mutableListOf(0, 4, 0, 0), mutableListOf(0, 0, 0, 0),
            mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))

        stage.currentField[0][1] = 2
        stage.currentField[1][1] = 2
        stage.moveW()
        assertTrue(stage.currentField == expectedField)

        expectedField[0][1] = 8
        stage.currentField[2][1] = 4
        stage.moveW()
        assertTrue(stage.currentField == expectedField)

        expectedField[0][1] = 16
        expectedField[1][1] = 4
        expectedField[0][3] = 4
        expectedField[1][3] = 2
        stage.currentField[1][1] = 8
        stage.currentField[2][1] = 2
        stage.currentField[3][1] = 2
        stage.currentField[1][3] = 2
        stage.currentField[2][3] = 2
        stage.currentField[3][3] = 2
        stage.moveW()
        assertTrue(stage.currentField == expectedField)
    }

    @Test
    fun moveS() {
        val stage = MainLogic()
        val expectedField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0),
            mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 2, 0))

        stage.currentField[0][2] = 2
        stage.moveS()
        assertTrue(stage.currentField == expectedField)

        expectedField[3][1] = 2
        expectedField[3][2] = 4
        stage.currentField[1][2] = 2
        stage.currentField[2][1] = 2
        stage.moveS()
        assertTrue(stage.currentField == expectedField)

        expectedField[3][0] = 8
        expectedField[2][0] = 4
        expectedField[3][1] = 4
        expectedField[2][1] = 2
        stage.currentField[3][0] = 4
        stage.currentField[2][0] = 4
        stage.currentField[1][0] = 2
        stage.currentField[0][0] = 2
        stage.currentField[2][1] = 2
        stage.currentField[1][1] = 2
        stage.moveS()
        assertTrue(stage.currentField == expectedField)
    }

    @Test
    fun moveA() {
        val stage = MainLogic()
        val expectedField = mutableListOf(mutableListOf(2, 0, 0, 0), mutableListOf(0, 0, 0, 0),
            mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0))

        stage.currentField[0][0] = 2
        stage.moveA()
        assertTrue(stage.currentField == expectedField)

        expectedField[0][0] = 4
        expectedField[0][1] = 8
        expectedField[1][0] = 4
        expectedField[1][1] = 8
        expectedField[1][2] = 2
        expectedField[2][0] = 16
        stage.currentField[0][1] = 2
        stage.currentField[0][2] = 4
        stage.currentField[0][3] = 4
        stage.currentField[1][1] = 4
        stage.currentField[1][2] = 8
        stage.currentField[1][3] = 2
        stage.currentField[2][1] = 8
        stage.currentField[2][3] = 8
        stage.moveA()
        assertTrue(stage.currentField == expectedField)
    }

    @Test
    fun moveD() {
        val stage = MainLogic()
        val expectedField = mutableListOf(mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 0),
            mutableListOf(0, 0, 0, 0), mutableListOf(0, 0, 0, 4))

        stage.currentField[3][1] = 2
        stage.currentField[3][3] = 2
        stage.moveD()
        assertTrue(stage.currentField == expectedField)

        expectedField[3][3] = 8
        expectedField[3][2] = 8
        expectedField[1][3] = 4
        expectedField[1][2] = 8
        expectedField[0][3] = 16
        expectedField[0][2] = 4
        stage.currentField[3][2] = 4
        stage.currentField[3][1] = 8
        stage.currentField[1][3] = 2
        stage.currentField[1][2] = 2
        stage.currentField[1][1] = 4
        stage.currentField[1][0] = 4
        stage.currentField[0][2] = 8
        stage.currentField[0][1] = 8
        stage.currentField[0][0] = 4
        stage.moveD()
        assertTrue(stage.currentField == expectedField)
    }

    @Test
    fun endGame() {
        val stage = MainLogic()

        assertFalse(stage.endGame())

        stage.currentField[0][2] = 4
        stage.currentField[3][1] = 32
        stage.currentField[1][0] = 8
        assertFalse(stage.endGame())

        for (i in 0..15) {
            stage.currentField[i / 4][i % 4] = 2
        }
        assertTrue(stage.endGame())
    }
}