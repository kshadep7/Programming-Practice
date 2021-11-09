import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleRequests {

	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws Exception{


		String filename;
		filename = scan.nextLine();
		Map<String, Integer> map = new HashMap<>();

		File file = new File(filename);
		try {
			// Create a new Scanner object which will read the data
			// from the file passed in. To check if there are more
			// line to read from it we check by calling the
			// scanner.hasNextLine() method. We then read line one
			// by one till all lines is read.
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
//				System.out.println(line);
				String[] arr = line.split(" ");
				map.put(arr[3], map.getOrDefault(arr[3], 0)+1);
			}

			writeFile1(filename, map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile1(String filename, Map<String, Integer> map) throws IOException {
		File fout = new File("req_"+filename);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for(String key: map.keySet()){
			if(map.get(key) > 1){
				bw.write(key);
				bw.newLine();;
			}
		}
//		for (int i = 0; i < 10; i++) {
//			bw.write("something");
//			bw.newLine();
//		}

		bw.close();
	}


}
