package controllers

import java.time.LocalDateTime
import java.sql.Date
import java.sql.Time
import java.time.ZoneId
import java.time.temporal.ChronoField

import play.api.libs.json._
import slick.jdbc.JdbcProfile
import model2.Tables._

class FormAccepter(profile: JdbcProfile) {

  sealed case class EventJSMapper(title:String, subtitle:String, description:String, venue:String,date:String,time:String,numSeats:String,registrationLink:String,mediaLink:Option[String])
  sealed case class SpeakerJSMapper(name:String, bio:String,image:Option[String])
  sealed case class SpeakerSeqMapper(speakers:Seq[SpeakerJSMapper])
  sealed case class TeamMemberConverter(name:String,position:String,major:String,year:Int,bio:String,mediaURL:String,email:String)
  sealed case class NewspostJSMapper(title:String,subtitle:String,`abstract`:String,body:String,media:String,email:String)
  implicit val eventConverter = Json.reads[EventJSMapper]
  implicit val speakerConverter = Json.reads[SpeakerJSMapper]
  implicit val speakerCol = Json.reads[SpeakerSeqMapper]
  implicit val teamMemberConverter = Json.reads[TeamMemberConverter]
  implicit val newspostConverter = Json.reads[NewspostJSMapper]

  def parseEvent(js:JsValue):EventRow = {
    val jsMapper:JsResult[EventJSMapper] = Json.fromJson[EventJSMapper](js)
    jsMapper match {
      case JsSuccess(item:EventJSMapper,path:JsPath) =>
        val date = item.date
        val time = item.time
        val split = date.split("-")
        val day = split(2).toInt
        val month = split(1).toInt
        val year = split(0).toInt
        val timeSplit = time.split(":")
        val hr = timeSplit(0).toInt
        val min = timeSplit(1).toInt
        val dateTime = LocalDateTime.of(year,month,day,hr,min)
        val epochsec = dateTime.atZone(ZoneId.of("America/Chicago")).getLong(ChronoField.INSTANT_SECONDS) * 1000
        //        val date = event.date.atZone(ZoneId.of("America/Chicago"))
        //        val epochsec = dateTime.getLong(ChronoField.INSTANT_SECONDS) * 1000
        val sqldate = new Date(epochsec)
        val sqltime = new Time(epochsec)
        val regLink = item.registrationLink
        val takenSeats = 0
        val id = 2
        val subOpt = if (item.subtitle != "") Some(item.subtitle) else None
        val media = if (item.mediaLink != "") Some("https://drive.google.com/uc?id="+item.mediaLink.get) else None
        EventRow(id,item.title,subOpt,item.description,item.venue,sqldate,sqltime,item.numSeats.toInt,takenSeats,regLink,media)
      case e: JsError =>
        println("Failed to construct JSValue currectly.")
        println("FAILED ON THE ERROR " + e.toString)
        null
    }
  }

  def parseSpeakers(js:JsValue,eventID:Int):Array[SpeakersRow] = {
    //    val list = js.as[List[SpeakerJSMapper]]
    val jsMapper:JsResult[Seq[SpeakerJSMapper]] = Json.fromJson[Seq[SpeakerJSMapper]](js)
    jsMapper match {
      case JsSuccess(item:Seq[SpeakerJSMapper],path:JsPath) =>
        val tmpId = 3
        item.map{ elem =>
          val img = if (elem.image.isDefined) "https://drive.google.com/uc?id=" + elem.image.get else ""
          SpeakersRow(tmpId,eventID,elem.name,elem.bio,img)
        }.toArray
      case e: JsError =>
        println(e.toString())
        println("Failed to parse the speaker correctly.")
        null
    }

  }

  def parseMember(js:JsValue):TeamMemberRow = {
    val jsMapper:JsResult[TeamMemberConverter] = Json.fromJson[TeamMemberConverter](js)
    jsMapper match {
      case JsSuccess(item:TeamMemberConverter,path:JsPath) =>
        val emailHead = item.email.split("@").head
        val imgName = "https://drive.google.com/uc?id="+item.mediaURL
        TeamMemberRow(2,1,item.name,item.position,item.major,item.year,item.bio,item.email,imgName)
      case e: JsError =>
        println("Couldn't construct team member")
        println(e.toString())
        null
    }
  }

  def parseNewsArticle(js:JsValue,db:model2.Tables.profile.backend.Database):(NewsletterPostRow,String) = {
    val jsMapper: JsResult[NewspostJSMapper] = Json.fromJson[NewspostJSMapper](js)
    jsMapper match {
      case JsSuccess(item: NewspostJSMapper, path: JsPath) =>
        val date = new java.util.Date()
        val sqlDate = new java.sql.Date(date.getTime)

        val media = if (item.media != "") Some("https://drive.google.com/uc?id="+item.media) else None
        (NewsletterPostRow(0, sqlDate, item.body, -1, item.title, item.subtitle, item.`abstract`, media), item.email)
      case e: JsError =>
        println("Failed parsing the newsarticle")
        null
    }
  }
}
