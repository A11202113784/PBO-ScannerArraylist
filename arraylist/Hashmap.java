package arraylist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Hashmap {

    public static void main(String[] args) {

        // Membuat objek HashMap untuk menyimpan data mahasiswa
        HashMap<String, ArrayList<String>> mahasiswa = new HashMap<String, ArrayList<String>>();

        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Loop utama untuk meminta input dari pengguna
        while (!input.equals("exit")) {
            System.out.print("Masukkan perintah (tambah/lihat/exit): ");
            input = scanner.nextLine();

            // Memproses input pengguna
            if (input.equals("tambah")) {
                System.out.print("Masukkan Nama Mahasiswa = ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM Mahasiswa  = ");
                String nim = scanner.nextLine();
                System.out.print("Masukan Nilai Mahasiswa = ");
                double nilai = scanner.nextDouble();
                scanner.nextLine();

 
                // Mengecek apakah nama sudah ada dalam HashMap
                if (mahasiswa.containsKey(nama)) {
                    // Jika nama sudah ada, tambahkan nim dan nilai ke ArrayList yang sudah ada
                    ArrayList<String> nims = mahasiswa.get(nama);
                    nims.add(nim + " (" + nilai + ")");
                    mahasiswa.put(nama, nims);
                } else {
                    // Jika nama belum ada, buat ArrayList baru dan tambahkan nim dan nilai ke dalamnya
                    ArrayList<String> nims = new ArrayList<String>();
                    nims.add(nim + ", Nilai = " + nilai);
                    mahasiswa.put(nama, nims);
                }
            } else if (input.equals("lihat")) {
                // Menampilkan data mahasiswa yang sudah disimpan
                for (String nama : mahasiswa.keySet()) {
                    ArrayList<String> nims = mahasiswa.get(nama);
                    System.out.print("Nama = " + nama + ", NIM = ");
                    for (String nim : nims) {
                        System.out.print(nim + " ");
                    }
                    System.out.println();
                }
            } else if (!input.equals("exit")) {
                System.out.println("Perintah tidak dikenali.");
            }
        }
        scanner.close();
    }
}