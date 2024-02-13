/**
 * Horizontally flips a TextBlock.
 * 
 * @author Arsal Shaikh
 * @author Zack
 */
public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+


  TextBlock inputBlock;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing top and bottom vertically.
   */
  public HorizontallyFlipped(TextBlock inputBlock) throws Exception {
    this.inputBlock = inputBlock;
  } // HorizontallyFlipped(Textblock, int)

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
    String flippedRow = "";
    int width = this.inputBlock.width();
    String initialRow = this.inputBlock.row(i);
    for (int col = 0; col < width; col++) {
      flippedRow += initialRow.charAt(width - 1 - col);
    }
    return flippedRow; 
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
    return this.inputBlock.width();
  } // width()

} // class HorizontallyFlipped
