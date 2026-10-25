# Rush Hour 

Kétszemélyes játék melnyek mérete 6 sor x 12 oszlop.

A mezők koordináta jelölései a következők:

    -Oszlopok jelölése (a,b,c,...)
    -Sorok jelölése (1,2,3,....)


Induláskor kapunk egy előre definiált pályát (akadályok és 2db céljármű).

Lehetsőgénük van pálya beolvasására is (txt, xml, json).

A járművek CSAK vertikálisan VAGY horizontálisan tudnak mozogni, melyeknek hossza 2-3 egység lehet.

Mindig a human játékos kezdi a játékot.

Csak érvényes művelet hajtható végre a körökben.

A soron lévő játékos bármelyik járművet elmozdíthajta (saját, ellenfél, akadály)

Egy jármű a körében bármekkora egységet elmozdulhat a körében.

A járművek nem ugorhatják át egymást, fedhetik egymást, fordíthatók el, vagy mehetnek le a pályáról.

A gépi játékos véletelnül választ egy ellenséges figurát és véletlen lépést végrehajt, addig ismételve amíg nem talál egy lehetségest.

Az a játékos nyer amelyik sikeresen kijut a kijáraton a saját koordinátáján.





# Elvárások

○ A repository tartalmaz egy megfelelő .gitignore fájlt annak érdekébe, hogy IDE
vagy Maven specifikus ideiglenes fájlok ne kerüljenek fel a repository ba

○ Egy Java 21-es Maven projekt létrehozása (pom.xml és Maven folder
struktúra)

○ A Maven projekt az alábbi konfigurációkat tartalmazza:
■ Plugin-ek:
■ org.apache.maven.plugins.maven-jar-plugin - annak
érdekében, hogy felkonfiguráljuk az alkalmazásunk belépési
pontját (Main Class)

■ org.apache.maven.plugins.maven-assembly-plugin - annak
érdekében, hogy egy függőségeket tartalmazó, futtatható
JAR fájl jöjjön létre az alkalmazás build-elése
eredményeként

■ org.jacoco.jacoco-maven-plugin - annak érdekében, hogy a
megírt Egység tesztek kód lefedettségét tudjuk mérni

■ org.apache.maven.plugins.maven-checkstyle-plugin - annak
érdekében, hogy a projekten elkövetett kód formázási
hibákat és egyéb rossz praktikák automatikus detektáljunk

■ Függőségek:
■ JUnit5
■ Mockito
■ Logback

○ Az alkalmazás objektum-orientált modellezése

■ Az alkalmazásunkhoz szükséges VO (Value Object) osztályok
létrehozása (ügyelve és figyelembe véve a "best practice"-eket:
Object methods overriding, Immutability, stb)

■ A teljes Connect4 játék funkcionalitás lefejlesztésre került
(lehetséges egy játékot végig játszani elejétől a végéig)

■ A játékmenet sem a main metódusban történjen, hanem egy Game
vagy hasonló nevű objektum start() metódushiivása történjen

○ Az induláskor egy szövegfájlból beolvas egy játékállást, ha nincs meg az
input fájl, akkor üres pályáról indulunk

○ Az alkalmazás képes kezdetleges felhasználói interakciókat fogadni

    ■ egy szövegfájlból betölteni egy pályát

    ■ egy szövegfájlba kiÍrni egy pályát

■ Például: Játékos nevének bekérése, Játék elindítása, a játéktér
kiiratása, Egy lépés fogadása a parancssoron, a lépés vizsgálata
abból a szempontból, hogy alkalmazható-e; a lépés alkalmazása
és az eredmény kiírása, stb

■ Itt nem határozunk meg kötelező elvárásokat, tetszőleges
interakciók elegendőek

○ Egység tesztek 80% lefedettséget biztosítanak üzleti logikát tartalmazó
osztályokra (tehát például VO osztályokra nem szükséges
egységteszteket írni)
●

○ A projekt a mvn clean install parancs futtatására hiba nélkül fordul 

○ Az alkalmazás egy adatbázisba lementi a játékosok nevét és azt, hogy
hányszor nyertek

■ Az alkalmazás képes megjeleníteni parancssorban egy high score
táblázatot (melyik játékos hány meccset nyert)

○ Opcionális (plusz pontért): egy aktuálisan folyamatban lévő játék állást az
alkalmazás képes egy XML fájlba kimenteni és később visszatölteni (tehát
a játékos onnan folytathatja a játékot, ahol korábban abba hagyta)

○ Egység tesztek 80% lefedettséget biztosítanak üzleti logikát tartalmazó
osztályokra