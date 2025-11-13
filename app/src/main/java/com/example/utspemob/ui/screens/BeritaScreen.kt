package com.example.utspemob.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class Berita(
    val judul: String,
    val imageUrl: String,
    val deskripsi: String,
    val timestamp: String
)

@Preview(showBackground = true)
@Composable
fun BeritaScreen() {
    val beritaList = listOf(
        Berita(
            "Petani Urban Gunakan IoT Tingkatkan Hasil Panen",
            "https://images.unsplash.com/photo-1507608616759-54f48f0af0ee?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=687",
            "Petani urban mulai menggunakan teknologi IoT untuk memantau kelembapan tanah dan suhu agar panen lebih efisien.",
            "13 Nov 2025, 08:30"
        ),
        Berita(
            "Program Baru Dukung Pengelolaan Sampah Komunitas",
            "https://images.unsplash.com/photo-1429087969512-1e85aab2683d?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=687",
            "Pemerintah meluncurkan program edukatif untuk mendorong warga berpartisipasi aktif dalam daur ulang dan pengelolaan sampah.",
            "13 Nov 2025, 07:15"
        ),
        Berita(
            "Startup Lokal Ciptakan Aplikasi Pemantau Kualitas Udara",
            "https://images.unsplash.com/photo-1481349518771-20055b2a7b24?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=1239",
            "Aplikasi ini memungkinkan pengguna melihat data kualitas udara real-time serta lokasi dengan polusi terendah di sekitar mereka.",
            "12 Nov 2025, 22:00"
        ),
        Berita(
            "Gerakan Bersih Kota Galakkan Gotong Royong Lingkungan",
            "https://images.unsplash.com/photo-1455849318743-b2233052fcff?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=1169",
            "Warga kota besar mulai kembali aktif dalam kegiatan gotong royong untuk menjaga kebersihan lingkungan tempat tinggal.",
            "12 Nov 2025, 18:40"
        ),
        Berita(
            "Mahasiswa Kembangkan Robot Pemilah Sampah Otomatis",
            "https://images.unsplash.com/photo-1509114397022-ed747cca3f65?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=735",
            "Robot cerdas ini mampu memisahkan sampah organik dan anorganik menggunakan sensor warna dan deteksi material.",
            "11 Nov 2025, 21:20"
        ),
        Berita(
            "Kampung Hijau Ciptakan Sistem Air Limbah Daur Ulang",
            "https://images.unsplash.com/photo-1485550409059-9afb054cada4?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=765",
            "Warga memanfaatkan teknologi filtrasi sederhana untuk mengubah air limbah rumah tangga menjadi air layak pakai.",
            "11 Nov 2025, 16:45"
        ),
        Berita(
            "Sekolah Adakan Edukasi Daur Ulang untuk Siswa",
            "https://plus.unsplash.com/premium_photo-1670590785994-ab5e8a2ccd61?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=764",
            "Program edukasi ini mengajarkan anak-anak pentingnya memilah sampah dan memanfaatkan barang bekas.",
            "10 Nov 2025, 10:10"
        ),
        Berita(
            "Inovasi Energi Terbarukan dari Sampah Organik",
            "https://images.unsplash.com/photo-1593642532973-d31b6557fa68?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=687",
            "Peneliti menemukan cara baru mengubah sampah dapur menjadi biogas yang dapat digunakan untuk memasak.",
            "10 Nov 2025, 08:00"
        ),
        Berita(
            "Aplikasi ‘BinMap’ Bantu Pemetaan Kebersihan Kota",
            "https://images.unsplash.com/photo-1556761175-5973dc0f32e7?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=687",
            "Aplikasi ini memungkinkan warga melaporkan kondisi tempat sampah dan lokasi kotor untuk dinilai kebersihannya oleh AI.",
            "9 Nov 2025, 14:50"
        ),
        Berita(
            "Komunitas Daur Ulang Fashion Bekas Semakin Populer",
            "https://images.unsplash.com/photo-1605600659908-0ef719419d41?q=80&w=736&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            "Tren sustainable fashion mendorong masyarakat untuk memperpanjang umur pakaian melalui daur ulang kreatif.",
            "9 Nov 2025, 09:25"
        ),
        Berita(
            "Kafe Ramah Lingkungan Gunakan Sedotan Bambu dan Solar Panel",
            "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=687",
            "Kafe ini menerapkan konsep zero waste dengan peralatan ramah lingkungan dan sumber energi matahari.",
            "8 Nov 2025, 17:10"
        ),
        Berita(
            "Event EcoFair 2025 Angkat Tema Inovasi Hijau Digital",
            "https://images.unsplash.com/photo-1504384308090-c894fdcc538d?ixlib=rb-4.1.0&auto=format&fit=crop&q=80&w=700",
            "Pameran tahunan ini menampilkan berbagai inovasi teknologi yang mendukung keberlanjutan lingkungan.",
            "8 Nov 2025, 11:00"
        )
    )


    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(beritaList) { berita ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF7C4DFF).copy(alpha = 0.08f)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column {
                    AsyncImage(
                        model = berita.imageUrl,
                        contentDescription = berita.judul,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 50.dp, max = 200.dp)
                    )

                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = berita.judul,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = berita.deskripsi,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = berita.timestamp,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }
            }
        }
    }
}

