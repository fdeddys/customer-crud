# customer-crud

## postman

### get 
curl --location --request GET 'http://localhost:8080/api/customer/name/deddy'
curl --location --request GET 'http://localhost:8080/api/customer/id/1'

### post
curl --location --request POST 'http://localhost:8080/api/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"nama1",
    "phone":"0812345"
}'

### put
curl --location --request PUT 'http://localhost:8080/api/customer/tes' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"tes",
"phone": 12345898
}'


### del
curl --location --request DELETE 'http://localhost:8080/api/customer/2'
