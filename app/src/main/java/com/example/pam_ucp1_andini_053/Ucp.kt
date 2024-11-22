package com.example.pam_ucp1_andini_053

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Ucp(modifier: Modifier = Modifier){
    Column (modifier = Modifier.fillMaxSize()){
        SectionHeader()
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Yuk lengkapi data dirimu!", modifier = modifier.padding(8.dp))
        MainSection()
    }
}

@Composable
fun SectionHeader(){
    Box(modifier = Modifier.fillMaxWidth().background(color = Color.Blue)){
        Row {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "",
                Modifier.padding(end = 13.dp).size(25.dp),
                tint = Color.White
            )
            Column (Modifier.padding(16.dp)){
                Text(text = "Hallo,", color = Color.White)
                Spacer(Modifier.height(4.dp))
                Text(text = "Andini Septi Andri", fontSize = 24.sp, color = Color.White)
            }

            Box(contentAlignment = Alignment.BottomEnd){
                Image(
                    painter = painterResource(id = R.drawable.cat),
                    contentDescription = "",
                    Modifier.size(100.dp).clip(shape = CircleShape)
                )

            }
        }
    }
}

@Composable
fun MainSection(modifier: Modifier = Modifier){
    var nama by rememberSaveable { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-Laki", "Perempuan")

    var namaUser by rememberSaveable { mutableStateOf("") }
    var noHPUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("") }

    Column (modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama")},
            label = { Text("Nama")},
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Nomor Handphone")},
            label = { Text("No HP")},
            leadingIcon = { Icon(Icons.Filled.Call, contentDescription = "")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        //Radio button untuk kelamin
        Row (){
            jenisKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) { RadioButton(
                    selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    }
                )
                    Text(item)
                }
            }
        }

        Button(onClick = {
            namaUser = nama
            selectedGenderUser = selectedGender
            noHPUser = noHP
        })
        { Text("Simpan") }

        Spacer(modifier = Modifier.padding(8.dp))
        Card(modifier.size(height = 200.dp, width = 350.dp)) {
            CardSection(judulParam = "No HP", isiParam = noHPUser)
            Icon(
                Icons.Filled.Call,
                contentDescription = "",
                Modifier.padding(end = 13.dp).size(25.dp).clip(shape = CircleShape),
                tint = Color.White
            )
            CardSection(judulParam = "Jenis Kelamin ", isiParam = selectedGenderUser)
            Icon(
                Icons.Filled.Person,
                contentDescription = "",
                Modifier.padding(end = 13.dp).size(25.dp).clip(shape = CircleShape),
                tint = Color.White
            )
        }
    }
}

@Composable
fun CardSection(judulParam:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)){

        Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = "$isiParam", modifier = Modifier.weight(2f))

        }
    }
}
