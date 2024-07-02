<template>
  <Header />

  <div class="publicacion">
    <h2>Publicar Producto</h2>
    <form @submit.prevent="crearProducto">
      <div class="form-group">
        <label for="name">Nombre del Producto</label>
        <input
          type="text"
          id="name"
          v-model="name"
          placeholder="Inserte Producto."
          required
        />

        <label for="precio">Precio</label>
        <input
          type="number"
          id="precio"
          v-model="precio"
          placeholder="$$$"
          required
        />
        
        <label for="stock">Stock</label>
        <input
          type="number"
          id="stock"
          v-model="stock"
          placeholder="Ingrese el numero de productos que tiene "
          required
        />
      </div>
      <div class="form-group-2">
        <label for="descripcion">Descripcion</label>
        <input
          type="text"
          id="descripcion"
          v-model="descripcion"
          placeholder="Ingrese una descripcion del Producto"
          required
        />

        <label for="categoria">Categoria</label>
        <input
          type="text"
          id="categoria"
          v-model="categoria"
          placeholder="Ingrese una categoria del Producto"
          required
        />

        <label for="image">Imagen</label>
        <input
          type="text"
          id="image"
          v-model="image"
          placeholder="Ingrese la url de la imagen del producto"
          required
        />
      </div>
      <button class="Submit" type="submit">Registrar Producto</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import Header from '../Header.vue';

export default {
  name: 'PublicarProducto',
  components: {
    Header
  },
  data() {
    return {
      name: '',
      precio: '',
      stock: '',
      descripcion: '',
      categoria: '',
      image: ''
    };
  },
  methods: {
    async crearProducto() {
      try {
        const nuevoProducto = {
          nombreproducto: this.name,
          precio: this.precio,
          stock: this.stock,
          descripcion: this.descripcion,
          categoria: this.categoria,
          imageUrl: this.image
        };

        const response = await axios.post('http://localhost:8080/api/productos/crear', nuevoProducto);
        console.log('Producto creado:', response.data);
        alert('Producto creado con éxito');
        
        this.name = '';
        this.precio = '';
        this.stock = ''; 
        this.descripcion = '';
        this.categoria='';
        this.image = '';
      } catch (error) {
        console.error('Error al crear el producto:', error);
      }
    }
  }
};
</script>
<style scoped>
.publicacion {
  color: white;
  background-color: #103973;
  margin: 0px 13rem;
  padding: 4rem 0 2rem 0;
  margin-top: 65px;
  border-radius: 15px;
  font-family: Arial, sans-serif;
}

h2 {
  display: flex;
  justify-content: center;
  background-color: #295a94;
  padding: 15px;
  margin-bottom: 50px;
  border-radius: 15px;
  width: 20%;
  margin: auto;
}

.form-group {
  display: flex;
  align-items: left;
  justify-content: center;
  flex-direction: column;
  margin: 30px 35rem 0 10rem;
}

.form-group-2 {
  display: flex;
  align-items: left;
  justify-content: center;
  flex-direction: column;
  margin: -16.6rem 4rem 0 40rem;
}

label {
  background-color: #528be6;
  padding: 2px;
  border-radius: 15px;
  margin-right: auto;
  margin-bottom: 15px;
  margin-top: 15px;
  width: 120px;
  height: 30px;
  align-items: center;
  text-align: center;
}

input {
  color: white;
  background-color: #528be6;
  border-radius: 15px;
  padding: 10px;
  color: white;
  text-align: left;
  width: 70%;
  border: none;
}

input::placeholder {
  color: black;
  font-weight: 500;
}
.Submit {
  margin-left: 450px;
  margin-top: 70px;
  border-radius: 15px;
  padding: 20px 30px;
  font-size: medium;
  background-color: #00ff73;
  color: rgb(0, 0, 0);
  border: none;
  transition: all 0.2s ease-in-out;
}
.Submit:hover {
  transform: scale(1.1);
}
</style>
