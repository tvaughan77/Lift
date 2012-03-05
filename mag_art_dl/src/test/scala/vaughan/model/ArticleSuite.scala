package vaughan.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat


@RunWith(classOf[JUnitRunner])
class ArticleSuite extends FunSuite {

  val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
  
  
  test("Construct a normal Article using the full constructor") {
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
  
  test("Using the auxillary/convenience constructor still creates an Article object") {
    val myArticle = new Article("Sailing World",
                                "Jul 2011",
                                44,
                                "The name of the article",
                                List("x", "y", "z"))
    assertNotNull(myArticle)
    assertTrue(myArticle.description.isEmpty)
    assertTrue(myArticle.notes.isEmpty)
    assertEquals(3, myArticle.categories.size)
    assertEquals(format.parse("2011-07-01"), myArticle.edition)
  }
  
  test("Not providing a publication is an exception") {
    intercept[IllegalArgumentException] {
      new Article("", "Jul 2011", 1, "Title", List("foo"))
    }
  }
}
