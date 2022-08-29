fun Int.to2UByteArray() : UByteArray
    = ubyteArrayOf(shr(8).toUByte(), toUByte())

fun Int.to2ByteArray() : ByteArray
        = byteArrayOf(shr(8).toByte(), toByte())

fun ByteArray.readUIntAt(idx: Int = 0) =
        ((this[idx].toUInt() and 0xFFu) shl 24) or
        ((this[idx + 1].toUInt() and 0xFFu) shl 16) or
        ((this[idx + 2].toUInt() and 0xFFu) shl 8) or
        (this[idx + 3].toUInt() and 0xFFu)

fun ByteArray.readUInt16At(idx: Int = 0) =
        ((this[idx + 0].toUInt() and 0xFFu) shl 8) or
        (this[idx + 1].toUInt() and 0xFFu)
