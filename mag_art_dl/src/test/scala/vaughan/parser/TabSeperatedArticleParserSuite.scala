package vaughan.parser

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._
import java.text.SimpleDateFormat
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class TabSeperatedArticleParserSuite extends FunSuite {

  test("Reading from a test source produces 2 articles") {
    val source = Source.fromInputStream(getClass.getResourceAsStream("one_article.tdf"))
    assertEquals(2, TabSeperatedArticleParser.parseSource(source).size)
  }
}
