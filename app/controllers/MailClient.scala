package controllers
import play.api.libs.mailer._
import java.io.File
import org.apache.commons.mail.EmailAttachment
import javax.inject.Inject

class MailerService @Inject() (mailerClient: MailerClient) {

  def sendEmail(subject: String, 
    body: String, 
    from: String,
    fromEmail: String,
    to: String,
    toEmail: String,
    ccEmail: String = "") = {
    val email = Email(
      subject,
      s"$from <$fromEmail>",
      Seq(s"$to <$toEmail>"),
      // adds attachment
      // sends text, HTML or both...
      bodyText = Some(body),
      cc = Seq(ccEmail)
    )
    mailerClient.send(email)
  }

}