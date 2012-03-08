package vaughan.dao

import vaughan.model.Article
import com.mongodb.casbah.Imports._
import javax.sql.DataSource
import org.springframework.stereotype.Component

/**
 * <p>A Mongo-backed DAO for Article objects</p>
 * 
 * @see http://api.mongodb.org/scala/casbah/current/tutorial.html
 * @see http://janxspirit.blogspot.com/2011/11/introduction-to-casbah-scala-mongodb.html
 * @author tom.vaughan
 */
@Component
class ArticleMongoDAO(dataSource: DataSource) extends AbstractDAO(dataSource) with ArticleDAO {
  
  /**
   * {@inheritDoc}
   */
  def findAll(): List[Article] = {
    List(Article.mockArticle1, Article.mockArticle2)
  }
  
  def findById(id: Serializable) = {
    Article.mockArticle1
  }
  
  def save(article: Article) = {
    article
  } 
  
  def remove(article: Article) = {
    
  }
}
