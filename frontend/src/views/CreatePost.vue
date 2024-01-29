<!-- views/CreatePost.vue -->
<template>
  <main class="create-post-container">
    <h1>게시글 작성</h1>
    <!-- Post creation form -->
    <form @submit.prevent="submitPost" class="post-form">
      <!-- Title input -->
      <div class="form-group">
        <label for="title">제목:</label>
        <input type="text" class="form-control" v-model="post.title" required>
      </div>

      <!-- Author input -->
      <div class="form-group">
        <label for="author">작성자:</label>
        <input type="text" class="form-control" v-model="post.member.userId" required>
      </div>

      <!-- Content textarea -->
      <div class="form-group">
        <label for="content">내용:</label>
        <textarea class="form-control" v-model="post.content" required></textarea>
      </div>

      <!-- Submit button -->
      <button type="submit" class="btn btn-primary">게시글 작성</button>
    </form>
  </main>
</template>

  
<script>
import axios from 'axios';

export default {
  name: 'CreatePost',
  data() {
    return {
      post: {
        title: '',
        member: {
          userId: '',
        },
        content: '',
      },
    };
  },

  methods: {
    submitPost() {
      console.log(this.post);
      axios.post(process.env.VUE_APP_API + '/api/posts', this.post )
      .then(response => {
          console.log('게시글이 성공적으로 생성되었습니다:', response.data);
          this.$router.push({ name: 'PostView' });
        })
        .catch(error => {
          console.error('게시글 생성 오류:', error);
        });
    },
  },
};
</script>
  
<style lang="scss" scoped>
.create-post-container {
  max-width: 600px;
  padding: 20px;
  text-align: left;
}

.post-form {
  background-color: #fff;
  padding: 20px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 8px;
}

.input-control {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 4px;
  outline-color: black;
}

button {
  padding: 10px 20px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
  