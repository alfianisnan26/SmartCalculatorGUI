import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;

//  Menu merupakan kelas yang inheritance atau beranak dari JFrame yang disediakan javax.swing
public class Submenu extends JFrame{

    //  Mendefinisikan array formulir untuk input variabel dengan parameter private
    //  Agar hanya dapat dibaca pada kelas ini (Submenu)
    private JTextField[] tfs;

    //  Mendefinisikan interface pembuat rumus, untuk menghitungnya kita cukup memanggil
    //  Method hitung dengan input array v sejumlah variabel inputnya.
    public static interface Rumus{
        double hitung(double[] v);
    }

    //  Mendefinisikan constructor dari Submeny dengan input nama fungsi, v untuk variabel
    //  input yang dibutuhkan, dan rumus yang akan digunakan.
    public Submenu(String name, String[] v, Rumus rumus){

        //  Mendefinisikan array sejumlah panjang variabel input yang dibutuhkan.
        tfs = new JTextField[v.length];

        //  Melakukan looping untuk membentuk objek dari setiap variabel input
        //  Meliputi label dari nama variabel dan formulisnya.
        for (int i = 0; i < v.length; i++) {

            //  Menambahkan label pada JFrame Submenu dengan nama variable i
            add(new JLabel(v[i]));

            //  Mendefinisikan JTextField untuk menyimpan nilai variabel
            tfs[i] = new JTextField();

            //  Menambahkan objek formulir JTextField kedalam JFrame dari Submenu
            add(tfs[i]);
        }

        //  Mendefinisikan tombol hasil
        JButton hasil = new JButton("Hasil");

        //  Mendefinisikan formulir hasil
        JTextField hasiltf = new JTextField();

        //  Konfigurasi formulir hasil agar isinya tidak dapat di ganti (di edit)
        hasiltf.setEditable(false);

        //  Memberikan perilaku pada tombol hasil saat pengguna menekan tombol hasil
        hasil.addActionListener((o)->{

            //  Memberikan try-catch untuk mendeteksi error
            try{

                //  Mendefinisikan array untuk menyimpan nilai sementara dari variabel
                double[] variables = new double[v.length];

                //  Memindahkan seluruh variabel yang ditulis pada formulir kedalam 
                //  Array variables berjenis double dan dilakukan penerjemahan dari
                //  String mendaji double menggunakan method parseDouble.
                for (int i = 0; i < v.length; i++) variables[i] = Double.parseDouble(tfs[i].getText());

                //  Menghitung hasil dengan memanggil fungsi hitung dari rumus dengan input
                //  array double[] bernama variable, kemudian hasilnya diubah kedalam string
                //  dan ditampilkan pada hasiltf (formulir hasil)
                hasiltf.setText(String.valueOf(rumus.hitung(variables)));
            } catch (Exception e){

                //  Jika terdapat error terdeteksi, maka program akan menampilkan dialog error
                JOptionPane.showMessageDialog(this, "Kesalahan!\nMohon input nilai yang valid");
            }
        });

        //  Menambahkan objek tombol hasil pada JFrame Submenu
        add(hasil);

        //  Menambahkan objek formulir hasil pada JFrame Submenu
        add(hasiltf);

        //  Setting tata letak JFrame agar memiliki dua kolom dan baris bebas
        //  yaitu kolom kiri untuk nama variabel dan tombol Hasil
        //  dan kolom kanan untuk formulir variabel dan formulir hasil.
        setLayout(new GridLayout(0, 2));

        //  Method untuk setting JFrame dari Submenu
        //  Menamai Submenu, (tidak ditampilkan)
        setName(name);

        //  Memberikan judul pada JFrame Submenu
        setTitle("Menghitung Luas " + name);

        //  Menentukan ukuran dari JFrame sbumenu dengan tinggi yang panjanya
        //  Sepanjang variabel input yang diperlukan.
        setSize(500, (v.length * 40) + 70);

        //  Melakukan konfigurasi agar Submenu tampil pertama kali di tengah layar
        setLocationRelativeTo(null);

        //  Mendefinisikan agar menu disembunyikan saat pengguna menekan tombol exit
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}
