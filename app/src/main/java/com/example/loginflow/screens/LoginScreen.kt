package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.BoldTextComponent
import com.example.loginflow.components.ClickableForgotTextComponent
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.ClickableRegisterTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.LoginButtonComponent
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextField
import com.example.loginflow.navigation.PostOfficeAppRouter
import com.example.loginflow.navigation.Screen
import com.example.loginflow.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(){
   Surface(
       modifier = Modifier
           .fillMaxSize()
           .background(color = Color.White)
           .padding(28.dp)
   ) {
       Column(
           modifier = Modifier.fillMaxSize()
       ) {
           NormalTextComponent(value = "Hey there,")
           BoldTextComponent(value= "Welcome Back")

           Spacer(modifier = Modifier.size(60.dp))

           MyTextField(labelValue = "Email", painterResource(id = R.drawable.mail48))

           PasswordTextField(labelValue = "Password", painterResource(id =R.drawable.lock48))

           Spacer(modifier = Modifier.size(20.dp))

           ClickableForgotTextComponent(onTextSelected = {

           })

           Spacer(modifier = Modifier.size(160.dp))

           LoginButtonComponent(value = "Login")

           Spacer(modifier = Modifier.size(10.dp))

           DividerTextComponent()

           Spacer(modifier = Modifier.size(10.dp))

           ClickableRegisterTextComponent(onTextSelected = {
              PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
           })
       }
   }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}