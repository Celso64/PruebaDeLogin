# Prueba de Login y SignUp
## Peticiones
### SignUp
POST
``http://localhost:8080/signup``

Body:
{
"fullName" : "Juan",
"email" : "juan@example.com",
"password" : 1111
}

### Login
POST
`` http://localhost:8080/login ``

Body:
{
"email" : "juan@example.com",
"password" : 1111
}

### Comprobar Login
``http://localhost:8080/user/hola``

**Anexionar el token que devolvio Login en el Header Authorization**
