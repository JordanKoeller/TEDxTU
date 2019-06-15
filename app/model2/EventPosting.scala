package model2

import java.time.LocalDateTime

case class Speaker(name:String,desc:String)


case class EventPosting(title:String,
    subtitle:Option[String],
   desc:String,
   date:LocalDateTime,
   venue:String,
   maxSeats:Int,
   mediaURL:Option[String],
   speakers:Array[Speaker])