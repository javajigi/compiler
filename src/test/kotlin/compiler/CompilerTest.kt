package compiler

import code.Instruction
import code.OpCode
import lexer.Lexer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import parser.MonkeyParser

class CompilerTest {
    @Test
    fun compile() {
        val parser = MonkeyParser(Lexer("1 + 2"))
        val program = parser.parse()
        val compiler = Compiler()
        compiler.compile(program)

        val bytecode = compiler.bytecode()
        val instructions = bytecode.instructions
        assertThat(instructions).hasSize(2)
        assertThat(instructions).containsExactly(
            Instruction(OpCode.OpConstant, 0),
            Instruction(OpCode.OpConstant, 1)
        )
        val constants = bytecode.constants
        assertThat(constants).hasSize(2)
        assertThat(constants).containsExactly(1, 2)
    }
}
