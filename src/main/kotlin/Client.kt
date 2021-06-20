import kotlin.math.roundToInt
import kotlin.random.Random

class Client{
    private companion object{
        val probabilities = listOf( 0.25f, 0.3f, 0.45f )
    }
    fun needToBuyInDepartment( departmentId: Int ) : Boolean = Random.isProbably( probabilities[departmentId] )
}

private fun Random.isProbably( probability : Float): Boolean {
    return nextInt(0,100) < (probability * 100).roundToInt()
}
