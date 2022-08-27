package compiler

import code.Instruction

data class Bytecode(
    val instructions: List<Instruction>,
    val constants: List<Any>
)
