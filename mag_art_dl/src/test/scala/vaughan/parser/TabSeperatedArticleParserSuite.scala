package vaughan.parser

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class TabSeperatedArticleParserSuite extends FunSuite {

  test("Reading from a test source file with a header row produces 1 articles") {
    val source = Source.fromInputStream(getClass.getResourceAsStream("one_article.tdf"))
    val parser = new TabSeperatedArticleParser(true)
    assertEquals(1, parser.parseSource(source).size)
  }
  
  test("Reading from a test source file with empty optional fields produces 1 article") {
    val source = Source.fromInputStream(getClass.getResourceAsStream("one_article_with_no_optional_fields.tdf"))
    val parser = new TabSeperatedArticleParser(true)
    val articles = parser.parseSource(source)
    assertEquals(1, articles.size)
    assertEquals("Sailing World", articles(0).publication)
    assertEquals("Alpha Title", articles(0).title)
  }
  
  test("Reading from a test source file with multiple comma-separated-categories gets parsed correctly") {
    val source = Source.fromInputStream(getClass.getResourceAsStream("one_article_with_multiple_categories.tdf"))
    val parser = new TabSeperatedArticleParser(false)
    val articles = parser.parseSource(source)
    assertEquals(1, articles.size)
    assertEquals("Esquire", articles(0).publication)
    assertEquals(3, articles(0).categories.size)
    assertTrue(articles(0).categories.contains("Cruising"))
    assertTrue(articles(0).categories.contains("Electronics"))
    assertTrue(articles(0).categories.contains("Navigation"))
  }
}
