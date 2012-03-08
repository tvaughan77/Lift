package vaughan.model

import java.util.Date;
import java.text.SimpleDateFormat

/**
 * <p>Represents an article I found in a magazine that I clipped for saving.</p>
 * 
 * <p>TODO:<br/>
 *    Change the type of categories to a List of enumerated values<br/>
 *    Change the type of notes to a List of strings<br/>
 *    Consider making the publication an enumeration too
 * </p>
 * @author tom.vaughan
 * @since 2012/03/05
 */
case class Article(id: String,
                   publication: String,
                   edition: Date,
                   page: Int,
                   title: String,
                   description: String,
                   notes: String,
                   categories: List[String]) extends Ordered[Article] {
  
  require(publication != null && !publication.isEmpty)
  require(edition!= null)
  require(page > 0)
  require(title != null && !title.isEmpty)
  require(categories != null && categories.size > 0)
  
  /**
   * <p>Convenience constructor - the description and notes probably aren't likely to be filled in very often, but
   * shorthanding the edition date string probably is.</p>
   */
  def this(publication: String,
           edition: String,
           page: Int,
           title: String,
           categories: List[String]) = this("", publication, Article.dFormat.parse(edition), page, title, "", "", categories)

  /**
   * <p>The natural sorting of Articles first by publication date and then by title</p>
   */
  @Override
  def compare(that: Article): Int = {
    if(that.edition.after(this.edition)) {
      -1
    } else if(that.edition.before(this.edition)) {
      1
    } else {
      this.title.compare(that.title)
    }
  }
}

object Article {
    
  val dFormat = new java.text.SimpleDateFormat("MMM yyyy")
  
  val mockArticle1 = mockInstance(publication = "Cruising World")
  val mockArticle2 = mockInstance(publication = "Sailing World", edition = "Dec 2011")

  /**
   * Creates a new article with a bunch of sensible defaults
   */
  def mockInstance(id:          String       = "",
                   publication: String       = "Cruising World",
                   edition:     String       = "Jan 2012",
                   page:        Int          = 123,
                   title:       String       = "Lorem Ipsum",
                   description: String       = "Some description of the article",
                   notes:       String       = "My Notes",
                   categories:  List[String] = List("foo", "bar")
                  ): Article = {
    val editionDate = Article.dFormat.parse(edition)
    Article(id, publication, editionDate, page, title, description, notes, categories)
  }
}
