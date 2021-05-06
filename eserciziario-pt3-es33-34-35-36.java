//Esercizio 3.33
// Scrivere la segnatura e l’opportuno contratto JML per un metodo che data una sequenza di interi, la ripartisca in due sequenze di interi positivi ed interi negativi.

//@ ensures (\forall int i; i ≥ 0 && i < pos.length; pos[i] ≥ 0) &&
(\forall int j; j ≥ 0 && j < neg.length; neg[j] < 0)
void Ripart(int[] seq, int[] pos, int[]neg);

//Esercizio 3.34
// -  Definire una classe Java avente come attributo un array di interi A e come metodo una funzione booleana pospredomina che restituisce true 
//    se la somma degli interi positivi in A supera il valore assoluto della somma degli interi negativi di A.
// -  Definire un contratto JML per il metodo pospredomina.

class Example {
  private int[] A;

  //@ ensures \result <==> 
  //@	  ((\sum int i; i ≥ 0 && i < A.length; A[i] ≥ 0 ⇒ A[i]) > 
  //@	  Math.Abs(\sum int i; i ≥ 0 && i < A.length; A[i] < 0 ⇒ A[i]))
  public boolean pospredomina () {
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

	//@ ensures \result <==> (\sum int i; i ≥ 0 && i < A.length; A[i]) > 0)
	public boolean sommaPositiva() {
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
	int[] A;
	int[] B;
	int[] C;
	
	//@ ensures (\forall int i; i ≥ 0 && i < B.length-1; B[i] ≥ 0 && (B[i] ≤ B[i+1]))
  //@	  && 
  //@	  (\forall int i ≥ 0 && i < C.length-1; C[i] < 0 && (C[i] ≤ C[i+1])) && C[C.length-1] < 0
  void ripartisci() {
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
