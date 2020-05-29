import axios from 'axios'

const state = {
    context: `http://localhost:5000/`,
    movie: [],
    count: 0
}
const actions = {
    async search({commit},searchWord){
        axios
            .get(state.context+`movie/${searchWord}`)
            .then(({data})=>{
                alert('연결')
                commit('SEARCH',data)
            })
            .catch(()=>{
                alert('실패')
            })
    }
}
const mutations = {

}
const getters = {

}
export default {
    name: 'movie',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}