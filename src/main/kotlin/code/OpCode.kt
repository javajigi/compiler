package code

enum class OpCode(val operandWidths: List<Int>) {
    OpConstant(listOf(2)),
    OpAdd(listOf());

    fun ordinalToByte(): UByte = this.ordinal.toUByte()

    fun operandWidths(): Int {
       return operandWidths.sum()
    }
}
