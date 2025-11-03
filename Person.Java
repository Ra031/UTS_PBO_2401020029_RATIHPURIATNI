// 1. Superclass: Person (Kelas Induk)
class Person {
    protected String name;
    protected String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Method yang akan di-override
    public void introduce() {
        System.out.println("Halo, saya " + name + " (ID: " + id + "). Saya adalah seorang Umum.");
    }
}

// 2. Subclass: Student (Kelas Anak)
class Student extends Person {
    private String major;

    public Student(String name, String id, String major) {
        // Memanggil constructor superclass
        super(name, id);
        this.major = major;
    }

    // Override Method: Mengimplementasikan Polimorfisme
    @Override
    public void introduce() {
        System.out.println("👋 Saya " + name + " (" + id + "), seorang Mahasiswa jurusan " + major + ".");
    }
}

// 3. Subclass: Lecturer (Kelas Anak)
class Lecturer extends Person {
    private String field;

    public Lecturer(String name, String id, String field) {
        // Memanggil constructor superclass
        super(name, id);
        this.field = field;
    }

    // Override Method: Mengimplementasikan Polimorfisme
    @Override
    public void introduce() {
        System.out.println("👨‍🏫 Saya " + name + " (" + id + "), seorang Dosen di bidang " + field + ".");
    }
}

// Main Class untuk Demonstrasi Polimorfisme
public class PolymorphismDemo {
    public static void main(String[] args) {

        System.out.println("=== Demonstrasi Polimorfisme (Java) ===");

        // 1. Membuat Objek dari berbagai Subclass
        Student studentA = new Student("Anisa Dewi", "11020", "Teknik Informatika");
        Lecturer lecturerA = new Lecturer("Dr. Hari", "4001", "Rekayasa Perangkat Lunak");
        Student studentB = new Student("Bagus Saputra", "11021", "Sistem Informasi");

        // 2. Deklarasi Array menggunakan tipe data Superclass (Person[])
        // Array ini dapat menampung objek dari kelas Person, Student, atau Lecturer
        Person[] campusMembers = new Person[3];
        campusMembers[0] = studentA;    // Objek Student dimasukkan ke array Person
        campusMembers[1] = lecturerA;   // Objek Lecturer dimasukkan ke array Person
        campusMembers[2] = studentB;

        System.out.println("\n--- Iterasi Array Person[] ---");

        // 3. Demonstrasi Polimorfisme: Memanggil method introduce()
        // Meskipun array bertipe Person, Java akan menjalankan method introduce()
        // yang benar (versi Student atau Lecturer) saat runtime. Ini disebut Dynamic Method Dispatch.
        for (Person member : campusMembers) {
            member.introduce();
        }

        System.out.println("\n=======================================");
        System.out.println("Kesimpulan: Kode di atas menunjukkan Polimorfisme karena");
        System.out.println("satu panggilan method (member.introduce()) menghasilkan");
        System.out.println("perilaku yang berbeda-beda tergantung pada tipe objek sesungguhnya.");
    }
}
