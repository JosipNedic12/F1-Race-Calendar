package hr.ferit.josipnedic.f1racecalendar.Results

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.rememberAsyncImagePainter
import hr.ferit.josipnedic.f1racecalendar.Details.CircularButton
import hr.ferit.josipnedic.f1racecalendar.R
import hr.ferit.josipnedic.f1racecalendar.Racing.F1Race

@Composable
fun ResultsScreen(
    viewModel: DriversViewModel,
    navController: NavController,
    race: F1Race,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopBar(navController = navController)
        DriversContainer(viewModel = viewModel)
        }
}



@Composable
fun TopBar(
    navController: NavController
) {
    Row (
        Modifier
            .height(75.dp)
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.topbackground1),
                contentScale = ContentScale.FillBounds
            )
            .border(
                BorderStroke(5.dp, Color.Black),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(15.dp, 0.dp, 15.dp, 0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){

        CircularButton(iconResource = R.drawable.ic_arrow_back, color = Color.Black, onClick = {navController.navigateUp()})
        Spacer(modifier = Modifier.width(82.dp))
        Text(
            text = "RESULTS",
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 35.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun DriversContainer(
viewModel: DriversViewModel
) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ){
        items(viewModel.driversData.size) {
            ResultBox(driver = viewModel.driversData[it])
        }
    }
}

@Composable
fun ResultBox(
  driver: Driver
) {
    Row (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.LightGray)
        ){

            Image(
                painter = rememberAsyncImagePainter(model = driver.image), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
        }
        Box(
            modifier = Modifier
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth()
                .height(60.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.LightGray)
        ){
            Text(
                text = driver.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 35.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold

                )
            )
        }
    }
}
