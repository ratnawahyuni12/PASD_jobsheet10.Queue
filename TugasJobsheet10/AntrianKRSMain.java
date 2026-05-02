package TugasJobsheet10;

import java.util.Scanner;

public class AntrianKRSMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);
        int pilihan;

        do {
            System.out.println("\n===- SISTEM ANTRIAN KRS - DPA -===");
            System.out.println("1. Daftar Antrian KRS");
            System.out.println("2. Panggil Antrian (2 Mahasiswa)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Tampilkan 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Paling Akhir");
            System.out.println("6. Cek Antrian Kosong");
            System.out.println("7. Cek Antrian Penuh");
            System.out.println("8. Kosongkan Antrian");
            System.out.println("9. Cetak Jumlah Antrian");
            System.out.println("10. Cetak Jumlah Sudah KRS");
            System.out.println("11. Cetak Jumlah Belum KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch(pilihan) {
                case 1:
                    System.out.println("=== Daftar Antrian KRS ===");
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    MahasiswaKRS mhs = new MahasiswaKRS(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    antrian.panggilAntrian();
                    break;
                case 3:
                    antrian.tampilkanSemua();
                    break;
                case 4:
                    antrian.tampilanDuaTerdepan();
                    break;
                case 5:
                    antrian.lihatAkhir();
                    break;
                case 6:
                    if (antrian.IsEmpty()) {
                        System.out.println("Antrian Kosong.");
                    } else {
                        System.out.println("Antrian Tidak Kosong. Jumlah: " + antrian.size);
                    }
                    break;
                case 7:
                    if (antrian.IsFull()) {
                        System.out.println("Antrian Penuh (Kapasitas " + antrian.max + ").");
                    } else {
                        System.out.println("Antrian Belum Penuh. Sisa kapasitas: " + (antrian.max - antrian.size));
                    } 
                    break;
                case 8:
                    antrian.kosongkanAntrian();
                    break;
                case 9:
                    antrian.cetakJumlahAntrian();
                    break;
                case 10:
                    antrian.cetakSudahKRS();
                    break;
                case 11:
                    antrian.cetakBelumKRS();
                    break;
                case 0:
                    System.out.println("Terima kasih. Program Selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}