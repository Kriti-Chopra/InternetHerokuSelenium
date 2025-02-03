import java.io.File;

public class FileDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fileLocation = new File("/Users/name/Downloads/");
		System.out.println(fileLocation.exists());
		File[] listFiles = fileLocation.listFiles();
		System.out.println(listFiles[0].getName());
	}

}
