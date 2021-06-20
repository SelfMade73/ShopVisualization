import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

val colors = listOf(
    Color(244, 143, 177),
    Color(188, 250, 117),
    Color(129, 212, 250)
)

fun stateWindow() = Window( size = IntSize(510,200),
    resizable = false){
    val shop = Shop
    Card (
        backgroundColor = Color(18,18,18),
        modifier = Modifier.width(510.dp).height(200.dp)
    ){
        Row{
            shop.deps.forEachIndexed{ index, department ->
                departmentColumn( department, colors[index] )
            }
        }
    }
}



