
object Shop {
    val deps  = mutableListOf<Department>()

    init {
        repeat(3){
            deps.add(Department())
        }
        // Своего рода linked list
        deps.forEachIndexed { index, department ->
            if ( index != deps.lastIndex ){
                department.setNextDep( deps[index + 1] )
            }
        }
    }

    fun addNewClient( client : Client ){
        deps.first().addClient(client)
    }

    fun initializeShop( sizes : List<Int?> ){
        this.resetShop()
        deps.forEachIndexed { index, department ->
            sizes[index]?.let {
                repeat(it){
                    department.addClient(Client())
                }
            }
        }
    }

    fun resetShop() = deps.forEach{ it.reset() }
}