# Gherkin formátum
Feature: Én, mint a Tesco online vásárlója, egy adott terméket szeretnék kikeresni az áruházban, hogy azt a kosaramba tudjam rakni.

  Background:
    Given A belepes utani nyito oldalon vagyok
    And cookie-k el vannak fogadva

  Rule: Létező termék keresése esetén feljön a találati lista

    Scenario Outline: Letezo termek keresese eseten feljon a talalati lista
      When A keresoben megadom "<termek>" termeknev
      Then Megjelenik a talalati lista
      Examples:
        | termek         |
        | Univer ketchup |

    Scenario Outline: Konkret termek keresese eseten csak az van a talalati listaban
      When A keresoben megadom "<termek>" termeknev
      Then Megjelenik a talalati lista
      Examples:
        | termek              |
        | Univer ketchup 1 kg |

  Rule: Nem létező termék esetén üres listát kapok

    Scenario Outline: Nem letezo termeknev megadása
      When A keresoben megadom "<termek>" termeknev
      Then Megjelenik nem letezo termeknev uzenet
      Examples:
        | termek            |
        | sapka |
