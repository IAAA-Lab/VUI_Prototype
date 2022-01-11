/* Generated By:JavaCC: Do not edit this line. GramaticaTFG.java */
package parseo;
import java.io.Reader;
import java.io.StringReader;

public class GramaticaTFG implements GramaticaTFGConstants {
  static String result=null;
  public static AnswerGenerator gis= new AnswerGenerator();
  public static String parse(String recon, GramaticaTFG parser) throws ParseException
  {
    gis.setRecon(recon);
    Reader r=new StringReader(recon);
    parser.ReInit(r);
    try
    {
      parser.instruction();
      return result;
    }
    catch (Exception e)
    {
      System.out.println("NOK.");
      System.out.println(e.getMessage());
    }
    catch (Error e)
    {
      System.out.println("Oops.");
      System.out.println(e.getMessage());
    }
    return null;
  }

  final public void instruction() throws ParseException {
    jj_consume_token(mapInit);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case vDirUp:
    case vDirDown:
    case vMov:
    case vDesp:
    case vIr:
      verb();
      break;
    case vBusca:
      search();
      break;
    case vZoomOut:
    case vZoom:
      zoom();
      break;
    case vSat:
    case Sat:
      sat();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(0);
  }

  final public void verb() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case vMov:
    case vDesp:
    case vIr:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case vMov:
        mov();
        break;
      case vIr:
        ir();
        break;
      case vDesp:
        desp();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case cuantif:
        jj_consume_token(cuantif);
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case nexo:
        jj_consume_token(nexo);
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      donde();
      break;
    case vDirUp:
    case vDirDown:
      dir();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case cuantif:
        jj_consume_token(cuantif);
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void dir() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case vDirUp:
      jj_consume_token(vDirUp);
               result="mover arriba";
      break;
    case vDirDown:
      jj_consume_token(vDirDown);
                 result="mover abajo";
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void mov() throws ParseException {
    jj_consume_token(vMov);
  }

  final public void desp() throws ParseException {
    jj_consume_token(vDesp);
  }

  final public void ir() throws ParseException {
    jj_consume_token(vIr);
  }

  final public void donde() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case dUp:
      jj_consume_token(dUp);
           result= "mover arriba";
      break;
    case dDown:
      jj_consume_token(dDown);
             result= "mover abajo";
      break;
    case dLeft:
      jj_consume_token(dLeft);
             result= "mover izquierda";
      break;
    case dRight:
      jj_consume_token(dRight);
              result= "mover derecha";
      break;
    case dSE:
      jj_consume_token(dSE);
           result= "mover abajo derecha";
      break;
    case dSO:
      jj_consume_token(dSO);
           result= "mover abajo izquierda";
      break;
    case dNE:
      jj_consume_token(dNE);
           result= "mover arriba derecha";
      break;
    case dNO:
      jj_consume_token(dNO);
           result= "mover arriba izquierda";
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void search() throws ParseException {
    jj_consume_token(vBusca);
    toponim();
  }

  final public void sat() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case vSat:
      jj_consume_token(vSat);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    jj_consume_token(Sat);
                        result="satelite";
  }

  final public void toponim() throws ParseException {
  Token t1 =null;
    t1 = jj_consume_token(topo);
         result="Busca "+t1.image;
  }

  final public void zoom() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case vZoom:
      jj_consume_token(vZoom);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case mapInit:
      case zTerm:
        zterm();
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case cuantif:
        jj_consume_token(cuantif);
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
                                       result="zoom in";
      break;
    case vZoomOut:
      jj_consume_token(vZoomOut);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case mapInit:
      case zTerm:
        zterm();
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case cuantif:
        jj_consume_token(cuantif);
        break;
      default:
        jj_la1[12] = jj_gen;
        ;
      }
                                          result="zoom out";
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void zterm() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case mapInit:
      jj_consume_token(mapInit);
      break;
    case zTerm:
      jj_consume_token(zTerm);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public GramaticaTFGTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200ff80,0xe00,0x1000000,0x40,0x1000000,0xf80,0x180,0xff0000,0x4000,0x4000020,0x1000000,0x4000020,0x1000000,0x3000,0x4000020,};
   }

  /** Constructor with InputStream. */
  public GramaticaTFG(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public GramaticaTFG(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GramaticaTFGTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public GramaticaTFG(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GramaticaTFGTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public GramaticaTFG(GramaticaTFGTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(GramaticaTFGTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
