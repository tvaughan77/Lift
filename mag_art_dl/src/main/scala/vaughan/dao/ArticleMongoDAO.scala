package vaughan.dao

import vaughan.LogHelper
import vaughan.model.Article
import com.mongodb.casbah.Imports._
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.core.MongoOperations
import scala.collection.JavaConversions._

/**
 * <p>A Mongo-backed DAO for Article objects</p>
 * 
 * @see http://api.mongodb.org/scala/casbah/current/tutorial.html
 * @see http://janxspirit.blogspot.com/2011/11/introduction-to-casbah-scala-mongodb.html
 * @author tom.vaughan
 */
@Repository
class ArticleMongoDAO(mongoOperations: MongoOperations) 
  extends AbstractMongoDAO(mongoOperations) 
     with ArticleDAO
     with LogHelper {
  
  require(mongoOperations != null)
  
  /**
   * {@inheritDoc}
   */
  def findAll(): List[Article] = {
    val articles = mongoOperations.findAll(classOf[Article])
    debug("%s.findAll found %d articles", this.getClass.getName, articles.size)
    articles.toList
  }
  
  def findById(id: Serializable) = {
    Article.mockArticle1
  }
  
  def save(article: Article) = {
    mongoOperations.save(article)
    debug("%s.save(%s) saved article", this.getClass.getName, article)
    article
  } 
  
  def remove(article: Article) = {
    mongoOperations.remove(article)
    debug("%s.remove(%s) removed article", this.getClass.getName, article)
  }
}
