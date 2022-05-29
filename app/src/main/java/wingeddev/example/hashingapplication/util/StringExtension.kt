package wingeddev.example.hashingapplication.util

import java.security.MessageDigest

fun String.toMd5String(): String {
    val hash = MessageDigest
        .getInstance("md5")
        .digest(this.toByteArray())
        .fold("") { str, it ->
            str + "%02x".format(
                it
            )
        }
    return hash
}

fun String.toSha512String(): String {
    val hash = MessageDigest
        .getInstance("SHA-512")
        .digest(this.toByteArray())
        .fold("") { str, it ->
            str + "%02x".format(
                it
            )
        }
    return hash
}

fun String.toSha256String(): String {
    val hash = MessageDigest
        .getInstance("SHA-256")
        .digest(this.toByteArray())
        .fold("") { str, it ->
            str + "%02x".format(
                it
            )
        }
    return hash
}