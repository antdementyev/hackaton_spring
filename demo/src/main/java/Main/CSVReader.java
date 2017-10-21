package Main;

import java.util.ArrayList;
import java.util.Random;

public class CSVReader {
	ArrayList<String> x;
    ArrayList<Integer> y;
    public CSVReader(){
    	 y = new ArrayList<>();
    	 Random r = new Random();
         for (int i=0 ; i <2; i++) {
         	 y.add(r.nextInt(20)+10);
         	y.add(r.nextInt(20)+10);
         	for (int j=0 ; j <400; j++) {
            	 y.add(r.nextInt(5)+5);
            }
         }
       /* String csvFile = "Resources/text/data.csv";
        BufferedReader br = null;
        x = new ArrayList<>();
        y = new ArrayList<>();
        String line="";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] values = line.split(cvsSplitBy);
                
                x.add(values[0]);
                y.add(values[1]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

    } 

    
	public static void main(String[] args) {
		new CSVReader();
	}
}
