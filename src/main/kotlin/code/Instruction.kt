package code

import to2UByteArray
import java.nio.ByteBuffer
import java.nio.ByteOrder

data class Instruction(val bytes: UByteArray) {
    constructor(opCode: OpCode): this(ubyteArrayOf(opCode.ordinalToByte()))

    constructor(opCode: OpCode, number: Int): this(ubyteArrayOf(opCode.ordinalToByte(), *number.to2UByteArray() ))

    fun opCode(): OpCode {
        val firstByte = bytes[0]
        return OpCode.byOrdinal(firstByte)
    }

    fun index(): Int = bytes[2].toInt()

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
