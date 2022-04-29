import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class project {

	private static String[] stack = new String[5];
	private static int counters = 0;

	private static boolean penyimpanan() {
		if(counters < stack.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void masukkan() {
		do{
			int alpha = 0;
			String str = String.valueOf(alpha);
			System.out.print("Masukkan nama : ");
			Scanner input = new Scanner(System.in);
			str = input.nextLine();
			stack[counters] = str;
			counters++;
		}while(counters < stack.length);
		
	}
	
	private static void hapus() {
		counters--; 
		System.out.println("Data berhasil dikeluarkan");
	}
	
	private static void displayDataStack() {
		System.out.print("Data : ");
		for(int i = 0; i < counters; i++) {
			System.out.print(" | " + stack[i] + " | ");
		}
		System.out.println("");
	}
	
	private static void cleanStack() {
		counters = 0;
	}

	private static void urutanStack(){
		System.out.println("Sebelum diurutkan");
		System.out.println(Arrays.toString(stack));

		Arrays.sort(stack);
		System.out.println();

		System.out.println("Sesudah diurutkan");
		System.out.println(Arrays.toString(stack));
	}
	
	private static void menuChooser(int pilih) {
		switch(pilih) {
			case 1:
				boolean check = penyimpanan();
				if(check) {
					masukkan();
				}
				else {
					System.out.println("Stack Penuh!, kosongkan satu data terlebih dahulu!");
				}
				break;
			case 2:
				hapus();
				break;
			case 3:
				System.out.println("Kapasitas: " + stack.length);
				System.out.println("Terisi   : " + counters);
				break;
			case 4:
				displayDataStack();
				break;
			case 5:
				cleanStack();
				break;
			case 6:
				urutanStack();
				break;
			case 7:
				System.exit(6);
				break;
		}
		menu();
	}
	
	private static void menu() {
		int loop = 0;
		int pilih = 0;
		while(loop == 0) {
			System.out.println("\nMembuat Presensi Mahasiswa otomatis");
			System.out.println("Menu: ");
			System.out.println("1. Tambah Nama Mahasiswa");
			System.out.println("2. Hapus Nama Mahasiswa");
			System.out.println("3. Jumlah Mahasiswa");
			System.out.println("4. Tampilkan Semua Nama mahasiswa");
			System.out.println("5. Bersihkan Data");
			System.out.println("6. Urutkan sesuai abjad");
			System.out.println("7. Keluar");

			System.out.print("Pilih menu : ");
			Scanner menuOption = new Scanner(System.in);
			try {
				pilih = menuOption.nextInt();
				loop = 1;
			}catch(InputMismatchException e) {
				System.out.println("Masukan harus Angka!");
			}
		}
		menuChooser(pilih);
	}

	public static void main(String[] args) {
		menu();
	}
	
}