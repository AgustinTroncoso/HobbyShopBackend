<template>
    <div class="login__container">
        <div class="login">
            <h2>Login</h2>
            <form @submit.prevent="login">
                <div class="form-group">
                    <label class="email" for="email">Correo electrónico</label>
                    <span>{{ v$.email.$errors[0]?.$message }}</span>
                    <input type="email" id="email" v-model="loginData.email" placeholder="ejemplo@gmail.com" required>

                    <label class="password" for="password">Contraseña</label>
                    <span>{{ v$.password.$errors[0]?.$message }}</span>
                    <input type="password" id="password" v-model="loginData.password"
                        placeholder="Introducir contraseña..." required>

                </div>
                <div class="bottom">
                    <button type="submit">Login</button>
                    <span>No tienes una cuenta? <router-link to="/Register">Registrate aquí!</router-link></span>
                </div>
            </form>
        </div>
    </div>
</template>

<script setup>

import useVuelidate from '@vuelidate/core';
import { maxLength, minLength, required, helpers } from '@vuelidate/validators';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const rules = {
    email: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 10 caracteres.", minLength(10)), maxLength: helpers.withMessage("Máximo de 10 catacteres.", maxLength(50)) },
    password: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 6 caracteres", minLength(6)), maxLength: helpers.withMessage("Máximo de 30 caracteres.", maxLength(30)) },
};

const loginData = ref({
    email: '',
    password: '',
});

const v$ = useVuelidate(rules, loginData);

const login = async () => {
    const result = await v$.value.$validate();
    if (result) {
        localStorage.setItem('isLoggedIn', true);
        localStorage.setItem('email', loginData.value.email);
        localStorage.setItem('password', loginData.value.password);
        router.push('/');
    }
};
</script>

<style scoped>

.login__container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;
}

.login {
    color: white;
    background-color: #103973;
    margin: 0px 33rem;
    padding: 7rem 0 7rem 0;
    border-radius: 15px;
    font-family: Arial, sans-serif;
}

h2 {
    display: flex;
    justify-content: center;
    background-color: #295A94;
    padding: 15px;
    margin: -30px 10rem;
    margin-bottom: 100px;
    border-radius: 15px;
}

form {
    display: flex;
    justify-content: center;
    flex-direction: column;
    height: 20vh;
}

.form-group {
    display: flex;
    align-items: flex-start;
    justify-content: center;
    flex-direction: column;
    margin-bottom: 10px;
    margin-left: 20px;
    margin-right: 50px;
}

label {
    background-color: #528BE6;
    padding: 2px;
    margin-right: auto;
    border-radius: 15px;
    margin-bottom: 10px;
}

label:first-child {
    margin-top: 30px;
}

input {
    color: white;
    background-color: #528BE6;
    border-radius: 7px;
    padding: 10px 10px;
    width: 100%;
    margin-bottom: 20px;
}


input::placeholder {
    color: black;
    font-weight: 500;
}

input:-webkit-autofill,
input:-webkit-autofill:hover,
input:-webkit-autofill:focus,
input:-webkit-autofill:active {
    -webkit-box-shadow: 0 0 0 30px #528BE6 inset !important;
    color: white !important;
}

.bottom {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

button {
    border-radius: 7px;
    padding: 7px 20px;
    color: white;
    background-color: #528BE6;
    transition: all 0.5s ease;
}

button:hover {
    cursor: pointer;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    transform: scale(1.03);
}

span a {
    color: white;
    text-decoration: underline;
}

span {
    margin-top: 20px;
}
</style>