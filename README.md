# f1teams

Az alkalmazás backendjét Java 19, Spring boot és Maven hármas alkotja. 
Spring security védi a végpontokat és a frontend képernyőit.
Az adatbázis inmemory H2 lett, a kezdeti adatfeltöltésről az src/main/resource/data.sql gondoskodik,
ha esetleg kitörölnénk ezt a fájlt, a szükséges táblákat az entitások alapján a hibernate akkor is létrehozza.
Az alkalmazást service, repository rétegek, restController, entitás, dto, valamint ezekhez tartozó mapper osztály alkotja.
Az alkalmazás backendjét az intelliJ F1teamsApplication alap run configjával lehet inditani, ekkor kikerül a 
spring boot embedded tomcatjére és elindul http://localhost:8080 -on.
