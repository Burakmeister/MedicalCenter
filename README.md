# MedicalCenter
Aby uruchomić aplikację na urządzeNiu z systemem Linux, należy:
- postawić serwer MySQL, przy pomocy skryptu znajdującego się w pliku script.sql
- w archiwum jar o nazwie "start.jar" znajduje się plik "hibernate.cfg.xml", należy zmienić w nim "connection.username" oraz "connection.password" na takie, które zostały wybrane przy tworzeniu serwera, w polu o nazwie "connection.url" należy wprowadzić adres serwera
uruchomić plik start.jar
- uruchomić plik "start.jar"

Zaimplementowane funkcjonalności:
- tworzenie/modyfikacja/usuwanie pacjentów oraz użytkowników
- tworzenie/modyfikacja/usuwanie projektów badawczych
- deklarowanie/wycofywanie zgód na udział w projekcie

Baza danych oraz struktura projektu pozwala na rozbudowę aplikacji o pozostałe funkcjonalności.
Konto administratora pozwala na tworzenie/usuwanie/edytowanie projektów oraz przypisywanie i wycofywanie zgód pacjentów.
Konto pacjenta umożliwia jedynie edycje danych oraz deklarowanie zgód.
Prawa administracyjne nadawane są wyłącznie bezpośrednio z poziomu bazy danych.

Zrzuty ekranu z działającej aplikacji:
![6BqaFUDrG4](https://user-images.githubusercontent.com/35082302/227746314-133d7856-d48c-4715-97fa-5bd7b9066994.png)
![qLwjQogQ4X](https://user-images.githubusercontent.com/35082302/227746315-34a3d968-ee5f-4934-8b49-82a799b1a0b2.png)
![SqGRO1zxPF](https://user-images.githubusercontent.com/35082302/227746316-2c490d6b-f7db-4cf6-9d60-4f606a588c54.png)
![SPgoNQXH3X](https://user-images.githubusercontent.com/35082302/227746317-8915b5c0-6ed4-4c2f-ab7b-0d22691211a7.png)
![3OJshvRuQW](https://user-images.githubusercontent.com/35082302/227746319-005c50d3-aff3-4b97-9f0a-82ea4309260a.png)
![Coopp1I72D](https://user-images.githubusercontent.com/35082302/227746320-18f9ec32-5991-4fc6-aec3-97f1b682961f.png)
![XMxTkXdFob](https://user-images.githubusercontent.com/35082302/227746321-d37451e0-17e2-49f9-90c4-cd95888b68d6.png)
