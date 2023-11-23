import kotlin.random.Random

fun main() {
    println("Привет, поиграем Камень-Ножницы-Бумага!")
    println("Выбери свой ход: 1 - Камень, 2 - Ножницы, 3 - Бумага")

    val playerChoice = readLine()?.toIntOrNull()

    if (playerChoice != null && playerChoice in 1..3) {
        val computerChoice = Random.nextInt(1, 4)
        displayChoices(playerChoice, computerChoice)

        val result = determineWinner(playerChoice, computerChoice)
        println(result)
    } else {
        println("Некорректный ввод. Пожалуйста, выберите число от 1 до 3.")
    }
}

fun displayChoices(player: Int, computer: Int) {
    println("Ваш выбор: ${translateChoice(player)}")
    println("Выбор компьютера: ${translateChoice(computer)}")
}

fun translateChoice(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Я вас не понимаю!"
    }
}

fun determineWinner(player: Int, computer: Int): String {
    return when {
        player == computer -> "Ничья!"
        (player == 1 && computer == 3) || (player == 2 && computer == 1) || (player == 3 && computer == 2) ->
            "Вы победили!"
        else -> "Вы проиграли."
    }
}