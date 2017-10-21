## Korišteni alati/tehnologije

* Java
* MySQL
* [Hibernate ORM](http://hibernate.org/orm/)
* [Netbeans IDE](https://netbeans.org/)
* [Apache PDFBox](https://pdfbox.apache.org/)
* [Apache POI](https://poi.apache.org/)
* [LGoodDatePicker](https://github.com/LGoodDatePicker/LGoodDatePicker)
* [Google Static Maps API](https://developers.google.com/maps/documentation/static-maps/)
* [Google Geocoding API](https://developers.google.com/maps/documentation/geocoding/intro)

## Sažetak

Event Manager je Java desktop aplikacija koja služi kao katalog glazbenih, kulturnih i drugih događanja i ulaznica te evidenciju narudžbi istih od strane korisnika. Korisničko sučelje aplikacije izrađeno je u Swing okruženju, dok se podaci spremaju u MySQL bazu podataka na lokalnom disku. Za posredstvo između korisničkog sučelja i baze odgovoran je Hibernate ORM alat.

Sama aplikacija sastoji se od glavnog prozora u kojem se izmjenjuje nekoliko panela, ovisno o kategoriji odabranoj u glavnom izborniku.

1. Kategorija "Eventi" omogućava čitanje, unos, promjenu i brisanje eventa u/iz baze podataka (CRUD). Evente se može pretraživati i sortirati na različite načine. Svakom eventu moguće je dodjeliti datum i mjesto održavanja te pripadajuće ulaznice.

<img src="screenshots/ss01.PNG" width="350" height="250" />   <img src="screenshots/ss07.PNG" width="350" height="250" />

2. U Kategoriji "Lokacije", uz CRUD, koriste si i Google-ovi Static Maps i Geocoding API-ji. Oni omogućavaju lociranje i iscrtavanje karte za određene koordinate, na osnovu naziva, adrese ili mjesta koje korisnik unese.

<img src="screenshots/ss02.PNG" width="350" height="250" />

3. Kategorija "Osobe" odgovorna je za CRUD kupaca te sadrži popis naselja u Republici Hrvatskoj s pripadajućim poštanskim brojevima(preuzeto od [ndekic](https://github.com/ndekic/popis_naselja_u_republici_hrvatskoj))

<img src="screenshots/ss03.PNG" width="350" height="250" />   <img src="screenshots/ss08.png" width="350" height="250" />

4. U kategoriji "Narudžbe" implementiran je jednostavan sustav izrade narudžbi putem košarice. Također je moguće narudžbe izraditi i pohraniti u PDF formatu.

<img src="screenshots/ss04.PNG" width="350" height="250" />

5. Kategorija "Pregled" sadrži sve bitne podatke na jednom mjestu u obliku tablica te omogućava brzo i jednostavno sortiranje i pretraživanje. Za svaku tablicu moguće je izraditi i pohraniti Excel datoteku.

<img src="screenshots/ss05.PNG" width="350" height="250" />

6. Za kraj, pritiskom na ikonu žarulje moguće je promjeniti vizualnu temu aplikacije:

<img src="screenshots/ss06.PNG" width="350" height="250" />








