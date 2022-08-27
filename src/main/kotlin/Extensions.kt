fun Int.to2UByteArray() : UByteArray
    = ubyteArrayOf(shr(8).toUByte(), toUByte())
