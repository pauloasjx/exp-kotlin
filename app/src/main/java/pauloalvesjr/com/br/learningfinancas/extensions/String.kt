package pauloalvesjr.com.br.learningfinancas.extensions

fun String.limit(n : Int) : String {
    if (this.length > n) {
        return "${this.substring(0, n)}..."
    }
    return this
}