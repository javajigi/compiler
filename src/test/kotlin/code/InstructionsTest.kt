package code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstructionsTest {
    @Test
    fun create() {
        val opConstant = Instructions(OpCode.OpConstant)
        assertThat(opConstant.bytes).containsExactly(0, 2, 0)
    }
}
