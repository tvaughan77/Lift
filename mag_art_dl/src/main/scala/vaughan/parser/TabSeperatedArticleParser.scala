package vaughan.parser

import vaughan.model.Article
import vaughan.LogHelper
import scala.io.Source

/**
 * <p>An implementation of the ArticleParser trait that assumes the input source contains tab-delimited strings that should
 * be parsed into an {@code Article} object.  It is further assumed that each line from the source contains a complete
 * Article object.  Back-to-back tabs in the input source implies an empty value for the field.</p>
 * 
 * @author tom.vaughan
 */
class TabSeperatedArticleParser(val hasHeaderRow: Boolean) extends ArticleParser with LogHelper {
  
  def this() = this(false)
  
  /**
   * {@inheritDoc}
   */
  def parseSource(source: Source): List[Article] = {
    val lines = 
      if(hasHeaderRow) 
        source.getLines().toList.tail 
      else 
        source.getLines().toList

    val articles = scala.collection.mutable.Set.empty[Article]
    for(line <- lines) 
      articles += TabSeperatedArticleParser.parseLine(line)
    
    articles.toList
  }
}


object TabSeperatedArticleParser extends LogHelper {
  
  /**
   * @param line a single line containing exactly 7 tokens of tab-separated information in it, with this spec:
   * <ol>
   *  <li>Name of the publication</li>
   *  <li>The edition of the publication, in date format like "Mar 2011" or "Aug 2009"</li>
   *  <li>The first page of the article, parseable as an integer</li>
   *  <li>The title of the article</li>
   *  <li>An optional description of the article.</li>
   *  <li>An optional string containing notes about the article</li>
   *  <li>A comma separated list of categories (meta-data) describing the article</li>
   * </ol>
   */
  private def parseLine(line: String): Article = {
    val tokens = line.split('\t')
    debug("parsing input line '%s'", line)
    require(7 == tokens.size, {error("Input line only had %d tokens", tokens.size)})
    
    val edition = Article.dFormat.parse(tokens(1))
    val page = tokens(2).toInt
    val categories = tokens(6).split(",").toList
    
    debug("categories = %s", categories.mkString)
    
    new Article(tokens(0), edition, page, tokens(3), tokens(4), tokens(5), categories)
  }
}
