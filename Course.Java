public class Course {
    // Atribut dibuat PRIVATE untuk mengaktifkan ENKAPSULASI
    private String courseName;
    private int credit;
    private String instructorName;

    // Constructor
    public Course(String name, int credits, String instructor) {
        this.courseName = name;
        this.instructorName = instructor;
        // Menggunakan setter agar validasi diterapkan bahkan saat inisialisasi
        setCredit(credits);
    }

    // --- Getter (Untuk Akses Baca) ---
    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    // --- Setter (Untuk Akses Tulis) dengan Validasi Data ---

    /**
     * Setter untuk credit. Menerapkan validasi: SKS harus >= 0.
     * Ini menunjukkan PENTINGNYA ENKAPSULASI: mengontrol integritas data.
     */
    public void setCredit(int credit) {
        if (credit >= 0) {
            this.credit = credit;
        } else {
            // Memberi pesan ERROR dan menolak perubahan jika data tidak valid
            System.err.println("❌ Gagal Mengubah! Nilai SKS (Credit) tidak boleh negatif. Data Ditolak.");
            // Nilai credit lama (existing) dipertahankan
        }
    }

    // --- Metode displayInfo() ---
    public void displayInfo() {
        System.out.println("------------------------------------------");
        System.out.println("Nama Mata Kuliah  : " + courseName);
        System.out.println("Jumlah SKS        : " + credit);
        System.out.println("Nama Instruktur   : " + instructorName);
    }

    // --- Metode main() untuk Demonstrasi dan Penjelasan ---
    public static void main(String[] args) {

        System.out.println("### PENTINGNYA ENKAPSULASI (Validation) ###");

        // 1. Membuat Objek dengan nilai awal yang valid
        Course validCourse = new Course("Dasar Pemrograman", 3, "Ibu Rina");
        System.out.println("\n[Kasus 1: Nilai Awal Valid]");
        validCourse.displayInfo();

        // 2. Mencoba mengubah atribut menggunakan Setter dengan nilai yang TIDAK VALID (-5)
        System.out.println("\n[Kasus 2: Mencoba mengubah SKS menjadi -5]");
        validCourse.setCredit(-5); // ENKAPSULASI: Validasi menolak nilai negatif

        System.out.println("\n**Hasil Setelah Percobaan Perubahan:**");
        validCourse.displayInfo();

        // Penjelasan mengapa SKS tetap 3:
        System.out.println("\n=> Penjelasan Enkapsulasi:");
        System.out.println("   Fungsi Enkapsulasi: Karena atribut 'credit' bersifat private,");
        System.out.println("   satu-satunya cara mengubahnya adalah melalui method public 'setCredit()'.");
        System.out.println("   Method ini memiliki VALIDASI (if/else) yang memastikan data (SKS) tidak");
        System.out.println("   melanggar aturan bisnis (yaitu SKS >= 0). Hal ini menjaga INTEGRITAS DATA.");

        // 3. Mencoba mengubah atribut dengan nilai yang VALID (4)
        System.out.println("\n[Kasus 3: Mencoba mengubah SKS menjadi 4]");
        validCourse.setCredit(4); // Perubahan diterima
        validCourse.displayInfo();
        System.out.println("------------------------------------------");
    }
}
