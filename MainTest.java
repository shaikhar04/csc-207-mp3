import java.io.PrintWriter;

/**
 * MainTest
 */
public class MainTest {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    TextBlock txt1 = new TextLine("Hello,World");
    TextBlock txt2 = new TextLine("This is a computer");
    TextBlock input = new VComposition(txt1, txt2);
    
    TextBlock result = new VerticallyFlipped(new VerticallyFlipped(input));

    TBUtils.print(pen, result);
  }
}