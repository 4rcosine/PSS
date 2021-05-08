//Esercizio 3.33
//Scrivere la segnatura e l’opportuno contratto JML per un metodo che data una sequenza di interi, la ripartisca in due sequenze di interi positivi ed interi negativi.

//Seq non è vuoto
//@ requires (seq != null) && (seq.length > 0)
//Tutti i numeri in pos sono positivi e sono presenti in seq
//@ ensures (\forall int i; i ≥ 0 && i < pos.length; pos[i] ≥ 0 && (\exists int j; j >= 0 && j < seq.length; pos[i] == seq[j]))
//Tutti i numeri in neg sono negativi e sono presenti in seq
//@ ensures (\forall int i; i ≥ 0 && i < neg.length; neg[i] < 0 && (\exists int j; j >= 0 && j < seq.length; neg[i] == seq[j]))
//Tutti i numeri in seq sono contenuti in pos o neg
//@ ensures (\forall int i; i ≥ 0 && i < seq.length; 
//	(\exists int j; j >= 0 && j < pos.length; seq[i] == pos[j]) || (\exists int j; j >= 0 && j < pos.length; seq[i] == neg[j]))
void Ripart(int[] seq, int[] pos, int[]neg);

//Esercizio 3.34
// -  Definire una classe Java avente come attributo un array di interi A e come metodo una funzione booleana pospredomina che restituisce true 
//    se la somma degli interi positivi in A supera il valore assoluto della somma degli interi negativi di A.
// -  Definire un contratto JML per il metodo pospredomina.
class Example {
	private int[] A;

	//A non è vuoto
	//@ requires (A != null) && (A.length > 0)
	//Il risultato tornato deve essere true se la somma dei positivi è maggiore del valore assoluto della somma dei numeri negativi
	//@ ensures \result <==> 
	//@	  ((\sum int i; i ≥ 0 && i < A.length; A[i] ≥ 0 ⇒ A[i]) > 
	//@	  Math.Abs(\sum int i; i ≥ 0 && i < A.length; A[i] < 0 ⇒ A[i]))
	private boolean pospredomina () {
		int sumPos = 0;
		int sumNeg = 0;

		for(int i = 0; i< A.length; i++) {
			if (A[i] ≥ 0)
				sumPos += A[i];

			else
				sumNeg += A[i];
		}

		return sumPos > Math.Abs(sumNeg);
	}
}

//Esercizio 3.35
// -  Definire una classe Java avente come attributo un array di interi A e come metodo una funzione booleana sommaPositiva che restituisce true 
//    se la somma degli interi in A è positiva.
// -  Definire un contratto JML per il metodo sommaPositiva
class Example {
	private int[] A;

	//A non è vuoto
	//@ requires (A != null) && (A.length > 0)
	//Il risultato è true se la somma degli interi è positiva, falso altrimenti
	//@ ensures \result <==> (\sum int i; i ≥ 0 && i < A.length; A[i]) > 0)
	private boolean sommaPositiva() {
		int sum = 0;

		for(int i = 0; i< A.length; i++) {
			sum += A[i];
		}

		return sumPos > 0;
	}
}

//Esercizio 3.36
// -  Definire una classe Java avente come attributi tre array di interi A, B, e C, ed un metodo ripartisci che ripartisce l’array A negli array, 
//    ordinati in modo crescente, B di interi positivi e C di interi negativi.
// -  Dare la segnatura e l’opportuno contratto JML per il metodo ripartisci.
class Example {
	private int[] A;
	private int[] B;
	private int[] C;
	
	//A non è vuoto
	//@ requires (A != null) && (A.length > 0)
	//Tutti i numeri di B sono interi positivi, e sono in ordine
	//@ ensures (\forall int i; i ≥ 0 && i < B.length-1; B[i] ≥ 0 && (B[i] ≤ B[i+1]))
	//Tutti i numeri di C sono interi negativi e sono i nordine
  	//@ ensures (\forall int i ≥ 0 && i < C.length-1; C[i] < 0 && (C[i] ≤ C[i+1])) && C[C.length-1] < 0
	//Tutti i numeri di B sono in A
	//@ ensures (\forall int i; i ≥ 0 && i < B.length; (\exists int j; j >= 0 && j < A.length; B[i] == A[j]))
	//Tutti i numeri di C sono in A
	//@ ensures (\forall int i; i ≥ 0 && i < C.length; (\exists int j; j >= 0 && j < A.length; C[i] == A[j]))
	//Tutti i numeri di A sono in B o in C
	//@ ensures (\forall int i; i ≥ 0 && i < A.length;
	//	(\exists int j; j >= 0 && j < B.length; A[i] == B[j]) || (\exists int j; j >= 0 && j < C.length; A[i] == C[j]))
	private void ripartisci() {
		int idxB = 0;
		int idxC = 0;
		for(int i = 0; i< A.length; i++) {
			if (A[i] ≥ 0) {
				B[idxB] = A[i];
				idxB++;
			}
			else {
				C[idxC] = A[i];
				idxC++;
			}
		}

		Array.sort(B);
		Array.sort(C);
	}
}
