package code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ByteInstructionTest {
    @Test
    fun create() {
        val opConstant = ByteInstruction(OpCode.OpConstant, 65534)
        assertThat(opConstant.bytes).containsExactly(0u, 255u, 254u)
    }
}
