import Vue from "vue";
import VueRouter from "vue-router";
import Google from "@/components/Google";
import Soccer from "@/components/Soccer";
import Movie from "@/components/Movie";
import Music from "@/components/Music";

Vue.use(VueRouter);
export default new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        { path: "/", component: Google },
        { path: "/soccer", component: Soccer },
        { path: "/movie", component: Movie },
        { path: "/music", component: Music }
    ]
});