/**
 * Creates a new block of specified width and justifies passed block to the right.
 * 
 * @author Arsal Shaikh
 * @author Zack
 */
public class LeftJustified implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int maxWidth;
  TextBlock inputBlock;
  
  // +-------------+-------------------------------------------------------
  // | Constructor |
  // +-------------+
  public LeftJustified(TextBlock inputBlock, int maxWidth) throws Exception {
    if (inputBlock.width() > maxWidth) {
      throw new Exception("Width provided must be longer than block");
    }
    this.maxWidth = maxWidth;
    this.inputBlock = inputBlock;
  } // LeftJustified(TextBlock, int)


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    if (i > inputBlock.height()) {
      throw new Exception("Invalid row " + i);
    }    
    int contentWidth = inputBlock.width();
    return inputBlock.row(i) + TBUtils.spaces(maxWidth - contentWidth);    
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

} // class LeftJustified