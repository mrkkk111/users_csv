# users_csv

## link to heroku

https://csv-spring-app.herokuapp.com/csv/search

(can take some time - up to 90s to start up because of a free hosting account)


## description
The main objective of this sample project was to create
a spring boot based app using pagination and H2 databse. The frontend was not of a primary concern
and was created using ThymeLeaf, Bootstrap and JQuery.

This app is supposed to process a csv file that contains user data.
A test file below is missing some data, but can be enhanced, parsed and stored in the DB.

This [test file](https://raw.githubusercontent.com/mrkkk111/users_csv/master/csv/txt.csv) is included in the csv directory in the project root,<br/>
to save it on the hard drive please follow the link and hit ctrl + s.

```first_name;last_name;birth_date;phone_no
Stefan;Testowy;1988.11.11;600700800
Maria;Ziółko;1999.1.1;555666777;
Stefan;Testowy;1988.11.11;600700801
Maria;Ziółko;1999.1.1;555666778;
;;;
Jolanta;Magia;2000.02.04;666000111

 marian;kowalewski;1950.10.01;670540120
Zygmunt;	Stefanowicz;1991.06.01;-
Ernest;Gąbka;1991.06.01;
Elżbieta;Żółw;1988.03.03;670540120
Jolanta;Magia;2000.02.04;666000112

 marian;kowalewski;1950.10.01;670540121
 marian;kowalewski;1950.10.01;670540124
Andrzej;Testowy;1988.10.11;600700807
```
