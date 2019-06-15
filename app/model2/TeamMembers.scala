package model2

case class TeamMember(name:String,year:String, major:String, email:String, role:String, description:String,imgLink:String) {
  def classDescription:String = major + ", Class of " + year  + " <br> " + email
  def emailName:String = email.split("@").head

}

object TeamMembers {
  def apply():List[TeamMember] = {
    val tmp = FinancialCoordinator :: DesignCoordinator :: OperationsCoordinator :: WebCoordinator :: ProductionCoordinator :: CommunityOutreach :: Nil
    val tmp2 = tmp.sortBy(_.role)
    
    val tmp3 = ExecutiveCoordinator :: tmp2
    tmp3 ++ (DavidStiles :: Nil)
  }
  
  val Anonymous = TeamMember(
      "Anonymous",
      "999",
      "",
      "",
      "",
      "",
      "")
  
  val FinancialCoordinator = TeamMember(
      "Devon Patel",
      "2021",
      "Neuroscience & Spanish Minor",
      "dpatel2@trinity.edu",
      "Financial Coordinator",
      """Devon is a first year student from Las Vegas, Nevada. He intends to major in Neuroscience and minor in Spanish. He aspires to become a neuroradiologist. Outside of TEDxTrinityUniversity, Devon is involved in the Trinity University Chess Club and the First Time Offenders Improv Comedy Troupe. Some of his hobbies include martial arts (he is a second degree black belt in shotokan karate) and cooking/baking. As Financial Coordinator of TEDxTrinityUniversity, Devon is responsible for creating the event budget, ensuring all purchases are in accordance with Trinity University and TEDx policies, and presenting at Student Government Association budget meetings.""",
      "assets/images/dpatel.png"
      )
      
  val DesignCoordinator = TeamMember(
   "Anna Laflin",
   "2019",
   "Art & Business Administration",
   "alaflin@trinity.edu",
   "Design Coordinator",
   """Anna is a junior from Houston, Texas. She is currently double majoring in Art and Business Administration with a concentration in Marketing. After graduation, she plans on continuing to combine her marketing and graphic design skills to help nonprofit organizations get their messages out to the public. When she isn’t drawing, she enjoys hiking, cooking, and traveling. As Design Coordinator, Anna is responsible for designing all TEDx promotional material as well as working with the Production Coordinator to create the event experience. """,
   "assets/images/anna_laflin.jpg"
  )
  
  val OperationsCoordinator = TeamMember(
      "Andrea Cruz",
      "2021",
      "Economics & Psychology",
      "acruz4@trinity.edu",
      "Operations Coordinator",
      """Andrea is a first year student from Chicago, Illinois. She intends to double major in Economics and Psychology. Outside of TEDxTrinityUniversity, Andrea is involved in psychological research exploring the ways food insecurity affects mental health. She is also interested in playing the piano, philosophy, and anything spontaneous. As Operations Coordinator, Andrea is responsible for managing TEDx Salon events, directing group and individual responsibilities, and maintaining TEDxTrinityUniversity’s social media accounts. """,
      "assets/images/andrea_cruz.jpg"
  )
  
  val ProductionCoordinator = TeamMember(
      "Kayla Ellis",
      "2021",
      "Mathematics",
      "kellis@trinity.edu",
      "Production Coordinator",
      """Kayla is a first year student from Lake Jackson, Texas. She intends to major in mathematics and plans to go to law school after graduating from Trinity. Outside of TEDxTrinityUniversity, Kayla is a member of LoonE Crew, a hip hop dance team, and she enjoys spending her free time planning home renovations on Pinterest. As Production Coordinator, Kayla will manage the recording and photographing of any event.. She will also work closely with the Design Coordinator to craft the event attendees’ experience by managing catering and assisting with venue design. """,
      "assets/images/kayla_ellis.jpg"
      )
      
  val ExecutiveCoordinator = TeamMember(
   "Rohan Walawalkar",
   "2020",
   "Anthropology",
   "rwalawal@trinity.edu",
   "Executive Coordinator",
   """Rohan is the founder, primary licensee, and executive coordinator of TEDxTrinityUniversity. Rohan maintains TEDxTrinityUniversity’s relationship with the University and TED and works with the other coordinators to execute on the organization’s vision for its events. Outside the organization, Rohan is an pre-med Anthropology Major passionate about understanding the experience of homelessness and conducts research with people experiencing it. When he isn’t working on classes, TEDx, or his research, he enjoys reading, bouldering, and playing the viola. """,
   "assets/images/rohan_walawalkar.jpg"
  )
  
  val DavidStiles = TeamMember(
      "David Stiles",
      "2021",
      "English",
      "dstiles@trinity.edu",
      "Member",
      """David is a first year student from Houston, TX. He intends to major in English and minor in Education. Outside of TEDxTrinityUniversity, David is a mentor for Saturday Morning Experience. Some of his hobbies include playing guitar, playing Magic: The Gathering, and reading science fiction novels. As a member of TEDxTrinityUniversity, David is helping out wherever he is needed.""",
      "assets/images/david_stiles.jpg"
      )
      
  val CommunityOutreach = TeamMember(
      "Jonathan \"Chappie\" Chapman",
      "2020",
      "French & History",
      "jchapma1@trinity.edu",
      "Community Outreach & Development Coordinator",
      """Jonathan Chapman is a sophomore from College Station, Texas and is attending Trinity University.He is currently pursuing majors in French and History. Jonathan specializes in contemporary European and American history. He hopes to use his education and expand it further with a career in academia; that being said, he is open to all kinds of opportunities and discussion about the directions his education may take him. Some of his hobbies include cooking, playing soccer, and traveling. As Community Outreach and Development Coordinator, it his responsibility to expand TEDxTrinityUniversity’s brand as well as invite interested parties to contribute in order to facilitate the exchange of ideas that the broader community may enjoy.""",
      "assets/images/jonathan_chapman.png"
      )
      
  val WebCoordinator = TeamMember(
      "Jordan Koeller",
      "2019",
      "Physics & Computer Science",
      "jkoeller@trinity.edu",
      "Web Coordinator",
      "Loading... Please wait.",
      "assets/images/jordan_koeller.jpg"
      )
  
  
}