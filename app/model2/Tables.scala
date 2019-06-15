package model2
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Event.schema ++ NewsletterPost.schema ++ Posters.schema ++ Speakers.schema ++ TeamMember.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Event
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param title Database column title SqlType(varchar), Length(1000,true)
   *  @param subtitle Database column subtitle SqlType(varchar), Length(1000,true), Default(None)
   *  @param description Database column description SqlType(text)
   *  @param venue Database column venue SqlType(varchar), Length(1000,true)
   *  @param eventDate Database column event_date SqlType(date)
   *  @param time Database column time SqlType(time)
   *  @param maxSeats Database column max_seats SqlType(int4)
   *  @param takenSeats Database column taken_seats SqlType(int4)
   *  @param registrationLink Database column registration_link SqlType(varchar), Length(1000,true)
   *  @param mediaLink Database column media_link SqlType(varchar), Length(1000,true), Default(None) */
  case class EventRow(override val id: Int, title: String, subtitle: Option[String] = None, description: String, venue: String, eventDate: java.sql.Date,override val time: java.sql.Time, maxSeats: Int, takenSeats: Int, registrationLink: String, mediaLink: Option[String] = None) extends Post(eventDate,time,id)
  /** GetResult implicit for fetching EventRow objects using plain SQL queries */
  implicit def GetResultEventRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Date], e4: GR[java.sql.Time]): GR[EventRow] = GR{
    prs => import prs._
    EventRow.tupled((<<[Int], <<[String], <<?[String], <<[String], <<[String], <<[java.sql.Date], <<[java.sql.Time], <<[Int], <<[Int], <<[String], <<?[String]))
  }
  /** Table description of table event. Objects of this class serve as prototypes for rows in queries. */
  class Event(_tableTag: Tag) extends profile.api.Table[EventRow](_tableTag, "event") {
    def * = (id, title, subtitle, description, venue, eventDate, time, maxSeats, takenSeats, registrationLink, mediaLink) <> (EventRow.tupled, EventRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(title), subtitle, Rep.Some(description), Rep.Some(venue), Rep.Some(eventDate), Rep.Some(time), Rep.Some(maxSeats), Rep.Some(takenSeats), Rep.Some(registrationLink), mediaLink).shaped.<>({r=>import r._; _1.map(_=> EventRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column title SqlType(varchar), Length(1000,true) */
    val title: Rep[String] = column[String]("title", O.Length(1000,varying=true))
    /** Database column subtitle SqlType(varchar), Length(1000,true), Default(None) */
    val subtitle: Rep[Option[String]] = column[Option[String]]("subtitle", O.Length(1000,varying=true), O.Default(None))
    /** Database column description SqlType(text) */
    val description: Rep[String] = column[String]("description")
    /** Database column venue SqlType(varchar), Length(1000,true) */
    val venue: Rep[String] = column[String]("venue", O.Length(1000,varying=true))
    /** Database column event_date SqlType(date) */
    val eventDate: Rep[java.sql.Date] = column[java.sql.Date]("event_date")
    /** Database column time SqlType(time) */
    val time: Rep[java.sql.Time] = column[java.sql.Time]("time")
    /** Database column max_seats SqlType(int4) */
    val maxSeats: Rep[Int] = column[Int]("max_seats")
    /** Database column taken_seats SqlType(int4) */
    val takenSeats: Rep[Int] = column[Int]("taken_seats")
    /** Database column registration_link SqlType(varchar), Length(1000,true) */
    val registrationLink: Rep[String] = column[String]("registration_link", O.Length(1000,varying=true))
    /** Database column media_link SqlType(varchar), Length(1000,true), Default(None) */
    val mediaLink: Rep[Option[String]] = column[Option[String]]("media_link", O.Length(1000,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Event */
  lazy val Event = new TableQuery(tag => new Event(tag))

  /** Entity class storing rows of table NewsletterPost
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param postDate Database column post_date SqlType(date)
   *  @param description Database column description SqlType(text)
   *  @param userId Database column user_id SqlType(int4)
   *  @param title Database column title SqlType(varchar), Length(1000,true)
   *  @param subtitle Database column subtitle SqlType(varchar), Length(1000,true)
   *  @param `abstract` Database column abstract SqlType(varchar), Length(1000,true)
   *  @param mediaLink Database column media_link SqlType(varchar), Length(1000,true), Default(None) */
  case class NewsletterPostRow(override val id: Int, postDate: java.sql.Date, description: String, userId: Int, title: String, subtitle: String, `abstract`: String, mediaLink: Option[String] = None) extends Post(postDate,null,id)
  /** GetResult implicit for fetching NewsletterPostRow objects using plain SQL queries */
  implicit def GetResultNewsletterPostRow(implicit e0: GR[Int], e1: GR[java.sql.Date], e2: GR[String], e3: GR[Option[String]]): GR[NewsletterPostRow] = GR{
    prs => import prs._
    NewsletterPostRow.tupled((<<[Int], <<[java.sql.Date], <<[String], <<[Int], <<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table newsletter_post. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: abstract */
  class NewsletterPost(_tableTag: Tag) extends profile.api.Table[NewsletterPostRow](_tableTag, "newsletter_post") {
    def * = (id, postDate, description, userId, title, subtitle, `abstract`, mediaLink) <> (NewsletterPostRow.tupled, NewsletterPostRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(postDate), Rep.Some(description), Rep.Some(userId), Rep.Some(title), Rep.Some(subtitle), Rep.Some(`abstract`), mediaLink).shaped.<>({r=>import r._; _1.map(_=> NewsletterPostRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column post_date SqlType(date) */
    val postDate: Rep[java.sql.Date] = column[java.sql.Date]("post_date")
    /** Database column description SqlType(text) */
    val description: Rep[String] = column[String]("description")
    /** Database column user_id SqlType(int4) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column title SqlType(varchar), Length(1000,true) */
    val title: Rep[String] = column[String]("title", O.Length(1000,varying=true))
    /** Database column subtitle SqlType(varchar), Length(1000,true) */
    val subtitle: Rep[String] = column[String]("subtitle", O.Length(1000,varying=true))
    /** Database column abstract SqlType(varchar), Length(1000,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `abstract`: Rep[String] = column[String]("abstract", O.Length(1000,varying=true))
    /** Database column media_link SqlType(varchar), Length(1000,true), Default(None) */
    val mediaLink: Rep[Option[String]] = column[Option[String]]("media_link", O.Length(1000,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table NewsletterPost */
  lazy val NewsletterPost = new TableQuery(tag => new NewsletterPost(tag))

  /** Entity class storing rows of table Posters
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Length(100,true)
   *  @param email Database column email SqlType(varchar), Length(40,true) */
  case class PostersRow(id: Int, name: String, email: String)
  /** GetResult implicit for fetching PostersRow objects using plain SQL queries */
  implicit def GetResultPostersRow(implicit e0: GR[Int], e1: GR[String]): GR[PostersRow] = GR{
    prs => import prs._
    PostersRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table posters. Objects of this class serve as prototypes for rows in queries. */
  class Posters(_tableTag: Tag) extends profile.api.Table[PostersRow](_tableTag, "posters") {
    def * = (id, name, email) <> (PostersRow.tupled, PostersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(email)).shaped.<>({r=>import r._; _1.map(_=> PostersRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Length(100,true) */
    val name: Rep[String] = column[String]("name", O.Length(100,varying=true))
    /** Database column email SqlType(varchar), Length(40,true) */
    val email: Rep[String] = column[String]("email", O.Length(40,varying=true))
  }
  /** Collection-like TableQuery object for table Posters */
  lazy val Posters = new TableQuery(tag => new Posters(tag))

  /** Entity class storing rows of table Speakers
   *  @param speakerId Database column speaker_id SqlType(serial), AutoInc, PrimaryKey
   *  @param eventId Database column event_id SqlType(int4)
   *  @param name Database column name SqlType(varchar), Length(1000,true)
   *  @param bio Database column bio SqlType(text)
   *  @param media Database column media SqlType(varchar), Length(1000,true) */
  case class SpeakersRow(speakerId: Int, eventId: Int, name: String, bio: String, media: String)
  /** GetResult implicit for fetching SpeakersRow objects using plain SQL queries */
  implicit def GetResultSpeakersRow(implicit e0: GR[Int], e1: GR[String]): GR[SpeakersRow] = GR{
    prs => import prs._
    SpeakersRow.tupled((<<[Int], <<[Int], <<[String], <<[String], <<[String]))
  }
  /** Table description of table speakers. Objects of this class serve as prototypes for rows in queries. */
  class Speakers(_tableTag: Tag) extends profile.api.Table[SpeakersRow](_tableTag, "speakers") {
    def * = (speakerId, eventId, name, bio, media) <> (SpeakersRow.tupled, SpeakersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(speakerId), Rep.Some(eventId), Rep.Some(name), Rep.Some(bio), Rep.Some(media)).shaped.<>({r=>import r._; _1.map(_=> SpeakersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column speaker_id SqlType(serial), AutoInc, PrimaryKey */
    val speakerId: Rep[Int] = column[Int]("speaker_id", O.AutoInc, O.PrimaryKey)
    /** Database column event_id SqlType(int4) */
    val eventId: Rep[Int] = column[Int]("event_id")
    /** Database column name SqlType(varchar), Length(1000,true) */
    val name: Rep[String] = column[String]("name", O.Length(1000,varying=true))
    /** Database column bio SqlType(text) */
    val bio: Rep[String] = column[String]("bio")
    /** Database column media SqlType(varchar), Length(1000,true) */
    val media: Rep[String] = column[String]("media", O.Length(1000,varying=true))
  }
  /** Collection-like TableQuery object for table Speakers */
  lazy val Speakers = new TableQuery(tag => new Speakers(tag))

  /** Entity class storing rows of table TeamMember
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param isActive Database column is_active SqlType(int4)
   *  @param name Database column name SqlType(varchar), Length(1000,true)
   *  @param position Database column position SqlType(varchar), Length(1000,true)
   *  @param major Database column major SqlType(varchar), Length(1000,true)
   *  @param gradClass Database column grad_class SqlType(int4)
   *  @param biography Database column biography SqlType(text)
   *  @param email Database column email SqlType(varchar), Length(1000,true)
   *  @param mediaUrl Database column media_url SqlType(varchar), Length(1000,true) */
  case class TeamMemberRow(override val id: Int, isActive: Int, name: String, position: String, major: String, gradClass: Int, biography: String, email: String, mediaUrl: String)  extends WithID(id) {
    def nameLink:String = {
      val specials  = """$&+,/:;=?@ "<>#%{}|\^~[]'"""
      name.filterNot(c => specials.contains(c))
    }
  }
  /** GetResult implicit for fetching TeamMemberRow objects using plain SQL queries */
  implicit def GetResultTeamMemberRow(implicit e0: GR[Int], e1: GR[String]): GR[TeamMemberRow] = GR{
    prs => import prs._
    TeamMemberRow.tupled((<<[Int], <<[Int], <<[String], <<[String], <<[String], <<[Int], <<[String], <<[String], <<[String]))
  }
  /** Table description of table team_member. Objects of this class serve as prototypes for rows in queries. */
  class TeamMember(_tableTag: Tag) extends profile.api.Table[TeamMemberRow](_tableTag, "team_member") {
    def * = (id, isActive, name, position, major, gradClass, biography, email, mediaUrl) <> (TeamMemberRow.tupled, TeamMemberRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(isActive), Rep.Some(name), Rep.Some(position), Rep.Some(major), Rep.Some(gradClass), Rep.Some(biography), Rep.Some(email), Rep.Some(mediaUrl)).shaped.<>({r=>import r._; _1.map(_=> TeamMemberRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column is_active SqlType(int4) */
    val isActive: Rep[Int] = column[Int]("is_active")
    /** Database column name SqlType(varchar), Length(1000,true) */
    val name: Rep[String] = column[String]("name", O.Length(1000,varying=true))
    /** Database column position SqlType(varchar), Length(1000,true) */
    val position: Rep[String] = column[String]("position", O.Length(1000,varying=true))
    /** Database column major SqlType(varchar), Length(1000,true) */
    val major: Rep[String] = column[String]("major", O.Length(1000,varying=true))
    /** Database column grad_class SqlType(int4) */
    val gradClass: Rep[Int] = column[Int]("grad_class")
    /** Database column biography SqlType(text) */
    val biography: Rep[String] = column[String]("biography")
    /** Database column email SqlType(varchar), Length(1000,true) */
    val email: Rep[String] = column[String]("email", O.Length(1000,varying=true))
    /** Database column media_url SqlType(varchar), Length(1000,true) */
    val mediaUrl: Rep[String] = column[String]("media_url", O.Length(1000,varying=true))
  }
  /** Collection-like TableQuery object for table TeamMember */
  lazy val TeamMember = new TableQuery(tag => new TeamMember(tag))
}
