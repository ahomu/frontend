package navigation

object GlobalNavigation {

  val newsPillar = Pillar(
    "network front",
    "/",
    "news",
    NewsSections
  )

  val opinionPillar = Pillar(
    "commentisfree",
    "/commentisfree",
    "opinion",
    OpinionSections
  )

  val sportPillar = Pillar(
    "sport",
    "/sport",
    "sport",
    SportSections
  )

  val artsPillar = Pillar(
    "culture",
    "/culture",
    "arts",
    ArtsSections
  )

  val lifePillar = Pillar(
    "lifeandstyle",
    "/lifeandstyle",
    "life",
    LifeSections
  )

  val pillars = List(newsPillar, opinionPillar, sportPillar, artsPillar, lifePillar)
}
