package TugasJobsheet10;

public class AntrianKRS {
    MahasiswaKRS[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahKRS;
    int maxDitanganiDPA;

    public AntrianKRS(int max) {
        this.max = max;
        this.maxDitanganiDPA = 30;
        this.data = new MahasiswaKRS[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.sudahKRS = 0;
    }

    // cek antrian kosong
    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    // cek antrian penuh
    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    // mengosongkan antrian
    public void kosongkanAntrian() {
        if (IsEmpty()) {
            System.out.println("Antrian sudah kosong.");
        } else {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan");
        }
    }

    // menambah antrian
    public void tambahAntrian(MahasiswaKRS mhs) {
        if (IsFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambah mahasiswa.");
            return;
        }
        if (sudahKRS >= maxDitanganiDPA) {
            System.out.println("DPA sudah menangani " + maxDitanganiDPA + " mahasiswa. Sesi selesai.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian KRS. No. antrian: " + size);
    }

    // memanggil antrian untuk proses KRS – setiap 1x panggilan terdiri dari 2 mahasiswa
    public void panggilAntrian() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong. Tidak ada mahasiswa untuk dipanggil.");
            return;
        }
        System.out.println("=== Memanggil antrian untuk proses KRS ===");
        int dipanggil = 0;

        // panggil 2 mahasiswa (antrian no 1 dan 2)
        while (dipanggil < 2 && !IsEmpty()) {
            MahasiswaKRS mhs = data[front];
            front = (front + 1) % max;
            size--;
            sudahKRS++;
            dipanggil++;
            System.out.print("Dipanggil [" + dipanggil + "]: ");
            mhs.tampilkanData();
        }

        if (dipanggil == 0) {
            System.out.println("Tidak ada mahasiswa yang dapat dipanggil.");
        } else {
            System.out.println("Total mahasiswa yang sudah proses KRS: " + sudahKRS);
        }
    }

    // menampilkan semua antrian
    public void tampilkanSemua() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Daftar Semua Antrian KRS ===");
        System.out.println("No | NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    // menampilkan 2 antrian terdepan
    public void tampilanDuaTerdepan() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== 2 Antrian Terdepan ===");
        int tampil = Math.min(2, size);
        for (int i = 0; i < tampil; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    // menampilkan antrian paling akhir
    public void lihatAkhir() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian paling belakang: ");
            data[rear].tampilkanData();
        }
    }

    // cetak jumlah antrian
    public void cetakJumlahAntrian() {
        System.out.println("Jumlah antrian saat ini: " + size);
    }

    // cetak jumlah yang sudah melakukan proses KRS
    public void cetakSudahKRS() {
        System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + sudahKRS);
    }

    // cetak jumlah mahasiswa yang belum melakukan proses KRS
    public void cetakBelumKRS() {
        int belumKRS = maxDitanganiDPA - sudahKRS;
        if (belumKRS < 0) {
            belumKRS = 0;
        }
        System.out.println("Jumlah mahasiswa yang belum proses KRS (sisa kota DPA): " + belumKRS);
    }
}