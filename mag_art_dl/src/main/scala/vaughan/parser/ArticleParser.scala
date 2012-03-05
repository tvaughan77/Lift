package vaughan.parser

import vaughan.model.Article
import scala.io.Source

/**
 * <p>A trait capturing the interface for parsing {@code Article} objects.</p>
 * @author tom.vaughan
 */
trait ArticleParser {

  /**
   * TODO - consider returning a tuple of Lists - one of "successful" parsing and one of errors?  Or maybe an Option?
   *
   * @param source a Source providing data that the implementing class attempts to convert to a list of Article objects
   * @return A List of {@code Article} objects based off the source.
   */
  def parseSource(source: Source): List[Article]
}
