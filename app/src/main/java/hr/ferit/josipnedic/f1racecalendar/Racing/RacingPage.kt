package hr.ferit.josipnedic.f1racecalendar.Racing

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hr.ferit.josipnedic.f1racecalendar.R
import hr.ferit.josipnedic.f1racecalendar.Routes.getRaceDetailsPath

@Composable
fun RacingPage(
    navController: NavController
) {
    Column (
        Modifier.
        fillMaxWidth()
    ){
        HomeTitle()
        RacingContainer(navController)
    }
}



@Composable
fun HomeTitle(
        title: String = stringResource(id = R.string.home_title),
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .paint(
                painter = painterResource(id = R.drawable.topbackground1),
                contentScale = ContentScale.FillBounds
            )
            .border(
                BorderStroke(5.dp, Color.Black),
                shape = RoundedCornerShape(3.dp)
            )
            .clip(shape = RoundedCornerShape(5.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 35.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold

            )
        )
        SearchBar(
            iconResource = R.drawable.ic_search,
            labelText = "Search",
        )
    }
}


@Composable
fun F1RaceItem(
    id: Int,
    race: F1Race,
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(15.dp, 10.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .height(130.dp)
            .clickable {
                navController.navigate(getRaceDetailsPath(id))
            }
    ) {
        // Background Image
        Image(
            painter = painterResource(id = race.image), // Replace with your image resource
            contentDescription = null, // Content description for accessibility
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .blur(radius = 2.dp),
            contentScale = ContentScale.Crop
        )

        // Content on top of the background image
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = race.location, fontWeight = FontWeight.Bold, fontSize = 30.sp,color = Color.Red)
            Text(text = race.date, fontSize = 16.sp ,color = Color.Red, fontWeight = FontWeight.Bold)
            Text(text = race.name, fontSize = 16.sp ,color = Color.Red, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun RacingContainer(
    navController: NavController
) {
    LazyColumn (
        Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        races.forEachIndexed { index, f1Race ->
            item { F1RaceItem(index,race = f1Race,navController) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        placeholderColor = White,
        textColor = White,
        unfocusedLabelColor = White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
    )
) {
    val searchInput = remember { mutableStateOf("") }
    TextField(
        value = searchInput.value,
        onValueChange = { searchInput.value = it },
        label = {
            Text(labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(4.dp, color = Black), shape = RoundedCornerShape(5.dp))
    )
}

