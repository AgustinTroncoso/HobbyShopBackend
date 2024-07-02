<template>
    <Header />

    <div class="general__container">
        <div class="profile__container">
            <div class="profile__image">
                <img src="/src/assets/img/harold.jpg" alt="profile">
                <div class="profile__image__elements">
                    <button>Seleccionar Archivo</button>
                    <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M12 5v9m-5 0H5a1 1 0 0 0-1 1v4a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1v-4a1 1 0 0 0-1-1h-2M8 9l4-5 4 5m1 8h.01" />
                    </svg>
                </div>
            </div>
            <div class="form__container">
                <h2>Editar Perfil</h2>
                <form @submit.prevent="modify">
                    <div class="form__group">
                        <label for="name">Nombre de Usuario</label>
                        <span>{{ v$.name.$errors[0]?.$message }}</span>
                        <input type="text" id="name" v-model="modifyData.name" placeholder="Inserte nuevo Usuario..."
                            required>

                        <label for="email">Correo de Contacto</label>
                        <span>{{ v$.email.$errors[0]?.$message }}</span>
                        <input type="email" id="email" v-model="modifyData.email"
                            placeholder="Nuevo correo de contacto..." required>

                        <label for="password">Contraseña</label>
                        <span>{{ v$.password.$errors[0]?.$message }}</span>
                        <input type="password" id="password" v-model="modifyData.password"
                            placeholder="Ingrese nueva contraseña..." required>
                    </div>
                    <div class="form__group">
                        <label for="confirmPassword">Confirmar Contraseña</label>
                        <span>{{ v$.confirmPassword.$errors[0]?.$message }}</span>
                        <input type="password" id="confirmPassword" v-model="modifyData.confirmPassword"
                            placeholder="Confirme nueva contraseña..." required>

                        <label for="address">Dirección</label>
                        <span>{{ v$.address.$errors[0]?.$message }}</span>
                        <input type="text" id="address" v-model="modifyData.address" placeholder="Nueva dirección..." required>

                        <label for="phone">Número Telefónico</label>
                        <span>{{ v$.phone.$errors[0]?.$message }}</span>
                        <input type="text" id="phone" v-model="modifyData.phone"
                            placeholder="Nuevo número telefónico..." required>
                    </div>
                </form>
                <div class="button__container">
                    <RouterLink to="/Profile"><button id="green" type="submit">Guardar Cambios</button></RouterLink>
                    <RouterLink to="/Profile"><button id="red" type="submit">Descartar Cambios</button></RouterLink>
                </div>
            </div>
        </div>
    </div>

</template>

<script setup>
import Header from "../Header.vue";
import useVuelidate from '@vuelidate/core';
import { required, maxLength, minLength, helpers, sameAs } from '@vuelidate/validators';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const validatePhone = (value) => {
    const phoneRegex = /^\+569\d{8}$/;
    return phoneRegex.test(value);
}

const modifyData = ref({
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    address: '',
    phone: '',
});

const rules = {
    name: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 2 caracteres.", minLength(2)), maxLength: helpers.withMessage("Máximo de 20 caracteres.", maxLength(20)) },

    email: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 10 caracteres.", minLength(10)), maxLength: helpers.withMessage("Máximo de 50 caracteres.", maxLength(50)) },

    password: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 6 caracteres", minLength(6)), maxLength: helpers.withMessage("Máximo de 30 caracteres.", maxLength(30)) },

    confirmPassword: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 6 caracteres", minLength(6)), maxLength: helpers.withMessage("Máximo de 30 caracteres.", maxLength(30)), sameAs: helpers.withMessage("Las contraseñas no coinciden.", sameAs(computed(() => modifyData.value.password))) },

    address: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 10 caracteres.", minLength(10)), maxLength: helpers.withMessage("Máximo de 50 caracteres.", maxLength(50)) },

    phone: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 8 caracteres.", minLength(8)), maxLength: helpers.withMessage("Máximo de 12 caracteres.", maxLength(12)), format: helpers.withMessage("Formato incorrecto.", validatePhone) },
};


const v$ = useVuelidate(rules, modifyData);

const modify = async () => {
    const result = await v$.value.$validate();
    if (result) {
        localStorage.setItem('isLoggedIn', true);
        localStorage.setItem('name', registerData.value.name);
        localStorage.setItem('email', registerData.value.email);
        router.push('/Profile');
    }
};
</script>

<style scoped>
.general__container {
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    height: calc(100% - 70px);
    border-radius: 15px;
    margin: auto;
}

.profile__container {
    display: flex;
    align-items: center;
    text-align: center;
    justify-content: center;
    background-color: #103973;
    border-radius: 10px;
    gap: 3rem;
    width: 90%;
    height: 95%;
}

.profile__container img {
    width: 400px;
    height: 400px;
    border-radius: 8px;
}

.profile__image__elements {
    display: flex;
    justify-content: center;
    flex-direction: row;
    gap: 1rem;
}

.profile__image__elements button {
    background-color: #528BE6;
    color: white;
    border: none;
    border-radius: 15px;
    padding: 0.5rem;
    width: 10rem;
    align-items: center;
    cursor: pointer;
    transition: all 0.5s ease;
}

.profile__image__elements button:hover {
    cursor: pointer;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    transform: scale(1.01);
}

.form__container {
    display: flex;
    flex-direction: column;
    text-align: left;
}

.form__container h2 {
    background-color: #528BE6;
    padding: 15px;
    border-radius: 15px;
    width: 25%;
}

form {
    display: flex;
    justify-content: center;
    gap: 1rem;
}

.form__group {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    gap: 1rem;
}

label {
    background-color: #528BE6;
    padding: 6px;
    border-radius: 15px;
    margin-right: auto;
    margin-bottom: 15px;
    margin-top: 15px;
}

input {
    color: white;
    background-color: #528BE6;
    border: none;
    border-radius: 15px;
    padding: 0.5rem;
    width: 15rem;
}

input::placeholder {
    color: white;
}

.button__container {
    display: flex;
    justify-content: center;
    gap: 9rem;
    margin-top: 50px;
    height: 25px;
}

.button__container a:hover {
    cursor: pointer;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    transform: scale(1.03);
}

.button__container a #green {
    background-color: #53E142;
    color: white;
    border-radius: 7px;
    border: none;
    cursor: pointer;
    width: 8rem;
    height: 2rem;
}

.button__container a #red {
    background-color: red;
    color: white;
    border-radius: 7px;
    border: none;
    cursor: pointer;
    width: 8rem;
    height: 2rem;
}
</style>