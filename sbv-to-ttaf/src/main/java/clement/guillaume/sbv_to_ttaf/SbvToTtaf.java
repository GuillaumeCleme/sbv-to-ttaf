package clement.guillaume.sbv_to_ttaf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Simple SBV to TTAF file conversion using regex pattern matching and text structure evaluation
 * 
 * 
 * @author Guillaume Clement
 *
 */
public class SbvToTtaf {

	public static void main(String[] args) throws IOException{

		BufferedReader br = null;
		boolean debug = false;
		String lineValue = "";
		final String timeStampRegex = "\\d:\\d{2}:\\d{2}.\\d{3},\\d:\\d{2}:\\d{2}\\.\\d{3}";

		//A proper W3C document object could be used here, but since our processing is so minimal, we can use simple lines
		ArrayList<String> lines = new ArrayList<String>();

		try {
			//Argument checking
			if (args.length<2) {
				System.out.println("Use: java -jar svb-to-ttaf.jar <path to sbv file> <path to ttaf file>");
				throw new IllegalArgumentException("Invocation requires two argument: [sbvFilePath, ttafFilePath]");	
			}

			//Argument assignment
			String sbvPathString = args[0];
			String ttafPathString = args[1];
			
			//Check debug flag
			if (args.length == 3) {
				debug = args[2].equals("debug") ? true : false;
			}

			//Create files, and make sure that the path exists
			File sbvFile = new File(sbvPathString);
			File ttafFile = new File(ttafPathString);

			//Start the file off with the XML header
			lines.add("<tt xmlns=\"http://www.w3.org/2006/10/ttaf1\"> <body> <div xml:id=\"captions\">");

			//Create the buffered reader
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(sbvFile),"UTF-8"));
			
			//Read file line by line
			while ((lineValue = br.readLine()) != null) {

				if (debug) {
					System.out.println("Processing line:" + lineValue);
				}

				//Check if line is a timestamp
				if(lineValue.matches(timeStampRegex)){
					if (debug) {
						System.out.println("Line is a timestamp:" 
								+ lineValue);
					}

					//Split timestamps
					String[] timeSplit = lineValue.split(",");

					lines.add("<p begin=\"" + 
							timeSplit[0].substring(0, timeSplit[0].lastIndexOf(".")) + 
							"\" end=\"" + 
							timeSplit[1].substring(0, timeSplit[1].lastIndexOf(".")) + 
							"\">");
				}

				//A non empty line has content that we must add to the paragraph
				else if (!lineValue.isEmpty()) {
					if (debug) {
						System.out.println("Line is a caption value:"
								+ lineValue);
					}

					lines.add(lineValue);
				}

				//An empty line indicates the end of the paragraph
				else {
					if (debug) {
						System.out.println("Line is empty:" + lineValue);
					}

					lines.add("</p>");
				}
			}

			//Close off the XML document
			lines.add("</div>");
			lines.add("</body>");
			lines.add("</tt>");

			if (debug) {
				System.out.println("Reassembled lines:" 
						+ lines);
			}
			
			//Write file out
			Files.write(ttafFile.toPath(), lines, Charset.forName("UTF-8"));
			
			System.out.println("Conversion success");

		} finally {
			if(null != br){
				br.close();
			}
		}
	}
}
