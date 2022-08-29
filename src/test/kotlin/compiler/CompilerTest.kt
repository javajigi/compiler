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
        val bytecode = bytecode("1 + 2")
        val instructions = bytecode.instructions
        assertThat(instructions).hasSize(3)
        assertThat(instructions).containsExactly(
            Instruction(OpCode.OpConstant, 0),
            Instruction(OpCode.OpConstant, 1),
            Instruction(OpCode.OpAdd)
        )
        val constants = bytecode.constants
        assertThat(constants).hasSize(2)
        assertThat(constants).containsExactly(1, 2)
    }
}

fun bytecode(statement: String): Bytecode {
    val parser = MonkeyParser(Lexer(statement))
    val program = parser.parse()
    val compiler = Compiler()
    compiler.compile(program)
    return compiler.bytecode()
}
