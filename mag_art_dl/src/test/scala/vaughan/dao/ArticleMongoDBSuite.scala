package vaughan.dao

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat


@RunWith(classOf[JUnitRunner])
class ArticleMongoDBSuite extends FunSuite {

  test("Find all returns a couple mock articles") {
    assertEquals(2, ArticleMongoDAO.findAll().size)
  }
}
