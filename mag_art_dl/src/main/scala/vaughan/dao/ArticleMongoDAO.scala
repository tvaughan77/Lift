package vaughan.dao

import vaughan.model.Article
import com.mongodb.casbah.Imports._
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.core.MongoOperations
import collection.JavaConversions._

/**
 * <p>A Mongo-backed DAO for Article objects</p>
 * <p>TODO - is there a way to annotate/ship the collectionName with the class??</p>
 * 
 * @see http://api.mongodb.org/scala/casbah/current/tutorial.html
 * @see http://janxspirit.blogspot.com/2011/11/introduction-to-casbah-scala-mongodb.html
 * @author tom.vaughan
 */
@Repository
class ArticleMongoDAO(mongoOperations: MongoOperations) 
  extends AbstractMongoDAO(mongoOperations) 
     with ArticleDAO {
  
  require(mongoOperations != null)
  
  private val collectionName = "articles"  // The "table name" in our underlying MongoDB to CRUD records to
  
  /**
   * {@inheritDoc}
   */
  def findAll(): List[Article] = {
    //mongoOperations.findAll(classOf[Article], collectionName)
    List(Article.mockArticle1, Article.mockArticle2)
  }
  
  def findById(id: Serializable) = {
    Article.mockArticle1
  }
  
  def save(article: Article) = {
    mongoOperations.save(article, collectionName)
    article
  } 
  
  def remove(article: Article) = {
    mongoOperations.remove(article)
  }
}
