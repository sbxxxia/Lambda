import Vue from "vue";
import VueRouter from "vue-router";
import Retriever from "../components/Retriever";
import Home from "../components/Home";
import Soccer from "../components/Soccer";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        {path: '/', component: Home},
        {path: '/retriever', component: Retriever},
        {path: '/soccer', component: Soccer}
    ]
});

export default router;