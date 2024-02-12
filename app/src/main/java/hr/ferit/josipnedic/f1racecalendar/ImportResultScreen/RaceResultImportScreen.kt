package hr.ferit.josipnedic.f1racecalendar.ImportResultScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.josipnedic.f1racecalendar.Details.CircularButton
import hr.ferit.josipnedic.f1racecalendar.R
import hr.ferit.josipnedic.f1racecalendar.Results.DriversViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RaceResultInputScreen(viewModel: DriversViewModel,navController: NavController) {
    var raceId by remember { mutableStateOf("") }
    var raceResultText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            ),
    ) {
        TopBar(navController = navController)
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            TextField(
                value = raceId,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                onValueChange = { raceId = it },
                label = { Text("Race ID") },
                modifier = Modifier
                    .padding(15.dp, 5.dp)
                    .fillMaxWidth()
                    .background(color = Color.Transparent)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .border(BorderStroke(3.dp,Color.Black), shape = RoundedCornerShape(15.dp))
            )
            TextField(
                value = raceResultText,
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                onValueChange = { raceResultText = it },
                label = { Text("Race Result (comma separated)") },
                modifier = Modifier
                    .padding(15.dp, 5.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(15.dp))
                    .border(BorderStroke(3.dp,Color.Black),
                        shape = RoundedCornerShape(15.dp))
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                onClick = {
                    if(raceResultText != "" && raceId != ""){
                    val resultArray = raceResultText.split(",").map { it.trim() }
                    viewModel.saveRaceResultToFirestore(raceId, resultArray)}
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .border(BorderStroke(3.dp,Color.Black), shape = RoundedCornerShape(20.dp))
            ) {
                Text("Save Race Result",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontSize = 15.sp
                    ))
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun TopBar(
    navController: NavController
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(75.dp)
            .paint(
                painter = painterResource(id = R.drawable.topbackground1),
                contentScale = ContentScale.FillBounds
            )
            .border(
                BorderStroke(5.dp, Color.Black),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(15.dp, 0.dp, 15.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CircularButton(
            iconResource = R.drawable.ic_arrow_back,
            color = Color.White,
            onClick = { navController.navigateUp() })
        Text(
            text = "IMPORT-RESULT",
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 35.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.width(20.dp))
    }
}
