package code

import to2ByteArray

class Instructions(val bytes: ByteArray) {
    constructor(opCode: OpCode): this(byteArrayOf(opCode.ordinalToByte(), *opCode.operandWidths().to2ByteArray() ))
}
