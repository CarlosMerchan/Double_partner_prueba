
Prueba Técnica _ Desarrollador Full Stack Java  esta prueba contiene dos microservicio.

1. Aplicación para ticket el cual implementa Grahpql como metodo de comunicación,el cual usa Jpa para la persistencia en base de datos. 

2. Aplicación para explotar una api de gihub para traer perfiles segun el nombre que se ingrese en la solicitud.


# 📋 Requisitos
Asegúrate de tener instaladas las siguientes herramientas en tu máquina:

- Java 17
- Docker - Docker Compose
- Postman
- Mysql
- IDE de tu preferencia.

⚙️ Instalación
Sigue estos pasos para ejecutar el proyecto en tu máquina local:

## ⚙️ Instalación con Docker

Sigue estos pasos para ejecutar el proyecto en tu máquina local con imagenes Docker:

### 1. Clona el repositorio

    
  Ejecuta el comando **git clone  https://github.com/CarlosMerchan/Double_partner_prueba.git** para tener una copia del poryecto.
    

### 2.Ejecutar el docker compose que viene en la raiz
En la carpeta principal viene el archivo docker compose configurado para descargar y configurar los contenedores.

Para ejecutarlo abre una consola en la carpeta del proyecto, pero antes validar tener el docker encendido.

ahora ejecutamos el comando **docker compose up -d** 

con esto estara listo el ambiente para realizar pruebas.

###### Nota 
- **validar que el puerto 3306** no este ocupado, sino ingresa al docker compose y cambir el puerto del lado izquiero que es el de nuestro equipo,** ejemplo 3307:3306**
- Aplica igualmente para los microservicios, estos tiene los **puertos 9000 y 9001.**

## ⚙️ Instalación y ejecución con IDE(Spring tools, IntelliJ IDEA)

### 1. Clona el repositorio

    
  Ejecuta el comando **git clone  https://github.com/CarlosMerchan/Double_partner_prueba.git** para tener una copia del poryecto.

### 2.Ejecutar el docker compose que viene en la raiz
1. Importar el projecto con el IDE que uses.
2. configurar el properties o yaml de la carpeta  📁 resource con los datos de tu Base de datos, en este caso esta configurado para Mysql
3. Levantar los poyectos para comenzar a realizar pruebas.

###### Nota
- Configurar  con el usuario User y password de tu BD en el application.properties.

# Consultas y Mutaciones en GraphQL

Para comenzar a realizar peticiones a grahpql tienes que ingresar a **http://localhost:9000/graphiql** desde donde se mostrata un consola con la documentación de las peticiones y  podras realizar consultas.



A continuación se muestran ejemplos de consultas y mutaciones en GraphQL que se pueden utilizar para interactuar con el sistema de tickets.

---

## 🎟️ Obtener Ticket por ID

Esta consulta obtiene los detalles de un ticket por su ID:

    
    
    
    query {
      	findTicketById(ticketId: "21") {
       		 id,
       		 creationDate
       		 user {
          		firstName,
          		lastName,
          		email
        }
      }
    }

##✏️ Crear un Nuevo Ticket
Esta mutación permite crear un nuevo ticket con los datos de un usuario:



    mutation{
      createTicket(inputTicket:{
       	 description:"Test de otro de creación de ticket",
       	 inputUser:{
        	  documentNumber: "12345"
         	 firstName: "carlos",
         	 lastName: "test",
         	 email: "testgmail.com"
         	 secondName:"test"
        }
      })
    }
	
## 🛑 Cerrar un Ticket
Esta mutación se utiliza para cerrar un ticket con una solución proporcionada:


    mutation{
      closeTicket(inputCloseTicket:{
        idTicket: "38",
        descriptionSolution: "testFinalSolucion"
      })
    }

##🗑️ Eliminar un Ticket
Esta mutación permite eliminar un ticket mediante su ID:



    mutation{
      deleteTicket(idTicket: "37")
    }
	
	
## 📜 Obtener Todos los Tickets
Esta consulta devuelve una lista de todos los tickets, con paginación. En este caso, se solicita la primera página con 10 tickets por página:



    query{
     	findAllTickets(page:0,size:10){
        id,
        status
      }
    }
	
## 👤 Obtener Tickets de un Usuario Específico
Esta consulta obtiene todos los tickets de un usuario específico, usando su ID y paginación:



    query{
      findTicketsForUser(userId:"12345",page:0,size:5){
        id,
        status
      }
    }
	
## ✏️ Actualizar Usuario
Esta mutación actualiza la información de un usuario específico exceptuando el documento:

    mutation{
      updateUser(inputUser: {
        documentNumber: "1855888",
        firstName: "test",
        secondName: "test",
        lastName: "test",
        email:"dja@dsaf.com"
      })
    }
	

# Consulta para api list de github
para realizar una consulta la puedes hacer a traves del navegado o postman con la siguiente url

**http://localhost:9001/getUsers/{Your Name}**

Cambiar es valor por cualquier nombre en donde estan las llaves {Your name}
