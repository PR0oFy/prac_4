fun main() {
    println("Введите строку для шифрования: ")
    val inputString = readLine() ?: ""

    println("Введите код для шифрования: ")
    val enteredCode = readLine() ?: ""
    val encryptedString = encryptString(inputString, enteredCode)
    println("Зашифрованная строка: $encryptedString")
}

fun encryptString(input: String, code: String): String {
    val shifr = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val encryptedChars = mutableListOf<Char>()

    for (i in input.indices) {
        val inputChar = input[i]
        val codeChar = code[i % code.length]

        val begin = shifr.indexOf(inputChar)
        val offset = shifr.indexOf(codeChar)
        val encryptedChar = shifr[(begin + offset) % 33]

        encryptedChars.add(encryptedChar)
    }

    return encryptedChars.joinToString("")
}