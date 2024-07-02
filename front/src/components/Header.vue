<template>
  <header>
    <RouterLink to="/"><button class="logo"><img src="../assets/img/logohobby.png"></button></RouterLink>


    <button class="drop" @click="showDropdown = !showDropdown" @blur="hideDropdown">
      Categorías
      <svg class="w-[12px] h-[12px] text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
        width="12" height="12" fill="currentColor" viewBox="0 -4 24 24">
        <path fill-rule="evenodd"
          d="M18.425 10.271C19.499 8.967 18.57 7 16.88 7H7.12c-1.69 0-2.618 1.967-1.544 3.271l4.881 5.927a2 2 0 0 0 3.088 0l4.88-5.927Z"
          clip-rule="evenodd" />
      </svg>


    </button>

    <ul v-if="showDropdown" class="dropdown">
      <li>
        <RouterLink to="#">Accesorios</RouterLink>
      </li>
      <li>
        <RouterLink to="#">Cartas</RouterLink>
      </li>
      <li>
        <RouterLink to="#">Figurines</RouterLink>
      </li>
      <li>
        <RouterLink to="#">Gundams</RouterLink>
      </li>
      <li>
        <RouterLink to="#">Juegos de Mesa</RouterLink>
      </li>
      <li>
        <RouterLink to="#">Peluches</RouterLink>
      </li>
    </ul>


    <div class="searchbar">
      <input
      type="text"
      v-model="query"
      @input="onSearch"
      placeholder="Buscar productos..."
    />
      <button class="magglass">
        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
        width="24" height="24" fill="none" viewBox="0 0 24 24">
        <path stroke="white" stroke-linecap="round" stroke-width="2"
          d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z" />
      </svg></button>
    </div>

    <div class="icons">
      <button @click="navigateToShoppingCart"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
          viewBox="0 0 24 24" fill="white" class="icon icon-tabler icons-tabler-filled icon-tabler-shopping-cart">
          <path stroke="none" d="M0 0h24v24H0z" fill="none" />
          <path
            d="M6 2a1 1 0 0 1 .993 .883l.007 .117v1.068l13.071 .935a1 1 0 0 1 .929 1.024l-.01 .114l-1 7a1 1 0 0 1 -.877 .853l-.113 .006h-12v2h10a3 3 0 1 1 -2.995 3.176l-.005 -.176l.005 -.176c.017 -.288 .074 -.564 .166 -.824h-5.342a3 3 0 1 1 -5.824 1.176l-.005 -.176l.005 -.176a3.002 3.002 0 0 1 1.995 -2.654v-12.17h-1a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 .883 -.993l.117 -.007h2zm0 16a1 1 0 1 0 0 2a1 1 0 0 0 0 -2zm11 0a1 1 0 1 0 0 2a1 1 0 0 0 0 -2z" />
        </svg></button>

      <button @click="handleButtonClick"><svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
          xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" viewBox="0 0 24 24">
          <path fill-rule="evenodd"
            d="M12 20a7.966 7.966 0 0 1-5.002-1.756l.002.001v-.683c0-1.794 1.492-3.25 3.333-3.25h3.334c1.84 0 3.333 1.456 3.333 3.25v.683A7.966 7.966 0 0 1 12 20ZM2 12C2 6.477 6.477 2 12 2s10 4.477 10 10c0 5.5-4.44 9.963-9.932 10h-.138C6.438 21.962 2 17.5 2 12Zm10-5c-1.84 0-3.333 1.455-3.333 3.25S10.159 13.5 12 13.5c1.84 0 3.333-1.455 3.333-3.25S13.841 7 12 7Z"
            clip-rule="evenodd" />
        </svg></button>

      <button v-if="isAuthenticated" @click="logout"><svg class="w-6 h-6 text-gray-800 dark:text-white"
          aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="none" viewBox="0 0 24 24">
          <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
            d="M16 12H4m12 0-4 4m4-4-4-4m3-4h2a3 3 0 0 1 3 3v10a3 3 0 0 1-3 3h-2" />
        </svg></button>
    </div>
  </header>
</template>


<script>
export default {
  name: 'SearchBar',
  data() {
    return {
      email: '',
      password: '',
      isAuthenticated: false,
      showDropdown: false,
      query: ''
    }
  },
  mounted() {
    this.isAuthenticated = localStorage.getItem("isLoggedIn") === "true";
  },
  methods: {
    hideDropdown() {
      setTimeout(() => {
        this.showDropdown = false;
      }, 200)
    },
    logout() {
      localStorage.removeItem('email');
      localStorage.removeItem('password');
      localStorage.setItem('isLoggedIn', 'false');
      this.isAuthenticated = false;
      location.reload();
    },
    handleButtonClick() {
      if (this.isAuthenticated) {
        this.$router.push('/Profile');
      } else {
        this.$router.push('/Login');
      }
    },
    navigateToShoppingCart() {
         this.$router.push('/Carritocompras');
    }, onSearch() {
      this.$emit('search', this.query);
    }
  },
}
</script>

<style scoped>
header {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #000B1C;
}

.logo {
  order: 1;
  margin-left: 50px;
}

.searchbar {
  order: 2;
  border: none;
  display: flex;
  align-items: center;
  justify-content: flex-start;
  width: 45rem;
  height: 20px;
  padding-left: 10px;
}

.magglass {
  position: absolute;
  cursor: pointer;
  border-radius: 75%;
  transform: translateY(-50%);
  margin-left: 385px;
  margin-top: 33px;
}

input {
  width: 60%;
  border-radius: 15px;
  border: none;
  padding: 0.5rem;
  color: white;
  background-color: #103973;
}

input:focus {
  outline: none;
  color: white;
  background-color: #103973;
}

input::placeholder {
  color: white;
}

.dropdown {
  position: absolute;
  top: 50%;
  left: 19rem;
  width: 40rem;
  z-index: 1;
}

.dropdown li {
  padding: 5px;
  width: 12%;
  list-style: none;
  background: #103973;
  font-weight: 500;
}

.dropdown li a {
  color: white;
  text-decoration: none;
}

.dropdown li:first-child {
  border-radius: 10px 10px 0 0;
}

.dropdown li:last-child {
  border-radius: 0 0 10px 10px;
}


.drop {
  cursor: pointer;
  color: white;
  background: none;
  border: none;

}

.icons {
  order: 4;
  margin-right: 50px;
}

img {
  width: 12%;
}

button img {
  padding: 0;
  width: 80px;
  background: none;
}

button {
  cursor: pointer;
  color: white;
  background: none;
  border: none;
}

.logo {
  background: none;
}

.magglass {
  padding: 0 22px;
}
</style>
