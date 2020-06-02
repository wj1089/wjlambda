import router from "@/routers";

const state ={
    context : "http://localhost:5000",
    searchWord : 'null',
    pageNumber: '0',
    soccers : [],
    movies : [],
    musics: [],
    pager: {}

}
const actions ={
    async find({commit},searchWord){
        alert('>>> '+searchWord)
        commit("SEARCHWORD",searchWord)
        switch (searchWord) {
            case '영화': router.push("/Movie")
                break
            case '음악': router.push("/Music")
                break
            case '축구': router.push("/Soccer")
                break
        }


    },


}
const mutations ={
    MOVIE(state, data){
        alert("영화 뮤테이션에서 결과 수 : " + data.count)
        state.movies = []
        state.pager = data.pager;
        data.list.forEach(item => {
            state.movies.push({
                seq: item.seq,
                movieName: item.movieName,
                rankDate : item.rankDate
            });
        });
    },
    SEARCHWORD(state, data){
        alert(`뮤테이션:: ${data}`)
        state.searchWord = data
    }
}
const getters ={}



export default {
    name:"search",
    namespaced: true,
    state,
    actions,
    mutations,
    getters

}