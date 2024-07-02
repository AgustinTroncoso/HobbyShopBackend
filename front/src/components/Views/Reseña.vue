<script>
import Header from "../Header.vue";
import axios from 'axios';

export default {
    components: {
      Header
    }, data() {
    return {
      reseñas: [],
      loading: true,
    };
  },
  created() {
    this.fetchreseñas();
  },
  methods: {
    async fetchreseñas() {
      try {
        const response = await axios.get('http://localhost:8080/api/reseña/todo');
        this.reseñas = response.data;
        this.loading = false;
      } catch (error) {
        console.error('Error fetching reseñas:', error);
      }
    },
  },
};
</script>
<template>
    <Header />
    <div class="reviews-container">
    <h1>Reseñas</h1>
    <div v-if="loading">Cargando reseñas...</div>
    <div v-else>
      <card
        v-for="reseña in reseñas"
        :id="reseña.id"
        :nombrereseña="reseña.nombre"
        :descripcion="productos.precio"
        :imageUrl="productos.imageUrl"
        class="card"
      />
    
      <div v-for="reseña in reseñas" :key="reseña.id" class="reseña">
        <h2 >{{ reseña.nombre }}</h2>
        <p >{{ reseña.descripcion }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.reviews-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
  color: #295A94;
}

.loading {
  text-align: center;
  font-size: 1.2em;
  color: #666;
}

.card {
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 20px;
  margin-bottom: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  transition: transform 0.2s;
}

.review-card:hover {
  transform: scale(1.02);
}

.review-card h2 {
  margin: 0 0 10px 0;
  font-size: 1.5em;
  color: #ffffff;
}

.review-card p {
  margin: 0;
  font-size: 1em;
  color: #ffffff;
}
</style>