package model2


abstract class WithID(val id:Int)

abstract class Post(val date:java.sql.Date, val time:java.sql.Time, override val id:Int)  extends  WithID(id) with Serializable {

  def dayOfWeek: String = {
    val dayNum = date.toLocalDate.getDayOfWeek.getValue()
    dayNum match {
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case 7 => "Sunday"
    }
  }

  def timeString:String = {
    val hr = time.toLocalTime.getHour()
    val min = time.toLocalTime.getMinute()
    val hrFormatted = hr % 12
    val amPm = if (hr >= 12) "PM" else "AM"
    val minString = if (min < 10) "0" + min else min
    val hrString = if (hrFormatted == 0) "12" else hrFormatted
    s"$hrString:$minString $amPm"
  }

  def dateNumberString(delimiter: String = "/"): String = {
    val month = date.toLocalDate.getMonth.getValue()
    val day = date.toLocalDate.getDayOfMonth()
    val year = date.toLocalDate.getYear()
    month + delimiter + day + delimiter + year
  }

  def monthSuffix: String = {
    val month = date.toLocalDate.getMonth.getValue()
    month match {
      case 1 => "uary"
      case 2 => "ruary"
      case 3 => ""
      case 4 => ""
      case 5 => ""
      case 6 => ""
      case 7 => "y"
      case 8 => "ust"
      case 9 => "ember"
      case 10 => "ober"
      case 11 => "ember"
      case 12 => "ember"
    }

  }

  def monthPrefix: String = {
    val month = date.toLocalDate.getMonth.getValue()
    month match {
      case 1 => "Jan"
      case 2 => "Feb"
      case 3 => "March"
      case 4 => "April"
      case 5 => "May"
      case 6 => "June"
      case 7 => "Jul"
      case 8 => "Aug"
      case 9 => "Sept"
      case 10 => "Oct"
      case 11 => "Nov"
      case 12 => "Dec"
    }
  }

  def dateString:String = {
    val m = monthPrefix+monthSuffix
    dayOfWeek + ", " + m +" " + date.toLocalDate.getDayOfMonth + " " +  date.toLocalDate.getYear
  }
}