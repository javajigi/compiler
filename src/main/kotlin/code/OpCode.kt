package code

enum class OpCode(val operandWidths: List<Int>) {
    OpConstant(listOf(2)),
    OpAdd(listOf());

    fun ordinalToByte(): Byte = this.ordinal.toByte()

    fun operandWidths(): Int {
       return operandWidths.sum()
    }
}
