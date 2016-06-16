import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;


public class write_and_read {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    try {
	        String path1="122.txt";
	        String check = "zzz1ÿÿÿ2ààà3ááá";
	        File f = new File(path1);
	        System.out.println("in:"+check);
	       // System.out.println(f.exists());
	        
	      //windows-1251
	        //UTF-8
	       String charsetin = "UTF-8";
	       String charsetout = "windows-1251";
			
		   OutputStreamWriter osw = new OutputStreamWriter( new FileOutputStream(f),charsetin);
	       BufferedWriter bw = new BufferedWriter(osw);
	       bw.write(check);
	       bw.flush();
	       	       
	        InputStreamReader isr = new InputStreamReader(new FileInputStream(f),charsetout);
	        BufferedReader br = new BufferedReader(isr);
	        String s;
			while(true)
			{s=br.readLine();
			if (s==null) break;
	        	System.out.println("out:"+s);
			}
			
			System.out.println("Reference charsets:");
			SortedMap<String, Charset> sc = Charset.availableCharsets();
	        Set<String> ks = sc.keySet();
	        for (String k : ks) {
	        	//System.out.println(k);
			}
			
	        } catch(Exception e){
	        String error = e.getMessage();
	        }

	}

}
