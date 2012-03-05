package vaughan.parser

import vaughan.model.Article
import scala.io.Source

/**
 * <p>An implementation of the ArticleParser trait that assumes the input source contains tab-delimited strings that should
 * be parsed into an {@code Article} object.  It is further assumed that each line from the source contains a complete
 * Article object.  Back-to-back tabs in the input source implies an empty value for the field.</p>
 * 
 * @author tom.vaughan
 */
object TabSeperatedArticleParser extends ArticleParser {
  
  /**
   * {@inheritDoc}
   */
  def parseSource(source: Source): List[Article] = {
    List(Article.mockArticle1, Article.mockArticle2)
  }
}
