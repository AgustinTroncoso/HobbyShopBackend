<template>
    <div class="register__container">
        <div class="register">
            <h2>Register</h2>
            <form @submit.prevent="register">
                <div class="form-group">
                    <label for="name">Nombre de Usuario</label>
                    <span>{{ v$.name.$errors[0]?.$message }}</span>
                    <input type="text" id="name" v-model="registerData.name" placeholder="Inserte Usuario..." required>

                    <label for="email">Email</label>
                    <span>{{ v$.email.$errors[0]?.$message }}</span>
                    <input type="email" id="email" v-model="registerData.email" placeholder="ejemplo@gmail.com"
                        required>

                    <label for="password">Contraseña</label>
                    <span>{{ v$.password.$errors[0]?.$message }}</span>
                    <input type="password" id="password" v-model="registerData.password"
                        placeholder="Ingrese su contraseña..." required>
                </div>
                <div class="form-group-2">
                    <label for="confirmPassword">Confirmar Contraseña</label>
                    <span>{{ v$.confirmPassword.$errors[0]?.$message }}</span>
                    <input type="Password" id="confirmPassword" v-model="registerData.confirmPassword"
                        placeholder="Confirme su contraseña..." required>

                    <label for="address">Dirección</label>
                    <span>{{ v$.address.$errors[0]?.$message }}</span>
                    <input type="text" id="address" v-model="registerData.address" placeholder="Avenida Siempreviva 123"
                        required>

                    <label for="phone">Número Telefónico</label>
                    <span>{{ v$.phone.$errors[0]?.$message }}</span>
                    <input type="text" id="phone" v-model="registerData.phone" placeholder="+569..." required>
                </div>
                <div class="button__container">
                    <button type="submit">Registrar cuenta</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script setup>
import useVuelidate from '@vuelidate/core';
import { maxLength, minLength, required, helpers, sameAs } from '@vuelidate/validators';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const validatePhone = (value) => {
    const phoneRegex = /^\+569\d{8}$/;
    return phoneRegex.test(value);
}

const registerData = ref({
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

    confirmPassword: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 6 caracteres", minLength(6)), maxLength: helpers.withMessage("Máximo de 30 caracteres.", maxLength(30)), sameAs: helpers.withMessage("Las contraseñas no coinciden.", sameAs(computed(() => registerData.value.password))) },

    address: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 10 caracteres.", minLength(10)), maxLength: helpers.withMessage("Máximo de 50 caracteres.", maxLength(50)) },

    phone: { required: helpers.withMessage("Requerido", required), minLength: helpers.withMessage("Mínimo de 8 caracteres.", minLength(8)), maxLength: helpers.withMessage("Máximo de 12 caracteres.", maxLength(12)), format: helpers.withMessage("Formato incorrecto.", validatePhone) },
};


const v$ = useVuelidate(rules, registerData);

const register = async () => {
    const result = await v$.value.$validate();
    if (result) {
        localStorage.setItem('isLoggedIn', true);
        localStorage.setItem('name', registerData.value.name);
        localStorage.setItem('email', registerData.value.email);
        router.push('/');
    }
};
</script>

<style scoped>
.register__container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;
}

.register {
    color: white;
    background-color: #103973;
    padding: 4rem 0 2rem 0;
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
    align-items: left;
    justify-content: center;
    flex-direction: column;
    margin: 10px 35rem 0 10rem;
}

.form-group-2 {
    display: flex;
    align-items: left;
    justify-content: center;
    flex-direction: column;
    margin: -16.6rem 4rem 0 40rem;
}

label {
    background-color: #528BE6;
    padding: 2px;
    border-radius: 15px;
    margin-right: auto;
    margin-bottom: 15px;
    margin-top: 15px;
}

input {
    color: white;
    background-color: #528BE6;
    border-radius: 15px;
    padding: 10px;
    color: white;
    text-align: left;
    border: none;
    width: 18rem;
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

button {
    border-radius: 15px;
    padding: 20px 30px;
    font-size: medium;
    background-color: #528BE6;
    color: white;
    border: none;
    transition: all 0.5s ease;
}

button:hover {
    cursor: pointer;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    transform: scale(1.01);
}

.button__container {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
</style>