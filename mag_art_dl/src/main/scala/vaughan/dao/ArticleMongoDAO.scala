package vaughan.dao

import vaughan.model.Article
import com.mongodb.casbah.Imports._

/**
 * <p>A Mongo-backed DAO for Article objects</p>
 * @author tom.vaughan
 */
object ArticleMongoDAO extends ArticleDAO {
  
  /**
   * {@inheritDoc}
   */
  def findAll(): List[Article] = {
    List(Article.mockArticle1, Article.mockArticle2)
  }
}
