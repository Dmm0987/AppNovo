package com.example.proj_23_08

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proj_23_08.ui.theme.Proj2308Theme
import java.text.Normalizer.Form

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proj2308Theme {
                FormLay()
                LargeFloatingActionButtonSample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FormLay() {

    val focusManager = LocalFocusManager.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    onClick = { /* TODO */ },
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.size(96.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AccountBox,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Text("Add photo")
            }
        }

        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Primeiro Nome") },
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )

        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Sobrenome") },
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        }
        item { Spacer(Modifier.height(4.dp)) }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Numero de Telefone") },
                value = text,
                onValueChange = { text = it },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                singleLine = true,
            )
        }
        item { Spacer(Modifier.height(4.dp)) }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Email") },
                value = text,
                onValueChange = { text = it },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus()
                },
                singleLine = true,
            )
        }
        item { Spacer(Modifier.height(4.dp)) }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("País") },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
            )
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Endereço") },
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
            )
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("Cidade") },
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Next)
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
            )
        }
        item {
            var text by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = { Text("CEP") },
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions {
                    focusManager.clearFocus()
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(
                        visible = text.isNotBlank(),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Outlined.Clear, "Clear")
                        }
                    }
                },
            )
        }
        item {
            Text(
                text = "Grupos",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 24.dp,
                    bottom = 8.dp
                )
            )
        }
        item {
            var selected by remember { mutableStateOf<Int?>(null) }
            val options = listOf("Familia", "Amigos", "Trabalho", "Outro")
            Column {
                options.forEachIndexed { i, option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier
                            .clickable { selected = i }
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        RadioButton(
                            selected = selected == i,
                            onClick = null
                        )
                        Text(text = option)
                    }

                }
            }
        }
        item {
            Text(
                text = "Opções de Notificações",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 24.dp,
                    bottom = 8.dp
                )
            )
        }
        item {
            var selected by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .clickable { selected = selected.not() }
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = selected,
                    onCheckedChange = null
                )
                Text(text = "Usar 'Não pertube'")
            }
        }
        item {
            var selected by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .clickable { selected = selected.not() }
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = selected,
                    onCheckedChange = null
                )
                Text(text = "Bloquear chamadas deste contato")

            }
        }
    }
}

@Preview
@Composable
fun LargeFloatingActionButtonSample() {
    LargeFloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "Localized description",
            modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize),
        )
    }
}

