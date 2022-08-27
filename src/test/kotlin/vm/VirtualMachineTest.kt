package vm

import compiler.Compiler
import lexer.Lexer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import parser.MonkeyParser

class VirtualMachineTest {
    @Test
    fun run() {
        val parser = MonkeyParser(Lexer("1 + 2"))
        val program = parser.parse()
        val compiler = Compiler()
        compiler.compile(program)
        val bytecode = compiler.bytecode()
        val vm = VirtualMachine(bytecode)
        vm.run()
        assertThat(vm.pop()).isEqualTo(3)
    }
}
