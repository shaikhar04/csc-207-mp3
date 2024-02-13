import java.io.PrintWriter;

/**
 * MainTest
 */
public class MainTest {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    TextBlock tb1 = new TextLine("Hello");
    TextBlock tb2 = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello")));
    
    // TextBlock result = new VerticallyFlipped(new VerticallyFlipped(input));

    pen.println(TBUtils.equals(tb1, tb2));
  }
}