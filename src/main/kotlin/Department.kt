import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.random.Random

class Department {
    var clientsInQueue = mutableStateOf(0)
    fun setNextDep( department: Department ){
        next = department
    }

    fun addClient( client: Client ){
        if (clients.size >= CLIENT_QUEUE_MAX_SIZE || !client.needToBuyInDepartment( id ) ){
            toNext(client)
            return
        }
        clients.add(client)
        clientsInQueue.value++
        GlobalScope.launch {
            handleClient()
        }
    }

    fun getId() : Int = id
    fun reset() {
        clients.clear()
        clientsInQueue.value = 0
    }

    @Synchronized
    private fun handleClient(){
        if ( clients.isNotEmpty()){
            runBlocking {
                launch {
                    delay( Random.nextLong(350,3000) )
                }
            }.invokeOnCompletion {
                if ( clients.isNotEmpty() ){
                    toNext( clients.remove() )
                    --clientsInQueue.value
                }
            }
        }
    }

    private companion object{
        const val CLIENT_QUEUE_MAX_SIZE = 5
        var id = 0
            get() { return field++ }
    }

    private var id = Department.id
    private var next : Department? = null

    // Очередь не требующая примитивов синхронизации для работы с ней
    private val clients = ConcurrentLinkedQueue<Client>()

    private fun toNext( client: Client) = next?.addClient(client = client)


}