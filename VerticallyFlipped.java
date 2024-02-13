/**
 * Vertically flips a TextBlock.
 * 
 * @author Arsal Shaikh
 * @author Zack
 */
public class VerticallyFlipped implements TextBlock {
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
  public VerticallyFlipped(TextBlock inputBlock) throws Exception {
    this.inputBlock = inputBlock;
  } // VerticallyFlipped(Textblock, int)

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
    return inputBlock.row(inputBlock.height() - 1 - i);
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

} // class VerticallyFlipped
