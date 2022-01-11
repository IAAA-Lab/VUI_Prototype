package parseo;

import com.example.demo.Answer;

import java.io.Reader;
import java.io.StringReader;

public class AnswerGenerator{
    public enum direction{Left,Right,Up,Down}
    String recon;
    Reader r=new StringReader("");
    GramaticaTFG parser= new GramaticaTFG(r);

    public void setRecon(String recon) {
        this.recon = recon;
    }
    public Answer parseRecognized(String recon){
        try{
            return new Answer(recon,GramaticaTFG.parse(recon,parser));
        }
        catch(ParseException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    /*
    public Answer move (direction dir) {
        return new Answer(recon,"mover"+dir);
    }
    public Answer zoom(Boolean in) {
        if(in) {
            return new Answer(recon,"Zoom in");
        }
        else {
            return new Answer(recon,"Zoom out");
        }
    }
    public Answer layer() {
        Answer a= new Answer(recon,"Vista satelite");
        return a;
    }

    public Answer search(String s) {
        return new Answer(recon,"Busca"+s);
    }*/

}
