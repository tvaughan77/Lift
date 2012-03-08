package vaughan

import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import vaughan.dao.ArticleDAO
import vaughan.model.Article

/**
 * @author tom.vaughan
 */
object App {
  
  
  def main(args : Array[String]) {
    val context = new ClassPathXmlApplicationContext("applicationContext.xml")
    
    val articleDAO = context.getBean("articleDAO").asInstanceOf[ArticleDAO] 
    
//    val articles = articleDAO.findAll()
//    articles.foreach(println)
    articleDAO.save(Article.mockArticle1)
    println("Just saved the mockArticle1")
    articleDAO.remove(Article.mockArticle1)
    println("Allegedly just removed the mockArticle1")
  }

}
