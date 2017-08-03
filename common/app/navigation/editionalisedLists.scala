package navigation

import NavLinks2._
import GlobalNavigation._

object NewsSections extends EditionalisedNavList {
  val uk = List(networkFront, ukNews, world, business, environment, tech, politics, science, globalDevelopment, cities, obituaries)
  val au = List(networkFront, australiaNews, world, auPolitics, environment, indigenousAustralia, auImmigration, media)
  val us = List(networkFront, usNews, world, environment, usPolitics, business, science, money, tech, obituaries)
  val int = List(networkFront, world, ukNews, science, cities, globalDevelopment, tech, business, environment, obituaries)
}

object OpinionSections extends EditionalisedNavList {
  val uk = List(
    opinion,
    theGuardianView,
    columnists,
    cartoons,
    inMyOpinion,
    letters,
    NavLink2("", "/profile/pollytoynbee", "Polly Toynbee", opinionPillar, None, None),
    NavLink2("", "/profile/owen-jones", "Owen Jones", opinionPillar, None, None),
    NavLink2("", "/profile/jonathanfreedland", "Jonathan Freedland", opinionPillar, None, None),
    NavLink2("", "/profile/marinahyde", "Marina Hyde", opinionPillar, None, None)
  )
  val au = List(
    opinion,
    auColumnists,
    cartoons,
    indigenousAustraliaOpinion,
    theGuardianView.copy(title="editorials"),
    letters,
    NavLink2("", "/profile/first-dog-on-the-moon", "first dog on the moon", opinionPillar, None, None),
    NavLink2("", "/profile/katharine-murphy", "Katharine Murphy", opinionPillar, None, None)
  )
  val us = List(
    opinion,
    theGuardianView,
    columnists,
    letters,
    NavLink2("", "/profile/jill-abramson", "Jill Abramson", opinionPillar, None, None),
    NavLink2("", "/commentisfree/series/jessica-valenti-column", "Jessica Valenti", opinionPillar, None, None),
    NavLink2("", "/profile/steven-w-thrasher", "Steven W Thrasher", opinionPillar, None, None),
    NavLink2("", "/profile/richard-wolffe", "Richard Wolffe", opinionPillar, None, None),
    inMyOpinion,
    cartoons
  )
  val int = List(
    opinion,
    theGuardianView,
    columnists,
    cartoons,
    inMyOpinion,
    letters
  )
}

object SportSections extends EditionalisedNavList {
  val uk = List(sport, football, rugbyUnion, cricket, tennis, cycling, formulaOne, rugbyLeague, racing, usSports, golf)
  val au = List(sport, football, AFL, NRL, aLeague, cricket, rugbyUnion, tennis)
  val us = List(sport, soccer, NFL, tennis, MLB, MLS, NBA, NHL)
  val int = List(sport, football, rugbyUnion, cricket, tennis, cycling, formulaOne, golf, usSports)
}

object ArtsSections extends EditionalisedNavList {
  val uk = List(culture, tvAndRadio, music, film, stage, books, games, artAndDesign, classical)
  val au = List(culture, film, music, books, tvAndRadio, artAndDesign, stage, games, classical)
  val us = List(culture, film, books, music, artAndDesign, tvAndRadio, stage, classical, games)
  val int = List(culture, books, music, tvAndRadio, artAndDesign, film,games, classical, stage)
}

object LifeSections extends EditionalisedNavList {
  val uk = List(lifestyle, fashion, food, recipes, travel, loveAndSex, family, home, health, women, money)
  val au = List(lifestyle, travel, foodAu, relationshipsAu, fashionAu, healthAu, loveAndSex, family, home)
  val us = List(lifestyle, fashion, food, recipes, loveAndSex, home, health, family, travel, money)
  val int = List(lifestyle, fashion, food, recipes, loveAndSex, health, home, women, family, travel, money)
}

object NetworkFrontSections extends EditionalisedNavList {
  val uk = List(networkFront, ukNews, world, business, environment, tech, football)
  val au = List(networkFront, australiaNews, world, auPolitics, environment, football)
  val us = List(networkFront, usNews, world, usPolitics, business, environment, soccer)
  val int = List(networkFront, world, ukNews, business, science, globalDevelopment, football)
}


