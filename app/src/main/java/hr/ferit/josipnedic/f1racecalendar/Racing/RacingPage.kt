package hr.ferit.josipnedic.f1racecalendar.Racing

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import hr.ferit.josipnedic.f1racecalendar.Details.CircularButton
import hr.ferit.josipnedic.f1racecalendar.R
import hr.ferit.josipnedic.f1racecalendar.Results.DriversViewModel
import hr.ferit.josipnedic.f1racecalendar.Routes
import hr.ferit.josipnedic.f1racecalendar.Routes.getRaceDetailsPath

@Composable
fun RacingPage(
    viewModel: DriversViewModel,
    navController: NavController
) {
    var searchText by remember { mutableStateOf("") }

    Column (
        Modifier.
        fillMaxWidth()
    ){
        HomeTitle(navController)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .paint(
                painter = painterResource(id = R.drawable.topbackground1),
                contentScale = ContentScale.FillBounds
            )) {
            SearchBar(
                iconResource = R.drawable.ic_search,
                labelText = "Search",
                onSearchTextChanged = { newText ->
                    searchText = newText
                }
            )
        }
        RacingContainer(viewModel.filterRaces(searchText),navController)
    }
}



@Composable
fun HomeTitle(
    navController: NavController,
        title: String = stringResource(id = R.string.home_title),
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .paint(
                painter = painterResource(id = R.drawable.topbackground1),
                contentScale = ContentScale.FillBounds
            )
            .padding(10.dp, 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 37.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold

            )
        )
        CircularButton(iconResource = R.drawable.user, color = White, onClick = {navController.navigate(Routes.getStandingsPath())}
        )
    }
}


@Composable
fun F1RaceItem(
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
                navController.navigate(getRaceDetailsPath(race.id))
            }
    ) {
        // Background Image
        Image(
            painter = rememberAsyncImagePainter(
                model = race.image,
                onError = { error ->
                    Log.e("ImageLoading", "Error loading image: ${error.result}")
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = race.location, fontWeight = FontWeight.Bold, fontSize = 30.sp,color = Color.White)
            Text(text = race.date, fontSize = 16.sp ,color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = race.name, fontSize = 16.sp ,color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable

fun RacingContainer(
    racesData: List<F1Race>,
    navController: NavController
) {
    LazyColumn (
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        items(racesData.size) {
            F1RaceItem(race = racesData[it],navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    onSearchTextChanged: (String) -> Unit,
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
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = searchInput.value,
        onValueChange = {
            searchInput.value = it
            onSearchTextChanged(it) // Notify the parent of the new search text
        },
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
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        modifier = Modifier
            .padding(10.dp, 0.dp, 10.dp, 5.dp)
            .fillMaxWidth()
            .border(BorderStroke(4.dp, color = Black), shape = RoundedCornerShape(25.dp)),
    )

}


fun DriversViewModel.filterRaces(searchQuery: String): List<F1Race> {
    return if (searchQuery.isBlank()) {
        racesData // Return all races if the search query is empty
    } else {
       racesData.filter { race ->
            race.location.contains(searchQuery, ignoreCase = true) ||
                    race.date.contains(searchQuery, ignoreCase = true) ||
                    race.name.contains(searchQuery, ignoreCase = true)
        }
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
            .border(BorderStroke(4.dp, color = White), shape = RoundedCornerShape(10.dp))

    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
        )
    }
}