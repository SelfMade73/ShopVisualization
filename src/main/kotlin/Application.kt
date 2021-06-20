import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

fun main() = Window( size = IntSize(250,110) ) {
    Row {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Button(onClick = {
                controlWindow();
            }
            ){
                Text("Control")
            }
        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Button( onClick = {
                stateWindow()
            }){
                Text("State")
            }


        }
    }
}

@Composable
fun departmentColumn( department: Department, progressColor : Color ) {
    val clientsInQueue by remember { mutableStateOf(department.clientsInQueue) }
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp),
        backgroundColor = Color(8,8,8)
    ){
        Column(
            Modifier.padding(24.dp)
        ) {
            Text(
                text = "Department №${department.getId() + 1}",
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White
            )
            CircularProgressIndicator(
                progress = clientsInQueue.value.toFloat().div(5),
                strokeWidth = 40.dp,
                color = progressColor
            )
        }
    }
}

