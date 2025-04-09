# 📦 ProjectPLBK_Kelompok4

**Nama Anggota :**
1. ###Cut Sula Fhatia Rahma (2208107010048)
2. ###Muhammad Alvin (2208107010089)

## 🧾 Lost and Found System

**Lost and Found System** adalah aplikasi berbasis Java yang memungkinkan pengguna melaporkan barang hilang atau ditemukan, serta mengelola klaim dengan sistem verifikasi kode. Antarmuka dibuat menggunakan Java Swing agar mudah digunakan.

---

## ✨ Fitur

- **Menambahkan Barang**  
  Pengguna dapat menambahkan laporan barang hilang atau ditemukan ke dalam sistem.

- **Melihat Daftar Barang**  
  Sistem menampilkan daftar barang yang dilaporkan dalam bentuk tabel.

- **Mengubah Status Barang**  
  Status barang dapat diubah menjadi *"Sudah dikembalikan"* dengan validasi kode verifikasi.

- **Verifikasi Kode**  
  Sistem meminta kode verifikasi saat pengguna mencoba mengubah status barang.

- **Antarmuka GUI**  
  Tampilan grafis interaktif menggunakan komponen dari `javax.swing`.

---

## 🗂️ Struktur Proyek

```
LostAndFound/
├── bin/ # File hasil kompilasi (.class)
├── lib/ # Pustaka eksternal (jika ada)
├── src/ # Berisi source code Java 
    ├── img/ # Gambar/icon yang digunakan dalam antarmuka 
    ├── Barang.java 
    ├── FormPanel.java 
    ├── TablePanel.java
    ├── LostAndFoundGUI.java
    └── Main.java
└── README.md # Dokumentasi proyek
```
---

## ▶️ Cara Menjalankan

1. **Kompilasi semua file Java**:

```
cd src
javac /*.java
```
2. **Jalankan program:**

```
java LostAndFoundGUI
```
---

## 📋 Contoh Penggunaan

Saat pengguna membuka aplikasi, mereka akan diminta mengisi formulir:
```
Nama Barang     : Dompet Coklat
Deskripsi       : Dompet warna coklat merek charles and keith berukuran sedang
Lokasi          : Perpustakaan USK
Kontak          : 08123456789
Kategori        : Barang Hilang
Status          : Belum diklaim
Kode Verifikasi : rahasia123

```
Untuk mengubah status barang:
```
Masukkan kode verifikasi: rahasia123
Status berhasil diubah menjadi "Sudah Diklaim" dan "Sudah Dikembalikan".

```
---

## 🤝 Kontribusi

Jika ingin berkontribusi dalam proyek ini:
1. Fork repository ini.
2. Buat branch baru:
```git checkout -b fitur-baru```
3. Commit perubahan:
```git commit -m "Menambahkan fitur filter lokasi"```
4. Push ke branch:
```git push origin fitur-baru```
5. Buat Pull Request.
