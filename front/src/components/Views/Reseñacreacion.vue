<script >
import axios from 'axios';
import Header from "../Header.vue";

export default {
  components: {
    Header
  },
  data() {
    return {
      name: '',
      descripcion: ''
    };
  },
  methods: {
    async crear() {
      try {
        const response = await axios.get('http://localhost:8080/api/reseña/todo');
        const reseñas = response.data;

        const lastId = reseñas.length > 0 ? reseñas[reseñas.length - 1].id : 0;
        const newId = lastId + 1;

        const nuevaReseña = {
          id: newId,
          nombre: this.name,
          descripcion: this.descripcion
        };
        const postResponse = await axios.post('http://localhost:8080/api/reseña/crear', nuevaReseña);
        console.log('Reseña agregada:', postResponse.data);
        alert('Reseña agregada con éxito');

        this.name = '';
        this.descripcion = '';
      } catch (error) {
        console.error('Error al agregar la reseña:', error);
      }
    }
  }
};
</script>

<template>
        <Header />
    <div class="Reseña">
       <h2>Reseña el producto</h2>
       <form @submit.prevent="crear">
           <div class="form-group">
               <label for="name">Nombre del Problema</label>
               <input type="text" id="name" v-model="name" placeholder="Inserte nombre problema" required>
             <label for="descripcion">Descripcion del Problema</label>
               <input type="text" id="descripcion" v-model="descripcion" placeholder="Ingrese una descripcion del Producto" required>   
           </div>
           <button class="Submit" type="submit">Crear reseña</button>
       </form>
   </div>
</template>

<style scoped>
.Reseña {
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
   background-color: #295A94;
   padding: 15px;
   margin-bottom: 50px;
   border-radius: 15px;
   width: 20%;
   margin: auto;
}

.form-group {
   display: flex;
   align-items: center;
   justify-content: center;
   flex-direction: column;
  
}



label {
   background-color: #528BE6;
   padding: 2px;
   border-radius: 15px;
   
   margin-bottom: 15px;
   margin-top: 15px;
   width: 120px;
  height: 30px;
  align-items: center;
  text-align: center;
  
    
}

input {
   color: white;
   background-color: #528BE6;
   border-radius: 15px;
   padding: 10px;
   color: white;
   text-align: left;
   width: 70%;
   height: auto;
   border: none;
}

input::placeholder {
   color: black;
   font-weight: 500;
}
.Submit {
    margin-left: 450px;
   margin-top: 180px;
   border-radius: 15px;
   padding: 20px 30px;
   font-size: medium;
   background-color: #00ff73;
   color: rgb(0, 0, 0);
   border: none;
   transition: all .2s ease-in-out; 
}
.Submit:hover{
    transform: scale(1.1);
}
</style>