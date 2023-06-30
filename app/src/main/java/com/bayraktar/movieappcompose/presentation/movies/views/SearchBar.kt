package com.bayraktar.movieappcompose.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    modifier: Modifier,
    hint: String,
    onSearch: (String) -> Unit = {}
) {

    var text by remember {
        mutableStateOf("")
    }
    //to check searchbar hint
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    val textFieldColors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        placeholderColor = Color.Red
    )

    Box(modifier = modifier) {
        TextField(
            value = text,
            colors = textFieldColors,
            onValueChange = { newText ->
                text = newText
            },
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
            }),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black, fontStyle = FontStyle.Italic),
            shape = RoundedCornerShape(12.dp),

            modifier = modifier
                .fillMaxWidth()
                .shadow(3.dp,shape = CircleShape, ambientColor = Color.Green)
                .padding(9.dp)
                .onFocusChanged {
                    //if searchbar not focused and is empty, show hint, if not, dont show hint
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                }

        )
        //customize hint text
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 20.dp)
            )
        }

    }
}