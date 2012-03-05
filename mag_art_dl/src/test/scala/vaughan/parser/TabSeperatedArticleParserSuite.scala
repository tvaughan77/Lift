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
}
