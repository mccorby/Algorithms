package com.mccorby.algorithms.lesson2

class DijkstraTwoStacksAlgorithm(private val parser: ExprParser) {

    private val values: LinkedStack<Int> = LinkedStack()
    private val operators: LinkedStack<String> = LinkedStack()

    fun execute(input: String): Int {
        return 0
    }

}

/**
 * A very simple parser that transforms the input string in a list of strings
 * This parser only allows numbers in the range 0..9
 */
class SimpleExprParser: ExprParser {
    override fun parse(input: String): List<String> {
        return input.map { c -> c.toString() }
    }
}

interface ExprParser {
    fun parse(input: String): List<String>
}
