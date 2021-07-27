package com.compose.example.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.example.Application
import com.compose.example.R

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            prepareUI()
        }
    }
}

@Preview
@Composable
fun prepareUI() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 7.dp) {
            Column(
                modifier = Modifier
                    .width(250.dp)
                    .height(75.dp)
                    .padding(5.dp),
            ){
                Image(
                    painterResource(id = R.drawable.log_in),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = {
                Text("Kullanıcı Adı")
            },
            singleLine = true
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Şifre") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(onClick = {
            Toast.makeText(Application.appContext, "Hoş geldin $username", Toast.LENGTH_LONG).show()
        }, modifier = Modifier.padding(5.dp)) {
            Text("Giris Yap")
        }
    }
}
