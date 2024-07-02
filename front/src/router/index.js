import { createRouter, createWebHashHistory } from 'vue-router'

//Componentes a usar acá
import Profile from '../components/Views/Profile.vue';
import Login from '../components/Views/Login.vue';
import Register from '../components/Views/Register.vue';
import VistaProducto from './../components/Views/VistaProducto.vue'
import Principal from './../components/Views/Principal.vue'
import Resena from '../components/Views/Reseñacreacion.vue'
import Publicacion from './../components/Views/Publicacion.vue'
import Carritocompras from './../components/Views/Carritocompras.vue'
import EditProfile from './../components/Views/EditProfile.vue';
import Reseña from './../components/Views/Reseña.vue'
import Historial from './../components/Views/Historial.vue'
//Definir Rutas
const routes = [
{ name: "profile" ,path: "/Profile", component: Profile, meta: { isPrivate: true } },
{ name: "login" ,path: "/Login", component: Login, meta: { isPrivate: false } },
{ name: "register" ,path: "/Register", component: Register, meta: { isPrivate: false } },
{ name: "vistaproducto" ,path: "/Vistaproducto/:id", component: VistaProducto, meta: { isPrivate: false } },
{ name: "principal" ,path: "/", component: Principal, meta: { isPrivate: false } },
{ name: "reseñacreacion" ,path: "/Resenacreacion", component: Resena, meta: { isPrivate: true } },
{ name: "publicacion" ,path: "/Publicacion", component: Publicacion, meta: { isPrivate: true } },
{ name: "carritocompras" ,path: "/Carritocompras", component: Carritocompras, meta: { isPrivate: true } },
{ name: "editprofile" ,path: "/EditProfile", component: EditProfile, meta: { isPrivate: true } },
{ name: "Reseña" ,path: "/Resena", component: Reseña, meta: { isPrivate: false } },
{ name: "historial" ,path: "/Historial", component: Historial, meta: { isPrivate: true } },
]

//Crear Router
const router = createRouter({ history: createWebHashHistory(), routes, })

router.beforeEach((to, from, next) => {
    const isPrivate = to.meta.isPrivate; 
    const isAuthenticated = localStorage.getItem("isLoggedIn") === "true";
    console.log("Privado?", isPrivate, "Autenticado?", isAuthenticated, "Ruta:", to.name);
    if (isPrivate && !isAuthenticated) {
      next({ path: '/Login' }); 
    } else {
      next(); 
    }
  })

  export default router;