package vm

import code.OpCode
import compiler.Bytecode
import java.util.*

class VirtualMachine(private val bytecode: Bytecode) {
    private val instructions = bytecode.instructions
    private val constants = bytecode.constants
    private val stack = Stack<Any>()
    private var lastPoppedStackElement: Any? = null

    fun run() {
        for (instruction in instructions) {
            val opCode = instruction.opCode

            if (opCode.constants()) {
                stack.push(constants[instruction.index])
            }

            if (OpCode.binaryOperator(opCode)) {
                val right = stack.pop() as Int
                val left = stack.pop() as Int
                stack.push(opCode.operateBinary(left, right))
            }

            if (opCode == OpCode.OpPop) {
                lastPoppedStackElement = stack.pop()
            }
        }
    }

    fun lastPoppedStackElement(): Any? = lastPoppedStackElement
}
