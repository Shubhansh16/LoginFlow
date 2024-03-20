@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.loginflow.components

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.R
import com.example.loginflow.ui.theme.BgColor
import com.example.loginflow.ui.theme.GrayColor
import com.example.loginflow.ui.theme.Primary
import com.example.loginflow.ui.theme.Secondary
import com.example.loginflow.ui.theme.TextColor
import kotlin.math.log
import androidx.compose.material3.Text as Text1
import androidx.compose.material3.Text as Text2

@Composable
fun NormalTextComponent(value:String){
    Text2(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun BoldTextComponent(value:String){
    Text2(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue:String, painterResource:Painter){
    val textValue = remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor),

        label = { Text(text = labelValue)},


        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value ,
        onValueChange = {
            textValue.value=it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue:String, painterResource:Painter){

    val localFocusManager = LocalFocusManager.current

    val passowrd = remember{
        mutableStateOf("")
    }
    
    val passwordVisible= remember{
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor),

        label = { Text(text = labelValue)},


        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        value = passowrd.value ,
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions{
                                         localFocusManager.clearFocus()
        },
        onValueChange = {
            passowrd.value=it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            var description= if(passwordVisible.value){
                "Hide Password"
            } else {
                "Show Password"
            }
            IconButton(onClick = { passwordVisible.value= !passwordVisible.value }) {
                 Icon(imageVector =iconImage , contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckboxComponent(value: String,onTextSelected:(String)->Unit){
  Row (
      modifier = Modifier
          .fillMaxWidth()
          .heightIn(56.dp),
      verticalAlignment = Alignment.CenterVertically
  ){
      val checkedState = remember {
          mutableStateOf(false)
      }
     Checkbox(checked = checkedState.value,
         onCheckedChange ={
             checkedState.value != checkedState.value
         } )
      ClickableTextComponent(value = value, onTextSelected)
  }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected:(String)->Unit){

    val initialText= "By continuing you accept our "
    val privacyPolicy="Privacy Policy"
    val andText=" and "
    val termsAndUse="Terms and Use"

    val annotatedString = buildAnnotatedString {
     append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = termsAndUse, annotation = termsAndUse)
            append(termsAndUse)
        }
    }
    ClickableText(text = annotatedString, onClick = {offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent", "{$span}")

               if ((span.item==termsAndUse )||(span.item==privacyPolicy)){
                   onTextSelected(span.item)
               }
            }
    } )
}

@Composable
fun ButtonComponent(value: String){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(androidx.compose.ui.graphics.Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
          Text(text = value,
              fontSize = 18.sp,
              fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LoginButtonComponent(value: String){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(androidx.compose.ui.graphics.Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DividerTextComponent(){
   Row (
       modifier = Modifier.fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically

   ){
      Divider(modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
          color = GrayColor,
          thickness = 1.dp)

       Text(text = " Or ", fontSize = 14.sp, color = TextColor, modifier = Modifier.padding(9.dp))

       Divider(modifier = Modifier
           .fillMaxWidth()
           .weight(1f),
           color = GrayColor,
           thickness = 1.dp)
   }
}

@Composable
fun ClickableLoginTextComponent(onTextSelected:(String)->Unit){

    val initialText= "Already have an account? "
    val login="Login"

    val annotatedString = buildAnnotatedString {
        append(initialText)

        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = login, annotation = login)
            append(login)
        }
    }
    ClickableText(  modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        ),
        text = annotatedString, onClick = {offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent", "{$span}")

                if (span.item==login ){
                    onTextSelected(span.item)
                }
            }
    } )
}

@Composable
fun ClickableRegisterTextComponent(onTextSelected:(String)->Unit){

    val initialText= "Don't have an account yet? "
    val register="Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)

        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = register, annotation = register)
            append(register)
        }
    }
    ClickableText(  modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        ),
        text = annotatedString, onClick = {offset->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also {span->
                    Log.d("ClickableTextComponent", "{$span}")

                    if (span.item==register ){
                        onTextSelected(span.item)
                    }
                }
        } )
}

@Composable
fun ClickableForgotTextComponent(onTextSelected:(String)->Unit){

    val initialText= ""
    val forgot="Forgot your Password"

    val annotatedString = buildAnnotatedString {
        append(initialText)

        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = forgot, annotation = forgot)
            append(forgot)
        }
    }
    ClickableText(  modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        ),
        text = annotatedString, onClick = {offset->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also {span->
                    Log.d("ClickableTextComponent", "{$span}")

                    if (span.item==forgot ){
                        onTextSelected(span.item)
                    }
                }
        } )
}

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview(){
    ButtonComponent("Register")
}

@Preview(showBackground = true)
@Composable
fun NormalTextComponentPreview(){
    NormalTextComponent("Hey There")
}

@Preview(showBackground = true)
@Composable
fun BoldTextComponentPreview(){
    BoldTextComponent("Create an Account")
}

@Preview(showBackground = true)
@Composable
fun MyTextFieldPreview(){
    MyTextField("First Name",painterResource(id = R.drawable.outline_account_circle_24))
}

@Composable
@Preview(showBackground = true)
fun CheckBoxComponentPreview(){
   // CheckboxComponent("terms and Conditions", onTextSelected =)
}