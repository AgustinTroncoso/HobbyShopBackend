# Funcionalidades por integrante:
Sebastián Ávila Fica:

Funciones Gestión de Usuario: Permiten la manipulación de los datos relacionados a los usuarios y a su interacción dentro de la aplicación. Estas funciones serán:
- Registro
- Login
- Edición Perfil
- Detalles Perfil
- Historial Compra/Venta
- Historial Reseñas


Agustín Troncoso Rojas:

Funciones Gestión de Productos: Permiten la manipulación de los productos, considerando que un usuario puede publicar, vender y comprar productos. Estas funciones serán:

- Vista Producto
- Compra Producto
- Publicación Producto
- Eliminación Producto
- Creación Reseñas


## Instalación de Proyecto
En la consola, se debe ejecutar la siguiente secuencia de comandos:
```
git clone https://github.com/fakeChiaki/Grupo_N2--HobbyShop.git
```
Luego, se debe ir a la ruta del proyecto:
```
cd Grupo_N2--HobbyShop
```
Nota: Se debe contar con `Node.js` y `npm` con anterioridad.


## Setup librerias
Instalar librerias:

```
npm install
```

Este comando debería instalar todas las librerias usadas dentro del proyecto. En caso de no funcionar, se pueden instalar individualmente con los siguientes comandos dentro de la consola:

Vuelidate:

```
npm install @vuelidate/core @vuelidate/validators
```

Vue-Router:

```
npm install vue-router
```

Axios:

```
npm install axios
```



## Setup JSON
Se debe abrir una terminal integrada desde la carpeta json. Luego de esto, se debe correr el comando:
```json-server --watch ./data.json``` 

## Correr programa
Se debe abrir la terminal de preferencia, donde se debe ejecutar el comando: `npm run dev`

