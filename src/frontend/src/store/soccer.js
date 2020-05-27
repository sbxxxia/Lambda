import axios from 'axios'

const state = {
    context: "http://localhost:5000/"
}
const actions = {
    async search({commit},searchWord){
        axios.post(state.context+`soccer`,searchWord,{
            authorization: 'JWT fefege..',
            Accept : 'application/json',
            'Content-Type': 'application/json'
        })
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
    SEARCH(state,data){
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