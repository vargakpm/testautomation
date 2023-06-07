# Gherkin formátum
Feature: Én, mint a Tesco regisztrált vásárlója be szeretnék lépni a Tesco online áruházába, hogy ott vásárolni tudjak.

  Background:
    Given A belepesi oldalon vagyok
    And cookie-k el vannak fogadva

  Rule: Helyes belépési adatok esetén a webshop fiókomba jutok

    Scenario Outline: Egyszerű belépés
      When Megadom emailCim "<email_cim>" es jelszo "<jelszo>"
      Then A rendszer beleptetet a fiokomba
      Examples:
        | email_cim            | jelszo    |
        | vargakpm@freemail.hu | Tesco0000 |

  Rule: Helytelen belépési adatok esetén visszajutok a belépési adatok megadásához

    Scenario Outline: Hibas e-mail cim megadása
      When Megadom emailCim "<email_cim>" es jelszo "<jelszo>"
      Then A rendszer "<uzenet>" hibauzenetet ad
      And a belepesi adatok megadasanal maradok
      Examples:
        | email_cim             | jelszo    | uzenet |
        | vargakpm@freemmail.hu | Tesco0000 | Sajnos nem sikerült azonosítani a megadott adatokat. Kérjük, ellenőrizd és próbálkozz újra! Ne feledd a kis- és nagy betűk használatát! |

    Scenario Outline: Hibás jelszó megadása
      When Megadom emailCim "<email_cim>" es jelszo "<jelszo>"
      Then A rendszer "<uzenet>" hibauzenetet ad
      And a belepesi adatok megadasanal maradok
      Examples:
        | email_cim             | jelszo    | uzenet |
        | vargakpm@freemail.hu | Tescokkkk | Sajnos nem sikerült azonosítani a megadott adatokat. Kérjük, ellenőrizd és próbálkozz újra! Ne feledd a kis- és nagy betűk használatát! |

    Scenario Outline: E-mail cim és jelszó nélküli belépési próba
      When Megadom emailCim "<email_cim>" es jelszo "<jelszo>"
      Then A rendszer "<uzenet>" hibauzenetet ad
      And a belepesi adatok megadasanal maradok
      Examples:
        | email_cim             | jelszo    | uzenet                            |
        |  |  | Kérjük, adj meg egy e-mail címet! |