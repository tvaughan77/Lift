package vaughan.dao

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.Assert._
import java.text.SimpleDateFormat
import com.mongodb.casbah.Imports._
import com.mongodb.Mongo
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.data.mongodb.core.MongoTemplate
import vaughan.model.Article


@RunWith(classOf[JUnitRunner])
class ArticleMongoDBSuite extends FunSuite with BeforeAndAfter {
  
  val context = new ClassPathXmlApplicationContext("applicationContext.xml")
  val mongo = context.getBean("mongo").asInstanceOf[Mongo]
  val mongoOperations = new MongoTemplate(mongo, "testdb")
  val articleDAO = new ArticleMongoDAO(mongoOperations)  
  
  before {
    
  }
  
  // FIXME - there's got to be a better way of associating DAOs, POSOs and collectionNames than this
  after {
    //mongoOperations.dropCollection(articleDAO.collectionName)
  }
  
  test("Find all returns a couple mock articles") {
    articleDAO.save(Article.mockArticle1)
    articleDAO.save(Article.mockArticle2)
    
//    val articles = articleDAO.findAll()
//    assertNotNull(articles)
//    assertEquals(2, articles.size)
  }
}
