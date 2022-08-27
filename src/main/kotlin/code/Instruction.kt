package code

import to2ByteArray

data class Instruction(val bytes: ByteArray) {
    constructor(opCode: OpCode): this(byteArrayOf(opCode.ordinalToByte()))

    constructor(opCode: OpCode, number: Int): this(byteArrayOf(opCode.ordinalToByte(), *number.to2ByteArray() ))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Instruction

        if (!bytes.contentEquals(other.bytes)) return false

        return true
    }

    override fun hashCode(): Int {
        return bytes.contentHashCode()
    }
}
