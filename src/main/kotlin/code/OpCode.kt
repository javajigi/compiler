package code

enum class OpCode(val operandWidths: List<Int>) {
    OpConstant(listOf(2)),
    OpPop(listOf()),
    OpAdd(listOf());

    fun constants(): Boolean = this == OpConstant

    fun ordinalToByte(): UByte = this.ordinal.toUByte()

    fun operandWidths(): Int {
       return operandWidths.sum()
    }

    companion object {
        fun byOrdinal(ordinal: Int): OpCode {
            return values().first { it.ordinal == ordinal }
        }

        fun byOrdinal(ordinal: UByte): OpCode = byOrdinal(ordinal.toInt())
    }
}
