import axios from "axios"
import router from "../router";

const state = {
    context: 'http://localhost:5000/',
    bugsmusic: [],
    navermovie: [],
    count: 0

}
const actions = {
    async search({commit}, searchWord){
        alert('검색어: '+searchWord)
        switch (searchWord) {
            case '벅스':
                axios
                    .post(state.context+`bugsmusic`,searchWord,{
                        authorization: 'JWT fefege..',
                        Accept : 'application/json',
                        'Content-Type': 'application/json'
                    })
                    .then(({data})=>{
                        alert('검색된 결과 수: '+data.count)
                        commit('SEARCH', data)
                        router.push('/retriever')
                    })
                    .catch(()=>{
                        alert('통신 실패 !')
                    })
                break;
            case '네이버영화':
                axios
                    .get(state.context+`movie/list/0/${searchWord}`)
                    .then(({data})=>{
                        alert('연결')
                        commit('MOVIE',data)
                        router.push('/naverMovie')
                    })
                    .catch(()=>{
                        alert('실패')
                    })
                break;
        }

    }
}
const mutations = {
    SEARCH(state, data){
        state.bugsmusic = []
        state.count = data.count
        data.list.forEach(item => {
            state.bugsmusic.push({
                seq: item.seq,
                artist: item.artist,
                title: item.title,
                thumbnail: item.thumbnail
            })
        })
    },
    MOVIE(state, data){
        alert('뮤테이션에서 결과 수: '+data.count)
        state.navermovie = []
        state.count = data.count
        data.list.forEach(item => {
            state.navermovie.push({
                movieSeq: item.movieSeq,
                rank: item.rank,
                title: item.title,
                rankDate: item.rankDate

            })
        })

    }
}
const getters = {
    bugsmusic : state => state.bugsmusic,
    count: state => state.count,
    navermovie: state => state.count
}

export default {
    name: 'crawling',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}