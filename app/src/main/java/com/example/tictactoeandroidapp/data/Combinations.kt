package com.example.tictactoeandroidapp.data

object Combinations {
   val gameCombinations : HashMap<Int, ArrayList<ArrayList<Int>>> = initHashMap()

    private fun initHashMap(): HashMap<Int, ArrayList<ArrayList<Int>>> {
        val gameCombinations : HashMap<Int, ArrayList<ArrayList<Int>>> = HashMap()

        gameCombinations[1] = arrayListOf(arrayListOf(1,2,3), arrayListOf(1,5,9), arrayListOf(1,4,7))
        gameCombinations[2] = arrayListOf(arrayListOf(1,2,3), arrayListOf(2,5,8))
        gameCombinations[3] = arrayListOf(arrayListOf(1,2,3), arrayListOf(3,5,7), arrayListOf(3,6,9))
        gameCombinations[4] = arrayListOf(arrayListOf(1,4,7), arrayListOf(4,5,6))
        gameCombinations[5] = arrayListOf(arrayListOf(2,5,8), arrayListOf(1,5,9), arrayListOf(3,5,7), arrayListOf(4,5,6))
        gameCombinations[6] = arrayListOf(arrayListOf(3,6,9), arrayListOf(4,5,6))
        gameCombinations[7] = arrayListOf(arrayListOf(1,4,7), arrayListOf(3,5,7), arrayListOf(7,8,9))
        gameCombinations[8] = arrayListOf(arrayListOf(2,5,8), arrayListOf(7,8,9))
        gameCombinations[9] = arrayListOf(arrayListOf(3,6,9), arrayListOf(1,5,9), arrayListOf(7,8,9))

        return gameCombinations
    }

}