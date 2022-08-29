package code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpCodeTest {
    @Test
    fun instructionLength() {
        assertThat(OpCode.OpConstant.operandWidths()).isEqualTo(2)
        assertThat(OpCode.OpAdd.operandWidths()).isEqualTo(0)
    }
}
