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
        DriversContainer(race = race,viewModel = viewModel)
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

        CircularButton(iconResource = R.drawable.ic_arrow_back, color = Color.White, onClick = {navController.navigateUp()})
        Spacer(modifier = Modifier.width(82.dp))
        Text(
            text = "RESULTS",
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 35.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun DriversContainer(
    race: F1Race,
    viewModel: DriversViewModel
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(race.results.size==0) {
            item{
                Text(text = "TBD",
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 40.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
            }
        }
        for (i in 0..race.results.size-1) {
            val id = race.results[i]
            items(viewModel.driversData.size) {
                if (id == viewModel.driversData[it].id) {
                    ResultBox(i,driver = viewModel.driversData[it])
                }
            }
        }
    }
}

@Composable
fun ResultBox(
    place: Int,
    driver: Driver
) {
    val ordinalNumbers = listOf(
        "1st", "2nd", "3rd", "4th", "5th",
        "6th", "7th", "8th", "9th", "10th",
        "11th", "12th", "13th", "14th", "15th",
        "16th", "17th", "18th", "19th", "20th"
    )
    Row (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(10.dp))
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
                .width(60.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color.Transparent),

        ){
            Image(
                painter = rememberAsyncImagePainter(model = driver.teamLogo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.CenterStart
            )
        }
        Box(
            modifier = Modifier
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
                .width(180.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color.Transparent)
                .paint(
                    painter = painterResource(id = R.drawable.topbackground),
                    contentScale = ContentScale.FillBounds
                )
                .padding(5.dp, 0.dp, 0.dp, 0.dp),
                contentAlignment = Alignment.CenterStart
            ){
            Text(text = driver.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Box(
            modifier = Modifier
                .padding(10.dp, 0.dp, 0.dp, 0.dp)
                .width(60.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color.Transparent)
                .paint(
                    painter = painterResource(id = R.drawable.topbackground),
                    contentScale = ContentScale.FillBounds
                ),
            contentAlignment = Alignment.Center
        ){
            Text(text = ordinalNumbers[place],
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
