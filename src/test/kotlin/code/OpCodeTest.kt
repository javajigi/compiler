package code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OpCodeTest {
    @Test
    fun instructionLength() {
        assertThat(OpCode.OpConstant.operandWidths()).isEqualTo(2)
        assertThat(OpCode.OpAdd.operandWidths()).isEqualTo(0)
    }

    @Test
    fun byOrdinal() {
        assertThat(OpCode.byOrdinal(0)).isEqualTo(OpCode.OpConstant)
        assertThat(OpCode.byOrdinal(0u)).isEqualTo(OpCode.OpConstant)
        assertThat(OpCode.byOrdinal(1)).isEqualTo(OpCode.OpAdd)
        assertThat(OpCode.byOrdinal(1u)).isEqualTo(OpCode.OpAdd)
    }
}
