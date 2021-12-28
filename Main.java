class Main {
    //  Mendefinisikan menu dengan submenu untuk rumus-rumus yang tersedia
    //  Dengan cara membentuk objek dengan memanggil konstruktor Submenu
    //  yaitu Submenu(nama_rumus, variabel_rumus, rumusnya)
    public static Submenu[] menuList = new Submenu[]{
        new Submenu("Kubus", new String[]{"Sisi"},
            v -> Math.pow(v[0], 2) * 6
        ),
        new Submenu("Balok", new String[]{"Panjang", "Lebar", "Tinggi"},
            v -> ((v[0] * v[1]) + (v[0] * v[2]) + (v[1] + v[2])) * 2
        ),
        new Submenu("Bola", new String[]{"Jari-jari"},
            v -> 4 * Math.PI * Math.pow(v[0], 2)
        ),
        new Submenu("Silinder", new String[]{"Jari-jari", "Tinggi"},
            v -> 2 * Math.PI * v[0] * (v[0] + v[1])
        ),
    };
    
    //  Fungsi utama aplikasi ini melalui method main
    public static void main(String[] args) {

        //  Membentuk objek menu dengan memanggil konstraktor Menu
        //  dan kemudian mengirimkan menu-menu (rumus) yang akan ditampilkan
        new Menu(menuList);
    }
}