// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// Níveis de formação
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }
// Classe de usuário
class Usuario
// Classe de conteúdo educacional
data class ConteudoEducacional(var nome: String, val duracao: Int = 60)
// Classe de formação
data class Formacao(val nomeForm: String, var conteudos: List<ConteudoEducacional>) {
    // Lista de usuários inscritos
    val inscritos = mutableListOf<Usuario>()
    // Função para matricular um usuário
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    // Função para exibir os inscritos
    fun exibirInscritos() {
        println("Usuários inscritos na formação $nomeForm:")
        for (usuario in inscritos) {
            println(usuario.toString())
        }
    }
}

// Função para criar lista de formações
fun criarFormacoes(): List<Formacao> {
    val conteudoAAMK = ConteudoEducacional("Arquitetura de Aplicativos Móveis com Kotlin", 90)
    val conteudoTDAM = ConteudoEducacional("Teste e Depuração de Aplicativos Móveis", 120)
    val conteudoML = ConteudoEducacional("Machine Learning", 150)
    val conteudoRC = ConteudoEducacional("Redes de Computadores", 100)
    val conteudoDWA = ConteudoEducacional("Desenvolvimento Web Avançado", 120)
    val conteudoSDI = ConteudoEducacional("Segurança da Informação", 130)

    val formacaoDevMobile = Formacao("Desenvolvimento Mobile", listOf(conteudoAAMK, conteudoTDAM))
    val formacaoDevWeb = Formacao("Desenvolvimento Web", listOf(conteudoML, conteudoRC, conteudoDWA))
    val formacaoSeguranca = Formacao("Segurança Cibernética", listOf(conteudoSDI))

    return listOf(formacaoDevMobile, formacaoDevWeb, formacaoSeguranca)
}

fun main() {
    
    val usuario1 = Usuario()
    val usuario2 = Usuario()
    val usuario3 = Usuario()
    val usuario4 = Usuario()
    
    val formacoes = criarFormacoes()
    
    // Associar formações pelo nome
    val formacoesPorNome = formacoes.associateBy { it.nomeForm }
     
    // Matricular usuários em formações
    formacoesPorNome["Desenvolvimento Mobile"]?.matricular(usuario1)
    formacoesPorNome["Desenvolvimento Mobile"]?.matricular(usuario4)
    formacoesPorNome["Desenvolvimento Web"]?.matricular(usuario2)
    formacoesPorNome["Segurança Cibernética"]?.matricular(usuario3)
    
    // Exibir inscritos em cada formação
    for (formacao in formacoes) {
        println("Formação: ${formacao.nomeForm}")
        formacao.exibirInscritos()
        println()
    }
}
