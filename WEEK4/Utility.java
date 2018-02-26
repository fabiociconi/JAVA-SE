import java.io.IOException;

public class Utility {
	
	public int calculateAverage(int total, int count) throws IOException{
		if (count <= 0){
			throw new IOException("Invalid count");
		}
		return total/count;
	}
}
