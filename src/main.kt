
import java.util.*
import kotlin.math.sqrt


fun main (){

sieveBig(100000)

}
fun sieveBig(numQuantity: Int) {

   //https://en.wikipedia.org/wiki/Prime-counting_function
    val numPrimes: Int = (1.25506 * numQuantity / Math.log(numQuantity.toDouble())).toInt()
    val resultArr = ArrayList<Int>(numPrimes)
    val isComposite = BooleanArray(numQuantity) // all false == simple

    for (i in 2..sqrt(numQuantity.toDouble()).toInt()) {
        if (!isComposite[i]) {
            resultArr.add(i)
            //все что меньше и кратны i имеют простой делитель меньше i
            var j = i * i
            while (j < numQuantity) {
                isComposite[j] = true
                j += i
            }
        }
    }
    for (i in sqrt(numQuantity.toDouble()).toInt() until numQuantity)
        if (!isComposite[i])
            resultArr.add(i)
    println(resultArr)
}

