<template>
    <div>
        <h3>검색결과 : {{count}}</h3>

        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">앨범</th>
                    <th class="text-left">가 수</th>
                    <th class="text-left">노래제목</th>

                </tr>
                </thead>
                <tbody>
                <tr v-for="item of bugsmusic" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td><img :src="item.thumbnail"></td>
                    <td>{{ item.artist }}</td>
                    <td>{{ item.title }}</td>

                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>
        </div>
    </div>



</template>

<script>
    import { mapState } from "vuex";
    export default {
        data () {
            return {
                page: 1
            }
        },
        created() { //아무것도 안하다가 밑에 method가 실행될때 비로서 이부분도 실행되는것을 Hooking이라한다.
            alert('CREATE in Music.')
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
                bugsmusic: state => state.crawling.bugsmusic
            })
        }
    };
</script>