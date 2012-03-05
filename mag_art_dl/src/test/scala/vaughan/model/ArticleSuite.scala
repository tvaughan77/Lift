package vaughan.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat


@RunWith(classOf[JUnitRunner])
class ArticleSuite extends FunSuite {

  val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
  
  
  test("Construct a normal article") {
    val myArticle = new Article("Cruising World", 
                                format.parse("2012-02-01"),
                                23,
                                "How to foo your bar",
                                "Describes what foos are best in bolstering your bar",
                                "",
                                List("foo","bar"))
    assertNotNull(myArticle)
    assertEquals(2, myArticle.categories.size)
  }
}
