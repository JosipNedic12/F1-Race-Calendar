package hr.ferit.josipnedic.f1racecalendar.Standings

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import coil.compose.rememberAsyncImagePainter
import hr.ferit.josipnedic.f1racecalendar.Details.CircularButton
import hr.ferit.josipnedic.f1racecalendar.R
import hr.ferit.josipnedic.f1racecalendar.Results.Driver
import hr.ferit.josipnedic.f1racecalendar.Results.DriversViewModel
import hr.ferit.josipnedic.f1racecalendar.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandingsScreen(
    navController: NavController,
    viewModel: DriversViewModel
) {
    Column (
        Modifier.fillMaxWidth()
    ){
        TopBar(navController = navController)
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){

        }
        StandingsContainer(viewModel = viewModel)
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
            text = "STANDINGS",
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 35.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        )
        CircularButton(iconResource = R.drawable.form, color = Color.White, onClick = {
            navController.navigate(
                Routes.getResultImportPath()
            )})
    }
}

@Composable
fun StandingsContainer(
    viewModel: DriversViewModel
) {
    viewModel.driversData.forEach { driver->
        CalculatePoints(viewModel,driver)
    }
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
        viewModel.driversData.sortedByDescending { it.points }.forEach { driver ->
            item{PointsBox(driver)}
        }
    }
}

@Composable
fun PointsBox(
    driver: Driver
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = driver.image),
                contentDescription = null,
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

            ) {
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
        ) {
            Text(
                text = driver.name,
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
        ) {
            Text(
                text = driver.points.toString(),
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

@SuppressLint("SuspiciousIndentation")
fun CalculatePoints(
    viewModel: DriversViewModel,
    driver: Driver
){
    driver.points=0
    val PointSystem:List<Int> = listOf(25,18,15,12,10,8,6,4,2,1,0,0,0,0,0,0,0,0,0,0)
    val id = ""
    viewModel.racesData.forEach { race ->
    for (i in 0..race.results.size-1) {
        val id = race.results[i]
            if(id == driver.id) {
                driver.points+=PointSystem[i]
            }
        }
    }
}

