enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)
// Os parâmetros definidos com var foram definidos usando val para que não se tenha mudanças nesses valores.

class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    // O mesmo foi feito nos parâmetros dessa classe.

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }
}

fun main() {
    // Alguns objetos de exemplo
    val conteudo1 = ConteudoEducacional("Introdução à Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 90)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android com Kotlin", 120)

    val usuario1 = Usuario("Pedro")
    val usuario2 = Usuario("Paulo")

    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Listando inscritos na formação
    formacaoKotlin.listarInscritos()
}
