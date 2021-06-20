import androidx.compose.desktop.DesktopTheme
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

fun controlWindow() = Window(   size = IntSize(310,500),
    resizable = false) {
    var firstDepartment by remember {  mutableStateOf("") }
    var secondDepartment by remember {  mutableStateOf("") }
    var thirdDepartment by remember {  mutableStateOf("") }
    val inputs = listOf(  firstDepartment, secondDepartment, thirdDepartment)

    val shop = Shop
    DesktopTheme {
        Column {
            Row {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Button(
                        onClick = {
                            shop.addNewClient(Client())
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(156, 204, 101),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Add Client")
                    }
                }
                Column(
                    Modifier.padding(16.dp)
                ) {
                    Button(
                        onClick = {
                            shop.resetShop()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(244, 67, 54),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Reset Shop")
                    }
                }
            }
            Row {
                Column(Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = firstDepartment,
                        onValueChange = { firstDepartment = it },
                        label = { Text("First Department") }
                    )
                }
            }
            Row {
                Column(Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = secondDepartment,
                        onValueChange = { secondDepartment = it },
                        label = { Text("Second Department") }
                    )
                }
            }
            Row {
                Column(Modifier.padding(16.dp)) {
                    OutlinedTextField(
                        value = thirdDepartment,
                        onValueChange = { thirdDepartment = it },
                        label = { Text("Third Department") }
                    )
                }
            }
            Row {
                Column(Modifier.padding(16.dp)) {
                    Button(
                        onClick = {
                            shop.initializeShop( inputs.map { it.toIntOrNull() } )
                            firstDepartment = ""
                            secondDepartment = ""
                            thirdDepartment = ""
                        }
                    ){
                        Text("Initialize with values")
                    }
                }
            }

        }
    }
}
