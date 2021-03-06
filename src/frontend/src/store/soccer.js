import axios from 'axios'

const state = {
    soccer: [],
    context: "http://localhost:5000/"
}
const actions = {
    async search({commit},searchWord){
        axios.get(state.context+`/soccer/`+searchWord)
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
    SEARCH(){
        alert('뮤테이션 진입')
    }
}
const getters = {

}
export default {
    name: 'soccer',
    namespaced: true,
    state,
    actions,
    mutations,
    getters

}