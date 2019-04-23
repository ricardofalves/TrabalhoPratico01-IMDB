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
	private static final int STRING_MAX_TAM = 300;

	public ArquivoDados() {
		this.file = null;
		this.numReg = -1; // numero de registro (-1: nao ha registros)
		this.tamReg = STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) +  (Integer.SIZE / 8) + STRING_MAX_TAM + 
				(Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + 
				STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + 
				STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Double.SIZE / 16) + (Double.SIZE / 16) + (Integer.SIZE / 8);
		this.tamHead = 4;
	}

	public void openFile(String path) {
		File f = new File(path);		// se arquivo no existe definie numReg como 0. Se o arquivo ja existe, mantenha como -1 
		if (!f.exists())
			this.numReg = 0;
		try {
			file = new RandomAccessFile(f, "rw");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}	// se numReg eh igual a -1, ha registros dentro do arquivo, entao verifica a quantidade de registros
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
	public void setData(Movie m) {
		int pos = this.tamHead + (this.numReg * this.tamReg); // calculaponteiro para a primeira posicao vazia do arquivo
		try {
			file.seek(pos);
			file.writeUTF(m.getColor());
			file.seek(pos + STRING_MAX_TAM);
			file.writeUTF(m.getDirector_name());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM);
			file.writeInt(m.getNum_critic_for_reviews());
			file.writeInt(m.getDuration());
			file.writeInt(m.getDirector_facebook_likes());
			file.writeInt(m.getActor_3_facebook_likes());
			file.writeUTF(m.getActor_2_name());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM);
			file.writeInt(m.getActor_1_facebook_likes());
			file.writeInt(m.getGross());
			file.writeUTF(m.getGenres());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM);
			file.writeUTF(m.getActor_1_name());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM);
			file.writeUTF(m.getMovie_title());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM);
			file.writeInt(m.getNum_voted_users());
			file.writeInt(m.getCast_total_facebook_likes());
			file.writeUTF(m.getActor_3_name());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM);
			file.writeInt(m.getFacenumber_in_poster());
			file.writeUTF(m.getPlot_keywords());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM);
			file.writeUTF(m.getMovie_imdb_link());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM);
			file.writeInt(m.getNum_user_for_reviews());
			file.writeUTF(m.getLanguage());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM);
			file.writeUTF(m.getCountry());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM);
			file.writeUTF(m.getContent_rating());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM);
			file.writeInt(m.getBudget());
			file.writeInt(m.getTitle_year());
			file.writeInt(m.getActor_2_facebook_likes());
			file.writeDouble(m.getImdb_score());
			file.writeDouble(m.getAspect_ratio());
			file.writeInt(m.getMovie_facebook_likes());
			file.seek(0);
			this.numReg += 1;
			file.writeInt(this.numReg);
		} catch (IOException e) {
			System.out.println("Error!");
			System.exit(0);
		}
	}
	public Movie getData(int key) {
		if (key >= this.numReg)
			return null;
		int pos = this.tamHead + (key * this.tamReg);
		Movie m = new Movie();
		try {
			file.seek(pos);
			m.setColor(file.readUTF());
			file.seek(pos + STRING_MAX_TAM);
			m.setDirector_name(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM);
			m.setNum_critic_for_reviews(file.readInt());
			m.setDuration(file.readInt());
			m.setDirector_facebook_likes(file.readInt());
			m.setActor_3_facebook_likes(file.readInt());
			m.setActor_2_name(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM);
			m.setActor_1_facebook_likes(file.readInt());
			m.setGross(file.readInt());
			m.setGenres(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM);
			m.setActor_1_name(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM);
			m.setMovie_title(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM);
			m.setNum_voted_users(file.readInt());
			m.setCast_total_facebook_likes(file.readInt());
			m.setActor_3_name(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM);
			m.setFacenumber_in_poster(file.readInt());
			m.setPlot_keywords(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM);
			m.setMovie_imdb_link(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM);
			m.setNum_user_for_reviews(file.readInt());
			m.setLanguage(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM);
			m.setCountry(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM);
			m.setContent_rating(file.readUTF());
			file.seek(pos + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + (Integer.SIZE / 8) + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + (Integer.SIZE / 8) + STRING_MAX_TAM + STRING_MAX_TAM + STRING_MAX_TAM);
			m.setBudget(file.readInt());
			m.setTitle_year(file.readInt());
			m.setActor_2_facebook_likes(file.readInt());
			m.setImdb_score(file.readDouble());
			m.setAspect_ratio(file.readDouble());
			m.setMovie_facebook_likes(file.readInt());
		} catch (IOException e) {
			System.out.println("Error");
			System.exit(0);
		}
		return m;
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

