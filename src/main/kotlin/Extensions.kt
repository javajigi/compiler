fun Int.to2ByteArray() : ByteArray
    = byteArrayOf(toByte(), shr(8).toByte())
