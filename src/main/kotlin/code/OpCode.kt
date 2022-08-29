package code

enum class OpCode(val operandWidths: List<Int>, val operation: ((Int, Int) -> Int)?) {
    OpConstant(listOf(2)),
    OpPop(listOf()),
    OpAdd(listOf(), { x: Int, y: Int -> x + y }),
    OpSub(listOf(), { x: Int, y: Int -> x / y }),
    OpMul(listOf(), { x: Int, y: Int -> x * y }),
    OpDiv(listOf(), { x: Int, y: Int -> x / y });

    constructor(operandWidths: List<Int>): this(operandWidths, null)

    fun operateBinary(x: Int, y: Int): Int {
        if (!binaryOperator(this)) {
            throw IllegalArgumentException("Binary Operator가 아닙니다.")
        }
        return operation?.invoke(x, y) ?: throw IllegalArgumentException("Binary Operator가 아닙니다.")
    }

    fun constants(): Boolean = this == OpConstant

    fun ordinalToByte(): UByte = this.ordinal.toUByte()

    fun operandWidths(): Int {
       return operandWidths.sum()
    }

    companion object {
        private val binaryOperators = listOf(OpAdd, OpSub, OpMul, OpDiv)

        fun binaryOperator(opCode: OpCode): Boolean = binaryOperators.contains(opCode)

        fun byOrdinal(ordinal: Int): OpCode {
            return values().first { it.ordinal == ordinal }
        }

        fun byOrdinal(ordinal: UByte): OpCode = byOrdinal(ordinal.toInt())
    }
}
