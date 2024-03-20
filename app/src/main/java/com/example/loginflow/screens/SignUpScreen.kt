package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.BoldTextComponent
import com.example.loginflow.components.BoldTextComponentPreview
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.CheckboxComponent
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextField
import com.example.loginflow.navigation.PostOfficeAppRouter
import com.example.loginflow.navigation.Screen

@Composable
fun SignUpScreen() {
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
            BoldTextComponent(value= "Create an Account")

            Spacer(modifier = Modifier.size(60.dp))

            MyTextField(labelValue = "First Name",painterResource(id = R.drawable.user48))

            MyTextField(labelValue = "Last Name",painterResource(id = R.drawable.user48))

            MyTextField(labelValue = "Email",painterResource(id = R.drawable.mail48))

           PasswordTextField(labelValue = "Password", painterResource(id =R.drawable.lock48))

            CheckboxComponent(value = "By continuing you accept our Privacy Policy and Term of Use",
                onTextSelected = {
                   PostOfficeAppRouter.navigateTo(Screen.TermsAndUseScreen)
                })

            Spacer(modifier = Modifier.size(80.dp))

            ButtonComponent(value = "Register")

            Spacer(modifier = Modifier.size(10.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.size(10.dp))

            ClickableLoginTextComponent(onTextSelected = {
                 PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpScreen()
}