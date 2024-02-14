/**
 * Simple blocks of text for a lab on polymorphism
 * 
 * @author Samuel A. Rebelsky
 * @author Arsal Shaikh
 * @author Zack Abdilahi
 */
public interface TextBlock {
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception;

  /**
   * Determine how many rows are in the block.
   */
  public int height();

  /**
   * Determine how many columns are in the block.
   */
  public int width();

  /**
   * Determine if the two blocks were built the same way.
   */
  public boolean eqv(TextBlock other);

} // interface TextBlock
