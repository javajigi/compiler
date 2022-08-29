package vm

import code.OpCode
import compiler.Bytecode
import java.util.*

class VirtualMachine(private val bytecode: Bytecode) {
    private val instructions = bytecode.instructions
    private val constants = bytecode.constants
    private val stack = Stack<Any>()

    fun run() {
        for (instruction in instructions) {
            val opCode = instruction.opCode

            if (opCode.constants()) {
                stack.push(constants[instruction.index])
            }

            if (opCode == OpCode.OpAdd) {
                val right = stack.pop() as Int
                val left = stack.pop() as Int
                stack.push(left + right)
            }
        }
    }

    fun pop(): Any = stack.pop()
}
