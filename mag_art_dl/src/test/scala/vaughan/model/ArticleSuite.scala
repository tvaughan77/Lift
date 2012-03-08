package vaughan.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat



@RunWith(classOf[JUnitRunner])
class ArticleSuite extends FunSuite {

  test("Construct a normal Article using the full constructor") {
    val myArticle = new Article("Cruising World", 
                                new java.util.Date(),
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
    assertEquals(new java.text.SimpleDateFormat("yyyy-MM-dd").parse("2011-07-01"), myArticle.edition)
  }
  
  test("Not providing a publication is an exception") {
    intercept[IllegalArgumentException] {
      new Article("", "Jul 2011", 1, "Title", List("foo"))
    }
  }
  
  test("When comparing 2 articles with distinct edition dates, they're sorted in oldest-to-newest") {
    val before = Article.mockInstance(edition = "Jan 2012")
    val after  = Article.mockInstance(edition = "Feb 2012")
    
    assertTrue(before < after)
  }
  
  test("When comparing 2 articles, both with the same edition dates, they're sorted in alphabetical order") {
    val before = Article.mockInstance(title = "AAA")
    val after  = Article.mockInstance(title = "BBB")
    
    assertTrue(before < after)
  }
  
  test("Sorting a list of articles sorts by date and then by alphabetical title") {
    val a = Article.mockInstance(edition = "Jan 2012", title = "alpha")
    val b = Article.mockInstance(edition = "Feb 2012", title = "gamma")
    val c = Article.mockInstance(edition = "Feb 2012", title = "beta")
    val d = Article.mockInstance(edition = "Mar 2012", title = "eta")
    val e = Article.mockInstance(edition = "Dec 2011", title = "zeta")
    val f = Article.mockInstance(edition = "Jan 2012", title = "omega")
    
    val articles = List(a, b, c, d, e, f).sorted
    
    assertEquals(e, articles(0))
    assertEquals(a, articles(1))
    assertEquals(f, articles(2))
    assertEquals(c, articles(3))
    assertEquals(b, articles(4))
    assertEquals(d, articles(5))
  }
}


