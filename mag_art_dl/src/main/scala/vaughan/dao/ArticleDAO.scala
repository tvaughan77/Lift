package vaughan.dao

import vaughan.model.Article

/**
 * A DAO for Article objects
 * 
 */
trait ArticleDAO {
  
  /**
   * @return All articles from the underlying data source
   */
  def findAll(): List[Article]
  
}
