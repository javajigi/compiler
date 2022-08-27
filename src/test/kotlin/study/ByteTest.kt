package study

import code.OpCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import to2UByteArray

class ByteTest {
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
