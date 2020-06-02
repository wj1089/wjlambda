import Vue from "vue";
import VueRouter from "vue-router";
import Retrieve from "@/components/Retrieve";
import Google from "@/components/Google";
import Movie from "@/components/Movie";

Vue.use(VueRouter);
export default new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        { path: "/", component: Google },
        { path: "/retrieve", component: Retrieve },
        { path: "/movie", component: Movie }
    ]
});