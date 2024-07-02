<template>
      <Header />
      <div class="general__container">
        <h1>Historial de Transacciones</h1>
        <div class="button__container">
          <router-link to="/Profile">Volver a Perfil</router-link>
        </div>
        <div class="history__container" v-if="historial.length > 0">
          <div class="history__card" v-for="producto in historial" :key="item.id">
            <div class="history__info">
              <h2>{{ producto.nombreProducto }}</h2>
              <p>Fecha: {{ producto.fecha }}</p>
              <p>Precio: ${{ producto.precio }}</p>
              <p>Descripción: {{ producto.descripcion }}</p>
              <p>Cantidad: {{ producto.cantidad }}</p>
            </div>
          </div>
        </div>
      </div>
  </template>
  
  <script>
  import axios from 'axios';
import Header from '../Header.vue';

export default {
  components: {
    Header
  },
  data() {
    return {
      historial: []
    };
  },
  created() {
    this.getHistorial();
  },
  methods: {
    async getHistorial() {
      try {
        const response = await axios.get(`http://localhost:8080/api/historial/historial/${usuario_id}`);
        this.historial = response.data;
      } catch (error) {
        console.error('Error al obtener el historial:', error);
      }
    }
  }
};
</script>

<style scoped>

.general__container {
    color: white;
    display: flex;
    height: calc(100% - 70px);
    margin-left: 2rem;
    margin-top: 15px;
    width: 95%;
    height: 85%;
    align-items: center;
    flex-direction: column;
    background-color: #103973;
    border-radius: 15px;
}

.general__container h1 {
    background-color: #73A4EE;
    border-radius: 7px;
    width: 25%;
    padding: 2px;
   
}

a {
    color: white;
    text-decoration: none;
    padding: 10px;
    border-radius: 10px;
    background-color: #73A4EE;
}

.history__container {
    background-color: #102041;
    border-radius: 15px;
    
}

</style>