package parseo;
import java.io.Reader;
import java.io.StringReader;
public class main {
	public static void main(String args []) {

		Reader r=new StringReader("");
		GramaticaTFG parser= new GramaticaTFG(r);
		
		try {
			GramaticaTFG.parse("mapa quita zoom",parser);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r=new StringReader("mapa haz zoom");
			try {
				parser.ReInit(r);
				parser.instruction();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
