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
  
  test("When comparing 2 articles with distinct edition dates, they're sorted in oldest-to-newest") {
    val before = MockArticleFactory.mockInstance(edition = "2012-01-01")
    val after  = MockArticleFactory.mockInstance(edition = "2012-02-01")
    
    assertTrue(before < after)
  }
  
  test("When comparing 2 articles, both with the same edition dates, they're sorted in alphabetical order") {
    val before = MockArticleFactory.mockInstance(title = "AAA")
    val after  = MockArticleFactory.mockInstance(title = "BBB")
    
    assertTrue(before < after)
  }
  
  test("Sorting a list of articles sorts by date and then by alphabetical title") {
    val a = MockArticleFactory.mockInstance(edition = "2012-01-01", title = "alpha")
    val b = MockArticleFactory.mockInstance(edition = "2012-02-01", title = "gamma")
    val c = MockArticleFactory.mockInstance(edition = "2012-02-01", title = "beta")
    val d = MockArticleFactory.mockInstance(edition = "2012-03-01", title = "eta")
    val e = MockArticleFactory.mockInstance(edition = "2011-12-01", title = "zeta")
    val f = MockArticleFactory.mockInstance(edition = "2012-01-01", title = "omega")
    
    val articles = List(a, b, c, d, e, f).sorted
    
    assertEquals(e, articles(0))
    assertEquals(a, articles(1))
    assertEquals(f, articles(2))
    assertEquals(c, articles(3))
    assertEquals(b, articles(4))
    assertEquals(d, articles(5))
  }
}

object MockArticleFactory {
  
  val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
  
  /**
   * Creates a new article with a bunch of sensible defaults
   */
  def mockInstance(publication: String       = "Cruising World",
                   edition:     String       = "2012-01-01",
                   page:        Int          = 123,
                   title:       String       = "Lorem Ipsum",
                   description: String       = "Some description of the article",
                   notes:       String       = "My Notes",
                   categories:  List[String] = List("foo", "bar")
                  ): Article = {
    val editionDate = format.parse(edition)
    new Article(publication, editionDate, page, title, description, notes, categories)
  }
}
