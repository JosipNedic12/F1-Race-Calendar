package hr.ferit.josipnedic.f1racecalendar.Details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import coil.compose.AsyncImage
import com.google.firebase.Timestamp
import hr.ferit.josipnedic.f1racecalendar.R
import hr.ferit.josipnedic.f1racecalendar.Racing.F1Race
import hr.ferit.josipnedic.f1racecalendar.Routes
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun RaceDetailScreen(
    navController : NavController,
    race: F1Race
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopBar(race = race,navController)
        ScrollableList(race = race)
    }
}


@Composable
fun CircularButton(
    @DrawableRes iconResource: Int, color: Color,
    onClick: () -> Unit = {}
) {
    Button(
        contentPadding = PaddingValues(5.dp,5.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = color,

            ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
            .border(BorderStroke(4.dp, color = Color.White), shape = RoundedCornerShape(10.dp))

    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
        )
    }
}

@Composable
fun TimeBox(name: String , time: Timestamp) {
    Box(
        modifier = Modifier
            .padding(15.dp, 5.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(70.dp)
            .paint(
                painter = painterResource(id = R.drawable.topbackground),
                contentScale = ContentScale.FillBounds
            )
            .padding(5.dp, 10.dp),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.width(70.dp))
            Column(
                modifier = Modifier
                    .padding(0.dp,0.dp,10.dp,0.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                if(unixDateToString(timestampToUnix(time))=="February.07"){
                        Text(text ="TBC",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                textAlign = TextAlign.Right,
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }else {
                    Text(
                        text = unixDateToString(timestampToUnix(time)),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Right,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = unixDayToString(timestampToUnix(time)),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Right,
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar(
    race: F1Race,
    navController: NavController
) {
    Row (
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
    ){

        CircularButton(iconResource = R.drawable.ic_arrow_back, color = Color.White, onClick = {navController.navigateUp()})
        Text(
            text = race.location.toUpperCase(),
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 35.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        )
        CircularButton(iconResource = R.drawable.flag, color = Color.White, onClick = {navController.navigate(
            Routes.getRaceResultSPath(race.id))
        }
        )
    }
}

@Composable
fun ScrollableList(
    race:F1Race
) {
    LazyColumn (
        Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
            .padding(10.dp, 0.dp, 10.dp, 10.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(10.dp))
            AsyncImage(
                model = race.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(10.dp)) }
        item {
            Text(text = "Circuit layout",
                style = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        item {  Spacer(modifier = Modifier.height(10.dp)) }
        item{
            AsyncImage(
                model = race.layout,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
        }
        item{ TimeBox(name = "Practice 1", time = race.training1Time)}
        item{ TimeBox(name = "Practice 2", time = race.training2Time)}
        item{ TimeBox(name = "Practice 3", time = race.training3Time)}
        item{ TimeBox(name = "Qualifying", time = race.qualyTime)}
        item{ TimeBox(name = "Race", time = race.raceTime)}
    }
}


fun timestampToUnix(timestamp: Timestamp): Long {
    // Convert seconds and nanoseconds to milliseconds
    val milliseconds = timestamp.seconds * 1000 + timestamp.nanoseconds / 1_000_000 // Convert nanoseconds to milliseconds
    return milliseconds
}

fun unixDateToString(unixTimestamp: Long): String {
    val date = Date(unixTimestamp)
    val sdf = SimpleDateFormat("MMMM.dd", Locale.getDefault()) // Define your desired date format
    return sdf.format(date)
}
fun unixDayToString(unixTimestamp: Long): String {
    val date = Date(unixTimestamp)
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault()) // Define your desired date format
    return sdf.format(date)
}