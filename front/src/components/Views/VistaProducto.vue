<template>
  <div>
    <Header />
    <div class="fondo">
      <div class="fondoimagen">
        <img :src="imageUrl" alt="imagen" class="imagen" />
      </div>
      <div class="columna">
        <span class="nombre">{{ nombreproducto }}</span>
        <span class="precio">Precio: {{ precio }}</span>
        <span class="vendedor">Vendedor: Andrés</span>
        <span class="stock">Stock: {{ stock }}</span>
      </div>
      <span class="descripcion">Descripcion:<br />{{ Descripcion }}</span>
      <button class="compra" @click="comprarProducto">Comprar</button>
      <button class="eliminar" @click="eliminarProducto">Eliminar</button>
      <RouterLink to="/Resenacreacion">Reseñar</RouterLink>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';
import Header from '../Header.vue';

const route = useRoute();
const router = useRouter();
const id = ref(route.params.id);

const nombreproducto = ref('');
const precio = ref('');
const imageUrl = ref('');
const stock = ref('');
const Descripcion = ref('');

const fetchProducto = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/productos/${id.value}`);
    const producto = response.data;
    nombreproducto.value = producto.nombreproducto;
    precio.value = producto.precio;
    imageUrl.value = producto.imageUrl;
    stock.value = producto.stock;
    Descripcion.value = producto.Descripcion;
  } catch (error) {
    console.error('Error al cargar el producto:', error);
  }
};

const comprarProducto = async () => {
  try {
    const productoCarrito = {
      id: id.value,
      nombreproducto: nombreproducto.value,
      precio: precio.value,
      imageUrl: imageUrl.value,
      stock: stock.value,
      descripcion: Descripcion.value
    };

    const response = await axios.post('http://localhost:8080/api/carritos/1/agregar-producto', productoCarrito);
    console.log('Producto agregado al carrito:', response.data);
    alert('Producto agregado al carrito con éxito');
  } catch (error) {
    console.error('Error al agregar el producto al carrito:', error);
    alert('Error al agregar el producto al carrito');
  }
};

const eliminarProducto = async () => {
  try {
    await axios.delete(`http://localhost:8080/api/productos/${id.value}`);
    alert('Producto eliminado con éxito');
    router.push('/');
  } catch (error) {
    console.error('Error al eliminar el producto:', error);
    alert('Error al eliminar el producto');
  }
};

onMounted(fetchProducto);
</script>

<style scoped>
a{
  background-color: rgb(19, 172, 149);
  color: white;
  padding: 1rem 2rem;
  top: 45%;
  border-radius: 10px;
  text-decoration: none;
  left:15%;
  position: relative;
}
.eliminar {
  background-color: red;
  color: white;
  border: none;
  position: relative;
  width: 200px;
  height: 50px;
  top: 45%;
  left: -10%;
  border-radius: 10px;
  font-size: 20px;
  cursor: pointer;
  transition: all .2s ease-in-out; 
}
.eliminar:hover {
  transform: scale(1.1);  
}
.compra:hover{
  transform: scale(1.1);  
}
.compra {
  background-color: #00993d;
  color: #ffffff;
  border-radius: 10px;
  font-size: 20px;
  position: relative;
  width: 200px;
  height: 50px;
  top: 45%;
  left: 80%;
  border: none;
transition: all .2s ease-in-out; 
}

.fondo {
  border-radius: 10px;
  background-color: #103973;
  top: 12%;
  left: 10%;
  position: absolute;
  height: 600px;
  width: 1200px;
}
.fondoimagen {
  background-color: #00133b;
  border-radius: 10px;
  position: relative;
  top: 10px;
  left: center;
  height: 45%;
  width: 50%;
  display: flex;
  left: 5%;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
.imagen {
  height: 250px;
  border-radius: 10px;
  position: absolute;
  top: 10px;
  width: 309px;
} 
.columna {
  position: absolute;
  top:  -17%;
  left: 57.34%;
  
}
.nombre {
  background-color: #00133b;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
  flex-basis: auto;
  position: absolute;
  width: 426px;
  height: 52px;
  top: 120px;
  color: #ffffff;
  font-family: Inter, var(--default-font-family);
  font-size: 20px;
  font-weight: 400;
  line-height: 43.568px;
  text-align: center;
  white-space: nowrap;
  z-index: 10;
}
.precio {
  background-color: #00133b;
  display: flex;
  align-items: center;
  border-radius: 10px;
  justify-content: center;
  
  position: absolute;
  width: 426px;
  height: 52px;
  top: 190px;
  color: #ffffff;
  font-family: Inter, var(--default-font-family);
  font-size: 20px;
  font-weight: 400;
  line-height: 43.568px;
  text-align: center;
  white-space: nowrap;
  z-index: 11;
}
.vendedor {
  background-color: #00133b;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  position: absolute;
  width: 426px;
  height: 52px;
  top: 260px;
  left: 0;
  color: #ffffff;
  font-family: Inter, var(--default-font-family);
  font-size: 20px;
  font-weight: 400;
  line-height: 43.568px;

}
.stock {
  background-color: #00133b;
  border-radius: 10px;
  display: flex;
  align-items: center;
  position: absolute;
  justify-content: center;
  color: #ffffff;
  font-family: Inter, var(--default-font-family);
  font-size: 20px;
  width: 426px;
  height: 52px;
  top: 330px;
  left: 0;
}

.descripcion {
  display: flex;
  border-radius: 10px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  width: 95%;
  height: 30%;
  top: 50%;
  left: 1%;
  color: #ffffff;
  background-color: #00133b;
  font-family: Inter, var(--default-font-family);
  font-size: 15px;
  font-weight: 400;
  line-height: 38.727px;
  text-align: left;
  padding: 20px;
}
</style>
