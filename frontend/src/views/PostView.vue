<template>
    <main>
        <h1>Post</h1>
        <div>
            <!-- 게시글 리스트 -->
            <table class="post-table">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="post in posts" :key="post.id" @click="goToPostDetail(post.id)">
                        <!-- 클릭 이벤트를 추가하여 게시글 상세 페이지로 이동하도록 설정 -->
                        <td>{{ post.id }}</td>
                        <td>{{ post.title }}</td>
                        <td>{{ post.author }}</td>
                        <td>{{ formatTime(post.timestamp) }}</td>
                        <td>{{ post.views }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </main>
</template>

<script>
export default {
    name: 'PostView',
    props: {
        msg: String
    },
    data() {
        return {
            posts: [
                { id: 1, title: '첫 번째 게시글', author: '작성자1', timestamp: 1643269200000, views: 10 },
                { id: 2, title: '두 번째 게시글', author: '작성자2', timestamp: 1643272800000, views: 20 },
                // 실제 데이터를 불러오거나 하드코딩하여 추가
            ]
        };
    },
    methods: {
        formatTime(timestamp) {
            const date = new Date(timestamp);
            return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}`;
        },
        goToPostDetail(postId) {
            // 클릭한 게시글의 ID를 사용하여 상세 페이지로 이동
            this.$router.push({ name: 'PostDetail', params: { id: postId } });
        }
    }
};
</script>

<style lang="scss" scoped>
.post-table {
    width: 100%;
    border-collapse: collapse;
}

.post-table th, .post-table td {
    padding: 10px;
    text-align: left;
}

.post-table th {
    background-color: #f2f2f2;
    border-bottom: 2px solid #ccc; /* thead-bottom에만 선 추가 */
}


.post-table th:first-child, .post-table td:first-child {
    width: 10%; /* 번호 열의 너비 비율 1 */
}

.post-table th:nth-child(2), .post-table td:nth-child(2) {
    width: 40%; /* 제목 열의 너비 비율 8 */
}

.post-table th:nth-child(3), .post-table td:nth-child(3) {
    width: 10%; /* 작성자 열의 너비 비율 2 */
}

.post-table th:nth-child(4), .post-table td:nth-child(4) {
    width: 15%; /* 작성일 열의 너비 비율 3 */
}

.post-table th:last-child, .post-table td:last-child {
    width: 10%; /* 조회수 열의 너비 비율 1 */
}

/* 필요한 스타일을 추가하세요 */
</style>
