package com.praktikum.whitebox.util;

import com.praktikum.whitebox.model.Kategori;
import com.praktikum.whitebox.model.Produk;

public class ValidationUtils {

    // Validasi kode produk (3-10 karakter alfanumerik)
    public static boolean isValidKodeProduk(String kode) {
        if (kode == null) { // 🔹 Dipisah agar bisa diuji null
            return false;
        }
        String kodeBersih = kode.trim();
        if (kodeBersih.isEmpty()) { // 🔹 Tambahkan eksplisit branch empty
            return false;
        }
        return kodeBersih.matches("^[A-Za-z0-9]{3,10}$");
    }

    // Validasi nama (3-100 karakter, boleh huruf, angka, spasi)
    public static boolean isValidNama(String nama) {
        if (nama == null) { // 🔹 Dipisah null & empty
            return false;
        }
        String namaBersih = nama.trim();
        if (namaBersih.isEmpty()) { // 🔹 Tambah eksplisit empty
            return false;
        }
        return namaBersih.length() >= 3 && namaBersih.length() <= 100;
    }

    // Validasi harga (harus positif)
    public static boolean isValidHarga(double harga) {
        return harga > 0;
    }

    // Validasi stok (non-negatif)
    public static boolean isValidStok(int stok) {
        return stok >= 0;
    }

    // Validasi stok minimum (non-negatif)
    public static boolean isValidStokMinimum(int stokMinimum) {
        return stokMinimum >= 0;
    }

    // Validasi produk lengkap
    public static boolean isValidProduk(Produk produk) {
        if (produk == null) { // 🔹 Pastikan null bisa dites
            return false;
        }
        return isValidKodeProduk(produk.getKode()) &&
                isValidNama(produk.getNama()) &&
                isValidNama(produk.getKategori()) && // 🔹 kategori sebagai String nama
                isValidHarga(produk.getHarga()) &&
                isValidStok(produk.getStok()) &&
                isValidStokMinimum(produk.getStokMinimum());
    }

    // Validasi kategori
    public static boolean isValidKategori(Kategori kategori) {
        if (kategori == null) { // 🔹 Bisa dites null
            return false;
        }
        if (kategori.getDeskripsi() != null && kategori.getDeskripsi().length() > 500) { // 🔹 branch >500
            return false;
        }
        return isValidKodeProduk(kategori.getKode()) &&
                isValidNama(kategori.getNama());
    }

    // Validasi persentase (0-100)
    public static boolean isValidPersentase(double persentase) {
        return persentase >= 0 && persentase <= 100;
    }

    // Validasi kuantitas (positif)
    public static boolean isValidKuantitas(int kuantitas) {
        return kuantitas > 0;
    }
}