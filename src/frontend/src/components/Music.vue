<template>
    <div>
        <h3>검색결과 : {{pager.rowCount}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">이미지</th>
                    <th class="text-left">노래제목</th>
                    <th class="text-left">가 수</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td><img :src="item.thumbnail"></td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.artist }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <div style="margin: 0 auto; width: 500px; height: 100px">
                <span v-if="pager.existPrev" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">이전</span>
                <span v-for='i of pages' :key="i" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">{{i}}</span>
                <span v-if="pager.existNext" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">다음</span>
            </div>
<!--            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    import axios from "axios";

    export default {
        data () {
            return {
                list: [],
                page: 1,
                pager: {},
                pages: [1,2,3,4,5],
                existPrev: false,
                existNext: true
            }
        },
        created() {
            axios
                .get(`${this.$store.state.search.context}/musics/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res=>{
                    res.data.list.forEach(elem=>{this.list.push(elem)})
                    this.pager = res.data.pager
                    let i = this.pager.startPage +1
                    const arr = []
                    console.log(`페이지 끝: ${this.pager.endPage}`)
                    for(; i <= this.pager.endPage +1; i++){
                        arr.push(i)
                    }
                    this.pages = arr
                })
                .catch(err=>{
                    alert(`음악 전송 실패 ${err}`)
                })
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
                bugsmusic: state => state.crawling.bugsmusic
            })
        }
    };
</script>