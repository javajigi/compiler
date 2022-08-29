package code

data class Instruction(val opCode: OpCode, val index: Int) {
    constructor(opCode: OpCode): this(opCode, 0)
}
