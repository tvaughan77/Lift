package vaughan.model

import java.util.Date;

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
class Article(val publication: String,
              val edition: Date,
              val page: Int,
              val title: String,
              val description: String,
              val notes: String,
              val categories: List[String]) {
  
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
           categories: List[String]) = this(publication, Article.dFormat.parse(edition), page, title, "", "", categories)

}

object Article {
    
  val dFormat = new java.text.SimpleDateFormat("MMM yyyy")
  
  val mockArticle1 = new Article("Cruising World", 
                                 dFormat.parse("Feb 2012"),
                                 23,
                                 "How to foo your bar",
                                 "Describes what foos are best in bolstering your bar",
                                 "",
                                 List("foo","bar"))
  
  
  val mockArticle2 = new Article("Sailing World", 
                                 dFormat.parse("December 2011"),
                                 7,
                                 "Lorem Ipsum",
                                 "Whatever description you want goes here",
                                 "These are my notes for this artcle",
                                 List("bar","baz"))
}
