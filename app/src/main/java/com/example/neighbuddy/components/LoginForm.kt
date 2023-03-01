package com.example.neighbuddy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat.FocusDirection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(name: String, password: String, onNameChange: (String) -> Unit, onPasswordChange: (String) -> Unit, onLogin: () -> Unit) {
    var (passwordVisible, setPasswordVisible) = rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    // Logo
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 64.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(32.dp, 32.dp)
        )
    }

    // Text inputs
    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = name,
            onValueChange = onNameChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp, 4.dp),
            label = { Text("Usuário") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            keyboardActions = KeyboardActions(onDone = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down) })
        )

        TextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp, 4.dp),
            label = { Text("Senha") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            keyboardActions = KeyboardActions(onDone = { onLogin() }),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { setPasswordVisible(!passwordVisible) }){
                    Icon(imageVector  = image, description)
                }
            }

        )

        // Create a button with the text "Login"
        Button(
            onClick = onLogin,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp, 16.dp)
        ) {
            Text("Login", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}