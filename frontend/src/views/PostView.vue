<!-- views/PostView.vue -->
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
            <tr v-for="post in posts" :key="post.id"  @click="goToPostDetail(post.id)">
              <td>{{ post.id }}</td>
              <td>{{ post.title }}</td>
              <td>{{ post.member.username }}</td>
              <td>{{ formatTime(post.createdAt) }}</td>
              <td>{{ post.views }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'PostView',
    data() {
      return {
        posts: [],
      };
    },
    mounted() {
      this.fetchPosts();
    },
    methods: {
      fetchPosts() {
        axios.get(process.env.VUE_APP_API + '/api/posts')
          .then(response => {
            
            this.posts = response.data;
          })
          .catch(error => {
            console.error('API 호출 중 에러:', error);
          });
      },
      formatTime(timestamp) {
      if(timestamp === undefined) return ""; 
      const date = new Date(timestamp);
      return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}`;
    },
      goToPostDetail(postId) {
            // 클릭한 게시글의 ID를 사용하여 상세 페이지로 이동
            this.$router.push({ name: 'PostDetail', params: { id: postId } });
        },
    },
  };
  </script>
  
  <style lang="scss" scoped>
  .post-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .post-table th,
  .post-table td {
    padding: 10px;
    text-align: left;
  }
  
  .post-table th {
    background-color: #f2f2f2;
    border-bottom: 2px solid #373737;
  }
  
  .post-table tbody tr:hover {
    background-color: #ddd;
  }
  
  .post-table th:first-child,
  .post-table td:first-child {
    width: 5%;
  }
  
  .post-table th:nth-child(2),
  .post-table td:nth-child(2) {
    width: 40%;
  }
  
  .post-table th:nth-child(3),
  .post-table td:nth-child(3) {
    width: 10%;
  }
  
  .post-table th:nth-child(4),
  .post-table td:nth-child(4) {
    width: 15%;
  }
  
  .post-table th:last-child,
  .post-table td:last-child {
    width: 10%;
  }
  </style>
  