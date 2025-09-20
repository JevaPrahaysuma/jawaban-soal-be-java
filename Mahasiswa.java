// jawaban soal nomer 3
class Mahasiswa {
    private String nama;
    private String nim;
    private double nilai;

    public void setData(String nama, String nim, double nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    public void printStatus() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Nilai: " + nilai);
        if (nilai > 70) {
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Tidak Lulus");
        }
    }
}

public class MainMahasiswa {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        mhs.setData("Sisi", "123456", 75);
        mhs.printStatus();
    }
}
