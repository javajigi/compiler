package study

import code.OpCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import to2ByteArray

class ByteTest {
    @Test
    fun to2ByteArray() {
        val bytes = 3.to2ByteArray()
        assertThat(bytes).hasSize(2)
    }

    @Test
    fun setByteArray() {
        val bytes = byteArrayOf(OpCode.OpConstant.ordinal.toByte(), *3.to2ByteArray() )
        assertThat(bytes).hasSize(3)
        assertThat(bytes).containsExactly(0, 3, 0)
    }
}

