package soal2;
public class Anjing extends HewanPeliharaan{
    private String warnaBulu;
    private String [] kemampuan;
    public Anjing(String r, String n, String warnaBulu, String[] kemampuan) {
        super(r, n);
        this.warnaBulu = warnaBulu;
        this.kemampuan = kemampuan;
    }
    public void displayDetailAnjing(){
        super.display();
        System.out.println("Memiliki warna bulu : "+warnaBulu);
        System.out.print("Memiliki kemampuan : ");
        for (int i = 0; i < kemampuan.length; i++) {
            System.out.print(kemampuan[i]);
            if (i < kemampuan.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
  }
}