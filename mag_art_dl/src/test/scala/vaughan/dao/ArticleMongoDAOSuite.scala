package vaughan.dao

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat
import com.mongodb.casbah.Imports._


@RunWith(classOf[JUnitRunner])
class ArticleMongoDBSuite extends FunSuite {
  
  val dao = new ArticleMongoDAO(null)

  test("Find all returns a couple mock articles") {
    assertEquals(2, dao.findAll().size)
  }
  
  test("test connection to localhost mongodb") {
    val mongoConn = MongoConnection()
    val mongoDB = mongoConn("casbah_test")
  }
  
  test("test inserting and retrieving") {
    val mongoColl = MongoConnection()("casbah_test")("test_data")
    val user1 = MongoDBObject("user" -> "bwmcadams",
                              "email" -> "~~brendan~~<AT>10genDOTcom")
    val user2 = MongoDBObject("user" -> "someOtherUser")
    mongoColl += user1
    mongoColl += user2
    mongoColl.find()
    // com.mongodb.casbah.MongoCursor =
    // MongoCursor{Iterator[DBObject] with 2 objects.}

    for { x <- mongoColl} println(x)
  }
}
