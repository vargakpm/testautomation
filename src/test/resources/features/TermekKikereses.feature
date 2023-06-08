# Gherkin formátum
Feature: Én, mint a Tesco online vásárlója, egy adott terméket szeretnék kikeresni az áruházban, hogy azt a kosaramba tudjam rakni.

  Background:
    Given Az "email_cim" es "jelszo" megadása utani nyito oldalon vagyok
    And cookie-k el vannak fogadva

  Rule: Létező termék keresése esetén feljön a találati lista

    Scenario Outline: Letezo termek keresese eseten feljon a talalati lista
      When A keresoben megadom "<keresendo>" termeknev
      Then Megjelenik a talalati lista
      Examples:
        | keresendo         | email_cim            | jelszo    |
        | Univer ketchup | vargakpm@freemail.hu | Tesco0000 |

    Scenario Outline: Konkret termek keresese eseten csak az van a talalati listaban
      When A keresoben megadom "<keresendo>" termeknev
      Then Megjelenik a talalati lista
      Examples:
        | keresendo           |
        | Univer ketchup 1 kg |

  Rule: Nem létező termék esetén üres listát kapok

    Scenario Outline: Nem letezo termeknev megadása
      When A keresoben megadom "<keresendo>" termeknev
      Then Megjelenik nem letezo termeknev uzenet
      Examples:
        | keresendo   |
        | sapka       |
