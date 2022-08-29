package study

import code.OpCode
import readUInt16At
import readUIntAt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import to2ByteArray
import to2UByteArray

class IntToByteToUIntTest {
    @Test
    fun int16ReadUInt16() {
        val byteArray = 65534.to2ByteArray()
        assertThat(byteArray).hasSize(2)
        assertThat(byteArray[0]).isEqualTo(255.toByte())
        assertThat(byteArray[1]).isEqualTo(254.toByte())
        assertThat(byteArray.readUInt16At()).isEqualTo(65534u)
    }

    @Test
    fun readUInt16() {
        val byteArray = ByteArray(4)
        byteArray[0] = 0
        byteArray[1] = 200.toByte()
        byteArray[2] = 0
        byteArray[3] = 255.toByte()
        assertThat(byteArray.readUInt16At(0)).isEqualTo(200u)
        assertThat(byteArray.readUInt16At(2)).isEqualTo(255u)
    }

    @Test
    fun byteArrayToUInt() {
        val byteArray = ByteArray(4)
        byteArray[0] = 0
        byteArray[1] = 0
        byteArray[2] = 0
        byteArray[3] = 255.toByte()

        val result = byteArray.readUIntAt()
        assertThat(result).isEqualTo(255u)
    }

    @Test
    fun to2UByteArray() {
        val bytes = 3.to2UByteArray()
        assertThat(bytes).hasSize(2)
    }

    @Test
    fun setByteArray() {
        val bytes = ubyteArrayOf(OpCode.OpConstant.ordinal.toUByte(), *3.to2UByteArray() )
        assertThat(bytes).hasSize(3)
        assertThat(bytes).containsExactly(0u, 0u, 3u)
    }

    @Test
    fun byte() {
        val byte = 255.toUByte()
        println("byte : $byte")
    }
}
