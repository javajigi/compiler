package vm

import compiler.bytecode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VirtualMachineTest {
    @Test
    fun run() {
        val bytecode = bytecode("1 + 2")
        val vm = VirtualMachine(bytecode)
        vm.run()
        assertThat(vm.lastPoppedStackElement()).isEqualTo(3)
    }
}
