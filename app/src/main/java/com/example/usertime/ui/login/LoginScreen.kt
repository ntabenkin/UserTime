package com.example.usertime


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.usertime.ui.home.UserState
import kotlinx.coroutines.launch


@ExperimentalFoundationApi
@Composable
fun ApplicationSwitcher() {
    val vm = UserState.current
    if (vm.isLoggedIn) {
        MainScreenView()
    } else {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    val email by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val vm = UserState.current
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (vm.loading) {
            CircularProgressIndicator()
        } else {
            Text("Login Screen", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Email(email)
            Spacer(modifier = Modifier.height(16.dp))
            Password(password)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                coroutineScope.launch {
                    vm.signIn(email, password)
                }
            }) {
                Text("Login")
            }
        }
    }
}

@Composable
fun Email(text: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}

@Composable
fun Password(text: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        //leadingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = "password") },
        //trailingIcon = {    Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Enter your password") },
    )
}
