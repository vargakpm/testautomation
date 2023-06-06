# Gherkin formátum
Feature: Én, mint a Tesco regisztrált vásárlója be szeretnék lépni a Tesco online áruházába, hogy ott vásárolni tudjak.

  Background:
    Given A belépési oldalon vagyok

  Rule: Helyes belépési adatok esetén a webshop fiókomba jutok

    Scenario: Egyszerű belépés
      When Megadom a regisztrált e-mail cimemet és a helyes jelszót
      Then A rendszer beléptetet a fiókomba

  Rule: Helytelen belépési adatok esetén visszajutok a belépési adatok megadásához

    Scenario: Hibás e-mail cim megadása
      When Megadom a elirva az e-mail cimemet és a helyes jelszót
      Then A rendszer hibaüzenetet ad
      And a belépési adatok megadásánál maradok

    Scenario: Hibás jelszó megadása
      When Megadom a regisztrált e-mail cimemet és egy téves jelszót
      Then A rendszer hibaüzenetet ad
      And a belépési adatok megadásánál maradok

    Scenario: E-mail cim és jelszó nélküli belépési próba
      When Nem adok meg e-mail cimet és jelszót
      Then A rendszer hibaüzenetet ad
      And a belépési adatok megadásánál maradok
