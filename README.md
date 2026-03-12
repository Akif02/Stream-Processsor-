# StreamProcessor - Uni Praktikumsaufgabe

Dieses Projekt wurde im Rahmen eines Uni-Praktikums erstellt. Es befasst sich mit der effizienten Verarbeitung von Datenströmen (Streams) in Java, dem Einlesen von Zahlen aus Dateien und der Implementierung robuster Fehlerbehandlungsmechanismen.

## Projektübersicht

Der **StreamProcessor** ist ein Java-basiertes Werkzeug, das Zahlen aus Textdateien einliest, diese über einen spezialisierten `NumberInputStream` verarbeitet und validiert. 

### Kernkomponenten:
- **`NumberInputStream`**: Ein benutzerdefinierter Input-Stream zur Validierung und Verarbeitung von numerischen Datenströmen.
- **`NumberToLargeException`**: Eine spezifische Exception-Klasse zur Behandlung von Grenzwertüberschreitungen während des Einlesevorgangs.
- **`Base64Writer`**: Implementierung zur Umwandlung und Speicherung von Daten im Base64-Format.
- **JUnit Tests**: Umfassende Testabdeckung (insbesondere für den `Base64Writer`), um die funktionale Korrektheit sicherzustellen.

## Installation & Ausführung

### Voraussetzungen
- Java JDK 11 oder höher
- Maven (zur Verwaltung von Abhängigkeiten und zum Ausführen von Tests)

### Kompilieren
Um das Projekt zu bauen, führe folgenden Befehl im Hauptverzeichnis aus:
```bash
mvn compile
```

### Ausführen
Das Programm erwartet einen oder mehrere Dateinamen als Kommandozeilenargumente:
```bash
java -cp target/classes org.example.Main <dateiname1> [dateiname2 ...]
```

### Tests ausführen
Um die integrierten JUnit-Tests zu starten:
```bash
mvn test
```

## Autor
- Mehmet Akif Erdem (Erstellt als Teil der akademischen Leistungen im Informatikstudium)
