package IMDB;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArquivoDados {
	private RandomAccessFile file;
	private int numReg;
	private int tamReg;
	private int tamHead;
	private static final int STRING_MAX_TAM = 30;

	public ArquivoDados() {
		this.file = null;
		this.numReg = -1; // n�mero de registro (-1: n�o h� registros)
		this.tamReg = (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8);
		this.tamHead = 4;
	}

	public void openFile(String path) {
		File f = new File(path);		// se arquivo no existe definie numReg como 0. Se o arquivo j� existe, mantenha como -1 
		if (!f.exists())
			this.numReg = 0;
		try {
			file = new RandomAccessFile(f, "rw");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}	// se numReg � igual a -1, h� registros dentro do arquivo, ent�o verifica a quantidade de registros
		if (this.numReg == -1)
			this.setNumReg();
	}
	private void setNumReg() {
		try {
			this.numReg = file.readInt();
		} catch (IOException e) {
			System.out.println("Error!");
			System.exit(0);
		}
	}
	public void openFileReadOnly(String path) {
		try {
			file = new RandomAccessFile(new File(path), "r");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		this.setNumReg();
	}
	public int getNumReg() {
		return numReg;
	}
	public void setData(Paciente p) {
		int pos = this.tamHead + (this.numReg * this.tamReg); // calculaponteiro para a primeira posi��o vazia do arquivo
		try {
			file.seek(pos);
			file.writeInt(p.getCodigo());
			file.writeUTF(p.getNome());
			file.seek(pos + (Integer.SIZE / 8) + STRING_MAX_TAM);
			file.writeUTF(p.getSobrenome());
			file.seek(pos + (Integer.SIZE / 8) + STRING_MAX_TAM +
					STRING_MAX_TAM);
			file.writeInt(p.getIdade());
			file.seek(0);
			this.numReg += 1;
			file.writeInt(this.numReg);
		} catch (IOException e) {
			System.out.println("Error!");
			System.exit(0);
		}
	}
	public Paciente getData(int key) {
		if (key >= this.numReg)
			return null;
		int pos = this.tamHead + (key * this.tamReg);
		Paciente p = new Paciente();
		try {
			file.seek(pos);
			p.setCodigo(file.readInt());
			p.setNome(file.readUTF());
			file.seek(pos + (Integer.SIZE / 8) + STRING_MAX_TAM);
			p.setSobrenome(file.readUTF());
			file.seek(pos + (Integer.SIZE / 8) + STRING_MAX_TAM +
					STRING_MAX_TAM);
			p.setIdade(file.readInt());
		} catch (IOException e) {
			System.out.println("Error");
			System.exit(0);
		}
		return p;
	}
	public void closeFile(String path) {
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("Error");
			System.exit(0);
		}
	}
}

