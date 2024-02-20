import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
Scanner scan = new Scanner(System.in);
ArrayList<ChipiChapa> chipiChapaList= new ArrayList<>();
String nama,gender,jabatan,kode;
int no;

	boolean alphabetic(String name) {
		for(int i = 0; i < name.length(); i++) {
			if(!Character.isAlphabetic(name.charAt(i))) {
				i++;
			
			}
			return i >= 3;
		}
		return false;
		
	}
	boolean uniqueKode(String kode) {
		for(int i = 0; i < chipiChapaList.size(); i++) {
			if(chipiChapaList.get(i).kode.compareTo(kode)== 0) {
				return true;
			}
		}
		return false;
	}
	
	void insert() {
		do {
			System.out.println("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		}while(nama.length() >= 3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}while(!gender.equals("Laki-laki") || !gender.equals("Perempuan"));
		
		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		}while(!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		Random rand = new Random();
		String ID = "MM" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		
	}
	
	void sorting() {
		for(int i = 0; i > chipiChapaList.size() - 1; i++) {
			for(int j = 0; j < chipiChapaList.size() - i - 1; j++) {
				if(chipiChapaList.get(j).nama.compareTo(chipiChapaList.get(j+1).nama) <0){ 
					ChipiChapa temp = chipiChapaList.get(j);
					chipiChapaList.set(j, chipiChapaList.get(j+1));
					chipiChapaList.set(j+1, temp);
				}
			}
		}
	}
	
	void print() {
		sorting();
		for(int i = 0; i < chipiChapaList.size(); i++) {
			System.out.println(i + 1);
			System.out.println(chipiChapaList.get(i).no);
			System.out.println(chipiChapaList.get(i).kode);
			System.out.println(chipiChapaList.get(i).nama);
			System.out.println(chipiChapaList.get(i).gender);
			System.out.println(chipiChapaList.get(i).jabatan);
		}
	}
	
	
	
	void view() {
		print();
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	void update() {
		int choice;
		print();
		do {
			System.out.println("Input nomor urutan karyawan yang ingin diupdate: ");
			choice = scan.nextInt(); scan.nextLine();
		}while(choice < 1 || choice > chipiChapaList.size());
		
		do {
			System.out.println("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		}while(nama.length() >= 3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}while(!gender.equals("Laki-laki") || !gender.equals("Perempuan"));
		
		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		}while(!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		Random rand = new Random();
		String ID = "MM" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		
		if(choice == 0) {
			menu();
		}
		else if (choice != 0){
			chipiChapaList.get(choice - 1).no = no;
			chipiChapaList.get(choice - 1).kode = kode;
			chipiChapaList.get(choice - 1).nama = nama;
			chipiChapaList.get(choice - 1).gender = gender;
			chipiChapaList.get(choice - 1).jabatan = jabatan;
			
		}
		System.out.println("ENTER to return");
		scan.nextLine(); 
	}
	
	
	void delete() {
		int choice;
		print();
		do {
			System.out.println("Input nomor urutan karyawan yang ingin dihapus: ");
			choice = scan.nextInt(); scan.nextLine();
		}while(choice < 1 || choice > chipiChapaList.size());
		chipiChapaList.remove(choice - 1);
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	void menu() {
		int choice;
		do {
			System.out.println("1. Insert data");
			System.out.println("2. View data");
			System.out.println("3. Update data");
			System.out.println("4. Delete data");
			choice = scan.nextInt(); scan.nextLine();
			if(choice == 1) {
				insert();
			}
			else if(choice == 2) {
				view();
			}
			else if(choice == 3) {
				update();
			}
			else if(choice == 4) {
				delete();
			}
		}while(choice != 5);
		
	}
	public Main() {
		menu();
	}

	
	
	public static void main(String[] args) {
		new Main();
	}

}