object UkNewsSubnav extends EditionalisedNavList {
  val uk = List(ukNews, politics, education, media, society, law, scotland, wales, northernIreland)
  val au = uk
  val us = uk
  val int = uk
}

object WorldSubnav extends EditionalisedNavList {
  val uk = List(world, europe, usNews, americas, asia, australiaNews, middleEast, africa, inequality, cities, globalDevelopment)
  val au = uk
  val us = uk
  val int = uk
}

object MoneySubnav extends EditionalisedNavList {
  val uk = List(money, property, pensions, savings, borrowing, careers)
  val au = uk
  val us = uk
  val int = uk
}

object FootballSubnav extends EditionalisedNavList {
  val uk = List(
    football,
    NavLink2("live scores", "/football/live", "football/live", sportPillar, Some(football), None),
    NavLink2("tables", "/football/tables", "football/tables", sportPillar, Some(football), None),
    NavLink2("competitions", "/football/competitions", "football/competitions", sportPillar, Some(football), None),
    NavLink2("results", "/football/results", "football/results", sportPillar, Some(football), None),
    NavLink2("fixtures", "/football/fixtures", "football/fixtures", sportPillar, Some(football), None),
    NavLink2("clubs", "/football/teams", "football/teams", sportPillar, Some(football), None)
  )
  val au = uk
  val us = uk
  val int = uk
}

object TodaysPaperSubnav extends EditionalisedNavList {
  val uk = List(
    todaysPaper,
    NavLink2("tone/obituaries", "/tone/obituaries", "obituaries", newsPillar, Some(todaysPaper), None),
    NavLink2("", "/theguardian/g2", "g2", newsPillar, Some(todaysPaper), None),
    NavLink2("", "/theguardian/weekend", "weekend", newsPillar, Some(todaysPaper), None),
    NavLink2("", "/theguardian/theguide", "the guide", newsPillar, Some(todaysPaper), None),
    NavLink2("", "/theguardian/guardianreview", "saturday review", newsPillar, Some(todaysPaper), None)
  )
  val au = uk
  val us = uk
  val int = uk
}

object ObserverSubnav extends EditionalisedNavList {
  val uk = List(
    observer,
    NavLink2("", "/theobserver/news/comment", "comment", newsPillar, Some(observer), None),
    NavLink2("", "/theobserver/new-review", "the new review", newsPillar, Some(observer), None),
    NavLink2("", "/theobserver/magazine", "observer magazine", newsPillar, Some(observer), None)
  )
  val au = uk
  val us = uk
  val int = uk
}

object CrosswordsSubnav extends EditionalisedNavList {
  val uk = List(
    crosswords,
    NavLink2("", "/crosswords/crossword-blog", "blog", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/crossword-editor-update", "editor", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/quick", "quick", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/cryptic", "cryptic", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/prize", "prize", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/weekend-crossword", "weekend", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/quiptic", "quiptic", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/genius", "genius", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/speedy", "speedy", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/everyman", "everyman", newsPillar, Some(crosswords), None),
    NavLink2("", "/crosswords/series/azed", "azed", newsPillar, Some(crosswords), None)
  )
  val au = uk
  val us = uk
  val int = uk
}

object BusinessSubnav extends EditionalisedNavList {
  val uk = List(business, economics, banking, money, markets, eurozone)
  val us = List(business, economics, sustainableBusiness, diversityEquality, smallBusiness)
  val au = List(business, markets, money)
  val int = uk
}

object EnvironmentSubnav extends EditionalisedNavList {
  val uk = List(environment, climateChange, wildlife, energy, pollution)
  val us = uk
  val au = List(environment, cities, globalDevelopment, sustainableBusiness)
  val int = uk
}

object TravelSubnav extends EditionalisedNavList {
  val uk = List(travel, travelUk, travelEurope, travelUs)
  val us = List(travel, travelUs, travelEurope, travelUk)
  val au = List(travel, travelAustralasia, travelAsia, travelUk, travelEurope, travelUs)
  val int = uk
}
