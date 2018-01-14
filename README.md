# Docker-Spring-Cloud

## Sebelum menjalankan aplikasi, berikut tool yang harus diinstall terlebih dahulu

* Lakukan Instalasi [Gradle](https://gradle.org/)
* Lakukan Instalasi [Docker](https://www.docker.com/) dan [Docker Compose](https://docs.docker.com/compose/), jika pengguna linux, silahkan lihat di artikel [Belajar Docker](https://rizkimufrizal.github.io/belajar-docker/)

## Cara Menjalankan Aplikasi Jika menggunakan Linux dan OSX

* Jalankan file shell `docker-build.sh` untuk proses build project
* Jalankan perintah `docker-compose up` untuk menjalankan 11 container secara berbarengan

## Cara Menjalankan Aplikasi Jika menggunakan Windows

* Jalankan perintah berikut secara berurutan
  ```bash
  gradle clean build docker -p Admin-Dashboard
  gradle clean build docker -p Transaction-Service
  gradle clean build docker -p Catalog-Service
  gradle clean build docker -p OAuth2-Service
  gradle clean build docker -p API-Gateway
  ```
* Jalankan perintah `docker-compose up` untuk menjalankan 11 container secara berbarengan

## Cara Mengakses Aplikasi

* Jalankan perintah berikut untuk mengenerate token OAuth2 :

```bash
curl -X POST \
  http://localhost:8080/v1/api/oauth/token \
  -vu clientid:secret \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d grant_type=client_credentials
```

dan berikut adalah contoh hasil token nya :

```json
{
  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiUkVTT1VSQ0VfSURfQVBJX0dBVEVXQVkiXSwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUxNTkwMjEwMiwiYXV0aG9yaXRpZXMiOlsiQURNSU5JU1RSQVRPUiIsIkNMSUVOVCIsIkFETUlOIl0sImp0aSI6ImMzMjg1YTU4LWZiNGQtNDQ5ZS1iMTZkLWVlZjNhZDcxMDFhZCIsImNsaWVudF9pZCI6ImNsaWVudGlkIn0.hPzJeSHX8_I_h6VCXIn2nlZJ5pA-0ULWI65Gd15AatiG2g5RhTNT4JUyi-LnNr8ZFwZiPU4KhzZczKNh71yBJ1sskZ3DmqdDtrsOyUciOO11e9HCp4sj8obGDzFwaG1kKKoEDwQarTeUbmjlAY6AGA1BYSFNkiJzHuFtlwOnVYXHoUUZ6CSvOMD03VAuoHgrgUhwjqr8lzouKUwAuR1RvsUJOan-I5bisrLG4mgsX221x9z4x9F2_0ufHDWRxT76bgOThOfqoGdpBn0sNp0IP3NNHXcW4P81QZLYoUQh1Lp1LPdsYMpbA4ywIinPplVOjD7jNhQtEu0mxrY3DxnhyQ",
  "token_type": "bearer",
  "expires_in": 3599,
  "scope": "read write",
  "jti": "c3285a58-fb4d-449e-b16d-eef3ad7101ad"
}
```

* Akses Catalog service service dengan menggunakan perintah berikut

```bash
curl -X GET \
  http://localhost:8080/v1/catalog/api/barangs \
  -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiUkVTT1VSQ0VfSURfQVBJX0dBVEVXQVkiXSwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUxNTkwMjEwMiwiYXV0aG9yaXRpZXMiOlsiQURNSU5JU1RSQVRPUiIsIkNMSUVOVCIsIkFETUlOIl0sImp0aSI6ImMzMjg1YTU4LWZiNGQtNDQ5ZS1iMTZkLWVlZjNhZDcxMDFhZCIsImNsaWVudF9pZCI6ImNsaWVudGlkIn0.hPzJeSHX8_I_h6VCXIn2nlZJ5pA-0ULWI65Gd15AatiG2g5RhTNT4JUyi-LnNr8ZFwZiPU4KhzZczKNh71yBJ1sskZ3DmqdDtrsOyUciOO11e9HCp4sj8obGDzFwaG1kKKoEDwQarTeUbmjlAY6AGA1BYSFNkiJzHuFtlwOnVYXHoUUZ6CSvOMD03VAuoHgrgUhwjqr8lzouKUwAuR1RvsUJOan-I5bisrLG4mgsX221x9z4x9F2_0ufHDWRxT76bgOThOfqoGdpBn0sNp0IP3NNHXcW4P81QZLYoUQh1Lp1LPdsYMpbA4ywIinPplVOjD7jNhQtEu0mxrY3DxnhyQ'
```

dan berikut adalah contoh hasil token nya :

```json
{
  "content": [
    {
      "idBarang": 1,
      "namaBarang": "Barang 1",
      "jenisBarang": "gas",
      "tanggalKadaluarsa": {
        "year": 2018,
        "month": "JANUARY",
        "leapYear": false,
        "dayOfMonth": 14,
        "dayOfWeek": "SUNDAY",
        "dayOfYear": 14,
        "era": "CE",
        "monthValue": 1,
        "chronology": {
          "calendarType": "iso8601",
          "id": "ISO"
        }
      },
      "hargaSatuanBarang": 5000,
      "jumlahBarangTersedia": 6
    },
    {
      "idBarang": 2,
      "namaBarang": "Barang 2",
      "jenisBarang": "cair",
      "tanggalKadaluarsa": {
        "year": 2018,
        "month": "JANUARY",
        "leapYear": false,
        "dayOfMonth": 14,
        "dayOfWeek": "SUNDAY",
        "dayOfYear": 14,
        "era": "CE",
        "monthValue": 1,
        "chronology": {
          "calendarType": "iso8601",
          "id": "ISO"
        }
      },
      "hargaSatuanBarang": 10000,
      "jumlahBarangTersedia": 7
    }
  ],
  "totalPages": 1,
  "totalElements": 10,
  "last": true,
  "numberOfElements": 10,
  "first": true,
  "sort": null,
  "size": 20,
  "number": 0
}
```

* Akses Transaction service service dengan menggunakan perintah berikut

```bash
  curl -X GET \
    http://localhost:8080/v1/transaction/api/penjualan/penjualandetails/1 \
    -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiUkVTT1VSQ0VfSURfQVBJX0dBVEVXQVkiXSwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUxNTkwMjEwMiwiYXV0aG9yaXRpZXMiOlsiQURNSU5JU1RSQVRPUiIsIkNMSUVOVCIsIkFETUlOIl0sImp0aSI6ImMzMjg1YTU4LWZiNGQtNDQ5ZS1iMTZkLWVlZjNhZDcxMDFhZCIsImNsaWVudF9pZCI6ImNsaWVudGlkIn0.hPzJeSHX8_I_h6VCXIn2nlZJ5pA-0ULWI65Gd15AatiG2g5RhTNT4JUyi-LnNr8ZFwZiPU4KhzZczKNh71yBJ1sskZ3DmqdDtrsOyUciOO11e9HCp4sj8obGDzFwaG1kKKoEDwQarTeUbmjlAY6AGA1BYSFNkiJzHuFtlwOnVYXHoUUZ6CSvOMD03VAuoHgrgUhwjqr8lzouKUwAuR1RvsUJOan-I5bisrLG4mgsX221x9z4x9F2_0ufHDWRxT76bgOThOfqoGdpBn0sNp0IP3NNHXcW4P81QZLYoUQh1Lp1LPdsYMpbA4ywIinPplVOjD7jNhQtEu0mxrY3DxnhyQ'
```

dan berikut adalah contoh hasil token nya :

```json
[
  {
    "idPenjualanDetail": "1.detail",
    "jumlahBarang": 6,
    "totalHargaPerBarang": 1000,
    "idPenjualan": "1",
    "barang": {
      "idBarang": 1,
      "namaBarang": "Barang 1",
      "jenisBarang": "gas",
      "tanggalKadaluarsa": {
        "year": 2018,
        "month": "JANUARY",
        "leapYear": false,
        "dayOfMonth": 14,
        "dayOfWeek": "SUNDAY",
        "dayOfYear": 14,
        "era": "CE",
        "monthValue": 1,
        "chronology": {
          "calendarType": "iso8601",
          "id": "ISO"
        }
      },
      "hargaSatuanBarang": "5000.00",
      "jumlahBarangTersedia": 6
    }
  }
]
```

## List Docker Container

1. consul : digunakan sebagai consul server
2. zipkin : digunakan sebagai zipkin server
3. postgrescatalog : digunakan sebagai database postgresql
4. mongotransaction : digunakan sebagai database mongodb
5. mariadboauth2 : digunakan sebagai database mariadb
6. redissessionoauth2 : digunakan sebagai database redis
7. admindashboard : digunakan sebagai admin dashboard
8. catalogservice : digunakan sebagai service catalog
9. transactionservice : digunakan sebagai service transaction
10. oauth2service : digunakan sebagai service oauth2
11. apigateway : digunakan sebagai apigateway

## List Screenshot

* Discovery Service Consul

![discovery service](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.53.28.png)

* Node Consul

![node consul](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.53.46.png)

* KV Consul

![KV Consul](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.53.56.png)

* Spring Boot Admin

![Spring Boot Admin](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.54.13.png)

* Spring Boot Admin Trace

![Spring Boot Admin Trace](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.54.37.png)

* Hystrix

![hystrix](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.55.26.png)

* Journal

![Journal](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.55.44.png)

* Zipkin

![Zipkin](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.57.06.png)

* Zipkin Trace

![Zipkin Trace](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.57.10.png)

* Trace Client To API Gateway

![Trace Client To API Gateway](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.57.35.png)

* Trace API Gateway To Service

![Trace API Gateway To Service](https://github.com/RizkiMufrizal/Docker-Spring-Cloud/blob/master/screenshot/Screen%20Shot%202018-01-14%20at%2009.57.39.png)
