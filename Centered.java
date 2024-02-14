/**
 * The vertical composition of two text blocks.
 * 
 * @author Arsal Shaikh
 * @author Zack
 */
public class Centered implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+


  TextBlock inputBlock;
  int maxWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing top and bottom vertically.
   */
  public Centered(TextBlock inputBlock, int maxWidth) throws Exception {
    if (inputBlock.width() > maxWidth) {
      throw new Exception("Width provided must be longer than block");
    }
    this.inputBlock = inputBlock;
    this.maxWidth = maxWidth;
  } // Centered(Textblock, int)

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
    int contentWidth = inputBlock.width();
    int whiteSpaceWidth = (maxWidth - contentWidth) / 2;
    return TBUtils.spaces(whiteSpaceWidth) +  inputBlock.row(i) + TBUtils.spaces(whiteSpaceWidth); 
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

  /**
   * Determine if the two blocks were built the same way.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof Centered) && (this.inputBlock.eqv(((Centered)other).inputBlock));
  }

} // class VComposition
