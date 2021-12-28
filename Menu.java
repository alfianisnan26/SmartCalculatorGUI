import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

//  Menu merupakan kelas yang inheritance atau beranak dari JFrame yang disediakan javax.swing
public class Menu extends JFrame{
    //  Constructor untuk tampilan menu
    //  menuList sebagai input apa saja menu-menu yang disediakan (rumus)
    public Menu(Submenu[] menuList){

        //  Pendefinisian panel untuk mengelompokkan tombol submenu nya
        JPanel panel = new JPanel();
        
        //  Menambahkan label pada tammpilan menu dengan posisi teks nya berada di tengah
        add(new JLabel("Pilihlah Rumus Yang Akan di Gunakan!", SwingConstants.CENTER));

        //  For Loop untuk menambahkan tombol sesuai jmlah menu yang tersedia pada menuList
        for (Submenu menu : menuList) {

            //  Mendefinisikan tombol dengan diberi nama dari menu (rumus) yang tersedia
            JButton btn = new JButton(menu.getName());

            //  Menambahkan perilaku tombol ketika ditekan yaitu akan
            //  Menampilkan submenu jika tidak tampil, atau menyembunyikan submenu
            //  jika telah tampil.
            btn.addActionListener((o)->menu.setVisible(!menu.isVisible()));

            //  Menambahkan objek tombol kedalam kelompok panel agar sebaris dengan tombol lain.
            panel.add(btn);
        }
        
        //  Mengatur tata letak panel agar dapat menampilkan hanya satu baris untuk seluruh tombol.
        panel.setLayout(new GridLayout(1, 0));

        //  Menambahkan panel pada JFrame Menu
        add(panel);

        //  Mengatur tata letak JFrame menu agar menampilkan satu kolom yaitu Label dan kelompok
        //  tombol pada panel.
        setLayout(new GridLayout(0, 1));

        //  Method untuk setting JFrame Menu
        //  Menamai JFrame Menu
        setTitle("Smart Geometric Calculator");

        //  Menentukan ukuran frame agar sepanjang menu yang tersedia
        setSize(menuList.length * 150, 100);

        //  Menampilkan tampilan menu ini saat program di jalankan
        setVisible(true);

        //  Memposisikan tampilan menu ini agar ditengah layar
        setLocationRelativeTo(null);

        //  Mendefinisikan untuk keluar dari program saat pengguna menekan tombol exit.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
