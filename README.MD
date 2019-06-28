# ePatient Backend

## Swagger with basic authentication

To use authenticated requests in swagger, you have to:
1. create patient account with `/user-management/patient`
1. Request to `/login` endpoint to retrieve JWT token
```
   curl -i -H "Content-Type: application/json" -X POST -d '{
       "username": "username",
       "password": "password"
   }' http://localhost:8080/login

```
1. Copy Authorization Header and pass to Authorize section in Swagger UI `Bearer <JWT>`