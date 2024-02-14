import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Tests {
  /**
 * Tests of the for MP3.
 * 
 * @author Arsal Shaikh
 * @author Zack Abdilahi
 */

  @Test
  public void tuncatedTest() throws Exception {
    TextBlock tb1 = new TextLine("Hello, World");
    TextBlock empty = new TextLine("");
    int maxWidth = 5;
    
    TextBlock truncatedBlock = new Truncated(tb1, maxWidth);
    assertEquals("Truncated shortens to correct width", truncatedBlock.width(), maxWidth) ;
    
    TextBlock emptyTextBlock = new Truncated(empty, 0);
    assertEquals("Truncated works with width 0", emptyTextBlock.width(), 0) ;

  }

  @Test
  public void centeredTest () throws Exception {
      TextBlock tb1 = new TextLine("My name is Sam");
      TextBlock centered = new Centered(tb1, 20);
      
      assertEquals("Centered creates block of correct width", centered.width(), 20);

      // Checking for correct spacing row by row
      String currentRow;
      String message;
      for (int i = 0; i < centered.height(); i++) {
        currentRow = centered.row(i);
        message = String.format("Correct spacing in %dth row", i);
        assertEquals(message, currentRow.substring(0, 3), "   ");
        assertEquals(message, currentRow.substring(currentRow.length() - 3), "   ");
      }
  }

  @Test
  public void rightJustifiedTest() throws Exception {
    TextBlock tb1 = new TextLine("My name is Sam");
    TextBlock rightJustifiedBlock = new RightJustified(tb1, 20);

    assertEquals("rightJustified creates block of correct width", rightJustifiedBlock.width(), 20);

    // Checking for correct spacing row by row
    String currentRow;
    String message;
    for (int i = 0; i < rightJustifiedBlock.height(); i++) {
      currentRow = rightJustifiedBlock.row(i);
      message = String.format("Correct spacing in %dth row", i);
      assertEquals(message, currentRow.substring(0, 3), "   ");
    }  
  }

  @Test
  public void leftJustifiedTest() throws Exception {
    TextBlock tb1 = new TextLine("My name is Sam");
    TextBlock leftJustifiedBlock = new LeftJustified(tb1, 20);
    
    assertEquals("leftJustified creates block of correct width", leftJustifiedBlock.width(), 20);

    // Checking for correct spacing row by row
    String currentRow;
    String message;
    for (int i = 0; i < leftJustifiedBlock.height(); i++) {
      currentRow = leftJustifiedBlock.row(i);
      message = String.format("Correct spacing in %dth row", i);
      assertEquals(message, currentRow.substring(currentRow.length() - 3), "   ");
    } 
  }


 @Test
  public void horizontallyFlippedTest() throws Exception {
    TextBlock tb = new TextLine("Football");
    TextBlock flippedOnce = new HorizontallyFlipped(tb);
    TextBlock flippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(tb));
    
    assertFalse("Horizontally flipping once changes the block", TBUtils.equals(tb, flippedOnce));
    assertTrue("Horizontally flipping twice gives the same block", TBUtils.equals(tb, flippedTwice));

    TextBlock emptyTextBlock = new HorizontallyFlipped(new TextLine(""));
    assertEquals("HorizontallyFlipped works with empty block", emptyTextBlock.width(), 0);
  }

  @Test
  public void verticallyFlippedTest() throws Exception {
    TextBlock upper = new TextLine("Basketball");
    TextBlock lower = new TextLine("Football");
    
    TextBlock tb = new VComposition(upper, lower);
    
    TextBlock flippedOnce = new VerticallyFlipped(tb);
    TextBlock flippedTwice = new VerticallyFlipped(new VerticallyFlipped(tb));
    
    assertFalse("Vertically flipping once changes the block", TBUtils.equals(tb, flippedOnce));
    assertTrue("Vertically flipping twice gives the same block", TBUtils.equals(tb, flippedTwice));

    TextBlock emptyTextBlock = new VerticallyFlipped(new TextLine(""));
    assertEquals("HorizontallyFlipped works with empty block", emptyTextBlock.width(), 0);
  }

  @Test
  public void equalsTest() throws Exception {
    TextBlock tb1 = new TextLine("Baseball");
    TextBlock tb2 = new TextLine("Baseball");
    TextBlock verticallyFlippedtb = new VerticallyFlipped(tb1);
    
    TextBlock tb3 = new TextLine("Golf");
    
    assertTrue("Returns true if the text is the same", TBUtils.equals(tb1, tb2));
    assertTrue("Returns true if the text is the same", TBUtils.equals(tb1, verticallyFlippedtb));
    assertFalse("Returns false if the text is different", TBUtils.equals(tb1, tb3));
  }

  @Test
  public void eqvTest() throws Exception {
    TextBlock notFlipped = new TextLine("Soccer");
    TextBlock flippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Soccer")));
    TextBlock alsoFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Soccer")));
    
    assertTrue("Returns true if the blocks were built in the same way", TBUtils.eqv(flippedTwice, alsoFlippedTwice));
    assertFalse("Returns false if the blocks were built in different ways", TBUtils.eqv(flippedTwice, notFlipped));
  }


  @Test
  public void eqTest() throws Exception {
    TextBlock tb1 = new TextLine("Tennis");
    TextBlock tb2 = tb1;
    TextBlock tb3 = new TextLine("Tennis");
    
    assertTrue("Returns true if the objects occupy the same memory location", TBUtils.eq(tb1, tb2));
    assertFalse("Returns false if the objects occupy different memory locations", TBUtils.eq(tb1, tb3));
  }

}
