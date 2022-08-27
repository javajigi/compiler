package code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstructionTest {
    @Test
    fun create() {
        val opConstant = Instruction(OpCode.OpConstant)
        assertThat(opConstant.bytes).containsExactly(0, 2, 0)
    }
}
