<template>
    <div>
        <h3>movieSeq : {{item.movieSeq}}</h3>
        <h3>rank : {{item.rank}}</h3>
        <h3>title : {{item.title}}</h3>
        <h3>rankDate : {{item.rankDate}}</h3>
    </div>
</template>

<script>
    import {mapState} from "vuex";

    export default {
        computed: {
            ...mapState({
                item: state => state.search.item
            })
        }
    }
</script>

<style scoped>

</style>