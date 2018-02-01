package com.mccorby.algorithms.lesson2

class BinaryConversor {

    fun convert(input: Int): String {
        val stack = LinkedStack<Int>()
        var n = input
        while (n > 0) {
            stack.push(n % 2)
            n /= 2
        }

        val result = StringBuffer()
        for (digit in stack) {
            result.append(digit)
        }
        return result.toString()
    }
    /**
     * int n = 50;

    Stack<Integer> stack = new Stack<Integer>();
    while (n > 0) {
    stack.push(n % 2);
    n = n / 2;
    }

    for (int digit : stack) {
    StdOut.print(digit);
    }

    StdOut.println();
     */
}