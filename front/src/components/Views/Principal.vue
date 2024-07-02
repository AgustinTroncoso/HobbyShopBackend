<template>
    <Header />
    <div class="row">
      <card
        v-for="productos in productos"
        :id="productos.id"
        :nombreproducto="productos.nombreproducto"
        :precio="productos.precio"
        :imageUrl="productos.imageUrl"
        class="card"
      />
    </div>
  </template>

  <script>
import Header from "../Header.vue";
  import axios from 'axios';
import Card from '../Card.vue';
  export default {
    components: {
      Card,
      Header
    },
    data() {
      return {
        productos: []
      };
    },
    mounted() {
        this.fetchproductos();
    },
    methods: {
        fetchproductos() {
            axios.get('http://localhost:8080/api/productos/todo')
        .then(response => {
          this.productos = response.data;
        })
        .catch(error => {
          console.error('Error al obtener los productos:', error);
        });
        }
    }

  }
  </script>
  <style >
  a{
    text-decoration: none;
  }
  .row {
    
    display: flex;
  flex-wrap: wrap;
  justify-content: center;
  }
  .card {
    flex: 0 1 calc(20% - 20px); 
  margin-bottom: 20px;
  margin-top: 20px;
  margin-right: 20px;
  margin-left: 20px;

}
.card:nth-child(3n) {
  margin-right: 20px; 
}
  </style>