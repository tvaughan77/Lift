package vaughan.parser

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat
import scala.io.Source
import vaughan.model.Article

@RunWith(classOf[JUnitRunner])
class TabSeparatedArticleParserSuite extends FunSuite {

  test("Reading from a test source file with a header row produces 1 articles") {
    val articles = getArticles("one_article.tdf", true)
    assertEquals(1, articles.size)
  }
  
  test("Reading from a test source file with empty optional fields produces 1 article") {
    val articles = getArticles("one_article_with_no_optional_fields.tdf", true)
    assertEquals(1, articles.size)
    assertEquals("Sailing World", articles(0).publication)
    assertEquals("Alpha Title", articles(0).title)
  }
  
  test("Reading from a test source file with multiple comma-separated-categories gets parsed correctly") {
    val articles = getArticles("one_article_with_multiple_categories.tdf", false)
    assertEquals(1, articles.size)
    assertEquals("Esquire", articles(0).publication)
    assertEquals(3, articles(0).categories.size)
    assertTrue(articles(0).categories.contains("Cruising"))
    assertTrue(articles(0).categories.contains("Electronics"))
    assertTrue(articles(0).categories.contains("Navigation"))
  }
  
  test("Reading from a header-less test source file with 3 articles gets parsed correctly") {
    val articles = getArticles("three_articles.tdf", false)
    assertEquals(3, articles.size)

    assertEquals(2, articles(0).categories.size)
    assertEquals("Sailing World", articles(1).publication)
    assertEquals("My notes about the article", articles(1).notes)

    assertEquals("Beta Title", articles(2).title)
    assertEquals(1200, articles(2).page)
  }
  
  private def getArticles(testFile: String, hasHeaderRow: Boolean): List[Article] = {
    val source = Source.fromInputStream(getClass.getResourceAsStream(testFile))
    val parser = new TabSeparatedArticleParser(hasHeaderRow)
    parser.parseSource(source)
  }
}
