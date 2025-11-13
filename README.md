# Viora — Personal Weather & Info App

Viora adalah aplikasi mobile berbasis **Jetpack Compose** yang menggabungkan informasi cuaca, biodata pengguna, kalkulator sederhana, kontak, dan berita terkini dalam satu aplikasi yang elegan dengan tema ungu futuristik.

Aplikasi ini dikembangkan sebagai bagian dari proyek pengembangan aplikasi mobile dengan fokus pada desain UI/UX modern dan pemanfaatan data statis berbasis Compose.

---

## 🪄 Fitur Utama

| Fitur | Deskripsi |
|-------|------------|
| 🕒 **Splash Screen** | Tampilan pembuka selama 5 detik berisi **judul aplikasi**, **foto pengguna**, **NIM**, dan **nama lengkap** dengan gradasi ungu lembut. |
| 🏠 **Dashboard (Navigation)** | Halaman utama setelah Splash Screen dengan **Bottom Navigation Bar** yang berisi menu: *Biodata, Kontak, Kalkulator, Cuaca, dan Berita*. Tiap menu tampil menggunakan konsep **Fragment/Composable Screen**. |
| 👤 **Biodata Page** | Menampilkan informasi pribadi seperti **nama, email, deskripsi singkat**, serta input interaktif berupa **dropdown**, **radio button**, **text field**, dan **calendar**. Disertai foto profil dan desain menarik. |
| 📞 **Kontak Page** | Menampilkan **daftar 15 kontak statis** dengan **foto berbentuk lingkaran** dan **nama kontak**. Tersedia tampilan modern dan rapi seperti layout daftar kontak pada umumnya. |
| 🧮 **Kalkulator Page** | Kalkulator sederhana yang mendukung operasi **tambah, kurang, kali, bagi, kuadrat, akar kuadrat**, serta tombol **hapus (C)**. Desainnya minimalis dan mudah digunakan. |
| 🌦️ **Cuaca Page** | Halaman statis yang menampilkan **informasi suhu, kelembapan, dan kondisi cuaca** disertai **gambar animasi cuaca menarik**. |
| 📰 **Berita Page** | Daftar berita statis dengan **gambar thumbnail**, **judul**, dan **ringkasan singkat**. Tampilan dibuat dalam bentuk **list card** berulang seperti layout berita profesional. |

---

## 📱 Tampilan Aplikasi (Screenshots)

| Halaman | Screenshot |
|----------|-------------|
| **Splash Screen** | <img src="screenshots/splash.png" height="400"/> |
| **Biodata Page** | <img src="screenshots/biodata.png" height="400"/> |
| **Kalkulator Page** | <img src="screenshots/kalkulator.png" height="400"/> |
| **Cuaca Page** | <img src="screenshots/cuaca.png" height="400"/> |
| **Kontak Page** | <img src="screenshots/kontak.png" height="400"/> |
| **Berita Page** | <img src="screenshots/berita.png" height="400"/> |

> 💡 *Semua screenshot dapat ditemukan di folder `screenshots/` pada repository ini.*

---

## 🧩 Teknologi yang Digunakan

- **Kotlin**
- **Jetpack Compose**
- **Material 3 Design**
- **Navigation Compose**
- **LazyColumn & LazyRow** untuk list berita dan ramalan cuaca
- **State Management** menggunakan `remember` dan `mutableStateOf`

---

## 🧭 Navigasi Aplikasi

Aplikasi menggunakan **Bottom Navigation Bar** untuk berpindah antar halaman utama:
- `Biodata`
- `Kalkulator`
- `Cuaca`
- `Kontak`
- `Berita`

---

## 🧑‍💻 Pengembang
**Nama:** Dindin Imanudin

**NIM:** 152023073

**Prodi:** Informatika 

**Kampus:** Institut Teknologi Nasional Bandung



