package com.example.utspemob.ui.screens

import android.util.Log
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.utspemob.R
import com.example.utspemob.ui.components.BlurredGradientBackground
import com.example.utspemob.ui.components.DatePickerFieldToModal
import com.example.utspemob.ui.components.DropdownMenuField
import com.example.utspemob.ui.components.Profile
import com.example.utspemob.ui.components.RadioGroupField
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun BiodataScreen() {
    val initialNama = "Dindin Imanudin"
    val initialAlamat = "Bandung, Jalan Terusan Cikutra Baru"
    val initialGender = "Laki-laki"
    val initialPendidikan = "S1"

    val localeID = Locale.forLanguageTag("id-ID")
    val defaultBirthDate = remember {
        SimpleDateFormat("dd MMMM yyyy", localeID).parse("14 Juli 2005")?.time
    }

    var nama by remember { mutableStateOf(initialNama) }
    var alamat by remember { mutableStateOf(initialAlamat) }
    var gender by remember { mutableStateOf(initialGender) }
    var pendidikan by remember { mutableStateOf(initialPendidikan) }
    var birthDate by remember { mutableStateOf<Long?>(defaultBirthDate) }

    val hasChanges = nama != initialNama ||
            alamat != initialAlamat ||
            gender != initialGender ||
            pendidikan != initialPendidikan ||
            birthDate != defaultBirthDate
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BlurredGradientBackground(
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Biodata",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Medium
                    )
                )

                if (hasChanges) {
                    Row {
                        IconButton(onClick = {
                            Log.d("Biodata", "Data disimpan!")
                        }) {
                            Icon(Icons.Default.Check, contentDescription = "Simpan")
                        }
                        IconButton(onClick = {
                            nama = initialNama
                            alamat = initialAlamat
                            gender = initialGender
                            pendidikan = initialPendidikan
                            birthDate = defaultBirthDate
                        }) {
                            Icon(Icons.Default.Close, contentDescription = "Batal")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Profile()
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth()
            )

            DatePickerFieldToModal(
                label = "Tanggal Lahir",
                value = birthDate,
                onValueChange = { birthDate = it },
                defaultValue = null,
                modifier = Modifier.padding(top = 16.dp)
            )

            RadioGroupField(
                options = listOf("Laki-laki", "Perempuan"),
                selectedOption = gender,
                onOptionSelected = { gender = it },
                label = "Jenis Kelamin",
                modifier = Modifier.padding(vertical = 16.dp)
            )

            DropdownMenuField(
                label = "Pendidikan",
                options = listOf("SD", "SMP", "SMA", "D3", "S1", "S2", "S3"),
                defaultValue = pendidikan,
                onSelected = { pendidikan = it }
            )
        }
    }

}


