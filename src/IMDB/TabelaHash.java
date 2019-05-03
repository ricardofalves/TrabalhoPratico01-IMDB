package IMDB;

import java.io.*;
import java.util.*;
import java.lang.*;

class Hash {
	public double item;
	public boolean ocupado;

	public Hash(boolean b) {
		ocupado = b;
	}

}

class TabelaHash {

	private Hash[] tab;
	private int TAM_MAX;

	public TabelaHash(int tam) {
		tab = new Hash[tam];
		TAM_MAX = tam;
		for (int i = 0; i < tam; i++)
			tab[i] = new Hash(false);
	}

	private int funcaohash(double chave) {
		int v = (int) chave;
		return (Math.abs(v) % TAM_MAX);
	}

	public void insere(double item) {

		if (cheia()) {
			return;
		}

		int pos = funcaohash(item);

		if (tab[pos].ocupado) { // colisao

			if (item == tab[pos].item) {
				return;
			}

			while (pos < TAM_MAX) {
				if (pos == TAM_MAX - 1)
					pos = -1;
				pos++;
				if (!tab[pos].ocupado)
					break;
			}
		}
		// FIM COLISAO

		tab[pos].item = item;
		tab[pos].ocupado = true;
	}

	public void imprime() {
		for (int i = 0; i < TAM_MAX; i++)
			if (tab[i].ocupado)
				System.out.print("\nHash[" + i + "] = " + tab[i].item);
	}

	public boolean cheia() {
		int i, qtde = 0;
		for (i = 0; i < TAM_MAX; i++)
			if (tab[i].ocupado)
				qtde++;
		if (qtde == TAM_MAX)
			return true;
		return false;
	}

}
