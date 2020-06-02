<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">날짜</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item">
                    <td>{{item.seq}}</td>
<!--                    <td><img :src="item.movieName"></td>-->
                    <td>{{item.movieName}}</td>
                    <td>{{item.rankDate}}</td>

                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
            <div style="margin: 0 auto; width: 500px; height: 100px">
                <span v-if ='existPrev' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">이전</span>
                <span v-for='i of pages' :key="i" style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">{{i}}</span>
                <span v-if ='existNext' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">다음</span>
            </div>

            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>

<!--        <div class="btn-cover" style="margin: 0 auto">-->
<!--            <button :disabled="pageNum === 0" @click="existPrev" class="page-btn">-->
<!--                <span v-if="existPrev"  style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">이전</span>-->
<!--            </button>-->
<!--            <span v-for="i of arr" :key="i" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 10px">{{i}}</span>-->
<!--            <button :disabled="pageNum >= pageCount - 1" @click="existNext" class="page-btn">-->
<!--                <span v-if="existNext" @click="existNext" style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">다음</span>-->
<!--            </button>-->
<!--        </div>-->
<!--    </div>-->
</template>

<script>
    import { mapState } from "vuex";
    import axios from "axios";

    export default {
        data () {
            return {
                pageNumber: 0,
                existPrev : false,
                existNext : true,
                pages: [],
                list: [],
                pager: {},
                totalCount: '',
            }
        },

        created() {
            axios
                .get(`${this.$store.state.search.context}/movies/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res=>{
//                    res.data.list(위에있는).forEach(elem(안쪽에있눈 elem으로!) => {this.list.push(elem)})
                    res.data.list.forEach(elem => {this.list.push(elem)})
                    this.pager = res.data.pager
                    let i = this.pager.pageStart +1
                    let arr = []
                    console.log(`페이지 끝: ${this.pager.pageEnd}`)
                    for(; i <= this.pager.pageEnd + 1;i++){
                        arr.push(i)
                    }
                    this.pages = arr
                })
                .catch(err=>{
                    alert(`영화 통신 실패 ${err}`)
                })
        },
        methods: {
        //     nextPage () {
        //         this.pageNum += 1;
        //     },
        //     prevPage () {
        //         this.pageNum -= 1;
        //     }
        },
        computed: {
            ...mapState({
                count: state => state.movie.count,
                movie: state => state.movie.movie
            })
        }
    };
</script>

<style>

</style>