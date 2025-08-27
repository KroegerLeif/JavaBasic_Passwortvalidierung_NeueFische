# Passwortvalidierung

Programm zur Passwortvalidierung in Java als Teil des Java Basics Abschnitts.

## Beschreibung

Dieses Projekt implementiert verschiedene Validierungsregeln für Passwörter.

## Policy

- Java 24
- Maven 3.9.11
- Unit-Tests mit JUnit 5
- CI-Integration über GitHub Actions
- Developet with TDD

## Installation

```bash
git clone <repository-url>
cd JavaBasic_Passwortvalidierung_NeueFische
mvn clean install
```

## Build
Build ist erfolgreich.
```bash
mvn clean install
```

## Run
Aktuell lässt sich nur die Test Klase ausführen.

## Test
```bash
mvn test
````
Paswort Validatoren werden getestet. In der Test Klasse. Aktuell sind 18 Tests vorhanden.


## Validation
```bash
mvn clean verify
```

## Passwortvalidierung
### Voraussetzungen für ein gutes Passwort:
1. Mindestens 8 Zeichen,
2. Mindestens eine Ziffer (0–9),
3. Groß- und Kleinbuchstaben (beides muss vorkommen),
4. nicht in einer Liste häufiger/schwacher Passwörter. 
5. Mindestens ein Sonderzeichen (definiere erlaubte Menge)

~~2. Mindestanzahl unterschiedlicher Zeichengruppen (z. B. 3 von 4: Groß, Klein, Ziffer, Sonderzeichen).~~


## Beispiel Aufrufe
Content wird noch erstellt.

## CI Status
Badge Zeigt aktuellen Status der CI.
Hacken heißt verendbar.

## Lizenz
Veränderungen am Code und Verbreitung sind erlaubt.