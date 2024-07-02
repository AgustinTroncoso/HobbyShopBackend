<template>
    <Header />
    <div class="general__container">
        <h2>Perfil</h2>
        <div class="content__container">
            <aside>
                <RouterLink to="/EditProfile">Editar Perfil</RouterLink>
                <RouterLink to="/Resena">Reseñas</RouterLink>
                <RouterLink to="/Historial">Historial</RouterLink>
                <RouterLink to="/Publicacion">Vender Producto</RouterLink>
            </aside>

            <div class="profile__container">
                <div class="profile__picture__container">
                    <img src="/src/assets/img/harold.jpg" alt="profile picture">
                    <p>Rating general de estrellas</p>
                    <div class="profile__rating__container">

                        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                            viewBox="0 0 24 24">
                            <path
                                d="M13.849 4.22c-.684-1.626-3.014-1.626-3.698 0L8.397 8.387l-4.552.361c-1.775.14-2.495 2.331-1.142 3.477l3.468 2.937-1.06 4.392c-.413 1.713 1.472 3.067 2.992 2.149L12 19.35l3.897 2.354c1.52.918 3.405-.436 2.992-2.15l-1.06-4.39 3.468-2.938c1.353-1.146.633-3.336-1.142-3.477l-4.552-.36-1.754-4.17Z" />
                        </svg>
                        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                            viewBox="0 0 24 24">
                            <path
                                d="M13.849 4.22c-.684-1.626-3.014-1.626-3.698 0L8.397 8.387l-4.552.361c-1.775.14-2.495 2.331-1.142 3.477l3.468 2.937-1.06 4.392c-.413 1.713 1.472 3.067 2.992 2.149L12 19.35l3.897 2.354c1.52.918 3.405-.436 2.992-2.15l-1.06-4.39 3.468-2.938c1.353-1.146.633-3.336-1.142-3.477l-4.552-.36-1.754-4.17Z" />
                        </svg>
                        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                            viewBox="0 0 24 24">
                            <path
                                d="M13.849 4.22c-.684-1.626-3.014-1.626-3.698 0L8.397 8.387l-4.552.361c-1.775.14-2.495 2.331-1.142 3.477l3.468 2.937-1.06 4.392c-.413 1.713 1.472 3.067 2.992 2.149L12 19.35l3.897 2.354c1.52.918 3.405-.436 2.992-2.15l-1.06-4.39 3.468-2.938c1.353-1.146.633-3.336-1.142-3.477l-4.552-.36-1.754-4.17Z" />
                        </svg>
                        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                            viewBox="0 0 24 24">
                            <path
                                d="M13.849 4.22c-.684-1.626-3.014-1.626-3.698 0L8.397 8.387l-4.552.361c-1.775.14-2.495 2.331-1.142 3.477l3.468 2.937-1.06 4.392c-.413 1.713 1.472 3.067 2.992 2.149L12 19.35l3.897 2.354c1.52.918 3.405-.436 2.992-2.15l-1.06-4.39 3.468-2.938c1.353-1.146.633-3.336-1.142-3.477l-4.552-.36-1.754-4.17Z" />
                        </svg>
                        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                            viewBox="0 0 24 24">
                            <path fill-rule="evenodd"
                                d="M13 4.024v-.005c0-.053.002-.353-.217-.632a1.013 1.013 0 0 0-1.176-.315c-.192.076-.315.193-.35.225-.052.05-.094.1-.122.134a4.358 4.358 0 0 0-.31.457c-.207.343-.484.84-.773 1.375a168.719 168.719 0 0 0-1.606 3.074h-.002l-4.599.367c-1.775.14-2.495 2.339-1.143 3.488L6.17 15.14l-1.06 4.406c-.412 1.72 1.472 3.078 2.992 2.157l3.94-2.388c.592-.359.958-.996.958-1.692v-13.6Zm-2.002 0v.025-.025Z"
                                clip-rule="evenodd" />
                        </svg>
                    </div>
                </div>
                <div class="profile__container__text">
                    <p>Nombre: John Trollface</p>
                    <p>Email: j.trollface@gmail.com</p>
                    <p>Dirección: Pedro de Valdivia 123</p>
                    <p>Número de contacto: +569 1234 5678</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import Header from "../Header.vue";


</script>


<style scoped>
.general__container {
    color: white;
    display: flex;
    height: calc(100% - 70px);
    width: 100%;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

.content__container {
    display: flex;
    align-items: center;
    gap: 3rem;
    width: 80%;
    height: 80%;
    border-radius: 10px;
}

.profile__container {
    display: flex;
    text-align: center;
    background-color: #103973;
    margin-left: auto;
    padding: 2rem;
    border-radius: 10px;
    gap: 3rem;
    width: 100%;
    height: 80%;
}

.profile__container img {
    width: 200px;
    height: 200px;
    border-radius: 8px;
}

.profile__rating__container {
    display: flex;
    width: 100%;
    justify-content: center;
    gap: 5px;
}

.profile__container__text {
    display: flex;
    flex-direction: column;
    gap: 5px;
    text-align: left;
    font-size: larger;
}

aside {
    display: flex;
    align-items: start;
    flex-direction: column;
    width: 50%;
    gap: 8px;
}

aside a {
    padding: 2rem 3rem;
    border-radius: 10px;
    border: none;
    background-color: #73A4EE;
    font-size: 1.5rem;
    font-weight: 540;
    width: 60%;
    cursor: pointer;
    text-decoration: none;
    text-align: center;
    color: black;
    transition: all 0.5s ease;
}

aside a:hover {
    cursor: pointer;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    transform: scale(1.01);
}

</style>