package com.example.utspemob.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val contentDescription: String
) {
    Biodata("biodata", Icons.Default.Person, "Biodata", "Biodata"),
    Kalkulator("kalkulator", Icons.Default.PlayArrow, "Kalkulator", "Kalkulator"),
    Cuaca("cuaca", Icons.Default.LocationOn, "Cuaca", "Cuaca"),
    Kontak("kontak", Icons.Default.Call, "Kontak", "Kontak"),
    Berita("berita", Icons.Default.MailOutline, "Berita", "Berita");

    companion object {
        val entries = listOf(Biodata, Kalkulator, Cuaca, Kontak, Berita)
    }
}