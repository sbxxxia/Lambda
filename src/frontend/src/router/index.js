import Vue from "vue";
import VueRouter from "vue-router";
import Retriever from "../components/Retriever";
import Home from "../components/Home";
import Soccer from "../components/Soccer";
import Movie from "../components/Movie";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        {path: '/', component: Home},
        {path: '/retriever', component: Retriever},
        {path: '/soccer', component: Soccer},
        {path: '/naverMovie', component: Movie}
    ]
});

export default router;