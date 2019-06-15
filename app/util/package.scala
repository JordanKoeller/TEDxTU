import play.twirl.api.Html

package object util {

	implicit def stringToHtml(arg:String):Html = new Html(arg)
	implicit def optStringToOptHtml(arg:Option[String]):Option[Html] = {
		if (arg.isDefined) Some(new Html(arg.get)) else None
	}

	implicit def articleToList(arg:Article):List[Article] = arg::Nil
	implicit def htmlToList(arg:Html):List[Html] = arg::Nil
	implicit def stringToList(arg:String):List[String] = arg::Nil
	implicit def htmlSeqToHtml(arg:Seq[Html]):Html = arg.foldLeft(new Html(""))((acc,elem) => acc + elem.body)
//
	case class Article(title:Html,body:Html,subtitle:Option[Html]=None,image:Option[Html] = None)
//
//
	case class PersonDescription(picLink:String,email:String,name:String,classDesc:String,description:String)
	private val jordan = PersonDescription("jkIcon.jpg","jkoeller@trinity.edu","Jordan Koeller","Physics & Computer Science, class of 2019","From time to time, I like to do science.")

	def peopleList:List[PersonDescription] = jordan :: Nil

}

