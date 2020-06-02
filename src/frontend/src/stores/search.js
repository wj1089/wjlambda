import axios from 'axios'
import routers from '@/routers'

const state ={
    context : 'http://localhost:5000/'

}
const actions ={
    async find({commit},searchWord) {
        axios.get(state.context + `soccer/`+searchWord)//열쇠없이 자유롭게 다니는 구조
        /*axios.post(state.context + `soccer` ,x,{
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'S
        })*/
            .then(({data})=>{
                alert('검색된 결과수'+data)
                commit('SEARCH',data)
                routers.push('/Google')
            })
            .catch(()=>{
                alert('통신실패!')
            })
    }
}

const mutations ={
    SEARCH() {
        alert('뮤테이션접속')
    }
}
const getters = {
}

export  default {
    name:'search',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}