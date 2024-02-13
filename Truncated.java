/**
 * Truncates a block into a specified width
 * 
 * @author Arsal Shaikh
 * @author Zack
 */
public class Truncated implements TextBlock {


  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int maxWidth;
  TextBlock inputBlock;

  // +-------------+-------------------------------------------------------
  // | Constructor |
  // +-------------+
  public Truncated(TextBlock inputBlock, int maxWidth) throws Exception {
    if (inputBlock.width() < maxWidth) {
      throw new Exception("Width provided must be shorter than block");
    }
    this.maxWidth = maxWidth;
    this.inputBlock = inputBlock;
  } // Truncated(TextBlock, int)


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  public String row(int i) throws Exception {
    if (i > inputBlock.height()) {
      throw new Exception("Invalid row " + i);
    }    
    return inputBlock.row(i).substring(0, maxWidth);    
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */

  public int height() {
    return this.inputBlock.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return maxWidth;
  } // width()
}