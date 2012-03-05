package vaughan.parser

import vaughan.model.Article
import scala.io.Source

/**
 * <p>An implementation of the ArticleParser trait that assumes the input source contains tab-delimited strings that should
 * be parsed into an {@code Article} object.  It is further assumed that each line from the source contains a complete
 * Article object.  Back-to-back tabs in the input source implies an empty value for the field.</p>
 * 
 * TODO: what's a good scala-like treatment for "has header row"?
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
  
  def parseLine(line: String): Article = {
    val tokens = line.split('\t')
    require(7 == tokens.size)
    val edition = Article.dFormat.parse(tokens(1))
    val page = tokens(2).toInt
    val categories = tokens(6).split(",").toList
    
    new Article(tokens(0), edition, page, tokens(3), tokens(4), tokens(5), categories)
  }
}
