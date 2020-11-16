// Baca Matriks dari File
// Baca Matriks dari input keyboard sesuai spek tiap problem
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.IOException;

public class Matriks{
	// Properti kelas matriks
	// Berisi Baris efektif, kolom efektif dan array 2 dimensi bertipe double
	private int BrsEff;
	private int KolEff;
	private double[][] Elmt;


	////////*KONSTRUKTOR*//////////
	// Konstruktor matriks dengan masukan elemen
	public Matriks(double[][] Elmt){
		BrsEff = Elmt.length;
		KolEff = Elmt[0].length;
		this.Elmt = new double[BrsEff][KolEff];
		for(int i=0;i<BrsEff;i++){
			for(int j=0;j<KolEff;j++){
				this.Elmt[i][j] = Elmt[i][j];
			}
		}
	}

	// Konstruktor Matriks dengan jumlah baris dan kolom
	public Matriks(int Brs, int Kol){
		this.BrsEff = Brs;
		this.KolEff = Kol;
		Elmt = new double[Brs][Kol];
	}


	//////////*INPUT/OUTPUT*//////////////
	// Print Matriks ke konsol dengan format sebagai berikut:
	// 1 2 3
	// 4 5 6
	// 7 8 9
	public void TulisIsi(){
		for(int i=0;i<BrsEff;i++){
			for(int j=0;j<KolEff;j++){
				System.out.printf("%.2f ", Elmt[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// Prosedur input elemen matriks satu per satu
	// Diawali dengan input jumlah kolom dan baris
	// Input kolom dan baris diasumsikan selalu valid baris>0 dan kolom>0
	public void BacaIsi(int masalah){
		// KAMUS LOKAL
		int metode;
		int nbBrs;
		int nbKol;

		Matriks tempM;

		Scanner sc = new Scanner(System.in);
		// ALGORITMA
		System.out.printf("Pilih metode pembacaan matriks \n1. Input Keyboard \n2. File \n");

		metode = sc.nextInt();

		if (metode == 1) {

			// Menerima Masukan dari keyboard untuk SPL
			if (masalah == 1) {

				System.out.printf("Panjang baris:");
				nbBrs = sc.nextInt();

				System.out.printf("Panjang kolom:");
				nbKol = sc.nextInt();

				tempM = new Matriks(nbBrs,nbKol);

				System.out.println("Matriks:");
				for (int i=0; i<nbBrs; i++) {
					for (int j=0; j<nbKol; j++) {
						tempM.Elmt[i][j] = sc.nextDouble();
					}
				}

<<<<<<< HEAD
				
=======
>>>>>>> 3fd955cf024845ce6a62834b1327d604a20de6d4
				this.Elmt = tempM.Elmt;
				this.BrsEff = tempM.BrsEff;
				this.KolEff = tempM.KolEff;
			}

			// Menerima Masukan untuk Interpolasi Linier dari Keyboard
			else if (masalah == 2) {
				String titik;
				Scanner scanner = new Scanner(System.in).useDelimiter("line.separator");
				Scanner s;

				System.out.printf("Input N: ");
				nbBrs = sc.nextInt();

				tempM = new Matriks(nbBrs,2);

				System.out.println("Titik:");
				for (int i=0; i<nbBrs+1; i++) {
					titik = scanner.nextLine();
					titik = titik.substring(1, titik.length()-1);

					s = new Scanner(titik).useDelimiter(", ");

					tempM.Elmt[i][0] = s.nextDouble();
					tempM.Elmt[i][1] = s.nextDouble();

					s.close();
				}

				scanner.close();
<<<<<<< HEAD
				
=======
>>>>>>> 3fd955cf024845ce6a62834b1327d604a20de6d4

				this.Elmt = tempM.Elmt;
				this.BrsEff = tempM.BrsEff;
				this.KolEff = tempM.KolEff;
			}

			//Menerima Masukan untuk Regresi Linier berganda
			else if (masalah == 3) {
				System.out.printf("Jumlah data: ");
				nbBrs = sc.nextInt();

				System.out.printf("Jumlah peubah: ");
				nbKol = sc.nextInt();

				tempM = new Matriks(nbBrs,nbKol+1);

				System.out.println("Matriks:");
				for (int i=0; i<nbBrs; i++) {
					for (int j=0; j<nbKol; j++) {
						tempM.Elmt[i][j] = sc.nextDouble();
					}
				}

				this.Elmt = tempM.Elmt;
				this.BrsEff = tempM.BrsEff;
				this.KolEff = tempM.KolEff;
				
			} 
			// Menerima Masukan input untuk persoalan matriks inverse dan determinan
			else{
				System.out.println("Ukuran Matriks: ");
				nbBrs = sc.nextInt();
				tempM = new Matriks(nbBrs, nbBrs);
				System.out.println("Elemen Matriks: ");

				for(int i=0; i<nbBrs; i++){
					for(int j=0; j<nbBrs; j++){
						tempM.Elmt[i][j] = sc.nextDouble();
					}
				}
				
				this.Elmt = tempM.Elmt;
				this.BrsEff = tempM.BrsEff;
				this.KolEff = tempM.KolEff;

			}
		}

		//Menerima masukan dari file eksternal
		else if (metode == 2) {
			int i = 0;
			int j = 0;
			double tempI;

			String b;
			String[] baris;

			System.out.printf("Masukkan alamat file: ");
			String alamat = sc.next();

			File file = new File(alamat);

			try {
				Scanner s = new Scanner(file);

				while (s.hasNextLine()) {
					b = s.nextLine();
					i = i + 1;
				}
				
				s.close();

				baris = new String[i];
				s = new Scanner(file);
				nbBrs = i;
				i = 0;

				while (s.hasNextLine()) {
					baris[i] = s.nextLine();
					i = i + 1;
				}
				s.close();

				s = new Scanner(baris[0]);

				while (s.hasNextDouble()) {
					tempI = s.nextDouble();
					j = j + 1;
				}
				s.close();
				nbKol = j;

				tempM = new Matriks(nbBrs,nbKol);

				for (i=0; i<nbBrs; i++) {
					sc = new Scanner(baris[i]);

					for (j=0; j<nbKol; j++) {
						tempM.Elmt[i][j] = sc.nextDouble();
					}

				sc.close();
				}
				
				this.Elmt = tempM.Elmt;
				this.BrsEff = tempM.BrsEff;
				this.KolEff = tempM.KolEff;
			} catch(FileNotFoundException e) {
				System.out.println("An error occured.");
				e.printStackTrace();
			}
		}
	}

	// Prosedur untuk mengeluarkan determinan pada layar atau pada file
	public static void writeDouble(double num){
		Scanner s = new Scanner(System.in);
		System.out.printf("1.Print Layar \n2.Print ke File \n");
		int kode = s.nextInt();

		switch(kode){
			case 1:
				System.out.printf("%.2f\n", num);
				break;
			case 2:
				System.out.println("Masukan nama File: ");
				String namaFile = s.next();

				try{
					PrintStream numWriter = new PrintStream(new File(namaFile));
					numWriter.printf("Hasil: %.2f", num);
				} catch(IOException e){
					System.out.println("An error occured.");
					e.printStackTrace();	
				}	
				s.close();
				break;
		}
	}

	// Prosedur untuk mengeluarkan matriks pada layar atau pada file
	public static void writeMatriks(Matriks A){
		Scanner s = new Scanner(System.in);
		System.out.printf("1. Print ke Layar \n2. Print ke File\n");
		int kode = s.nextInt();

		switch(kode){
			case 1:
				for(int i=0; i<A.BrsEff; i++){
					for(int j=0; j<A.KolEff; j++){
						System.out.printf("%.2f ", A.Elmt[i][j]);
					}
					System.out.println();
				}
				break;
			case 2:
				System.out.println("Masukan nama File: ");
				String namaFile = s.next();
				try{
					PrintStream matriksWriter = new PrintStream(new File(namaFile));
					matriksWriter.println("Matriks: \n");
					for(int i=0; i<A.BrsEff; i++){
						for(int j=0; j<A.KolEff; j++){
							matriksWriter.printf("%.2f ", A.Elmt[i][j]);
						}
						matriksWriter.println();
					}
				} catch(IOException e){
					System.out.println("An error occured.");
					e.printStackTrace();
				}
				break;
		}

		s.close();
	}


	// Prosedur untuk mengeluarkan hasil SPL pada layar atau pada file
	public static void writeSPL(double[] result, int flag){
		Scanner sc = new Scanner(System.in);
		System.out.printf("1. Print ke Layar \n2. Print ke File\n");
		int kode = sc.nextInt();
		switch(kode){
			case 1:
				switch(flag){
					case 1:
						for(int i=0; i<result.length; i++){
							System.out.printf("X%d = %.2f\n", i+1, result[i]);
						}
						break;
					case 2:
						System.out.println("");
						break;
					case 3:
						System.out.println("Sistem Persamaan Linier tidak memiliki solusi");
						break;
				}
<<<<<<< HEAD
				break;
=======
			break;
>>>>>>> 3fd955cf024845ce6a62834b1327d604a20de6d4
			case 2:
				System.out.println("Masukan nama File: ");
				String namaFile = sc.next();
				try{
					PrintStream writeSPL = new PrintStream(new File(namaFile));
					switch(flag){
						case 1:
							for(int i=0; i<result.length; i++){
								writeSPL.printf(" X%d = %.2f;", i+1, result[i]);
							}
							break;
						case 2:
							writeSPL.println(" ");
							break;
						case 3:
							writeSPL.println("Sistem Persamaan Linier tidak memiliki solusi");
							break;
						}
				} catch(IOException e){
					System.out.println("An error occured.");
					e.printStackTrace();
				}
				break;
		}

		sc.close();
	}

	// Prosedur untuk mengeluarkan hasil Interpolasi Linier pada layar atau pada file
	public static void writeInterpolasi(double x, double[] result){
		System.out.println("1. Print ke Layar\n2.Print ke File\n");
		Scanner sc = new Scanner(System.in);
		int kode = sc.nextInt();
		switch(kode){
			case 1:
				for(int i=0; i<result.length; i++){
					if(i==result.length-1){
						System.out.printf("%.2f(x^%d)\n", result[i], i);
					} else{
						System.out.printf("%.2f(x^%d) + ", result[i], i);
					}
				}
				System.out.printf("y(%.2f) = %.2f\n",x,result[result.length-1]);
				break;
			case 2:
				System.out.println("Masukan nama File: ");
				String namaFile = sc.next();
				try{
					PrintStream polinom = new PrintStream(new File(namaFile));
					polinom.printf("y = %.2f + ", result[0]);
					for(int i=1; i<result.length; i++){
						if(i==result.length-1){
							polinom.printf("%.2f(x^%d)", result[i], i);
						} else{
							polinom.printf("%.2f(x^%d) + ", result[i], i);
						}
					}
					polinom.println();
					polinom.printf("y(%.2f) = %.2f",x,result[result.length-1]);
				} catch(IOException e){
					System.out.println("An error occured");
					e.printStackTrace();
				}
				break;
		}

		sc.close();
	}

	///////*PRIMITIF MATRIKS*////////
	// Fungsi Transpose matriks
	// Melakukan operasi transpose pada sebuah matriks berukuran BrsEff x KolEff
	// Fungsi hanya bisa digunakan di dalam kelas Matriks
	private Matriks Transpose(){
		Matriks Mhasil = new Matriks(KolEff,BrsEff);
		for(int i=0;i<BrsEff;i++){
			for(int j=0;j<KolEff;j++){
				Mhasil.Elmt[j][i] = this.Elmt[i][j];
			}
		}
		return Mhasil;
	}


	// Fungsi untuk menukar dua baris pada matriks
	private void swapRow(int row1, int row2){
		for(int j=0; j<KolEff; j++){
			double temp = this.Elmt[row1][j];
			this.Elmt[row1][j] = this.Elmt[row2][j];
			this.Elmt[row2][j] = temp;
		}
	}

	// Fungsi yang mengembalikan matriks hasil perkalian dua buah matriks
	private Matriks KaliMatriks(Matriks A, Matriks B){
		Matriks Mhasil = new Matriks(A.BrsEff, B.KolEff);
		for(int i=0; i<A.BrsEff; i++){
			for(int j=0; j<B.KolEff; j++){
				for(int k=0; k<A.KolEff; k++){
					Mhasil.Elmt[i][j] += A.Elmt[i][k] * B.Elmt[k][j];
				}
			}
		}
		return Mhasil;
	} 


	// Prosedur memotong matriks dari indek terluar sehingga ukurannya menjadi lebih kecil
	// I.S. Matriks terdefinisi dengan NBrs < BrsEff dan NKol < KolEff
	// F.S. Matriks terpotong sehingga BrsEff -= NBrs dan KolEff -= NKol
	private void CutMatriks(int NBrs, int NKol) {
		Matriks tempM = new Matriks(this.BrsEff-NBrs, this.KolEff-NKol);
		
		for (int i=0; i<tempM.BrsEff; i++) {
			for (int j=0; j<tempM.KolEff; j++) {
				tempM.Elmt[i][j] = this.Elmt[i][j];
			}
		}
		
		this.Elmt = tempM.Elmt;
		this.BrsEff = tempM.BrsEff;
		this.KolEff = tempM.KolEff;
	}

	private void splitMatriks(Matriks A, Matriks B){

		int nkol = this.KolEff;
		int nbrs = this.BrsEff;

		Matriks tempMA = new Matriks(nbrs, nkol-1);
		Matriks tempMB = new Matriks(nbrs, 1);


		for(int i=0; i<nbrs;i++){
			for(int j=0; j<nkol-1;j++){
				tempMA.Elmt[i][j] = this.Elmt[i][j];
			}
		}


		for(int i=0; i<this.BrsEff; i++){
			tempMB.Elmt[i][0] = this.Elmt[i][nkol-1];
 		}

 		A.Elmt = tempMA.Elmt;
 		A.BrsEff = nbrs;
 		A.KolEff = nkol-1;

 		B.Elmt = tempMB.Elmt;
 		B.BrsEff = nbrs;
 		B.KolEff = 1;
	}


    
    // Mencari hasil
    public static void printResult(double[] sol){
        int N = sol.length;
        System.out.println("\nHasilnya adalah : ");
        for (int i = 0; i < N; i++) 
            System.out.printf("%.2f ", sol[i]);   
        System.out.println();     
    }  


	// Metode Gauss
	// Fungsi untuk melakukan eleminasi gauss
    // Metode Gauss
	// Fungsi untuk melakukan eleminasi gauss
    public static double[] Gauss(Matriks M) {
    	double[][] a = new double[M.BrsEff][M.KolEff-1];
    	double[] b = new double[M.BrsEff];
    	for (int i = 0; i < M.BrsEff; i++){
    		for (int j = 0; j < M.KolEff-1; j++){
    			a[i][j] = M.Elmt[i][j];
    		}
    	}
    	for (int i = 0; i < M.BrsEff; i++){
    		b[i] = M.Elmt[i][M.KolEff-1];
    	}
        int n = b.length;

        for (int p = 0; p < n; p++) {

            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(a[i][p]) > Math.abs(a[max][p])) {
                    max = i;
                }
            }
            double[] temp = a[p];
            a[p] = a[max];
            a[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            for (int i = p + 1; i < n; i++) {
                double ratio = a[i][p] / a[p][p];
                b[i] -= ratio * b[p];
                for (int j = p; j < n; j++) {
                    a[i][j] -= ratio * a[p][j];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / a[i][i];
        }
        return x;
    }

	/// Metode Gauss-Jordan
	/// Fungsi untuk melakukan eliminasi Gauss-Jordan

	public static double[] Jordan(Matriks M) {
        int i, j, k = 0, c;
        int flag = 0;
        int n = M.BrsEff; 
		double[][] a = new double[n][n+1];
		double[] x;
        
        for (i = 0; i < M.BrsEff; i++){
            for (j = 0; j < M.KolEff; j++){
                a[i][j] = M.Elmt[i][j];
            }
        }

        for (i = 0; i < n; i++){ 
            if (a[i][i] == 0){ 
                c = 1; 
                while ((i + c) < n && a[i + c][i] == 0){  
                   c++;
                }        
                if ((i + c) == n){
                    flag = 1; 
                    break; 
                }
                for (j = i, k = 0; k <= n; k++){
                    double temp =a[j][k]; 
                    a[j][k] = a[j+c][k]; 
                    a[j+c][k] = temp; 
                }
            } 
  
            for (j = 0; j < n; j++){ 
                if (i != j){ 
                    double p = a[j][i] / a[i][i];
                    for (k = 0; k <= n; k++){                  
                        a[j][k] = a[j][k] - (a[i][k]) * p;
                    }             
                } 
            } 
        }
        for (i = 0; i < M.BrsEff; i++){
            if ((a[i][i]!=0) && (a[i][i]!=1)){
                for (j = i; j < M.KolEff; j++){
                    M.Elmt[i][j] = a[i][j] / a[i][i];
                }
            }
        }
        if (flag == 1){
            flag = 3;
    	    for (i = 0; i < n; i++)  { 
        	    double sum = 0; 
        	    for (j = 0; j < n; j++){     
            	    sum = sum + M.Elmt[i][j]; 
        	    }
        	    if (sum == M.Elmt[i][n]) { 
            	    flag = 2;   
        	    }
    	    }
    	    if (flag == 3){
    	        x = new double[n+3];
                for (i = 0; i < n; i++){
                    x[i] = 0;
                }
    	    }
    	    else {
    	        x = new double[n+2];
                for (i = 0; i < n; i++){
                    x[i] = 0;
                }
    	    }
        }
        else{
            x = new double[n];
            for (i = 0; i < n; i++){
                x[i] = a[i][M.KolEff-1] / a[i][i];
            }
        }
        return x;
    }


	///////*KUMPULAN MATRIKS INVERSE*////////////
	// Fungsi untuk menghitung determinan matriks dengan metode reduksi baris
	public double DetReduksi(){
		Matriks temp = new Matriks(this.Elmt);
		for (int i=0; i<BrsEff; i++){
			for(int j=0; j<KolEff; j++){
				if(j>i){
					double rasio = temp.Elmt[j][i]/temp.Elmt[i][i];
					for(int k=0; k<KolEff; k++){
						temp.Elmt[j][k] -= rasio * temp.Elmt[i][k];
					}
				}
			}
		}

		double det = 1;
		for(int i=0; i<BrsEff; i++){
			det *= temp.Elmt[i][i];
		}
		return det;
	}

	// Fungsi yang mengembalikan kofaktor elemen baris ke-p kolom ke-q
	private Matriks Cofactor(Matriks M, int p, int q){
		Matriks cofactor = new Matriks(M.BrsEff-1, M.KolEff-1);
		int k = 0;
		int l = 0;
		for(int i=0; i<M.BrsEff; i++){
			for(int j=0; j<M.KolEff; j++){
				if (i!=p && j!=q){
					cofactor.Elmt[k][l] = M.Elmt[i][j];
					l += 1;
					if(l==cofactor.BrsEff){
						l = 0;
						k += 1;
					}
				}
			}
		}
		return cofactor;
	}

	// Fungsi menghitung determinan matriks menggunakan metode ekspansi kofaktor
	public double DetCofactor(Matriks M){
		if(M.BrsEff==1 && M.KolEff==1){
			return M.Elmt[0][0];
		} else{
			double result = 0;
			int sign = 1;
			for(int j=0;j<M.KolEff;j++){
				Matriks temp = M.Cofactor(M,0,j);
				result += sign*M.Elmt[0][j]*DetCofactor(temp);
				sign *= -1;
			}
			return result;
		}
	}

	// Fungsi yang mengembalikan matriks kofaktor dari suatu matriks
	private Matriks MatriksCofactor(Matriks M){
		Matriks Mcofactor = new Matriks(BrsEff, KolEff);
		for(int i=0; i<BrsEff; i++){
			for(int j=0;j<KolEff; j++){
				Matriks temp = M.Cofactor(M,i,j);
				Mcofactor.Elmt[i][j] = temp.DetCofactor(temp);
			}
		}
		return Mcofactor;
	}

	// Fungsi yang mengembalikan inverse suatu matriks
	// Asumsi matriks input adalah matriks yang simetris NxN
	// Determinan matriks input tidak nol
	public Matriks Inverse(Matriks M){
		Matriks Minv = M.MatriksCofactor(M);
		Minv = Minv.Transpose();
		double det = M.DetCofactor(M);
		int sign = 1;
		for(int i=0; i<BrsEff;i++){
			for(int j=0; j<KolEff; j++){
				Minv.Elmt[i][j] = sign*(1/det)*Minv.Elmt[i][j];
				sign *= -1;
			}
		}
		return Minv;
	}


	/////////*KUMPULAN SPL*///////////////
	// Fungsi yang mengkomputasi hasil sistem persamaan linier dengan menggunakan metode matriks inverse
	// AX = B
	// X = Inv(A)B
	// Asumsi determinan matriks tidak nol
	public double[] SPLInverse(Matriks A, Matriks B){
		Matriks temp = A.KaliMatriks(A.Inverse(A), B);
		double[] result = new double[temp.BrsEff];

		for(int i=0; i<temp.BrsEff; i++){
			result[i] = temp.Elmt[i][0];
		}

		return result;
	}

	// Fungsi mencari nilai x dengan metode Cramer
	// Keluaran berupa array double yang berisi nilai dari peubah
	public double[] Cramer() {
		double MainDet; // Determinan Matriks utama
		
		double[] ValX = new double[KolEff-1]; // Array nilai setiap variabel X yang memenuhi
		double[] ArrB = new double[BrsEff]; // Array nilai konstanta B pada SPL
		double[] DetN = new double[KolEff-1]; // Array nilai determinan yang telah diganti sekolom dengan nilai B
		
		Matriks tempM = new Matriks(BrsEff,KolEff);
		Matriks tempM2 = new Matriks(BrsEff,KolEff-1);
		
		tempM = this;
		
		for (int i=0; i<tempM.BrsEff; i++) {
			ArrB[i] = tempM.Elmt[i][tempM.KolEff-1];
		}
		
		tempM.CutMatriks(0,1);
		
		MainDet = tempM.DetCofactor(tempM);
		
		for (int j=0; j<tempM.KolEff; j++) {
			tempM2 = new Matriks(tempM.Elmt);
			
			for (int i=0; i<tempM2.BrsEff; i++) {
				tempM2.Elmt[i][j] = ArrB[i];
			}
			
			DetN[j] = tempM2.DetCofactor(tempM2);
			
			ValX[j] = DetN[j]/MainDet;
		}
		
		return ValX;
	}

	
	// Prosedur untuk menampilkan menu ketika program di-run
	// Print Hasil
	public static void Result(Matriks M, int flag) { 
		int n = M.KolEff;
    	System.out.print("Hasilnya adalah: "); 
  
    	if (flag == 2){      
    		System.out.println("Solusi banyak");
    	}  
    	else if (flag == 3){ 
    		System.out.println("Tidak memiliki solusi"); 
    	}
    	else { 
        	for (int i = 0; i < n; i++)          
            	System.out.print(M.Elmt[i][n] / M.Elmt[i][i] + " ");      
    	} 
	}


	///////INTERPOLASI MATRIKS////////////
	// Prosedur yang melakukan interpolasi polinom
	// Keluaran berupa array berisi koefisien polinom dan hasil taksiran polinom
	public double[] Interpolasi(Matriks input, int n, double x){
		double[] result = new double[n+2]; // Menyimpan koefisien polinom hasil interpolasi polinom dan hasil taksiran pada indeks terakhir
		Matriks M = new Matriks(n+1, n+2);
		int l = 0;
		int m = 0;

		// Mengubah masukan menjadi matriks augmented
		for(int i=0; i<n+1; i++){
			for(int j=0; j<n+2; j++){
				if(j==n+1){
					M.Elmt[i][j] = input.Elmt[l++][1];
				} else if(j==0){
					M.Elmt[i][j] = 1;
				} else{
					M.Elmt[i][j] = 1;
					for(int k=0; k<j; k++){
						M.Elmt[i][j] *= input.Elmt[m][0];
					}
				}
			}
			m++;
	    }
		
		double[] polinom = Matriks.Gauss(M);

		double taksiran = polinom[0];

		// Menghitung nilai taksiran dari hasil interpolasi polinom
		for(int i=1; i<n+1; i++){
			double temp = x;
			for(int j=1; j<i; j++){
				temp *= x;
			}
			taksiran += polinom[i] * temp;
		}

		for(int i=0; i<n+1; i++){
			result[i] = polinom[i];
		}
		result[n+1] = taksiran;
		return result;
	}




	public static void main(String[] args){

		MenuPilihan();
    } 
	
	// Prosedur untuk menampilkan menu ketika program di-run
	public static void MenuPilihan() {
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		int kode = 6;
		
		Matriks Minput = new Matriks(1,1);
		
		while (running) {
			System.out.printf("Menu \n1. Sistem Persamaan Linier \n2. Determinan \n3. Matriks balikan \n4. Interpolasi Polinom \n5. Regresi linier berganda \n6. Keluar \n");
			kode = sc.nextInt();

			switch(kode){
				case 1:
					System.out.printf("1. Metode eliminasi Gauss \n2. Metode eliminasi Gauss-Jordan \n3. Metode Matriks balikan \n4. Kaidah Cramer \n");
					int kode1 = sc.nextInt();
					Minput.BacaIsi(1);
					int flag;
					double[] hasil;
					switch(kode1){
						case 1:
							hasil = Gauss(Minput);
							if (hasil.length == 3 + Minput.BrsEff){
								flag = 3;
							}
							else if (hasil.length == 2 + Minput.BrsEff){
								flag = 2;
							}
							else {
								flag = 1;
							}
							Matriks.writeSPL(hasil, flag);
							break;
						case 2:
							hasil = Jordan(Minput);
							if (hasil.length == 3 + Minput.BrsEff){
								flag = 3;
							}
							else if (hasil.length == 2 + Minput.BrsEff){
								flag = 2;
							}
							else {
								flag = 1;
							}
							Matriks.writeSPL(hasil, flag);
							break;
						case 3:
							if(Minput.DetCofactor(Minput)==0){
								System.out.println("SPL tidak dapat diselesaikan dengan cara ini!");
							} else{
								Matriks A = new Matriks(1,1);
								Matriks B = new Matriks(1,1);

								Minput.splitMatriks(A,B);

								hasil = A.SPLInverse(A,B);
								Matriks.writeSPL(hasil, 1);
							}

							break;
						case 4:
							if(Minput.DetCofactor(Minput)==0){
								System.out.println("SPL tidak dapat diselesaikan dengan cara ini!");
							} else{
								hasil = Minput.Cramer();
								Matriks.writeSPL(hasil,1);
							}
							break;
					}
					break;
				case 2:
					System.out.printf("Menu \n1.Determinan Reduksi Baris \n2.Determinan Ekspansi Kofaktor \n");
					kode1 = sc.nextInt();
					Minput.BacaIsi(4);
					double determinan;

					switch(kode1){
						case 1:
							determinan = Minput.DetReduksi();
							Matriks.writeDouble(determinan);
							break;
						case 2:
							determinan = Minput.DetCofactor(Minput);
							Matriks.writeDouble(determinan);
							break;
					}
					break;
				case 3:
					System.out.printf("Matriks Balikan\n");
					Minput.BacaIsi(4);
					double det = Minput.DetCofactor(Minput);
					if(det!=0){
						Matriks Moutput = Minput.Inverse(Minput);
						Moutput.writeMatriks(Moutput);
					} else{
						System.out.println("Matriks yang anda masukan tidak memiliki inverse\n");
					}
					break;
				case 4:
					System.out.printf("Interpolasi Polinom");
					Minput.BacaIsi(2);
					System.out.println("Masukan nilai yang akan di taksir: ");
					double x = sc.nextDouble();
					int n = Minput.Elmt.length-1;

					double[] result = Minput.Interpolasi(Minput,n,x);
					Minput.writeInterpolasi(x, result);

					break;
				case 5:
					System.out.printf("Regresi Linier Berganda\n");
					Minput.BacaIsi(3);

					double jawaban;

					double[] rslt = Minput.Regresi();
					double[] var = new double[rslt.length-1];

					System.out.println("Masukkan variabel-variabel X untuk nilai Y yang ingin dicari:");

					for (int i=0; i<var.length; i++) {
						var[i] = sc.nextDouble();
					}

					jawaban = HasilRegresi(rslt, var);
					
					writeDouble(jawaban);
					break;
				case 6:
					running = false;
					break;
			}
		}
		sc.close();
	}


	// Method buat ngeluarin output yang parametrik
	// sudah gauss jordan matriksnya
	public static void parametrik(Matriks M) {
		// KAMUS LOKAL
		char[] varAlp = new char[10];
		int unusedAlpIdx = 0;
		char[] valOfVar = new char[M.KolEff];
		double[] numOfVar = new double[M.KolEff];


		// ALGORITMA
		varAlp[0] = 'q';
		valOfVar[0] = 'A';
		numOfVar[0] = -12345;

		for (int i=1; i<varAlp.length; i++) {
			varAlp[i] = (char) (varAlp[0]+1);

			if (i < M.KolEff-1) {
				valOfVar[i] = 'A';
				numOfVar[i] = -12345;
			}
		}

		valOfVar[M.KolEff-1] = 'B';


		for (int i=0; i<M.BrsEff - 1; i++) {
			int firstIdx = 0;

			boolean foundFirst1 = false;
			boolean foundSecond = false;

			for (int j=0; j<M.KolEff - 1; j++) {
				if(M.Elmt[i][j] != 0) {
					if (!foundFirst1) {
						foundFirst1 = true;
						firstIdx = j;
					}

					else {
						if (valOfVar[j] == 'A') {
							valOfVar[j] = varAlp[unusedAlpIdx];
							unusedAlpIdx++;
						}

						foundSecond = true;
					}
				}
			}

			if (!foundSecond && foundFirst1) {
				numOfVar[firstIdx] = M.Elmt[i][M.KolEff-1];
			}
		}

		for (int i=0; i<M.BrsEff; i=i+1) {
			int firstIdx = 0;

			boolean foundFirst1 = false;
			boolean foundSecond = false;

			for (int j=0; j<M.KolEff; j=j+1) {

				if (M.Elmt[i][j] != 0) {

					if ((!foundFirst1) && (j != M.KolEff-1)) {
						foundFirst1 = true;
						System.out.printf("x%d = ", j);
						firstIdx = j;
					}

					else {

						if (!foundSecond) {

							if (valOfVar[j] == 'A') {
								System.out.printf("%.2f ", -(M.Elmt[i][j] * numOfVar[j]));
								foundSecond = true;
							}

							else if (valOfVar[j] == 'B') {

							}

							else {
								System.out.printf("%.2f%c ", -M.Elmt[i][j], valOfVar[j]);
								foundSecond = true;
							}
						}
						
						else {

							if (valOfVar[j] == 'A') {
								double value = M.Elmt[i][j] * numOfVar[j];

								if (value < 0) {
									System.out.printf("+ %.2f ", -value);
								}

								else {
									System.out.printf("- %.2f ", value);
								}
								
							}

							else if (valOfVar[j] == 'B') {

								if (M.Elmt[i][j] < 0) {
									System.out.printf("+ %.2f ", -M.Elmt[i][j]);
								}

								else {
									System.out.printf("- %.2f ", M.Elmt[i][j]);
								}
							}

							else {

								if (M.Elmt[i][j] < 0) {
									System.out.printf("+ %.2f%c ", -M.Elmt[i][j], valOfVar[j]);
								}

								else {
									System.out.printf("- %.2f%c ", M.Elmt[i][j], valOfVar[j]);
								}
							}
						}
					}
				}
			}

			if (!foundSecond && foundFirst1) {
				System.out.printf("%.2f ", numOfVar[firstIdx]);
			}

			if (foundFirst1) {
				System.out.println();
			}
		}

		for (int j=0; j<valOfVar.length; j++) {

			if ((valOfVar[j] != 'A') && (valOfVar[j] != 'B')) {
				System.out.printf("x%d = %c", j, valOfVar[j]);
				System.out.println();
			}
		}
	}



// Fungsi Regresi() mencari koefisien persamaan regresi berdasarkan matriks data yang ada
	public double[] Regresi() {
		// KAMUS LOKAL
		int Kol = 0;
		
		double[] ans = new double[KolEff];
		
		Matriks MRegres;
		
		// ALGORITMA
		for (int i=KolEff; i>0; i++) {
		        Kol = Kol + KolEff;
		}
		
		MRegres = new Matriks(KolEff, KolEff+1);
		
		
		MRegres.Elmt[0][0] = this.BrsEff;
		MRegres.Elmt[0][MRegres.KolEff-1] = this.SigmaKol(this.KolEff-1);
		
		for (int j=1; j<MRegres.BrsEff; j++) {
		        double sum = this.SigmaKol(j-1);
		        MRegres.Elmt[0][j] = sum;
		        MRegres.Elmt[j][0] = sum;
		}
		
		
		for (int i=1; i<MRegres.BrsEff; i++) {
		        for (int j=i; j<MRegres.KolEff-1; j++) {
		                double sum = this.SigmaMult2Kol(i-1, j-1);
		                MRegres.Elmt[i][j] = sum;
		                MRegres.Elmt[j][i] = sum;
		        }
		}
		
		for (int i=1; i<MRegres.BrsEff; i++) {
		        int j = MRegres.KolEff-1;
		        MRegres.Elmt[i][j] = SigmaMult2Kol(i-1, j-1);
		}

		ans = Gauss(MRegres);
		
		return ans;
	}
		
	// Fungsi mencari jumlah seluruh elemen dalam sebuah kolom
	public double SigmaKol(int j) {
		double ans = 0;
		
		for (int i=0; i<BrsEff; i++) {
		    ans = ans + Elmt[i][j];
		}
		
		return ans;
	}
		
	// Fungsi mencari Sigma(Elmt[i][j1]*Elmt[i][j2])
	public double SigmaMult2Kol(int j1, int j2) {
		// KAMUS LOKAL
		double ans = 0;
		
		// ALGORITMA
		for (int i=0; i<BrsEff; i++) {
		    ans = ans + Elmt[i][j1] * Elmt[i][j2];
		}
		
		return ans;
	}


	// Fungsi Mengeluarkan hasil yang ingin dicari dari variabel-variabel pada Regresi
	public static double HasilRegresi(double[] konstanta, double[] variable) {

		// KAMUS LOKAL
		double ans = konstanta[0];

		// ALGORITMA
		for (int i=0; i<variable.length; i++) {
			ans = ans + variable[i]*konstanta[i+1];
		}

		return ans;
	}

}