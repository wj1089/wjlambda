import Vue from 'vue'
import Vuex from 'vuex'
import crawling from "./crawling";
import search from "./search"
import movie from "./movie"
import music from "./music"
Vue.use(Vuex)
export const store = new Vuex.Store({
    modules : {
        crawling,search,movie,music
    }
})